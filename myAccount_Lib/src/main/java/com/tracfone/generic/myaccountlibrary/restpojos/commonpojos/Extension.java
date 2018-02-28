package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class Extension implements Parcelable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    public static final String NAME_GROUP_IDENTIFIER  = "groupIdentifier";

    public Extension() {}
    protected Extension(Parcel in) {
        name = in.readString();
        value = in.readString();
    }

    public static final Creator<Extension> CREATOR = new Creator<Extension>() {
        @Override
        public Extension createFromParcel(Parcel in) {
            return new Extension(in);
        }

        @Override
        public Extension[] newArray(int size) {
            return new Extension[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(value);
    }
}
