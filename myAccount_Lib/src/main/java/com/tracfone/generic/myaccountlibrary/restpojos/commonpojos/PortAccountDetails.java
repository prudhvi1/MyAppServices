package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by atatipally on 11/18/2016.
 */
public class PortAccountDetails implements Parcelable{

    private String currentAccountNumber;
    private String currentPin;
    private String currentVKey;
    private String currentFullName;
    private String ssnLast4Digits;
    private String contactPhone;

    public String getSsnLast4Digits() {
        return ssnLast4Digits;
    }

    public void setSsnLast4Digits(String ssnLast4Digits) {
        this.ssnLast4Digits = ssnLast4Digits;
    }

    public String getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(String currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }

    public String getCurrentPin() {
        return currentPin;
    }

    public void setCurrentPin(String currentPin) {
        this.currentPin = currentPin;
    }

    public String getCurrentVKey() {
        return currentVKey;
    }

    public void setCurrentVKey(String currentVKey) {
        this.currentVKey = currentVKey;
    }

    public String getCurrentFullName() {
        return currentFullName;
    }

    public void setCurrentFullName(String currentFullName) {
        this.currentFullName = currentFullName;
    }

    public String getContactPhonee() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public PortAccountDetails() {
    }

    protected PortAccountDetails(Parcel in) {
        currentAccountNumber = in.readString();
        currentPin = in.readString();
        currentVKey = in.readString();
        currentFullName = in.readString();
        ssnLast4Digits = in.readString();
        contactPhone = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(currentAccountNumber);
        dest.writeString(currentPin);
        dest.writeString(currentVKey);
        dest.writeString(currentFullName);
        dest.writeString(ssnLast4Digits);
        dest.writeString(contactPhone);
    }

    public static Parcelable.Creator<PortAccountDetails> CREATOR = new Parcelable.Creator<PortAccountDetails>() {
        @Override
        public PortAccountDetails createFromParcel(Parcel source) {
            return new PortAccountDetails(source);
        }

        @Override
        public PortAccountDetails[] newArray(int size) {
            return new PortAccountDetails[size];
        }
    };
}
