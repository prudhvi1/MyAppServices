package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hserna on 10/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccountV2 implements Parcelable {

    @JsonProperty("customerBill")
    private CustomerBill customerBill;
    @JsonProperty("customerPayment")
    private CustomerPayment customerPayment;

    public BillingAccountV2(){}
    protected BillingAccountV2(Parcel in) {
        customerBill = in.readParcelable(CustomerBill.class.getClassLoader());
        customerPayment = in.readParcelable(CustomerPayment.class.getClassLoader());
    }

    public static final Creator<BillingAccountV2> CREATOR = new Creator<BillingAccountV2>() {
        @Override
        public BillingAccountV2 createFromParcel(Parcel in) {
            return new BillingAccountV2(in);
        }

        @Override
        public BillingAccountV2[] newArray(int size) {
            return new BillingAccountV2[size];
        }
    };

    public CustomerBill getCustomerBill() {
        return customerBill;
    }

    public void setCustomerBill(CustomerBill customerBill) {
        this.customerBill = customerBill;
    }

    public CustomerPayment getCustomerPayment() {
        return customerPayment;
    }

    public void setCustomerPayment(CustomerPayment customerPayment) {
        this.customerPayment = customerPayment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(customerBill, i);
        parcel.writeParcelable(customerPayment, i);
    }
}
