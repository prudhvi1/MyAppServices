package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by skishore on 10/14/2016.
 */

public class Sim implements Parcelable{
    @JsonProperty("iccid")
    String iccid;
    @JsonProperty("status")
    String status;
    @JsonProperty("isLegacyFlag")
    boolean isLegacyFlag;
    @JsonProperty("carrier")
    String carrier;

    public String getIccid() {
        return iccid;
    }
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public static final String SIM_STATUS_RESERVED = "SIM RESERVED";
    public static final String SIM_STATUS_VOID = "SIM VOID";
    public static final String SIM_STATUS_NEW = "SIM NEW";
    public static final String SIM_STATUS_ACTIVE = "SIM ACTIVE";
    public static final String SIM_STATUS_DAMAGED = "SIM DAMAGED";
    public static final String SIM_STATUS_EXPIRED = "SIM EXPIRED";
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public static final String SIM_CARRIER_TMO = "TMO";
    public static final String SIM_CARRIER_ATT = "ATT";
    public static final String SIM_CARRIER_VZW = "VZW";
    public static final String SIM_CARRIER_SPT = "SPT";
    public static final String SIM_CARRIER_CLA = "CLA";
    public static final String SIM_CARRIER_USC = "USC";
    public String getCarrier() {
        return carrier;
    }
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public boolean getIsLegacyFlag() { return isLegacyFlag; }
    public void setIsLegacyFlag(boolean isLegacyFlag) {
        this.isLegacyFlag = isLegacyFlag;
    }

    public Sim(Parcel source) {
        iccid = source.readString();
        status = source.readString();
        carrier = source.readString();
        isLegacyFlag = source.readByte() != 0;
    }

    public Sim() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iccid);
        dest.writeString(status);
        dest.writeString(carrier);
        dest.writeByte((byte) (isLegacyFlag ? 1 : 0));
    }

    public static Creator<Sim> CREATOR = new Creator<Sim>() {
        @Override
        public Sim createFromParcel(Parcel source) {
            return new Sim(source);
        }

        @Override
        public Sim[] newArray(int size) {
            return new Sim[size];
        }
    };

}
