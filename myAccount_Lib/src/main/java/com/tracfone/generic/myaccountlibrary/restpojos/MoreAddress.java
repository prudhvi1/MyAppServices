package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by psamdrala on 2/21/2017.
 */

public class MoreAddress implements  Parcelable {

    private String unitNumber;
    private String houseNumber;
    private String streetName;
    private String streetDirection;
    private String streetType;

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetDirection() {
        return streetDirection;
    }

    public void setStreetDirection(String streetDirection) {
        this.streetDirection = streetDirection;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public MoreAddress(){}

    protected MoreAddress(Parcel in) {
        unitNumber = in.readString();
        houseNumber = in.readString();
        streetName = in.readString();
        streetDirection = in.readString();
        streetType = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(unitNumber);
        dest.writeString(houseNumber);
        dest.writeString(streetName);
        dest.writeString(streetDirection);
        dest.writeString(streetType);
    }


    public static final Creator<MoreAddress> CREATOR = new Creator<MoreAddress>() {
        @Override
        public MoreAddress createFromParcel(Parcel in) {
            return new MoreAddress(in);
        }

        @Override
        public MoreAddress[] newArray(int size) {
            return new MoreAddress[size];
        }
    };
}
