package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hserna on 10/16/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecurringPrice implements Parcelable {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("tax")
    private Tax tax;

    public RecurringPrice(){}
    protected RecurringPrice(Parcel in) {
        amount = in.readString();
        currencyCode = in.readString();
        tax = in.readParcelable(Tax.class.getClassLoader());
    }

    public static final Creator<RecurringPrice> CREATOR = new Creator<RecurringPrice>() {
        @Override
        public RecurringPrice createFromParcel(Parcel in) {
            return new RecurringPrice(in);
        }

        @Override
        public RecurringPrice[] newArray(int size) {
            return new RecurringPrice[size];
        }
    };

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(amount);
        parcel.writeString(currencyCode);
        parcel.writeParcelable(tax, i);
    }
}
