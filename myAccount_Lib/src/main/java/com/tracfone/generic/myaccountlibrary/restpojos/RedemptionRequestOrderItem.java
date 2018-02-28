package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponsePlanList.PlanList.Plan;

public class RedemptionRequestOrderItem implements Parcelable {


    private Plan plan;
    private Device device;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }



    public RedemptionRequestOrderItem() {
    }

    protected RedemptionRequestOrderItem(Parcel in) {
        plan = in.readParcelable(Plan.class.getClassLoader());
        device = in.readParcelable(Device.class.getClassLoader());
    }

    public static final Creator<RedemptionRequestOrderItem> CREATOR = new Creator<RedemptionRequestOrderItem>() {
        @Override
        public RedemptionRequestOrderItem createFromParcel(Parcel in) {
            return new RedemptionRequestOrderItem(in);
        }

        @Override
        public RedemptionRequestOrderItem[] newArray(int size) {
            return new RedemptionRequestOrderItem[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(plan, i);
        parcel.writeParcelable(device, i);
    }


}
