package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class PostalAddress implements Parcelable{

    public static final Creator<PostalAddress> CREATOR = new Creator<PostalAddress>() {
        @Override
        public PostalAddress createFromParcel(Parcel in) {
            return new PostalAddress(in);
        }

        @Override
        public PostalAddress[] newArray(int size) {
            return new PostalAddress[size];
        }
    };

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @JsonProperty("zipcode")
    private String zipcode;

    public PostalAddress() {}
    protected PostalAddress(Parcel in) {
        zipcode = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(zipcode);
    }
}
