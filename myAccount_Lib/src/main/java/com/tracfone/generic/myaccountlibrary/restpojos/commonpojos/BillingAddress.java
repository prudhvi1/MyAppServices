package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class BillingAddress implements Parcelable {

    @JsonProperty("addressLine1")
    private String addressLine1;
    @JsonProperty("addressLine2")
    private String addressLine2;
    @JsonProperty("city")
    private String city;
    @JsonProperty("stateOrProvince")
    private String stateOrProvince;
    @JsonProperty("zipCode")
    private String zipcode;
    @JsonProperty("country")
    private String country;

    public BillingAddress(){}
    protected BillingAddress(Parcel in) {
        addressLine1 = in.readString();
        addressLine2 = in.readString();
        city = in.readString();
        stateOrProvince = in.readString();
        zipcode = in.readString();
        country = in.readString();
    }

    public static final Creator<BillingAddress> CREATOR = new Creator<BillingAddress>() {
        @Override
        public BillingAddress createFromParcel(Parcel in) {
            return new BillingAddress(in);
        }

        @Override
        public BillingAddress[] newArray(int size) {
            return new BillingAddress[size];
        }
    };

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getzipcode() {
        return zipcode;
    }

    public void setzipcode(String zipCode) {
        this.zipcode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(addressLine1);
        dest.writeString(addressLine2);
        dest.writeString(city);
        dest.writeString(stateOrProvince);
        dest.writeString(zipcode);
        dest.writeString(country);
    }
}
