package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/9/2016.
 */

public class ReferenceAddress implements Parcelable {
    public ReferenceAddress() {

    }
    @JsonProperty("id")
    private String id;
    @JsonProperty("multiple")
    private boolean multiple;
    @JsonProperty("pickList")
    private String pickList;

    public ReferenceAddress(Parcel in) {
        id = in.readString();
        multiple = in.readByte() != 0;
        pickList = in.readString();
    }

    public static final Creator<ReferenceAddress> CREATOR = new Creator<ReferenceAddress>() {
        @Override
        public ReferenceAddress createFromParcel(Parcel in) {
            return new ReferenceAddress(in);
        }

        @Override
        public ReferenceAddress[] newArray(int size) {
            return new ReferenceAddress[size];
        }
    };



    public String getPickList() {
        return pickList;
    }

    public void setPickList(String pickList) {
        this.pickList = pickList;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeByte((byte) (multiple ? 1 : 0));
        dest.writeString(pickList);
    }
}
