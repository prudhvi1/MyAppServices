package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by skishore on 10/17/2016.
 */

public class Location implements Parcelable {

    @JsonProperty("addressType")
    private String addressType;
    @JsonProperty("postalAddress")
    private PostalAddress postalAddress;

    public static final String ADDRESS_TYPE_BILLING = "BILLING";
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

    public static final String DEFAULT_ZIPCODE = "33178";
    public Location() {}
    protected Location(Parcel in) {
        addressType = in.readString();
        postalAddress = in.readParcelable(PostalAddress.class.getClassLoader());
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
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
