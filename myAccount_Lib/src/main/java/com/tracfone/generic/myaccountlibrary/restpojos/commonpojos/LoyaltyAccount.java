package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hserna on 7/27/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class LoyaltyAccount implements Parcelable {

    public static final String TYPE_TF_POINTS_PYMT_TYPE = "TF_POINTS_PYMT_TYPE";

    @JsonProperty("type")
    private String type;

    public LoyaltyAccount(){}
    protected LoyaltyAccount(Parcel in){
        type = in.readString();
    }

    public static final Creator<LoyaltyAccount> CREATOR = new Creator<LoyaltyAccount>() {
        @Override
        public LoyaltyAccount createFromParcel(Parcel in) {
            return new LoyaltyAccount(in);
        }

        @Override
        public LoyaltyAccount[] newArray(int size) {
            return new LoyaltyAccount[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
    }
}
