package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by psamdrala on 11/8/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Parcelable {

    public static final String CATEGORY_HANDSET = "HANDSET";

    @JsonProperty("productSerialNumber")
    private String productSerialNumber;
    @JsonProperty("productCategory")
    private String productCategory;
    @JsonProperty("nickName")
    private String nickName;
    @JsonProperty("productSpecification")
    private ProductSpecification productSpecification;
    @JsonProperty("relatedServices")
    private RelatedServices relatedServices;
    @JsonProperty("supportingResources")
    private ArrayList<SupportingResources> supportingResources;

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public void setProductSerialNumber(String productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }

    public RelatedServices getRelatedServices() {
        return relatedServices;
    }

    public void setRelatedServices(RelatedServices relatedServices) {
        this.relatedServices = relatedServices;
    }

    public ArrayList<SupportingResources> getSupportingResources() {
        return supportingResources;
    }

    public void setSupportingResources(ArrayList<SupportingResources> supportingResources) {
        this.supportingResources = supportingResources;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Product() {}
    protected Product(Parcel in) {
        productSerialNumber = in.readString();
        productCategory = in.readString();
        nickName = in.readString();
        productSpecification = in.readParcelable(ProductSpecification.class.getClassLoader());
        relatedServices = in.readParcelable(RelatedServices.class.getClassLoader());
        supportingResources = in.createTypedArrayList(SupportingResources.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(productSerialNumber);
        parcel.writeString(productCategory);
        parcel.writeString(nickName);
        parcel.writeParcelable(productSpecification, i);
        parcel.writeParcelable(relatedServices, i);
        parcel.writeTypedList(supportingResources);
    }
}
