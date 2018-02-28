package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hserna on 10/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMeanV2 implements Parcelable {

    @JsonProperty("type")
    private String paymentType;
    @JsonProperty("creditCard")
    private CreditCardV2 creditCardV2;

    public PaymentMeanV2(){}
    protected PaymentMeanV2(Parcel in) {
        paymentType = in.readString();
        creditCardV2 = in.readParcelable(CreditCardV2.class.getClassLoader());
    }

    public static final Creator<PaymentMeanV2> CREATOR = new Creator<PaymentMeanV2>() {
        @Override
        public PaymentMeanV2 createFromParcel(Parcel in) {
            return new PaymentMeanV2(in);
        }

        @Override
        public PaymentMeanV2[] newArray(int size) {
            return new PaymentMeanV2[size];
        }
    };

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public CreditCardV2 getCreditCardV2() {
        return creditCardV2;
    }

    public void setCreditCardV2(CreditCardV2 creditCardV2) {
        this.creditCardV2 = creditCardV2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(paymentType);
        parcel.writeParcelable(creditCardV2, i);
    }
}
