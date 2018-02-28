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
 * This class defines the POJO for Loayalty Rewards
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

@JsonIgnoreProperties(ignoreUnknown = true)

public class LoyaltyRewardsInfo implements Parcelable {

    @JsonProperty("totalPoints")
    private int totalPoints;
    @JsonProperty("pendingPoints")
    private int pendingPoints;
    @JsonProperty("availablePoints")
    private int availablePoints;
    @JsonProperty("enrlStartDate")
    private String enrlStartDate;

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
    public int getTotalPoints() {
        return totalPoints;
    }

    public void setPendingPoints(int pendingPoints) {
        this.pendingPoints = pendingPoints;
    }
    public int getPendingPoints() {
        return pendingPoints;
    }

    public void setAvailablePoints(int availablePoints) {
        this.availablePoints = availablePoints;
    }
    public int getAvailablePoints() {
        return availablePoints;
    }

    public void setEnrlStartDate(String enrlStartDate) {
        this.enrlStartDate = enrlStartDate;
    }
    public String getEnrlStartDate() {
        return enrlStartDate;
    }


    public LoyaltyRewardsInfo() {
    }

    protected LoyaltyRewardsInfo(Parcel in) {
        totalPoints = in.readInt();
        pendingPoints = in.readInt();
        availablePoints = in.readInt();
        enrlStartDate = in.readString();
    }

    public static final Creator<LoyaltyRewardsInfo> CREATOR = new Creator<LoyaltyRewardsInfo>() {
        @Override
        public LoyaltyRewardsInfo createFromParcel(Parcel in) {
            return new LoyaltyRewardsInfo(in);
        }

        @Override
        public LoyaltyRewardsInfo[] newArray(int size) {
            return new LoyaltyRewardsInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(totalPoints);
        parcel.writeInt(pendingPoints);
        parcel.writeInt(availablePoints);
        parcel.writeString(enrlStartDate);
    }
}
