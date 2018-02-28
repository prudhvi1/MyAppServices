package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hserna on 8/1/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckPoints implements Parcelable {

    public static final String CHECKPOINT_SMS = "SMS";
    public static final String CHECKPOINT_EMAIL = "EMAIL";
    public static final String CHECKPOINT_ZIPCODE = "ZIPCODE";

    @JsonProperty("type")
    String type;
    @JsonProperty("maskedValue")
    String maskedValue;

    public CheckPoints(){}

    protected CheckPoints(Parcel in) {

        type = in.readString();
        maskedValue = in.readString();
    }

    public static final Creator<CheckPoints> CREATOR = new Creator<CheckPoints>() {
        @Override
        public CheckPoints createFromParcel(Parcel in) {
            return new CheckPoints(in);
        }

        @Override
        public CheckPoints[] newArray(int size) {
            return new CheckPoints[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(maskedValue);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaskedValue() {
        return maskedValue;
    }

    public void setMakedValue(String maskedValue) {
        this.maskedValue = maskedValue;
    }
}
