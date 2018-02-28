package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class ResponseAvailableVAS defines the POJO for the response body of the get of the Value Added Service restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAvailableVAS {

    public static class VASList implements Parcelable {

        public static class VAS implements Parcelable {

            @JsonProperty("vasPlanId")
            private int vasPlanId;
            @JsonProperty("vasPlanPrice")
            private double vasPlanPrice;
            @JsonProperty("vasPartNumber")
            private String vasPartNumber;
            @JsonProperty("vasPlanType")
            private String vasPlanType;
            @JsonProperty("vasPlanName")
            private String vasPlanName;
            @JsonProperty("ildRatesLink")
            private String ildRatesLink;
            @JsonProperty("isLrpRedeemable")
            private boolean isLrpRedeemable;
            @JsonProperty("lrpPoints")
            private int lrpPoints;
            @JsonProperty("vasPlanDescription")
            private String vasPlanDescription;
            @JsonProperty("vasPlanDescription2")
            private String vasPlanDescription2;
            @JsonProperty("vasPlanDescription3")
            private String vasPlanDescription3;
            @JsonProperty("vasPlanDescription4")
            private String vasPlanDescription4;

            public int getVasPlanId() { return vasPlanId; }
            public void setVasPlanId(int vasPlanId) { this.vasPlanId = vasPlanId;  }

            public String getVasPlanPrice() {
                String planPriceString = "";
                if(vasPlanPrice==(long)vasPlanPrice)
                    planPriceString=String.format("%d", (long)vasPlanPrice);
                else {
                    //round off to two decimal places
                    vasPlanPrice = (double) Math.round(vasPlanPrice * 100) / 100;
                    //display only two decimal places
                    planPriceString = String.format("%.2f", vasPlanPrice);
                }
                return planPriceString; }
            public void setVasPlanPrice(double vasPlanPrice) { this.vasPlanPrice = vasPlanPrice; }

            public String getVasPartNumber() { return vasPartNumber;  }
            public void setVasPartNumber(String vasPartNumber) { this.vasPartNumber = vasPartNumber; }

            public String getVasPlanType() { return vasPlanType; }
            public void setVasPlanType(String vasPlanType) { this.vasPlanType = vasPlanType; }

            public String getVasPlanName() { return vasPlanName; }
            public void setVasPlanName(String vasPlanName) { this.vasPlanName = vasPlanName; }

            public String getVasPlanDescription() { return vasPlanDescription; }
            public void setVasPlanDescription(String vasPlanDescription) { this.vasPlanDescription = vasPlanDescription; }

            public String getIldRatesLink() { return ildRatesLink; }
            public void setIldRatesLink(String ildRatesLink) { this.ildRatesLink = ildRatesLink; }

            public boolean getIsLrpRedeemable() {
                return isLrpRedeemable;
            }

            public void setIsLrpRedeemable(boolean isLrpRedeemable) {
                this.isLrpRedeemable = isLrpRedeemable;
            }

            public int getLrpPoints() {
                return lrpPoints;
            }

            public void setLrpPoints(int lrpPoints) {
                this.lrpPoints = lrpPoints;
            }

            public String getVasPlanDescription2() { return vasPlanDescription2; }
            public void setVasPlanDescription2(String vasPlanDescription2) { this.vasPlanDescription2 = vasPlanDescription2; }

            public String getVasPlanDescription3() { return vasPlanDescription3; }
            public void setVasPlanDescription3(String vasPlanDescription3) { this.vasPlanDescription3 = vasPlanDescription3; }

            public String getVasPlanDescription4() { return vasPlanDescription4; }
            public void setVasPlanDescription4(String vasPlanDescription4) { this.vasPlanDescription4 = vasPlanDescription4; }

            public VAS() { }
            protected VAS(Parcel in) {
                vasPlanId = in.readInt();
                vasPlanPrice = in.readDouble();
                vasPartNumber = in.readString();
                vasPlanType = in.readString();
                vasPlanName = in.readString();
                ildRatesLink = in.readString();
                isLrpRedeemable = in.readByte() != 0;
                lrpPoints = in.readInt();
                vasPlanDescription = in.readString();
                vasPlanDescription2 = in.readString();
                vasPlanDescription3 = in.readString();
                vasPlanDescription4 = in.readString();
            }
            public static final Creator<VAS> CREATOR = new Creator<VAS>() {
                @Override
                public VAS createFromParcel(Parcel in) {
                    return new VAS(in);
                }
                @Override
                public VAS[] newArray(int size) {
                    return new VAS[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }
            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(vasPlanId);
                parcel.writeDouble(vasPlanPrice);
                parcel.writeString(vasPartNumber);
                parcel.writeString(vasPlanType);
                parcel.writeString(vasPlanName);
                parcel.writeString(ildRatesLink);
                parcel.writeByte((byte)(isLrpRedeemable ? 1:0));
                parcel.writeInt(lrpPoints);
                parcel.writeString(vasPlanDescription);
                parcel.writeString(vasPlanDescription2);
                parcel.writeString(vasPlanDescription3);
                parcel.writeString(vasPlanDescription4);
            }
        }

        @JsonProperty("vasPlans")
        private List<VAS> vasPlan = new ArrayList<VAS>();

        public List<VAS> getVasPlans() { return vasPlan; }
        public void setVasPlans(List<VAS> vasPlan) { this.vasPlan = vasPlan;}

        public VASList() { }
        protected VASList(Parcel in) {
            in.readTypedList(vasPlan,VAS.CREATOR);
        }
        public static final Creator<VASList> CREATOR = new Creator<VASList>() {
            @Override
            public VASList createFromParcel(Parcel in) {
                return new VASList(in);
            }
            @Override
            public VASList[] newArray(int size) {
                return new VASList[size];
            }
        };
        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(vasPlan);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private VASList vasPlanList;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public VASList getResponse() { return vasPlanList; }
    public void setResponse(VASList v) { vasPlanList = v; }

    /**
     * This method verifies all data returned from service is valid
     *
     * @return true if all request data is valid
     */
    public void validateVasPlanList() throws MyAccountServiceException {
        boolean valid = true;
        for (int i = 0; i < vasPlanList.getVasPlans().size(); i++) {
            if (vasPlanList.getVasPlans().get(i).getVasPlanId() == -1) valid = false;
            if (vasPlanList.getVasPlans().get(i).getVasPlanPrice() == null) valid = false;
            if (vasPlanList.getVasPlans().get(i).getVasPartNumber() == null) valid = false;
            if (vasPlanList.getVasPlans().get(i).getVasPlanType() == null) valid = false;
            if (vasPlanList.getVasPlans().get(i).getVasPlanName() == null) valid = false;
            if (vasPlanList.getVasPlans().get(i).getIldRatesLink() == null) valid = false;
            if (vasPlanList.getVasPlans().get(i).getVasPlanDescription() == null) valid = false;
            if (vasPlanList.getVasPlans().get(i).getVasPlanDescription2() == null) valid = false;
            if (vasPlanList.getVasPlans().get(i).getVasPlanDescription3() == null) valid = false;
            if (vasPlanList.getVasPlans().get(i).getVasPlanDescription4() == null) valid = false;
        }
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


    }
}