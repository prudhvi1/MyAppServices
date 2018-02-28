package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by gmateti on 4/11/2017.
 */

public class CustomerAccount implements Parcelable {

    @JsonProperty("pin")
    private String pin;

    protected CustomerAccount(Parcel in) {
        pin = in.readString();
    }

    public CustomerAccount() {}
    public static final Creator<CustomerAccount> CREATOR = new Creator<CustomerAccount>() {
        @Override
        public CustomerAccount createFromParcel(Parcel in) {
            return new CustomerAccount(in);
        }

        @Override
        public CustomerAccount[] newArray(int size) {
            return new CustomerAccount[size];
        }
    };

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(pin);
    }
}
