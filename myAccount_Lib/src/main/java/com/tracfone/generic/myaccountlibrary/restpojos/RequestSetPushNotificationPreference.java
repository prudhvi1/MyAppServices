package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class RequestSetPushNotificationPreference defines the POJO for the request body of the APN Settings Instructions restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

public class RequestSetPushNotificationPreference {


public static class PushNotificationPreferenceRequest implements Parcelable{


    @JsonProperty("accountId")
    private int accountId;

    public static class Devices implements Parcelable {

        @JsonProperty("esn")
        private String esn;
        @JsonProperty("min")
        private String min;
        @JsonProperty("preference")
        private Boolean preference;

        public String getEsn() {
            return esn;
        }
        public void setEsn(String esn) {
            this.esn = esn;
        }
        public String getMin() {
            return min;
        }
        public void setMin(String min) {
            this.min = min;
        }
        public boolean isPreference() {
            return preference;
        }
        public void setPreference(boolean preference) {
            this.preference = preference;
        }

        public Devices() { }
        protected Devices(Parcel in) {
            esn = in.readString();
            min = in.readString();
            preference = in.readByte() != 0;
        }

        public static final Creator<Devices> CREATOR = new Creator<Devices>() {
            @Override
            public Devices createFromParcel(Parcel in) {
                return new Devices(in);
            }

            @Override
            public Devices[] newArray(int size) {
                return new Devices[size];
            }
        };
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(esn);
            parcel.writeString(min);
            parcel.writeByte((byte) (preference ? 1 : 0));
        }
    }

    @JsonProperty("devices")
    private List<Devices> devicesList = new ArrayList<Devices>();

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<Devices> getDevicesList() {
        return devicesList;
    }

    public void setDevicesList(List<Devices> devicesList) {
        this.devicesList = devicesList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(accountId);
        dest.writeTypedList(devicesList);
    }

    public static final Creator<PushNotificationPreferenceRequest> CREATOR = new Creator<PushNotificationPreferenceRequest>() {
        @Override
        public PushNotificationPreferenceRequest createFromParcel(Parcel in) {
            return new PushNotificationPreferenceRequest(in);
        }
        @Override
        public PushNotificationPreferenceRequest[] newArray(int size) {
            return new PushNotificationPreferenceRequest[size];
        }
    };

    protected PushNotificationPreferenceRequest(Parcel in) {
        accountId = in.readInt();
        devicesList = in.createTypedArrayList(Devices.CREATOR);
    }


    public PushNotificationPreferenceRequest(){

    }

}
    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private PushNotificationPreferenceRequest request;

    public RequestCommon getCommon() {
        return common;
    }
    public void setCommon(RequestCommon common) {
        this.common = common;
    }
    public PushNotificationPreferenceRequest getRequest() {
        return request;
    }
    public void setRequest(PushNotificationPreferenceRequest request) {
        this.request = request;
    }

}
