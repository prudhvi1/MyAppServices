package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for account device details Rewards elements.
 * It corresponds to the restful service Get Customer Account Details.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/
@JsonIgnoreProperties(ignoreUnknown = true)

public class DeviceRewards implements Parcelable {

    @JsonProperty("totalPoints")
    private int totalPoints;
    @JsonProperty("pointsAccrued")
    private double pointsAccrued;
    @JsonProperty("hasBenefits")
    private boolean hasBenefits;

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setPointsAccrued(double i) {
        pointsAccrued = i;
    }

    public double getPointsAccrued() {
        return pointsAccrued;
    }

    public void setHasBenefits(boolean hasBenefits) {
        this.hasBenefits = hasBenefits;
    }

    public boolean getHasBenefits() {
        return hasBenefits;
    }

    public DeviceRewards() {
    }

    protected DeviceRewards(Parcel in) {
        totalPoints = in.readInt();
        pointsAccrued = in.readDouble();
        hasBenefits = in.readByte() != 0;
    }

    public static final Creator<DeviceRewards> CREATOR = new Creator<DeviceRewards>() {
        @Override
        public DeviceRewards createFromParcel(Parcel in) {
            return new DeviceRewards(in);
        }

        @Override
        public DeviceRewards[] newArray(int size) {
            return new DeviceRewards[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(totalPoints);
        parcel.writeDouble(pointsAccrued);
        parcel.writeByte((byte) (hasBenefits ? 1 : 0));
    }
}
