package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Created by hserna on 10/16/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPrice implements Parcelable {

    @JsonProperty("price")
    private Price price;
    @JsonProperty("recurringPrice")
    private RecurringPrice recurringPrice;
    @JsonProperty("tax")
    private Tax tax;

    public OrderPrice() {}
    protected OrderPrice(Parcel in) {
        price = in.readParcelable(Price.class.getClassLoader());
        recurringPrice = in.readParcelable((RecurringPrice.class.getClassLoader()));
        tax = in.readParcelable(Tax.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(price, flags);
        dest.writeParcelable(recurringPrice, flags);
        dest.writeParcelable(tax, flags);
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public RecurringPrice getRecurringPrice() {
        return recurringPrice;
    }

    public void setRecurringPrice(RecurringPrice recurringPrice) {
        this.recurringPrice = recurringPrice;
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

    public static final Creator<OrderPrice> CREATOR = new Creator<OrderPrice>() {
        @Override
        public OrderPrice createFromParcel(Parcel in) {
            return new OrderPrice(in);
        }

        @Override
        public OrderPrice[] newArray(int size) {
            return new OrderPrice[size];
        }
    };

}
