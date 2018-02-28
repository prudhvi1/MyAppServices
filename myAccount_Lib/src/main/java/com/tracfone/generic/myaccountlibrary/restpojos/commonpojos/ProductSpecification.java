package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class ProductSpecification implements Parcelable {

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("id")
    private String id;

    public ProductSpecification(){}
    protected ProductSpecification(Parcel in) {
        brand = in.readString();
    }

    public static final Creator<ProductSpecification> CREATOR = new Creator<ProductSpecification>() {
        @Override
        public ProductSpecification createFromParcel(Parcel in) {
            return new ProductSpecification(in);
        }

        @Override
        public ProductSpecification[] newArray(int size) {
            return new ProductSpecification[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brand);
    }
}
