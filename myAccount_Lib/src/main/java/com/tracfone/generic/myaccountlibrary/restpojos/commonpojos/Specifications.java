package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class Specifications implements Parcelable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;


    public static final String TYPE_EXTERNAL = "External";
    public static final String TYPE_INTERNAL = "Internal";
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final String VALUE_ATT = "AT&T";
    public static final String VALUE_TMOBILE = "T-Mobile";
    public static final String VALUE_GSM_UNLOCKED="GSM";
    public static final String VALUE_VERIZON = "Verizon";
    public static final String VALUE_SPRINT = "Sprint";
    public static final String VALUE_MULTI_CARRIER = "MULTI CARRIER";
    public static final String VALUE_NOT_ELIGIBLE = "NOT ELIGIBLE";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Specifications() { }
    protected Specifications(Parcel in) {
        name = in.readString();
        value = in.readString();
        description = in.readString();
        type = in.readString();
    }

    public static final Creator<Specifications> CREATOR = new Creator< Specifications>() {
        @Override
        public  Specifications createFromParcel(Parcel in) {
            return new  Specifications(in);
        }

        @Override
        public  Specifications[] newArray(int size) {
            return new  Specifications[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(value);
        parcel.writeString(description);
        parcel.writeString(type);
    }
}
