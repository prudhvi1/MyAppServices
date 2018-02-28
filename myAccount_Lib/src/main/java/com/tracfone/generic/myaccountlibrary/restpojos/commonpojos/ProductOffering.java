package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class ProductOffering implements Parcelable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("productSpecification")
    private ProductSpecification productSpecification;
    @JsonProperty("supportingResources")
    private ArrayList<SupportingResources> supportingResources;

    public ProductOffering(){}
    protected ProductOffering(Parcel in) {
        id = in.readString();
        name = in.readString();
        productSpecification = in.readParcelable(ProductSpecification.class.getClassLoader());
        supportingResources = in.createTypedArrayList(SupportingResources.CREATOR);
    }

    public static final Creator<ProductOffering> CREATOR = new Creator<ProductOffering>() {
        @Override
        public ProductOffering createFromParcel(Parcel in) {
            return new ProductOffering(in);
        }

        @Override
        public ProductOffering[] newArray(int size) {
            return new ProductOffering[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }

    public ArrayList<SupportingResources> getSupportingResources() {
        return supportingResources;
    }

    public void setSupportingResources(ArrayList<SupportingResources> supportingResources) {
        this.supportingResources = supportingResources;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeParcelable(productSpecification, flags);
        dest.writeTypedList(supportingResources);
    }
}
