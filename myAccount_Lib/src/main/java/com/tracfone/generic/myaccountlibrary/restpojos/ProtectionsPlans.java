package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

public class ProtectionsPlans implements Parcelable {
    private String Headername;
    private String planDesc;
    private String planName;
    private double planPrice;
    private int programid;
    private String protectionProgramLink;

    public ProtectionsPlans(Parcel source) {
        Headername = source.readString();
        planDesc = source.readString();
        planName = source.readString();
        planPrice = source.readDouble();
        programid =source.readInt();
        protectionProgramLink=source.readString();
    }

    public ProtectionsPlans() {

    }

    public String getHeadername() {
        return Headername;
    }

    public void setHeadername(String headername) {
        Headername = headername;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(double planPrice) {
        this.planPrice = planPrice;
    }

    public int getProgramid() {
        return programid;
    }

    public void setProgramid(int programid) {
        this.programid = programid;
    }

    public String getProtectionProgramLink() {
        return protectionProgramLink;
    }

    public void setProtectionProgramLink(String protectionProgramLink) {
        this.protectionProgramLink = protectionProgramLink;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Headername);
        dest.writeString(planDesc);
        dest.writeString(planName);
        dest.writeDouble(planPrice);
        dest.writeInt(programid);
        dest.writeString(protectionProgramLink);

    }

    public static Creator<ProtectionsPlans> CREATOR = new Creator<ProtectionsPlans>() {
        @Override
        public ProtectionsPlans createFromParcel(Parcel source) {
            return new ProtectionsPlans(source);
        }

        @Override
        public ProtectionsPlans[] newArray(int size) {
            return new ProtectionsPlans[size];
        }
    };
}
