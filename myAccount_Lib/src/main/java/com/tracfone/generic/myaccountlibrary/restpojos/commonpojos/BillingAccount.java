package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by skishore on 10/18/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccount implements Parcelable{

    @JsonProperty("paymentPlan")
    private PaymentPlan paymentPlan;
    @JsonProperty("id")
    private String id;

    public BillingAccount(){}
    protected BillingAccount(Parcel in) {
        paymentPlan = in.readParcelable(PaymentPlan.class.getClassLoader());
        id = in.readString();
    }

    public static final Creator<BillingAccount> CREATOR = new Creator<BillingAccount>() {
        @Override
        public BillingAccount createFromParcel(Parcel in) {
            return new BillingAccount(in);
        }

        @Override
        public BillingAccount[] newArray(int size) {
            return new BillingAccount[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaymentPlan getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(PaymentPlan paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(paymentPlan, i);
        parcel.writeString(id);
    }
}
