package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccountRenewalEnquiry;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseRenewalInquiry {

    public static class RenewalInquiryResponse implements Parcelable {

        @JsonProperty("billingAccount")
        private BillingAccountRenewalEnquiry billingAccount;


        public RenewalInquiryResponse() {}
        protected RenewalInquiryResponse(Parcel in) {
            billingAccount = in.readParcelable(BillingAccountRenewalEnquiry.class.getClassLoader());
        }

        public static final Creator<RenewalInquiryResponse> CREATOR = new Creator<RenewalInquiryResponse>() {
            @Override
            public RenewalInquiryResponse createFromParcel(Parcel in) {
                return new RenewalInquiryResponse(in);
            }

            @Override
            public RenewalInquiryResponse[] newArray(int size) {
                return new RenewalInquiryResponse[size];
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
    private RenewalInquiryResponse renewalInquiryResponse;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus s) {
        status = s;
    }

    public RenewalInquiryResponse getResponse() {
        return renewalInquiryResponse;
    }

    public void setResponse(RenewalInquiryResponse v) {
        renewalInquiryResponse = v;
    }

}
