package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price implements  Parcelable{

    public static final String CURRENCY_CODE_POINTS = "POINTS";

    @JsonProperty("amount")
    private double amount;
    @JsonProperty("currencyCode")
    private String currencyCode;

    public double getAmount() {
        return amount;

    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    public Price() {}

    protected Price(Parcel in) {
        amount = in.readDouble();
        currencyCode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(amount);
        dest.writeString(currencyCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Price> CREATOR = new Parcelable.Creator<Price>() {
        @Override
        public Price createFromParcel(Parcel in) {
            return new Price(in);
        }

        @Override
        public Price[] newArray(int size) {
            return new Price[size];
        }
    };
}
