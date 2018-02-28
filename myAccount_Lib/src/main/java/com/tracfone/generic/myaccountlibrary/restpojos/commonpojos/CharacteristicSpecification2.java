package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by atatipally on 12/12/2016.
 */
public class CharacteristicSpecification2 implements Parcelable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private int value;

    public CharacteristicSpecification2(){}
    protected CharacteristicSpecification2(Parcel in) {
        name = in.readString();
        value = in.readInt();
    }

    public static final Creator<CharacteristicSpecification2> CREATOR = new Creator<CharacteristicSpecification2>() {
        @Override
        public CharacteristicSpecification2 createFromParcel(Parcel in) {
            return new CharacteristicSpecification2(in);
        }

        @Override
        public CharacteristicSpecification2[] newArray(int size) {
            return new CharacteristicSpecification2[size];
        }
    };

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public static final String NAME_ORDER_ITEM_ID = "orderItemId";
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
        dest.writeInt(value);
    }
}
