package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class ServiceExtension implements Parcelable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    public static final String NAME_GENERAL_INSTRUCTIONS  = "generalInstruction";
    public static final String NAME_PRODUCT_INSTRUCTIONS  = "productInstruction";
    public static final String NAME_SERVICE_INSTRUCTIONS  = "serviceInstruction";
    public static final String CONFIRMATION_MSG = "confirmationMsg";
    public static final String TRANSACTION_MSG = "transactionMsg";
    public static final String RESERVE_COUNT = "reserveCount";

    public ServiceExtension() {}
    protected ServiceExtension(Parcel in) {
        name = in.readString();
        value = in.readString();
    }

    public static final Creator<ServiceExtension> CREATOR = new Creator<ServiceExtension>() {
        @Override
        public ServiceExtension createFromParcel(Parcel in) {
            return new ServiceExtension(in);
        }

        @Override
        public ServiceExtension[] newArray(int size) {
            return new ServiceExtension[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(value);
    }
}
