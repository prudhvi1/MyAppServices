package com.tracfone.generic.myaccountlibrary.restpojos;

/**
 * ********************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 * <p/>
 * CLASS DESCRIPTION:
 * <p/>
 * This class ResponseHandsetProtectionEnrolledProgram defines the response POJO to a restful request for
 * the currently Enrolled Protection Plan.
 * <p/>
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *********************************************************************************************************
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHandsetProtectionEnrolledProgram {

    public static class EnrolledProtectionProgram implements Parcelable {

        @JsonProperty("contractNumber")
        private String contractNumber;
        @JsonProperty("programName")
        private String programName;
        @JsonProperty("enrollmentDate")
        private String enrollmentDate;
        @JsonProperty("nextChargeDate")
        private String nextChargeDate;
        @JsonProperty("deductibleAmount")
        private String deductibleAmount;

        public String getContractNumber() {
            return contractNumber;
        }

        public void setContractNumber(String contractNumber) {
            this.contractNumber = contractNumber;
        }

        public String getProgramName() {
            return programName;
        }

        public void setProgramName(String programName) {
            this.programName = programName;
        }

        public String getEnrollmentDate() {
            return enrollmentDate;
        }

        public void setEnrollmentDate(String enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
        }

        public String getNextChargeDate() {
            return nextChargeDate;
        }

        public void setNextChargeDate(String nextChargeDate) {
            this.nextChargeDate = nextChargeDate;
        }

        public double getDeductibleAmount() {
            if (deductibleAmount != null) {
                return Double.parseDouble(deductibleAmount);
            } else return -1;
        }

        public void setDeductibleAmount(String deductibleAmount) {
            this.deductibleAmount = deductibleAmount;
        }


        public EnrolledProtectionProgram() {
        }

        protected EnrolledProtectionProgram(Parcel in) {
            contractNumber = in.readString();
            programName = in.readString();
            enrollmentDate = in.readString();
            nextChargeDate = in.readString();
            deductibleAmount = in.readString();
        }

        public static final Creator<EnrolledProtectionProgram> CREATOR = new Creator<EnrolledProtectionProgram>() {
            @Override
            public EnrolledProtectionProgram createFromParcel(Parcel in) {
                return new EnrolledProtectionProgram(in);
            }

            @Override
            public EnrolledProtectionProgram[] newArray(int size) {
                return new EnrolledProtectionProgram[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(contractNumber);
            parcel.writeString(programName);
            parcel.writeString(enrollmentDate);
            parcel.writeString(nextChargeDate);
            parcel.writeString(deductibleAmount);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private EnrolledProtectionProgram EnrolledProtectionProgram;

    public ResponseStatus getCommon() {
        return status;
    }

    public void setCommon(ResponseStatus s) {
        status = s;
    }

    public EnrolledProtectionProgram getResponse() {
        return EnrolledProtectionProgram;
    }

    public void setResponse(EnrolledProtectionProgram pp) {
        EnrolledProtectionProgram = pp;
    }

    public void  validateEnrolledProgramInfo() throws MyAccountServiceException{
        boolean valid = true;

        if (EnrolledProtectionProgram.getContractNumber() == null) valid = false;
        if (EnrolledProtectionProgram.getProgramName() == null) valid = false;
        if (EnrolledProtectionProgram.getEnrollmentDate() == null) valid = false;
        if (EnrolledProtectionProgram.getNextChargeDate() == null) valid = false;
        if (EnrolledProtectionProgram.getDeductibleAmount() == -1) valid = false;

        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


    }
}
