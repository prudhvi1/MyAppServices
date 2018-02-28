package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hserna on 8/1/2017.
 */

public class CheckPointValue implements Parcelable {

    @JsonProperty("verificationCode")
    String verificationCode;
    @JsonProperty("type")
    String checkPointType;

    public CheckPointValue(){}

    protected CheckPointValue(Parcel in) {
        verificationCode = in.readString();
        checkPointType = in.readString();
    }

    public static final Creator<CheckPointValue> CREATOR = new Creator<CheckPointValue>() {
        @Override
        public CheckPointValue createFromParcel(Parcel in) {
            return new CheckPointValue(in);
        }

        @Override
        public CheckPointValue[] newArray(int size) {
            return new CheckPointValue[size];
        }
    };

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getCheckPointType() {
        return checkPointType;
    }

    public void setCheckPointType(String checkPointType) {
        this.checkPointType = checkPointType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(verificationCode);
        dest.writeString(checkPointType);
    }
}
