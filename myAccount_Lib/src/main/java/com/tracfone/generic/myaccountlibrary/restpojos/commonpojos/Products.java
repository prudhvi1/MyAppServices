package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class Products implements Parcelable {

    @JsonProperty("productSerialNumber")
    private String productSerialNumber;
    @JsonProperty("productCategory")
    private String productCategory;
    @JsonProperty("relatedServices")
    private RelatedServices relatedServices;

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public void setProductSerialNumber(String productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
    }

    public static final String CATEGORY_HANDSET = "HANDSET";

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public RelatedServices getRelatedServices() {
        return relatedServices;
    }

    public void setRelatedServices(RelatedServices relatedServices) {
        this.relatedServices = relatedServices;
    }

    public Products() {}
    protected Products(Parcel in) {
        productSerialNumber = in.readString();
        productCategory = in.readString();
        relatedServices = in.readParcelable(RelatedServices.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(productSerialNumber);
        parcel.writeString(productCategory);
        parcel.writeParcelable(relatedServices, i);
    }
}
