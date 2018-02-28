package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceSpecificationV2 implements Parcelable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("isSharedPlan")
    private Boolean isSharedPlan;
    @JsonProperty("isGroupPlan")
    private Boolean isGroupPlan;
    @JsonProperty("isUnlimitedHighSpeed")
    private Boolean isUnlimitedHighSpeed;
    @JsonProperty("isUnlimitedVoice")
    private Boolean isUnlimitedVoice;
    @JsonProperty("isUnlimitedText")
    private Boolean isUnlimitedText;
    @JsonProperty("isILDSupported")
    private Boolean isILDSupported;

    public String getId() { return brand; }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getIsSharedPlan() {
        return isSharedPlan;
    }

    public void setIsSharedPlan(Boolean isSharedPlan) {
        this.isSharedPlan = isSharedPlan;
    }

    public Boolean getIsGroupPlan() {
        return isGroupPlan;
    }

    public void setIsGroupPlan(Boolean isGroupPlan) {
        this.isGroupPlan = isGroupPlan;
    }

    public Boolean getIsUnlimitedHighSpeed() {
        return isUnlimitedHighSpeed;
    }

    public void setIsUnlimitedHighSpeed(Boolean isUnlimitedHighSpeed) {
        this.isUnlimitedHighSpeed = isUnlimitedHighSpeed;
    }

    public Boolean getIsUnlimitedVoice() {
        return isUnlimitedVoice;
    }

    public void setIsUnlimitedVoice(Boolean isUnlimitedVoice) {
        this.isUnlimitedVoice = isUnlimitedVoice;
    }

    public Boolean getIsUnlimitedText() {
        return isUnlimitedText;
    }

    public void setIsUnlimitedText(Boolean isUnlimitedText) {
        this.isUnlimitedText = isUnlimitedText;
    }

    public Boolean getIsILDSupported() {
        return isILDSupported;
    }

    public void setIsILDSupported(Boolean isILDSupported) {
        this.isILDSupported = isILDSupported;
    }





    public ServiceSpecificationV2(){}
    protected ServiceSpecificationV2(Parcel in) {

         id = in.readString();
         brand = in.readString();
        switch (in.readInt()) {
            case 0:
                isSharedPlan = false;
                break;
            case 1:
                isSharedPlan = true;
                break;
            default:
                isSharedPlan = null;
                break;
        }
        switch (in.readInt()) {
            case 0:
                isGroupPlan = false;
                break;
            case 1:
                isGroupPlan = true;
                break;
            default:
                isGroupPlan = null;
                break;
        }
        switch (in.readInt()) {
            case 0:
                isUnlimitedHighSpeed = false;
                break;
            case 1:
                isUnlimitedHighSpeed = true;
                break;
            default:
                isUnlimitedHighSpeed = null;
                break;
        }
        switch (in.readInt()) {
            case 0:
                isUnlimitedVoice = false;
                break;
            case 1:
                isUnlimitedVoice = true;
                break;
            default:
                isUnlimitedVoice = null;
                break;
        }
        switch (in.readInt()) {
            case 0:
                isUnlimitedText = false;
                break;
            case 1:
                isUnlimitedText = true;
                break;
            default:
                isUnlimitedText = null;
                break;
        }
        switch (in.readInt()) {
            case 0:
                isILDSupported = false;
                break;
            case 1:
                isILDSupported = true;
                break;
            default:
                isILDSupported = null;
                break;
        }
    }

    public static final Creator<ServiceSpecificationV2> CREATOR = new Creator<ServiceSpecificationV2>() {
        @Override
        public ServiceSpecificationV2 createFromParcel(Parcel in) {
            return new ServiceSpecificationV2(in);
        }

        @Override
        public ServiceSpecificationV2[] newArray(int size) {
            return new ServiceSpecificationV2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(brand);
        if (isSharedPlan == null) {
            dest.writeInt(-1);
        } else {
            dest.writeByte((byte) (isSharedPlan ? 1 : 0));
        }
        if (isGroupPlan == null) {
            dest.writeInt(-1);
        } else {
            dest.writeByte((byte) (isGroupPlan ? 1 : 0));
        }
        if (isUnlimitedHighSpeed == null) {
            dest.writeInt(-1);
        } else {
            dest.writeByte((byte) (isUnlimitedHighSpeed ? 1 : 0));
        }
        if (isUnlimitedVoice == null) {
            dest.writeInt(-1);
        } else {
            dest.writeByte((byte) (isUnlimitedVoice ? 1 : 0));
        }
        if (isUnlimitedText == null) {
            dest.writeInt(-1);
        } else {
            dest.writeByte((byte) (isUnlimitedText ? 1 : 0));
        }
        if (isILDSupported == null) {
            dest.writeInt(-1);
        } else {
            dest.writeByte((byte) (isILDSupported ? 1 : 0));
        }
    }
}
