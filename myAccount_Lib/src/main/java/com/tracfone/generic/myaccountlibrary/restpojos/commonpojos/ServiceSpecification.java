package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class ServiceSpecification implements Parcelable{

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("lifecycleStatus")
    private String lifecycleStatus;
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;
    @JsonProperty("valueType")
    private String valueType;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static final String LIFECYCLE_STATUS_ACTIVE = "ACTIVE";
    public String getLifecycleStatus() {
        return lifecycleStatus;
    }

    public void setLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static final String NAME_SERVICE_FORECAST_DATE = "serviceForecastDate";

    public static final String VALUE_TYPE_MINUTES = "MINUTES";
    public static final String VALUE_TYPE_UNITS = "UNITS";
    public static final String VALUE_TYPE_MB = "MB";
    public static final String VALUE_TYPE_GB = "GB";
    public static final String VALUE_UNLIMITED = "VALUE_UNLIMITED";
    public static final String VALUE_SERVICE_DAYS ="serviceDays";

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }


    public ServiceSpecification(){}
    protected ServiceSpecification(Parcel in) {
        brand = in.readString();
        lifecycleStatus = in.readString();
        name = in.readString();
        value = in.readString();
        valueType = in.readString();
    }

    public static final Creator<ServiceSpecification> CREATOR = new Creator<ServiceSpecification>() {
        @Override
        public ServiceSpecification createFromParcel(Parcel in) {
            return new ServiceSpecification(in);
        }

        @Override
        public ServiceSpecification[] newArray(int size) {
            return new ServiceSpecification[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brand);
        dest.writeString(lifecycleStatus);
        dest.writeString(name);
        dest.writeString(value);
        dest.writeString(valueType);
    }
}
