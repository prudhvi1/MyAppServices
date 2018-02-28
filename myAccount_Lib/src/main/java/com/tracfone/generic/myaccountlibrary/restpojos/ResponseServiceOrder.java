package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccountV2;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsResponse;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Status;

import java.util.ArrayList;

/**
 * Created by skishore on 10/17/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseServiceOrder {

    public static class ServiceOrderResponse implements Parcelable {
        @JsonProperty("orderItems")
        private ArrayList<OrderItemsResponse> orderItems;
        @JsonProperty("billingAccount")
        private BillingAccountV2 billingAccountV2;

        protected ServiceOrderResponse(Parcel in) {
            orderItems = in.createTypedArrayList(OrderItemsResponse.CREATOR);
            billingAccountV2 = in.readParcelable(BillingAccountV2.class.getClassLoader());
        }

        public ServiceOrderResponse(){

        }
        public static final Creator<ServiceOrderResponse> CREATOR = new Creator<ServiceOrderResponse>() {
            @Override
            public ServiceOrderResponse createFromParcel(Parcel in) {
                return new ServiceOrderResponse(in);
            }

            @Override
            public ServiceOrderResponse[] newArray(int size) {
                return new ServiceOrderResponse[size];
            }
        };

        public ArrayList<OrderItemsResponse> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(ArrayList<OrderItemsResponse> orderItems) {
            this.orderItems = orderItems;
        }

        public BillingAccountV2 getBillingAccountV2() {
            return billingAccountV2;
        }

        public void setBillingAccountV2(BillingAccountV2 billingAccountV2) {
            this.billingAccountV2 = billingAccountV2;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeTypedList(orderItems);
            dest.writeParcelable(billingAccountV2, flags);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ServiceOrderResponse serviceOrderResponse;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus s) {
        status = s;
    }

    public ServiceOrderResponse getResponse() {
        return serviceOrderResponse;
    }

    public void setResponse(ServiceOrderResponse v) {
        serviceOrderResponse = v;
    }

}
