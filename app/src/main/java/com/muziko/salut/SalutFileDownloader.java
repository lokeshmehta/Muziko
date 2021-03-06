package com.muziko.salut;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.muziko.MyApplication;
import com.muziko.helpers.FileHelper;
import com.muziko.manager.AppController;
import com.muziko.manager.NotificationController;
import com.muziko.receivers.NotificationBroadcast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * Created by dev on 27/10/2016.
 */

public class SalutFileDownloader extends AsyncTask<Void, Integer, Boolean> {

	private final Context mContext;
	private final Salut salutInstance;
	private final Socket clientSocket;
	private byte[] buffer;
    private android.app.NotificationManager mNotifyManager;
    private NotificationCompat.Builder mBuilder;
    private int nID;
	private int totalBytes;
	private int bufferSize;
	private int progress;
	private PowerManager.WakeLock mWakeLock;
	private int lastSentProgress = 0;
	private File newfile;
	private String mUid;

	public SalutFileDownloader(Context ctx, Salut salutInstance, String uid, Socket clientSocket) {
		mContext = ctx;
		this.clientSocket = clientSocket;
		this.salutInstance = salutInstance;
		mUid = uid;
	}

	@Override
	protected Boolean doInBackground(Void... params) {

		boolean result = false;
		try {
			//If this code is reached, a client has connected and transferred data.
			Log.v(Salut.TAG, "A device is sending data...");

			// Input stream
			DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

			totalBytes = (int) dataInputStream.readLong();
			String filename = dataInputStream.readUTF();

            File parentDirFile = FileHelper.getMuzikoFolder();

			// Output
			newfile = new File(parentDirFile, filename);
			FileOutputStream fileOutputStream = new FileOutputStream(newfile);
			DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

			bufferSize = 4 * 1024;
			buffer = new byte[bufferSize];

			int progress = 0;
			int bytesRead;

			while ((bytesRead = dataInputStream.read(buffer)) > 0) {
				dataOutputStream.write(buffer, 0, bytesRead);
				progress += bytesRead;
				this.publishProgress((progress * 100) / totalBytes);
			}

			dataInputStream.close();
			dataOutputStream.close();
			fileOutputStream.close();

			Log.d(Salut.TAG, "\nSuccessfully received data.\n");

			if (newfile.length() > 0) {

				MyApplication.shareDownloaderList.remove(mUid);

				salutInstance.dataReceiver.activity.runOnUiThread(() -> salutInstance.dataReceiver.dataCallback.onDataReceived(newfile.getAbsolutePath()));
			}

		} catch (Exception ex) {
			Log.e(Salut.TAG, "An error occurred while trying to receive data.");
			result = false;
		} finally {
			result = true;
			try {
				clientSocket.close();
			} catch (Exception ex) {
				Log.e(Salut.TAG, "Failed to close data socket.");
			}
		}

		return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // take CPU lock to prevent CPU from going off if the user
        // presses the power button during download
        PowerManager pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                getClass().getName());
        mWakeLock.acquire();


        int min = 0;
        int max = 1000;

        Random r = new Random();
        nID = r.nextInt(max - min + 1) + min;

        mNotifyManager =
                (android.app.NotificationManager)
                        mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(mContext, "Muziko");
        mBuilder.setContentTitle("Getting shared file")
                .setContentText("Download in progress - Swipe to cancel")
                .setSmallIcon(NotificationController.Instance().getDownloadNotificationIcon());

        mBuilder.setProgress(100, 0, false);
        mBuilder.setDeleteIntent(getDeleteIntent());
        mNotifyManager.notify(nID, mBuilder.build());

	}

	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		mWakeLock.release();

		if (result) {

			mBuilder.setContentText("Download complete");
			// Removes the progress bar
			mBuilder.setProgress(0, 0, false);
			mNotifyManager.notify(nID, mBuilder.build());
			mNotifyManager.cancelAll();
		} else {
			mBuilder.setContentText("Download Error");
			// Removes the progress bar
			mBuilder.setProgress(0, 0, false);
			mNotifyManager.notify(nID, mBuilder.build());
			mNotifyManager.cancel(nID);

			Intent progressIntent = new Intent(AppController.INTENT_DOWNLOAD_PROGRESS);
			progressIntent.putExtra("url", salutInstance.registeredHost.readableName);
			progressIntent.putExtra("progress", -1);
			mContext.sendBroadcast(progressIntent);

		}

	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		int progress = values[0];

		if (lastSentProgress + 3 < progress) {
			lastSentProgress = progress;

			mBuilder.setProgress(100, progress, false);
			mNotifyManager.notify(nID, mBuilder.build());

			if (progress > 97) progress = 100;

			Intent progressIntent = new Intent(AppController.INTENT_DOWNLOAD_PROGRESS);
			progressIntent.putExtra("url", salutInstance.registeredHost.deviceName);
			progressIntent.putExtra("progress", progress);
			mContext.sendBroadcast(progressIntent);
		}
	}

	private PendingIntent getDeleteIntent() {
		Intent intent = new Intent(mContext, NotificationBroadcast.class);
		intent.setAction(AppController.NOTIFY_CANCEL_WIFI_DOWNLOAD);

		intent.putExtra("data", mUid);
		return PendingIntent.getBroadcast(mContext, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
	}
}
