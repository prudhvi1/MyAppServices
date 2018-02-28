package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for account device details Flash message element.
 * It corresponds to the restful service Get Customer Account Details and Validate Device
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

@JsonIgnoreProperties(ignoreUnknown = true)

public class DeviceFlashMessage implements Parcelable {

    @JsonProperty("flashText")
    private String flashText;
    @JsonProperty("isFlashHot")
    private boolean isFlashHot;
    //flashContinued is not part of the web service
    private boolean flashContinued = false;

    public void setFlashText(String i) {
        flashText = i;
    }

    public String getFlashText() {
        return flashText;
    }

    public void setFlashHot(boolean flashHot) {
        this.isFlashHot = flashHot;
    }

    public boolean getFlashHot() {
        return isFlashHot;
    }


    //flashContinued is not part of the web service
    public void setFlashContinued(boolean flashContinued) {
        this.flashContinued = flashContinued;
    }

    public boolean getFlashContinued() {
        return flashContinued;
    }

    public DeviceFlashMessage() {
    }

    protected DeviceFlashMessage(Parcel in) {
        flashText = in.readString();
        isFlashHot = in.readByte() != 0;
    }

    public static final Creator<DeviceFlashMessage> CREATOR = new Creator<DeviceFlashMessage>() {
        @Override
        public DeviceFlashMessage createFromParcel(Parcel in) {
            return new DeviceFlashMessage(in);
        }

        @Override
        public DeviceFlashMessage[] newArray(int size) {
            return new DeviceFlashMessage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(flashText);
        parcel.writeByte((byte) (isFlashHot ? 1 : 0));
    }
}
