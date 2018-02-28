package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by com.tracfone.preload on 1/16/2017.
 */

public class PartNumber implements Parcelable {

    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("partNumber")
    private String partNumber;

    public int getQuantity() {	return quantity; }
    public void setQuantity(int quantity) {	this.quantity = quantity; }


    public String getPartNumber() {	return partNumber;	}
    public void setPartNumber(String partNumber) {	this.partNumber = partNumber; }

    public PartNumber() { }
    protected PartNumber(Parcel in) {
        quantity = in.readInt();
        partNumber = in.readString();
    }

    public static final Creator<PartNumber> CREATOR = new Creator<PartNumber>() {
        @Override
        public PartNumber createFromParcel(Parcel in) {
            return new PartNumber(in);
        }

        @Override
        public PartNumber[] newArray(int size) {
            return new PartNumber[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(quantity);
        parcel.writeString(partNumber);
    }
}
