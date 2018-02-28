package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsResponse;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Status;

import java.util.ArrayList;

/**
 * Created by skishore on 10/18/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseProductOrder {

    public static class ProductOrderResponse implements Parcelable {
        @JsonProperty("orderItems")
        private ArrayList<OrderItemsResponse> orderItems;

        public ProductOrderResponse() {}
        protected ProductOrderResponse(Parcel in) {
            orderItems = in.createTypedArrayList(OrderItemsResponse.CREATOR);
        }

        public static final Creator<ProductOrderResponse> CREATOR = new Creator<ProductOrderResponse>() {
            @Override
            public ProductOrderResponse createFromParcel(Parcel in) {
                return new ProductOrderResponse(in);
            }

            @Override
            public ProductOrderResponse[] newArray(int size) {
                return new ProductOrderResponse[size];
            }
        };

        public ArrayList<OrderItemsResponse> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(ArrayList<OrderItemsResponse> orderItems) {
            this.orderItems = orderItems;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeTypedList(orderItems);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ProductOrderResponse productOrderResponse;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus s) {
        status = s;
    }

    public ProductOrderResponse getResponse() {
        return productOrderResponse;
    }

    public void setResponse(ProductOrderResponse v) {
        productOrderResponse = v;
    }

}
