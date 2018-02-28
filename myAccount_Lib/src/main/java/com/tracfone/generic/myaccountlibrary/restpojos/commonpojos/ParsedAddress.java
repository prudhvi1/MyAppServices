package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestValidateAddress;

/**
 * Created by psamdrala on 11/9/2016.
 */

public class ParsedAddress implements Parcelable {


    @JsonProperty("addressLine1")
    private String addressLine1;
    @JsonProperty("addressLine2")
    private String addressLine2;
    @JsonProperty("country")
    private String country;
    @JsonProperty("poBox")
    private String poBox;
    @JsonProperty("secondaryType")
    private String secondaryType;
    @JsonProperty("stateOrProvince")
    private String stateOrProvince;
    @JsonProperty("streetName")
    private String streetName;
    @JsonProperty("streetNr")
    private String streetNr;
    @JsonProperty("streetNrLast")
    private String streetNrLast;
    @JsonProperty("streetNrSuffix")
    private String streetNrSuffix;
    @JsonProperty("streetType")
    private String streetType;
    @JsonProperty("zipPus4")
    private String zipPus4;
    @JsonProperty("city")
    private String city;
    @JsonProperty("ruralRoute")
    private String ruralRoute;
    @JsonProperty("zipcode")
    private String zipCode;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(String secondaryType) {
        this.secondaryType = secondaryType;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getStreetNrLast() {
        return streetNrLast;
    }

    public void setStreetNrLast(String streetNrLast) {
        this.streetNrLast = streetNrLast;
    }

    public String getStreetNrSuffix() {
        return streetNrSuffix;
    }

    public void setStreetNrSuffix(String streetNrSuffix) {
        this.streetNrSuffix = streetNrSuffix;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getZipPus4() {
        return zipPus4;
    }

    public void setZipPus4(String zipPus4) {
        this.zipPus4 = zipPus4;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRuralRoute() {
        return ruralRoute;
    }

    public void setRuralRoute(String ruralRoute) {
        this.ruralRoute = ruralRoute;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ParsedAddress() {
    }

    protected ParsedAddress(Parcel in) {
        addressLine1 = in.readString();
        addressLine2 = in.readString();
        country = in.readString();
        poBox = in.readString();
        secondaryType = in.readString();
        stateOrProvince = in.readString();
        streetName = in.readString();
        streetNr = in.readString();
        streetNrLast = in.readString();
        streetNrSuffix = in.readString();
        streetType = in.readString();
        zipPus4 = in.readString();
        city = in.readString();
        ruralRoute = in.readString();
        zipCode = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(addressLine1);
        dest.writeString(addressLine2);
        dest.writeString(country);
        dest.writeString(poBox);
        dest.writeString(secondaryType);
        dest.writeString(stateOrProvince);
        dest.writeString(streetName);
        dest.writeString(streetNr);
        dest.writeString(streetNrLast);
        dest.writeString(streetNrSuffix);
        dest.writeString(streetType);
        dest.writeString(zipPus4);
        dest.writeString(city);
        dest.writeString(ruralRoute);
        dest.writeString(zipCode);
    }

    public static Parcelable.Creator<ParsedAddress> CREATOR = new Parcelable.Creator<ParsedAddress>() {
        @Override
        public ParsedAddress createFromParcel(Parcel source) {
            return new ParsedAddress(source);
        }

        @Override
        public ParsedAddress[] newArray(int size) {
            return new ParsedAddress[size];
        }
    };



}
