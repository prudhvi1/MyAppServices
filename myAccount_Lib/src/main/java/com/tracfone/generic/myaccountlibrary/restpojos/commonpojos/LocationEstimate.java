package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by skishore on 10/17/2016.
 */

public class LocationEstimate implements Parcelable {

    @JsonProperty("addressType")
    private String addressType;
    @JsonProperty("address")
    private PostalAddress postalAddress;

    public static final String ADDRESS_TYPE_BILLING = "BILLING";
    public static final String ADDRESS_TYPE_SHIPPING = "SHIPPING";
    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public LocationEstimate() {}
    protected LocationEstimate(Parcel in) {
        addressType = in.readString();
        postalAddress = in.readParcelable(PostalAddress.class.getClassLoader());
    }

    public static final Creator<LocationEstimate> CREATOR = new Creator<LocationEstimate>() {
        @Override
        public LocationEstimate createFromParcel(Parcel in) {
            return new LocationEstimate(in);
        }

        @Override
        public LocationEstimate[] newArray(int size) {
            return new LocationEstimate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(addressType);
        parcel.writeParcelable(postalAddress, i);


    }
}
