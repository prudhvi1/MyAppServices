package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentPlan implements Parcelable{

    @JsonProperty("isRecurring")
    private boolean isRecurring;
    @JsonProperty("paymentMean")
    private PaymentMean paymentMean;

    public Boolean getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public PaymentMean getPaymentMean() {
        return paymentMean;
    }

    public void setPaymentMean(PaymentMean paymentMean) {
        this.paymentMean = paymentMean;
    }



    public PaymentPlan(){}
    protected PaymentPlan(Parcel in) {
        isRecurring = in.readByte() != 0;
        paymentMean = in.readParcelable(PaymentMean.class.getClassLoader());
    }

    public static final Creator<PaymentPlan> CREATOR = new Creator<PaymentPlan>() {
        @Override
        public PaymentPlan createFromParcel(Parcel in) {
            return new PaymentPlan(in);
        }

        @Override
        public PaymentPlan[] newArray(int size) {
            return new PaymentPlan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (isRecurring ? 1 : 0));
        parcel.writeParcelable(paymentMean, i);
    }
}
