package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hserna on 10/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPayment implements Parcelable {

    @JsonProperty("paymentMean")
    private PaymentMeanV2 paymentMeanV2;
    @JsonProperty("isRecurring")
    private boolean isRecurring;

    public CustomerPayment(){}
    protected CustomerPayment(Parcel in) {
        paymentMeanV2 = in.readParcelable(PaymentMeanV2.class.getClassLoader());
        isRecurring = in.readByte() != 0;
    }

    public static final Creator<CustomerPayment> CREATOR = new Creator<CustomerPayment>() {
        @Override
        public CustomerPayment createFromParcel(Parcel in) {
            return new CustomerPayment(in);
        }

        @Override
        public CustomerPayment[] newArray(int size) {
            return new CustomerPayment[size];
        }
    };

    public PaymentMeanV2 getPaymentMeanV2() {
        return paymentMeanV2;
    }

    public void setPaymentMeanV2(PaymentMeanV2 paymentMeanV2) {
        this.paymentMeanV2 = paymentMeanV2;
    }

    public void setIsRecurring(boolean isRecurring){
        this.isRecurring = isRecurring;
    }

    public boolean getIsRecurring(){
        return isRecurring;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(paymentMeanV2, i);
        parcel.writeByte((byte) (isRecurring ? 1 : 0));
    }
}
