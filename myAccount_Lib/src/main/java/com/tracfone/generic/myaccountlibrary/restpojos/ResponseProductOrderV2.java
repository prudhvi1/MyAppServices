package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccountV2;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsResponse;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderPrice;

import java.util.ArrayList;

/**
 * Created by skishore on 10/18/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseProductOrderV2 {

    public static class ProductOrderResponse implements Parcelable {
        @JsonProperty("orderItems")
        private ArrayList<OrderItemsResponse> orderItems;
        @JsonProperty("billingAccount")
        private BillingAccountV2 billingAccountV2;
        @JsonProperty("orderPrice")
        private OrderPrice orderPrice;

        public ProductOrderResponse() {}
        protected ProductOrderResponse(Parcel in) {
            orderItems = in.createTypedArrayList(OrderItemsResponse.CREATOR);
            billingAccountV2 = in.readParcelable(BillingAccountV2.class.getClassLoader());
            orderPrice = in.readParcelable(OrderPrice.class.getClassLoader());
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

        public BillingAccountV2 getBillingAccountV2() {
            return billingAccountV2;
        }

        public void setBillingAccountV2(BillingAccountV2 billingAccountV2) {
            this.billingAccountV2 = billingAccountV2;
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
            dest.writeTypedList(orderItems);
            dest.writeParcelable(billingAccountV2, flags);
            dest.writeParcelable(orderPrice, flags);
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
