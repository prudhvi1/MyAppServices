package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsEstimateResponse;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderPrice;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;

import java.util.ArrayList;

/**
 * Created by hserna on 10/16/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseEstimateOrder {

    public static class EstimateOrderResponse implements Parcelable{

        @JsonProperty("externalID")
        private String externalID;
        @JsonProperty("orderDate")
        private String orderDate;
        @JsonProperty("relatedParties")
        private ArrayList<RelatedParties> relatedParties;
        @JsonProperty("orderItems")
        private ArrayList<OrderItemsEstimateResponse> orderItems;
        @JsonProperty("orderPrice")
        private OrderPrice orderPrice;

        public EstimateOrderResponse(){}
        protected EstimateOrderResponse(Parcel in) {
            externalID = in.readString();
            orderDate = in.readString();
            relatedParties = in.createTypedArrayList(RelatedParties.CREATOR);
            orderItems = in.createTypedArrayList(OrderItemsEstimateResponse.CREATOR);
            orderPrice = in.readParcelable(OrderPrice.class.getClassLoader());

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

        public String getExternalID() {
            return externalID;
        }

        public void setExternalID(String externalID) {
            this.externalID = externalID;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public ArrayList<RelatedParties> getRelatedParties() {
            return relatedParties;
        }

        public void setRelatedParties(ArrayList<RelatedParties> relatedParties) {
            this.relatedParties = relatedParties;
        }

        public ArrayList<OrderItemsEstimateResponse> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(ArrayList<OrderItemsEstimateResponse> orderItems) {
            this.orderItems = orderItems;
        }

        public OrderPrice getOrderPrice() {
            return orderPrice;
        }

        public void setOrderPrice(OrderPrice orderPrice) {
            this.orderPrice = orderPrice;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(externalID);
            dest.writeString(orderDate);
            dest.writeTypedList(relatedParties);
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

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public EstimateOrderResponse getEstimateOrderResponse() {
        return estimateOrderResponse;
    }

    public void setEstimateOrderResponse(EstimateOrderResponse estimateOrderResponse) {
        this.estimateOrderResponse = estimateOrderResponse;
    }
}
