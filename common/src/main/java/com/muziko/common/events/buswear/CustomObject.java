package com.muziko.common.events.buswear;

import android.os.Parcel;
import android.os.Parcelable;


public class CustomObject implements Parcelable {

    public static final Creator<CustomObject> CREATOR = new Creator<CustomObject>() {
        @Override
        public CustomObject createFromParcel(Parcel in) {
            return new CustomObject(in);
        }

        @Override
        public CustomObject[] newArray(int size) {
            return new CustomObject[size];
        }
    };
    private String name;

    public CustomObject(String name) {
        this.name = name;
    }

    public CustomObject(Parcel in) {
        this.name = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
