package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by hserna on 8/1/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckPointsResources implements Parcelable {

    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("resourceCategory")
    String resourceCategory;
    @JsonProperty("checkPoints")
    private ArrayList<CheckPoints> checkPoints;
    @JsonProperty("checkPointValue")
    private CheckPointValue checkPointValue;

    public static final String RESOURCE_CATEGORY_LINE = "LINE";
    public static final String RESOURCE_CATEGORY_HANDSET = "HANDSET";

    public CheckPointsResources(){}

    protected CheckPointsResources(Parcel in) {
        serialNumber = in.readString();
        resourceCategory = in.readString();
        checkPoints = in.createTypedArrayList(CheckPoints.CREATOR);
        checkPointValue = in.readParcelable(CheckPointValue.class.getClassLoader());
    }

    public static final Creator<CheckPointsResources> CREATOR = new Creator<CheckPointsResources>() {
        @Override
        public CheckPointsResources createFromParcel(Parcel in) {
            return new CheckPointsResources(in);
        }

        @Override
        public CheckPointsResources[] newArray(int size) {
            return new CheckPointsResources[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(serialNumber);
        dest.writeString(resourceCategory);
        dest.writeTypedList(checkPoints);
        dest.writeParcelable(checkPointValue, flags);
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getResourceCategory() {
        return resourceCategory;
    }

    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory;
    }

    public ArrayList<CheckPoints> getCheckPoints() {
        return checkPoints;
    }

    public void setCheckPoints(ArrayList<CheckPoints> checkPoints) {
        this.checkPoints = checkPoints;
    }

    public CheckPointValue getCheckPointValue() {
        return checkPointValue;
    }

    public void setCheckPointValue(CheckPointValue checkPointValue) {
        this.checkPointValue = checkPointValue;
    }
}
