package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseStatus;

import java.util.ArrayList;

/**
 * Created by hserna on 8/1/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCheckPoints {

    public static class CheckPointsResponse implements Parcelable {

        @JsonProperty("resource")
        private ArrayList<CheckPointsResources> checkPointsResources;

        public CheckPointsResponse(){}

        protected CheckPointsResponse(Parcel in){
            checkPointsResources = in.createTypedArrayList(CheckPointsResources.CREATOR);
        }

        public static final Creator<CheckPointsResponse> CREATOR = new Creator<CheckPointsResponse>(){

            @Override
            public CheckPointsResponse createFromParcel(Parcel in) {
                return new CheckPointsResponse(in);
            }

            @Override
            public CheckPointsResponse[] newArray(int size) {
                return new CheckPointsResponse[size];
            }
        };


        public ArrayList<CheckPointsResources> getCheckPointsResources() {
            return checkPointsResources;
        }

        public void setResource(ArrayList<CheckPointsResources> checkPointsResources) {
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

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private CheckPointsResponse checkPointsResponse;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public CheckPointsResponse getCheckPointsResponse() {
        return checkPointsResponse;
    }

    public void setCheckPointsResponse(CheckPointsResponse checkPointsResponse) {
        this.checkPointsResponse = checkPointsResponse;
    }


}
