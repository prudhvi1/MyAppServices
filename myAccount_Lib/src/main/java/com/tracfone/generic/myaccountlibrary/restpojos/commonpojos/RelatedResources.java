package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by skishore on 10/18/2016.
 */

public class RelatedResources implements Parcelable {

    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("productIdentifier")
    private String productIdentifier;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public static final String NAME_PRODUCT_SERIAL_NUMBER = "productSerialNumber";
    public static final String NAME_SERIAL_NUMBER = "serialNumber";
    public static final String NAME_SOURCE_SERIAL_NUMBER = "sourceSerialNumber";
    public static final String NAME_TARGET_PRODUCT_SERIAL_NUMBER = "targetProductSerialNumber";
    public static final String NAME_SOURCE_PRODUCT_SERIAL_NUMBER = "sourceProductSerialNumber";
    public static final String NAME_CURRENT_MIN = "currentMin";
    public static final String NAME_TARGET_SERIAL_NUMBER = "targetSerialNumber";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final String TYPE_AIRTIME_CARD  = "AIRTIME_CARD";
    public static final String TYPE_HANDSET  = "HANDSET";
    public static final String TYPE_SIM_CARD  = "SIM_CARD";
    public static final String TYPE_LINE  = "LINE";
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public RelatedResources(Parcel source) {
        serialNumber = source.readString();
        productIdentifier = source.readString();
        name = source.readString();
        type=source.readString();
    }

    public RelatedResources() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(serialNumber);
        dest.writeString(productIdentifier);
        dest.writeString(name);
        dest.writeString(type);

    }

    public static Creator<RelatedResources> CREATOR = new Creator<RelatedResources>() {
        @Override
        public RelatedResources createFromParcel(Parcel source) {
            return new RelatedResources(source);
        }

        @Override
        public RelatedResources[] newArray(int size) {
            return new RelatedResources[size];
        }
    };
}
