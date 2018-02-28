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
 * This class defines the POJO for account device details Group element.
 * It corresponds to the restful service Get Customer Account Details and Validate Device
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/
@JsonIgnoreProperties(ignoreUnknown = true)

public class DeviceGroup implements Parcelable {

    @JsonProperty("groupId")
    private String groupId;
    @JsonProperty("groupName")
    private String groupName;
    @JsonProperty("groupStatus")
    private String groupStatus;
    @JsonProperty("masterEsn")
    private String masterEsn;
    @JsonProperty("masterEsnStatus")
    private String masterEsnStatus;
    @JsonProperty("groupLeaseApplicationNumber")
    private String groupLeaseApplicationNumber;
    @JsonProperty("groupPlanId")
    private int groupPlanId;
    @JsonProperty("groupDeviceCount")
    private int groupDeviceCount;
    @JsonProperty("numberOfLines")
    private int numberOfLines;
    @JsonProperty("availableCapacity")
    private int availableCapacity;

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupName() {
        return this.groupName;
    }

    //Group Statuses
    public static final String GROUP_NEW = "GROUP_NEW";
    public static final String GROUP_INACTIVE = "GROUP_INACTIVE";
    public static final String GROUP_ACTIVE = "GROUP_ACTIVE";
    public static final String GROUP_EXPIRED = "GROUP_EXPIRED";
    public static final String GROUP_PASTDUE = "GROUP_PASTDUE";
    public static final String GROUP_CARRIER_PENDING = "GROUP_CARRIER_PENDING";
    public static final String GROUP_PAYMENT_PENDING = "GROUP_PAYMENT_PENDING";
    public static final String GROUP_SIM_PENDING = "GROUP_SIM_PENDING";
    public static final String GROUP_CASE_PENDING = "GROUP_CASE_PENDING";
    public void setGroupStatus(String groupStatus) { this.groupStatus = groupStatus; }
    public String getGroupStatus() {
        return "GROUP_" + this.groupStatus;
    }

    public void setMasterEsn(String masterEsn) {
        this.masterEsn = masterEsn;
    }
    public String getMasterEsn() {return this.masterEsn; }

    public void setMasterEsnStatus(String masterEsnStatus) { this.masterEsnStatus = masterEsnStatus; }
    public String getMasterEsnStatus() {return "DEVICE_" + this.masterEsnStatus; }

    public void setGroupLeaseApplicationNumber(String groupLeaseApplicationNumber) { this.groupLeaseApplicationNumber = groupLeaseApplicationNumber; }
    public String getGroupLeaseApplicationNumber() {
        return this.groupLeaseApplicationNumber;
    }

    public void setGroupPlanId(int groupPlanId) { this.groupPlanId = groupPlanId; }
    public int getGroupPlanId() {
        return this.groupPlanId;
    }

    public void setGroupDeviceCount(int groupDeviceCount) { this.groupDeviceCount = groupDeviceCount; }
    public int getGroupDeviceCount() {
        return this.groupDeviceCount;
    }

    public void setNumberOfLines(int numberOfLines) { this.numberOfLines = numberOfLines; }
    public int getNumberOfLines() {return this.numberOfLines; }

    public void setAvailableCapacity(int availableCapacity) { this.availableCapacity = availableCapacity; }
    public int getAvailableCapacity() {
        return this.availableCapacity;
    }



    public DeviceGroup() {
    }

    protected DeviceGroup(Parcel in) {
        groupId = in.readString();
        groupName = in.readString();
        groupStatus = in.readString();
        masterEsn = in.readString();
        masterEsnStatus = in.readString();
        groupLeaseApplicationNumber = in.readString();
        groupPlanId = in.readInt();
        groupDeviceCount = in.readInt();
        numberOfLines = in.readInt();
        availableCapacity = in.readInt();
    }

    public static final Creator<DeviceGroup> CREATOR = new Creator<DeviceGroup>() {
        @Override
        public DeviceGroup createFromParcel(Parcel in) {
            return new DeviceGroup(in);
        }

        @Override
        public DeviceGroup[] newArray(int size) {
            return new DeviceGroup[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(groupId);
        parcel.writeString(groupName);
        parcel.writeString(groupStatus);
        parcel.writeString(masterEsn);
        parcel.writeString(masterEsnStatus);
        parcel.writeString(groupLeaseApplicationNumber);
        parcel.writeInt(groupPlanId);
        parcel.writeInt(groupDeviceCount);
        parcel.writeInt(numberOfLines);
        parcel.writeInt(availableCapacity);
    }
}
