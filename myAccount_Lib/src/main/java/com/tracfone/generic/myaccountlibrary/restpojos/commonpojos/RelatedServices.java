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

public class RelatedServices implements Parcelable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("category")
    private String category;
    @JsonProperty("type")
    private String type;
    @JsonProperty("benefitType")
    private String benefitType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("serviceSpecification")
    private ArrayList<ServiceSpecification> serviceSpecification;
    @JsonProperty("validFor")
    private ValidFor validFor;
    @JsonProperty("serviceExtension")
    private ArrayList<ServiceExtension> serviceExtension;
    @JsonProperty("characteristicSpecification")
    private ArrayList<CharacteristicSpecification> characteristicSpecification;
    @JsonProperty("isRedeemNow")
    private Boolean isRedeemNow;
    @JsonProperty("isEnrollNow")
    private Boolean isEnrollNow;
    @JsonProperty("isRecurring")
    private Boolean isRecurring;
    @JsonProperty("isEnrolled")
    private Boolean isEnrolled;

    public Boolean getIsRedeemNow() {
        return isRedeemNow;
    }

    public void setIsRedeemNow(Boolean isRedeemNow) {
        this.isRedeemNow = isRedeemNow;
    }

    public Boolean getIsEnrollNow() {
        return isEnrollNow;
    }

    public void setIsEnrollNow(Boolean isEnrollNow) {
        this.isEnrollNow = isEnrollNow;
    }

    public Boolean getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public Boolean getIsEnrolled() {
        return isEnrolled;
    }

    public void setIsEnrolled(Boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    public static final String CATEGORY_SERVICE_PLAN = "SERVICE_PLAN";
    public static final String CATEGORY_ILD_ADDON = "ILD_ADDON";
    public static final String CATEGORY_LOYALTY_PROGRAM = "LOYALTY_PROGRAM";
    public static final String TYPE_PROGRAM_ENROLLMENT = "PROGRAM_ENROLLMENT";
    public static final String BENEFIT_TYPE_LOYALTY_POINTS = "LOYALTY_POINTS";

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ServiceSpecification> getServiceSpecification() {
        return serviceSpecification;
    }

    public void setServiceSpecification(ArrayList<ServiceSpecification> serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
    }

    public ArrayList<ServiceExtension> getServiceExtension() {
        return serviceExtension;
    }

    public void setServiceExtension(ArrayList<ServiceExtension> serviceExtension) {
        this.serviceExtension = serviceExtension;
    }

    public ValidFor getValidFor() {
        return validFor;
    }

    public void setValidFor(ValidFor validFor) {
        this.validFor = validFor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<CharacteristicSpecification> getCharacteristicSpecification() {
        return characteristicSpecification;
    }

    public void setCharacteristicSpecification(ArrayList<CharacteristicSpecification> characteristicSpecification) {
        this.characteristicSpecification = characteristicSpecification;
    }

    public RelatedServices() {}
    protected RelatedServices(Parcel in) {
        id = in.readString();
        category = in.readString();
        type = in.readString();
        benefitType = in.readString();
        description = in.readString();
        serviceSpecification = in.createTypedArrayList(ServiceSpecification.CREATOR);
        validFor = in.readParcelable(ValidFor.class.getClassLoader());
        serviceExtension = in.createTypedArrayList(ServiceExtension.CREATOR);
        characteristicSpecification = in.createTypedArrayList(CharacteristicSpecification.CREATOR);
        switch (in.readInt()) {
            case 0:
                isRedeemNow = false;
                break;
            case 1:
                isRedeemNow = true;
                break;
            default:
                isRedeemNow = null;
                break;
        }
        switch (in.readInt()) {
            case 0:
                isEnrollNow = false;
                break;
            case 1:
                isEnrollNow = true;
                break;
            default:
                isEnrollNow = null;
                break;
        }
        switch (in.readInt()) {
            case 0:
                isRecurring = false;
                break;
            case 1:
                isRecurring = true;
                break;
            default:
                isRecurring = null;
                break;
        }
        switch (in.readInt()) {
            case 0:
                isEnrolled = false;
                break;
            case 1:
                isEnrolled = true;
                break;
            default:
                isEnrolled = null;
                break;
        }
    }

    public static final Parcelable.Creator<RelatedServices> CREATOR = new Parcelable.Creator<RelatedServices>() {
        @Override
        public com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices createFromParcel(Parcel in) {
            return new com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices(in);
        }

        @Override
        public com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices[] newArray(int size) {
            return new com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(category);
        parcel.writeString(type);
        parcel.writeString(benefitType);
        parcel.writeString(description);
        parcel.writeTypedList(serviceSpecification);
        parcel.writeParcelable(validFor, i);
        parcel.writeTypedList(serviceExtension);
        parcel.writeTypedList(characteristicSpecification);
        if (isRedeemNow == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeByte((byte) (isRedeemNow ? 1 : 0));
        }
        if (isEnrollNow == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeByte((byte) (isEnrollNow ? 1 : 0));
        }
        if (isRecurring == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeByte((byte) (isRecurring ? 1 : 0));
        }
        if (isEnrolled == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeByte((byte) (isEnrolled ? 1 : 0));
        }
    }
}
