package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by com.tracfone.preload on 1/16/2017.
 */

public class VasPlans implements Parcelable {

    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("vasPlanId")
    private int vasPlanId;
    @JsonProperty("partNumber")
    private String partNumber;

    public int getQuantity() {	return quantity; }
    public void setQuantity(int quantity) {	this.quantity = quantity; }

    public int getVasPlanId() {	return vasPlanId; }
    public void setVasPlanId(int vasPlanId) { this.vasPlanId = vasPlanId; }

    public String getPartNumber() {	return partNumber;	}
    public void setPartNumber(String partNumber) {	this.partNumber = partNumber; }

    public VasPlans() { }
    protected VasPlans(Parcel in) {
        quantity = in.readInt();
        vasPlanId = in.readInt();
        partNumber = in.readString();
    }

    public static final Creator<VasPlans> CREATOR = new Creator<VasPlans>() {
        @Override
        public VasPlans createFromParcel(Parcel in) {
            return new VasPlans(in);
        }

        @Override
        public VasPlans[] newArray(int size) {
            return new VasPlans[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(quantity);
        parcel.writeInt(vasPlanId);
        parcel.writeString(partNumber);
    }
}
