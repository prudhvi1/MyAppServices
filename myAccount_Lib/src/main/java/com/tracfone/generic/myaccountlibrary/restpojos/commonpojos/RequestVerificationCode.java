package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

/**
 * Created by hserna on 8/1/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;

import java.util.ArrayList;

public class RequestVerificationCode {

    public static class VerificationCodeRequest implements Parcelable {
        @JsonProperty("resource")
        private ArrayList<CheckPointsResources> checkPointsResources;

        public VerificationCodeRequest(){}

        protected VerificationCodeRequest(Parcel in) {
            checkPointsResources = in.createTypedArrayList(CheckPointsResources.CREATOR);
        }

        public static final Creator<VerificationCodeRequest> CREATOR = new Creator<VerificationCodeRequest>() {
            @Override
            public VerificationCodeRequest createFromParcel(Parcel in) {
                return new VerificationCodeRequest(in);
            }

            @Override
            public VerificationCodeRequest[] newArray(int size) {
                return new VerificationCodeRequest[size];
            }
        };

        public ArrayList<CheckPointsResources> getCheckPointsResources() {
            return checkPointsResources;
        }

        public void setCheckPointsResources(ArrayList<CheckPointsResources> checkPointsResources) {
            this.checkPointsResources = checkPointsResources;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeTypedList(checkPointsResources);
        }
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private VerificationCodeRequest verificationCodeRequest;

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public VerificationCodeRequest getVerificationCodeRequest() {
        return verificationCodeRequest;
    }

    public void setVerificationCodeRequest(VerificationCodeRequest verificationCodeRequest) {
        this.verificationCodeRequest = verificationCodeRequest;
    }
}
