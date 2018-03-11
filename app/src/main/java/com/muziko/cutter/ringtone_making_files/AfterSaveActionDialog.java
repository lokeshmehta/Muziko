/*
 * Copyright (C) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.muziko.cutter.ringtone_making_files;

import android.app.Dialog;
import android.content.Context;
import android.os.Message;

import com.muziko.R;

class AfterSaveActionDialog extends Dialog {

	private Message mResponse;

	public AfterSaveActionDialog(Context context, Message response) {
		super(context);

		// Inflate our UI from its XML layout description.
		setContentView(R.layout.after_save_action);

		setTitle("Success");

		findViewById(R.id.button_make_default)
				.setOnClickListener(view -> closeAndSendResult(R.id.button_make_default));
		findViewById(R.id.button_choose_contact)
				.setOnClickListener(view -> closeAndSendResult(R.id.button_choose_contact));
		findViewById(R.id.button_do_nothing)
				.setOnClickListener(view -> closeAndSendResult(R.id.button_do_nothing));

		mResponse = response;
	}

	private void closeAndSendResult(int clickedButtonId) {
		mResponse.arg1 = clickedButtonId;
		mResponse.sendToTarget();
		dismiss();
	}
}
