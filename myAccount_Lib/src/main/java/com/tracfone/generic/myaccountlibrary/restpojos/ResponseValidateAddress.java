package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ParsedAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ReferenceAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;

import java.util.ArrayList;

/**
 * Created by atatipally on 9/22/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseValidateAddress implements Parcelable {

    public ResponseValidateAddress(){}
    protected ResponseValidateAddress(Parcel in) {
    }

    public static final Creator<ResponseValidateAddress> CREATOR = new Creator<ResponseValidateAddress>() {
        @Override
        public ResponseValidateAddress createFromParcel(Parcel in) {
            return new ResponseValidateAddress(in);
        }

        @Override
        public ResponseValidateAddress[] newArray(int size) {
            return new ResponseValidateAddress[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class ValidateAddress {

        @JsonProperty("relatedParties")
        private ArrayList<RelatedParties> relatedParties;
        @JsonProperty("parsedAddress")
        private ParsedAddress parsedAddress;
        @JsonProperty("ref")
        private ArrayList<ReferenceAddress> ref;
        @JsonProperty("verificationLevel")
        private String verificationLevel;

        public static String VERIFICATION_LEVEL_VERIFIED ="Verified";
        public static String VERIFICATION_LEVEL_MULTIPLE ="Multiple";
        public static String VERIFICATION_LEVEL_INTERACTION_REQUIRED ="InteractionRequired";
        public static String VERIFICATION_LEVEL_STREETPARTIAL ="StreetPartial";
        public ParsedAddress getParsedAddress() {
            return parsedAddress;
        }

        public void setParsedAddress(ParsedAddress parsedAddress) {
            this.parsedAddress = parsedAddress;
        }

        public ArrayList<ReferenceAddress> getRef() {
            return ref;
        }

        public void setRef(ArrayList<ReferenceAddress> ref) {
            this.ref = ref;
        }

        public String getVerificationLevel() {
            return verificationLevel;
        }

        public void setVerificationLevel(String verificationLevel) {
            this.verificationLevel = verificationLevel;
        }

        public ArrayList<RelatedParties> getRelatedParties() {
            return relatedParties;
        }

        public void setRelatedParties(ArrayList<RelatedParties> relatedParties) {
            this.relatedParties = relatedParties;
        }

    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ValidateAddress validateAddress; ;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public ValidateAddress getResponse() { return validateAddress; }
    public void setResponse(ValidateAddress v) { validateAddress = v; }
}
