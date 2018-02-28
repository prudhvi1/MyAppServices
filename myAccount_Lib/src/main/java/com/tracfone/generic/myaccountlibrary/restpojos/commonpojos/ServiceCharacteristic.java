package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class ServiceCharacteristic implements Parcelable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private String value;

    @JsonProperty("type")
    private String type;

    public ServiceCharacteristic() {
    }

    protected ServiceCharacteristic(Parcel in) {
        name = in.readString();
        value = in.readString();
        type = in.readString();
    }

    public static final Creator<ServiceCharacteristic> CREATOR = new Creator<ServiceCharacteristic>() {
        @Override
        public ServiceCharacteristic createFromParcel(Parcel in) {
            return new ServiceCharacteristic(in);
        }

        @Override
        public ServiceCharacteristic[] newArray(int size) {
            return new ServiceCharacteristic[size];
        }
    };

    public static final String NAME_ISLTE = "isLTE";
    public static final String NAME_ISSIMPURCHASEREQUIRED = "isSIMPurchaseRequired";
    public static final String NAME_ISBYOPELIGIBLE = "isBYOPEligible";
    public static final String NAME_VOICE = "VOICE";
    public static final String NAME_DATA = "DATA";
    public static final String NAME_MESSAGE = "TEXT";
    public static final String NAME_DAYS_REMAINING = "DAYSREMAINING";
    public static final String NAME_PRICE = "PRICE";
    public static final String NAME_DISCOUNT = "DISCOUNT";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static final String VALUE_No = "No";
    public static final String VALUE_Yes = "Yes";
    public static final String VALUE_N = "N";
    public static final String VALUE_Y = "Y";
    public static final String VALUE_TRUE = "true";
    public static final String VALUE_FALSE = "false";
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static final String TYPE_MINUTES = "MINS";
    public static final String TYPE_MB = "MB";
    public static final String TYPE_GB = "GB";
    public static final String TYPE_SMS = "SMS";
    public static final String TYPE_DAYS ="DAYS";
    public static final String TYPE_USD = "USD";
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(value);
        dest.writeString(type);
    }
}
