package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SupportingResources implements Parcelable{
    @JsonProperty("resourceType")
    private String resourceType;
    @JsonProperty("productIdentifier")
    private String productIdentifier;
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("resourceCategory")
    private String resourceCategory;
    @JsonProperty("resourceIdentifier")
    private String resourceIdentifier;

    public static final String RESOURCE_TYPE_AIRTIME_CARD = "AIRTIME_CARD";
    public static final String RESOURCE_TYPE_SIM_CARD= "SIM_CARD";
    public static final String RESOURCE_TYPE_LINE= "LINE";
    public static final String RESOURCE_TYPE_HANDSET= "HANDSET";

    public SupportingResources(){}
    protected SupportingResources(Parcel in) {
        resourceType = in.readString();
        productIdentifier = in.readString();
        serialNumber = in.readString();
        resourceCategory = in.readString();
        resourceIdentifier = in.readString();
    }

    public static final Creator<SupportingResources> CREATOR = new Creator<SupportingResources>() {
        @Override
        public SupportingResources createFromParcel(Parcel in) {
            return new SupportingResources(in);
        }

        @Override
        public SupportingResources[] newArray(int size) {
            return new SupportingResources[size];
        }
    };

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public static final String RESOURCE_CATEGORY_SIMCARD = "SIM_CARD";
    public static final String RESOURCE_CATEGORY_CARRIER = "CARRIER";
    public static final String RESOURCE_CATEGORY_SIMSIZE = "SIM_SIZE";
    public String getResourceCategory() {
        return resourceCategory;
    }

    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory;
    }

    public static final String RESOURCE_IDENTIFIER_NANO = "NANO";
    public String getResourceIdentifier() {
        return resourceIdentifier;
    }

    public void setResourceIdentifier(String resourceIdentifier) {
        this.resourceIdentifier = resourceIdentifier;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(resourceType);
        dest.writeString(productIdentifier);
        dest.writeString(serialNumber);
        dest.writeString(resourceCategory);
        dest.writeString(resourceIdentifier);
    }
}
