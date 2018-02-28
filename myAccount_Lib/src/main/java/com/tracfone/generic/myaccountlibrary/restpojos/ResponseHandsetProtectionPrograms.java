package com.tracfone.generic.myaccountlibrary.restpojos;

/**
 * ********************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 * <p>
 * CLASS DESCRIPTION:
 * <p>
 * This class ResponseHandsetProtectionPrograms defines the response POJO to a restful request for
 * the Handset Protection Plans List.
 * <p>
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *********************************************************************************************************
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHandsetProtectionPrograms {

    public static class ProtectionPrograms implements Parcelable {


        @JsonProperty("programId")
        private int programId;
        @JsonProperty("programPrice")
        private String programPrice;
        @JsonProperty("programName")
        private String programName;
        @JsonProperty("programTermsLink")
        private String programTermsLink;
        @JsonProperty("programDescription")
        private String programDescription;
        @JsonProperty("programMoreInfo")
        private String programMoreInfo;

        public int getProgramId() {
            return programId;
        }

        public void setProgramId(int programId) {
            this.programId = programId;
        }

        public double getProgramPrice() {
            if (programPrice != null) {
                return Double.parseDouble(programPrice);
            } else
                return -1;
        }

        public void setProgramPrice(String programPrice) {
            this.programPrice = programPrice;
        }

        public String getProgramName() {
            return programName;
        }

        public void setProgramName(String programName) {
            this.programName = programName;
        }

        public String getProgramTermsLink() {
            return programTermsLink;
        }

        public void setProgramTermsLink(String programTermsLink) {
            this.programTermsLink = programTermsLink;
        }

        public String getProgramDescription() {
            return programDescription;
        }

        public void setProgramDescription(String programDescription) {
            this.programDescription = programDescription;
        }

        public String getProgramMoreInfo() {
            return programMoreInfo;
        }

        public void setProgramMoreInfo(String programMoreInfo) {
            this.programMoreInfo = programMoreInfo;
        }

        @JsonProperty("programs")
        private List<ProtectionPrograms> programlist = new ArrayList<>();

        public List<ProtectionPrograms> getProtectionPrograms() {
            return programlist;
        }

        public void setProtectionPrograms(List<ProtectionPrograms> p) {
            programlist = p;
        }

        public ProtectionPrograms() {
        }
        protected ProtectionPrograms(Parcel in) {
            programId = in.readInt();
            programPrice = in.readString();
            programName = in.readString();
            programTermsLink = in.readString();
            programDescription = in.readString();
            programMoreInfo = in.readString();
        }

        public static final Creator<ProtectionPrograms> CREATOR = new Creator<ProtectionPrograms>() {
            @Override
            public ProtectionPrograms createFromParcel(Parcel in) {
                return new ProtectionPrograms(in);
            }

            @Override
            public ProtectionPrograms[] newArray(int size) {
                return new ProtectionPrograms[size];
            }
        };
        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(programId);
            parcel.writeString(programPrice);
            parcel.writeString(programName);
            parcel.writeString(programTermsLink);
            parcel.writeString(programDescription);
            parcel.writeString(programMoreInfo);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ProtectionPrograms handsetProtectionPrograms;

    public ResponseStatus getCommon() {
        return status;
    }

    public void setCommon(ResponseStatus s) {
        status = s;
    }

    public ProtectionPrograms getResponse() {
        return handsetProtectionPrograms;
    }

    public void setResponse(ProtectionPrograms pp) {
        handsetProtectionPrograms = pp;
    }


    public void validateProtectionPrograms()throws MyAccountServiceException {
        boolean valid = true;

        int size = handsetProtectionPrograms.getProtectionPrograms().size();
        for (int i = 0; i < handsetProtectionPrograms.getProtectionPrograms().size(); i++) {
            if (handsetProtectionPrograms.getProtectionPrograms().get(i).getProgramId() == 0)
                valid = false;
            if(handsetProtectionPrograms.getProtectionPrograms().get(i).getProgramPrice() == -1)
                valid = false;
            if (handsetProtectionPrograms.getProtectionPrograms().get(i).getProgramName() == null)
                valid = false;
            if (handsetProtectionPrograms.getProtectionPrograms().get(i).getProgramTermsLink() == null)
                valid = false;
            if (handsetProtectionPrograms.getProtectionPrograms().get(i).getProgramDescription() == null)
                valid = false;
            if (handsetProtectionPrograms.getProtectionPrograms().get(i).getProgramMoreInfo() == null)
                valid = false;
        }
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


    }

}
