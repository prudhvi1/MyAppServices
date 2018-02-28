package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderPriceWFM;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsEstimateResponseWFM;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseEstimateOrderWFM {

    public static class EstimateOrderResponse implements Parcelable {
        @JsonProperty("orderDate")
        private String orderDate;
        @JsonProperty("orderItems")
        private ArrayList<OrderItemsEstimateResponseWFM> orderItems;
        @JsonProperty("orderPrice")
        private OrderPriceWFM orderPrice;

        public EstimateOrderResponse() {}
        protected EstimateOrderResponse(Parcel in) {
            orderDate = in.readString();
            orderItems = in.createTypedArrayList(OrderItemsEstimateResponseWFM.CREATOR);
            orderPrice = in.readParcelable(OrderPriceWFM.class.getClassLoader());
        }

        public static final Creator<EstimateOrderResponse> CREATOR = new Creator<EstimateOrderResponse>() {
            @Override
            public EstimateOrderResponse createFromParcel(Parcel in) {
                return new EstimateOrderResponse(in);
            }

            @Override
            public EstimateOrderResponse[] newArray(int size) {
                return new EstimateOrderResponse[size];
            }
        };

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public ArrayList<OrderItemsEstimateResponseWFM> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(ArrayList<OrderItemsEstimateResponseWFM> orderItems) {
            this.orderItems = orderItems;
        }

        public OrderPriceWFM getOrderPrice() {
            return orderPrice;
        }

        public void setOrderPrice(OrderPriceWFM orderPrice) {
            this.orderPrice = orderPrice;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(orderDate);
            dest.writeTypedList(orderItems);
            dest.writeParcelable(orderPrice, flags);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private EstimateOrderResponse estimateOrderResponse;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus s) {
        status = s;
    }

    public EstimateOrderResponse getResponse() {
        return estimateOrderResponse;
    }

    public void setResponse(EstimateOrderResponse v) {
        estimateOrderResponse = v;
    }

}
