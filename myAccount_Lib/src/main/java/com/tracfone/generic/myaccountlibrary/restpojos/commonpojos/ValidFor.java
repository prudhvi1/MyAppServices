package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class ValidFor implements Parcelable{

    @JsonProperty("startDatetime")
    private String startDatetime;
    @JsonProperty("endDatetime")
    private String endDatetime;

    public ValidFor() {}
    protected ValidFor(Parcel in) {
        startDatetime = in.readString();
        endDatetime = in.readString();
    }

    public static final Creator<ValidFor> CREATOR = new Creator<ValidFor>() {
        @Override
        public ValidFor createFromParcel(Parcel in) {
            return new ValidFor(in);
        }

        @Override
        public ValidFor[] newArray(int size) {
            return new ValidFor[size];
        }
    };

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(startDatetime);
        dest.writeString(endDatetime);
    }
}
