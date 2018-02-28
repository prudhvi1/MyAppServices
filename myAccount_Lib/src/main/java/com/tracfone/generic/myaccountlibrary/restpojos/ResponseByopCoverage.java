package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Specifications;

import java.util.ArrayList;

/**
 * Created by skishore on 10/17/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseByopCoverage {


    public static class ByopCoverageResponse {


        public static class Location {

            public static class PostalAddress {

                @JsonProperty("zipcode")
                private String zipcode;

                public String getZipcode() {
                    return zipcode;
                }
                public void setZipcode(String zipcode) {
                    this.zipcode = zipcode;
                }

            }

            @JsonProperty("postalAddress")
            private PostalAddress postalAddress;

            public PostalAddress getPostalAddress() {
                return postalAddress;
            }
            public void setPostalAddress(PostalAddress postalAddress) {
                this.postalAddress = postalAddress;
            }
        }



        @JsonProperty("qualifiedCarriers")
        private ArrayList<String> qualifiedCarriers = new ArrayList<String>();

        @JsonProperty("qualificationResult")
        private String qualificaitonResult;

        @JsonProperty("location")
        private Location location;

        public ArrayList<String> getQualifiedCarriers() {
            return qualifiedCarriers;
        }
        public void setQualifiedCarriers(ArrayList<String> qualifiedCarriers) {
            this.qualifiedCarriers = qualifiedCarriers;
        }
        
        public String getQualificaitonResult() {
            return qualificaitonResult;
        }
        public void setQualificaitonResult(String qualificaitonResult) {
            this.qualificaitonResult = qualificaitonResult;
        }

        public Location getLocation() {
            return location;
        }
        public void setLocation(Location location) {
            this.location = location;
        }


    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ByopCoverageResponse byopCoverageResponse;

    public ResponseStatus getStatus() { return status; }
    public void setStatus(ResponseStatus s) { status = s; }

    public ByopCoverageResponse getResponse() { return byopCoverageResponse; }
    public void setResponse(ByopCoverageResponse v) { byopCoverageResponse = v; }


}
