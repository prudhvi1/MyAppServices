package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class AccountHolderName implements Parcelable {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
   

    public AccountHolderName(){}
    protected AccountHolderName(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
    }

    public static final Creator<AccountHolderName> CREATOR = new Creator<AccountHolderName>() {
        @Override
        public AccountHolderName createFromParcel(Parcel in) {
            return new AccountHolderName(in);
        }

        @Override
        public AccountHolderName[] newArray(int size) {
            return new AccountHolderName[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
    }
}
