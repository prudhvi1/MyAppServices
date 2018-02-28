package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class OrderItemPrice implements Parcelable{

    @JsonProperty("price")
    private Price price;
    @JsonProperty("tax")
    private Tax tax;
    @JsonProperty("discounts")
    private ArrayList<Discounts> discounts;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public ArrayList<Discounts> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discounts> discounts) {
        this.discounts = discounts;
    }


    protected OrderItemPrice(Parcel in) {
        price = in.readParcelable(Price.class.getClassLoader());
        tax = in.readParcelable(Tax.class.getClassLoader());
        discounts=  in.createTypedArrayList(Discounts.CREATOR);
    }

    public OrderItemPrice() {}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(price, flags);
        dest.writeParcelable(tax, flags);
        dest.writeTypedList(discounts);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OrderItemPrice> CREATOR = new Creator<OrderItemPrice>() {
        @Override
        public OrderItemPrice createFromParcel(Parcel in) {
            return new OrderItemPrice(in);
        }

        @Override
        public OrderItemPrice[] newArray(int size) {
            return new OrderItemPrice[size];
        }
    };

}
