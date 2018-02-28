package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hserna on 10/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardV2 implements Parcelable {

    @JsonProperty("type")
    private String type;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("accountNumber")
    private String accountNumber;

    public CreditCardV2(){}
    protected CreditCardV2(Parcel in) {
        type = in.readString();
        nickname = in.readString();
        accountNumber = in.readString();
    }

    public static final Creator<CreditCardV2> CREATOR = new Creator<CreditCardV2>() {
        @Override
        public CreditCardV2 createFromParcel(Parcel in) {
            return new CreditCardV2(in);
        }

        @Override
        public CreditCardV2[] newArray(int size) {
            return new CreditCardV2[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(nickname);
        parcel.writeString(accountNumber);
    }
}
