package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class Discounts implements Parcelable {

    @JsonProperty("specification")
    private Specifications specifications;


    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public Discounts() {}

    protected Discounts(Parcel in) {
        specifications =  in.readParcelable(Specifications.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(specifications, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Discounts> CREATOR = new Parcelable.Creator<Discounts>() {
        @Override
        public Discounts createFromParcel(Parcel in) {
            return new Discounts(in);
        }

        @Override
        public Discounts[] newArray(int size) {
            return new Discounts[size];
        }
    };

}
