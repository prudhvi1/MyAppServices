package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccountRenewalEnquiry;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseRenewalEnquiry {

    public static class RenewalEnquiryResponse implements Parcelable {

        @JsonProperty("billingAccount")
        private BillingAccountRenewalEnquiry billingAccount;


        public RenewalEnquiryResponse() {}
        protected RenewalEnquiryResponse(Parcel in) {
            billingAccount = in.readParcelable(BillingAccountRenewalEnquiry.class.getClassLoader());
        }

        public static final Creator<RenewalEnquiryResponse> CREATOR = new Creator<RenewalEnquiryResponse>() {
            @Override
            public RenewalEnquiryResponse createFromParcel(Parcel in) {
                return new RenewalEnquiryResponse(in);
            }

            @Override
            public RenewalEnquiryResponse[] newArray(int size) {
                return new RenewalEnquiryResponse[size];
            }
        };

        public BillingAccountRenewalEnquiry getBillingAccount() {
            return billingAccount;
        }

        public void setBillingAccount(BillingAccountRenewalEnquiry billingAccount) {
            this.billingAccount = billingAccount;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(billingAccount, flags);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private RenewalEnquiryResponse renewalEnquiryResponse;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus s) {
        status = s;
    }

    public RenewalEnquiryResponse getResponse() {
        return renewalEnquiryResponse;
    }

    public void setResponse(RenewalEnquiryResponse v) {
        renewalEnquiryResponse = v;
    }

}
