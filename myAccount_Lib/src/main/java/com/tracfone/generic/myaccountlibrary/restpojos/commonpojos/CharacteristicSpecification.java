package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by atatipally on 12/12/2016.
 */
public class CharacteristicSpecification implements Parcelable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    public CharacteristicSpecification(){}
    protected CharacteristicSpecification(Parcel in) {
        name = in.readString();
        value = in.readString();
    }

    public static final Creator<CharacteristicSpecification> CREATOR = new Creator<CharacteristicSpecification>() {
        @Override
        public CharacteristicSpecification createFromParcel(Parcel in) {
            return new CharacteristicSpecification(in);
        }

        @Override
        public CharacteristicSpecification[] newArray(int size) {
            return new CharacteristicSpecification[size];
        }
    };

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public static final String NAME_RELATED_PROGRAM = "relatedProgramId";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
