package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class ProductRequest implements Parcelable {

    @JsonProperty("productSerialNumber")
    private String productSerialNumber;
    @JsonProperty("productCategory")
    private String productCategory;
    @JsonProperty("productSpecification")
    private ProductSpecification productSpecification;
    @JsonProperty("relatedServices")
    private ArrayList<RelatedServices> relatedServices;
    @JsonProperty("supportingResources")
    private ArrayList<SupportingResources> supportingResources;

    public static final Creator<ProductRequest> CREATOR = new Creator<ProductRequest>() {
        @Override
        public ProductRequest createFromParcel(Parcel in) {
            return new ProductRequest(in);
        }

        @Override
        public ProductRequest[] newArray(int size) {
            return new ProductRequest[size];
        }
    };

    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public void setProductSerialNumber(String productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
    }

    public static final String CATEGORY_HANDSET = "HANDSET";
    public static final String CATEGORY_LINE = "LINE";

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

    public ArrayList<RelatedServices> getRelatedServices() {
        return relatedServices;
    }

    public void setRelatedServices(ArrayList<RelatedServices> relatedServices) {
        this.relatedServices = relatedServices;
    }

    public ArrayList<SupportingResources> getSupportingResources() {
        return supportingResources;
    }

    public void setSupportingResources(ArrayList<SupportingResources> supportingResources) {
        this.supportingResources = supportingResources;
    }

    public ProductRequest() {}
    protected ProductRequest(Parcel in) {
        productSerialNumber = in.readString();
        productCategory = in.readString();
        productSpecification = in.readParcelable(ProductSpecification.class.getClassLoader());
        relatedServices = in.createTypedArrayList(RelatedServices.CREATOR);
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
        parcel.writeParcelable(productSpecification, i);
        parcel.writeTypedList(relatedServices);
        parcel.writeTypedList(supportingResources);
    }
}
