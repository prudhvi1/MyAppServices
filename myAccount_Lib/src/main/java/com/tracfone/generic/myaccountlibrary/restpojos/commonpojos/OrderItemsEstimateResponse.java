package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * Created by hserna on 10/16/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemsEstimateResponse implements Parcelable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("orderItemPrice")
    private OrderItemPrice orderItemPrice;
    @JsonProperty("productOffering")
    private ProductOfferingEstimate productOffering;
    @JsonProperty("supportingResources")
    private ArrayList<SupportingResources> supportingResources;

    public OrderItemsEstimateResponse(){}
    protected OrderItemsEstimateResponse(Parcel in) {
        id = in.readString();
        orderItemPrice = in.readParcelable(OrderItemPrice.class.getClassLoader());
        productOffering = in.readParcelable(ProductOfferingEstimate.class.getClassLoader());
        supportingResources = in.createTypedArrayList(SupportingResources.CREATOR);
    }

    public static final Creator<OrderItemsEstimateResponse> CREATOR = new Creator<OrderItemsEstimateResponse>() {
        @Override
        public OrderItemsEstimateResponse createFromParcel(Parcel in) {
            return new OrderItemsEstimateResponse(in);
        }

        @Override
        public OrderItemsEstimateResponse[] newArray(int size) {
            return new OrderItemsEstimateResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderItemPrice getOrderPrice() {
        return orderItemPrice;
    }

    public void setOrderPrice(OrderItemPrice orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public ProductOfferingEstimate getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(ProductOfferingEstimate productOffering) {
        this.productOffering = productOffering;
    }

    public ArrayList<SupportingResources> getSupportingResources() {
        return supportingResources;
    }

    public void setSupportingResources(ArrayList<SupportingResources> supportingResources) {
        this.supportingResources = supportingResources;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeParcelable(orderItemPrice, i);
        parcel.writeParcelable(productOffering, i);
        parcel.writeTypedList(supportingResources);
    }
}
