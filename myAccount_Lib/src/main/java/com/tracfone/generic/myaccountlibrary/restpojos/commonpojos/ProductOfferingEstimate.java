package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOfferingEstimate implements Parcelable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("productSpecification")
    private ProductSpecification productSpecification;
    @JsonProperty("validFor")
    private ValidFor validFor;

    public ProductOfferingEstimate(){}

    protected ProductOfferingEstimate(Parcel in) {
        id = in.readString();
        brand = in.readString();
        productSpecification = in.readParcelable(ProductSpecification.class.getClassLoader());
        validFor = in.readParcelable(ValidFor.class.getClassLoader());
    }

    public static final Creator<ProductOfferingEstimate> CREATOR = new Creator<ProductOfferingEstimate>() {
        @Override
        public ProductOfferingEstimate createFromParcel(Parcel in) {
            return new ProductOfferingEstimate(in);
        }

        @Override
        public ProductOfferingEstimate[] newArray(int size) {
            return new ProductOfferingEstimate[size];
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

    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }

    public ValidFor getValidFor() {
        return validFor;
    }

    public void setValidFor(ValidFor validFor) {
        this.validFor = validFor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(brand);
        dest.writeParcelable(productSpecification, flags);
        dest.writeParcelable(validFor, flags);
    }
}
