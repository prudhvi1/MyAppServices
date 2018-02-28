package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by skishore on 10/19/2016.
 */

public class ProductPromotions implements Parcelable{
    @JsonProperty("id")
    private String id;
    public ProductPromotions(){}
    protected ProductPromotions(Parcel in) {
        id = in.readString();
    }

    public static final Creator<ProductPromotions> CREATOR = new Creator<ProductPromotions>() {
        @Override
        public ProductPromotions createFromParcel(Parcel in) {
            return new ProductPromotions(in);
        }

        @Override
        public ProductPromotions[] newArray(int size) {
            return new ProductPromotions[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }
}
