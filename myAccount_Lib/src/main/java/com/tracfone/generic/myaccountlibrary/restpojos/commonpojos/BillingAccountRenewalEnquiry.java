package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by skishore on 10/18/2016.
 */

public class BillingAccountRenewalEnquiry implements Parcelable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("products")
    private ArrayList<Products> products;
    @JsonProperty("customerBill")
    private CustomerBill customerBill;

    public BillingAccountRenewalEnquiry(){}
    protected BillingAccountRenewalEnquiry(Parcel in) {
        id = in.readString();
        products = in.createTypedArrayList(Products.CREATOR);
        customerBill = in.readParcelable(CustomerBill.class.getClassLoader());
    }

    public static final Creator<BillingAccountRenewalEnquiry> CREATOR = new Creator<BillingAccountRenewalEnquiry>() {
        @Override
        public BillingAccountRenewalEnquiry createFromParcel(Parcel in) {
            return new BillingAccountRenewalEnquiry(in);
        }

        @Override
        public BillingAccountRenewalEnquiry[] newArray(int size) {
            return new BillingAccountRenewalEnquiry[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public CustomerBill getCustomerBill() {
        return customerBill;
    }

    public void setCustomerBill(CustomerBill customerBill) {
        this.customerBill = customerBill;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeTypedList(products);
        parcel.writeParcelable(customerBill, i);
    }
}
