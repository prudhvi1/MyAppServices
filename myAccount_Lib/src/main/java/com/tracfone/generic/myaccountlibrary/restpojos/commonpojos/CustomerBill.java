package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerBill implements Parcelable {

    @JsonProperty("billNo")
    private String billNo;
    @JsonProperty("customerBillingCycle")
    private CustomerBillingCycle customerBillingCycle;
    @JsonProperty("pointsAccrued")
    private double pointsAccrued;
    @JsonProperty("customerBillTaxes")
    private Tax tax;

    public CustomerBill() {}

    public static final Creator<CustomerBill> CREATOR = new Creator<CustomerBill>() {
        @Override
        public CustomerBill createFromParcel(Parcel in) {
            return new CustomerBill(in);
        }

        @Override
        public CustomerBill[] newArray(int size) {
            return new CustomerBill[size];
        }
    };

    public CustomerBillingCycle getCustomerBillingCycle() {
        return customerBillingCycle;
    }

    public void setCustomerBillingCycle(CustomerBillingCycle customerBillingCycle) {
        this.customerBillingCycle = customerBillingCycle;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public double getPointsAccrued() {
        return pointsAccrued;
    }

    public void setPointsAccrued(double pointsAccrued) {
        this.pointsAccrued = pointsAccrued;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    protected CustomerBill(Parcel in) {
        billNo = in.readString();
        customerBillingCycle = in.readParcelable(CustomerBillingCycle.class.getClassLoader());
        pointsAccrued = in.readDouble();
        tax = in.readParcelable(Tax.class.getClassLoader());

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(billNo);
        parcel.writeParcelable(customerBillingCycle, i);
        parcel.writeDouble(pointsAccrued);
        parcel.writeParcelable(tax, i);

    }
}
