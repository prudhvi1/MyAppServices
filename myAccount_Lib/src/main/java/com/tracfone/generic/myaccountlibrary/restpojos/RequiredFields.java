package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by psamdrala on 3/13/2017.
 */

public class RequiredFields implements Parcelable {
public RequiredFields(){}

    public String isPhoneNumberRequired;
    public String isEsnRequired;
    public String isAccountNumberRequired;
    public String isPasswordRequired;
    public String isVKeysRequired;
    public String isFullNmRequired;
    public String isBillingAddrRequired;
    public String isLast4SsnRequired;
    public String isAccAlphaNumeric;
    public String isPinAlphaNumer;

    public static String VALUE_TRUE = "Y";
    public static String VALUE_FALSE = "N";

    public String getIsPhoneNumberRequired() {
        return isPhoneNumberRequired;
    }

    public void setIsPhoneNumberRequired(String isPhoneNumberRequired) {
        this.isPhoneNumberRequired = isPhoneNumberRequired;
    }

    public String getIsEsnRequired() {
        return isEsnRequired;
    }

    public void setIsEsnRequired(String isEsnRequired) {
        this.isEsnRequired = isEsnRequired;
    }

    public String getIsAccountNumberRequired() {
        return isAccountNumberRequired;
    }

    public void setIsAccountNumberRequired(String isAccountNumberRequired) {
        this.isAccountNumberRequired = isAccountNumberRequired;
    }

    public String getIsPasswordRequired() {
        return isPasswordRequired;
    }

    public void setIsPasswordRequired(String isPasswordRequired) {
        this.isPasswordRequired = isPasswordRequired;
    }

    public String getIsVKeysRequired() {
        return isVKeysRequired;
    }

    public void setIsVKeysRequired(String isVKeysRequired) {
        this.isVKeysRequired = isVKeysRequired;
    }

    public String getIsFullNmRequired() {
        return isFullNmRequired;
    }

    public void setIsFullNmRequired(String isFullNmRequired) {
        this.isFullNmRequired = isFullNmRequired;
    }

    public String getIsBillingAddrRequired() {
        return isBillingAddrRequired;
    }

    public void setIsBillingAddrRequired(String isBillingAddrRequired) {
        this.isBillingAddrRequired = isBillingAddrRequired;
    }

    public String getIsLast4SsnRequired() {
        return isLast4SsnRequired;
    }

    public void setIsLast4SsnRequired(String isLast4SsnRequired) {
        this.isLast4SsnRequired = isLast4SsnRequired;
    }

    public String getIsAccAlphaNumeric() {
        return isAccAlphaNumeric;
    }

    public void setIsAccAlphaNumeric(String isAccAlphaNumeric) {
        this.isAccAlphaNumeric = isAccAlphaNumeric;
    }

    public String getIsPinAlphaNumer() {
        return isPinAlphaNumer;
    }

    public void setIsPinAlphaNumer(String isPinAlphaNumer) {
        this.isPinAlphaNumer = isPinAlphaNumer;
    }



    public RequiredFields(Parcel in) {
        isPhoneNumberRequired = in.readString();
        isEsnRequired = in.readString();
        isAccountNumberRequired = in.readString();
        isPasswordRequired = in.readString();
        isVKeysRequired = in.readString();
        isFullNmRequired = in.readString();
        isBillingAddrRequired = in.readString();
        isLast4SsnRequired = in.readString();
        isAccAlphaNumeric = in.readString();
        isPinAlphaNumer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(isPhoneNumberRequired);
        dest.writeString(isEsnRequired);
        dest.writeString(isAccountNumberRequired);
        dest.writeString(isPasswordRequired);
        dest.writeString(isVKeysRequired);
        dest.writeString(isFullNmRequired);
        dest.writeString(isBillingAddrRequired);
        dest.writeString(isLast4SsnRequired);
        dest.writeString(isAccAlphaNumeric);
        dest.writeString(isPinAlphaNumer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RequiredFields> CREATOR = new Creator<RequiredFields>() {
        @Override
        public RequiredFields createFromParcel(Parcel in) {
            return new RequiredFields(in);
        }

        @Override
        public RequiredFields[] newArray(int size) {
            return new RequiredFields[size];
        }
    };
}
