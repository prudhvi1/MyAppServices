package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CustomerBillingCycle implements Parcelable{

    @JsonProperty("chargeDate")
    private String chargeDate;

    public CustomerBillingCycle() {}
    protected CustomerBillingCycle(Parcel in) {
        chargeDate = in.readString();
    }

    public static final Creator<CustomerBillingCycle> CREATOR = new Creator<CustomerBillingCycle>() {
        @Override
        public CustomerBillingCycle createFromParcel(Parcel in) {
            return new CustomerBillingCycle(in);
        }

        @Override
        public CustomerBillingCycle[] newArray(int size) {
            return new CustomerBillingCycle[size];
        }
    };


    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(chargeDate);
    }
}
