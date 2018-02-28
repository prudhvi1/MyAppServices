package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by atatipally on 9/22/2016.
 */
public class RequestValidateAddress {

    public static class ValidateAddress implements Parcelable{
        @JsonProperty("id")
        private String id;
        @JsonProperty("addressLine1")
        private String addressLine1;
        @JsonProperty("addressLine2")
        private String addressLine2;
        @JsonProperty("city")
        private String city;
        @JsonProperty("country")
        private String country;
        @JsonProperty("locality")
        private String locality;
        @JsonProperty("poBoxNumber")
        private String  poBoxNumber;
        @JsonProperty("stateOrProvince")
        private String stateOrProvince;
        @JsonProperty("streetName")
        private String streetName;
        @JsonProperty("zipcode")
        private String zipCode;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getPoBoxNumber() {
            return poBoxNumber;
        }

        public void setPoBoxNumber(String poBoxNumber) {
            this.poBoxNumber = poBoxNumber;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }


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

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getStateOrProvince() {
            return stateOrProvince;
        }

        public void setStateOrProvince(String stateOrProvince) {
            this.stateOrProvince = stateOrProvince;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public ValidateAddress() {
        }

        protected ValidateAddress(Parcel in) {
            id = in.readString();
            addressLine1 = in.readString();
            addressLine2 = in.readString();
            city = in.readString();
            country = in.readString();
            locality = in.readString();
            poBoxNumber = in.readString();
            stateOrProvince = in.readString();
            streetName = in.readString();
            zipCode = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(addressLine1);
            dest.writeString(addressLine2);
            dest.writeString(city);
            dest.writeString(country);
            dest.writeString(locality);
            dest.writeString(poBoxNumber);
            dest.writeString(stateOrProvince);
            dest.writeString(streetName);
            dest.writeString(zipCode);
        }

        public static Parcelable.Creator<ValidateAddress> CREATOR = new Parcelable.Creator<ValidateAddress>() {
            @Override
            public ValidateAddress createFromParcel(Parcel source) {
                return new ValidateAddress(source);
            }

            @Override
            public ValidateAddress[] newArray(int size) {
                return new ValidateAddress[size];
            }
        };
    }
    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private ValidateAddress request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public ValidateAddress getRequest() {
        return request;
    }
    public void setRequest(ValidateAddress request) {
        this.request = request;
    }


}
