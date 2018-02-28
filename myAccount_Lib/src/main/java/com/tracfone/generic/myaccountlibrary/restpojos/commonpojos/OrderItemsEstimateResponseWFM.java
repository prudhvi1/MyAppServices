package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OrderItemsEstimateResponseWFM implements Parcelable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("action")
    private String action;
    @JsonProperty("relatedOrderItems")
    private RelatedOrderItem relatedOrderItem;
    @JsonProperty("productOffering")
    private ProductOfferingEstimate productOffering;
    @JsonProperty("supportingResources")
    private ArrayList<SupportingResources> supportingResources;
    @JsonProperty("orderItemPrice")
    private OrderPriceWFM orderPrice;
    @JsonProperty("quantity")
    private String quantity;


    public static final Creator<OrderItemsEstimateResponseWFM> CREATOR = new Creator<OrderItemsEstimateResponseWFM>() {
        @Override
        public OrderItemsEstimateResponseWFM createFromParcel(Parcel in) {
            return new OrderItemsEstimateResponseWFM(in);
        }

        @Override
        public OrderItemsEstimateResponseWFM[] newArray(int size) {
            return new OrderItemsEstimateResponseWFM[size];
        }
    };



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public RelatedOrderItem getRelatedOrderItem() {
        return relatedOrderItem;
    }

    public void setRelatedOrderItem(RelatedOrderItem relatedOrderItem) {
        this.relatedOrderItem = relatedOrderItem;
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

    public OrderPriceWFM getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(OrderPriceWFM orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public OrderItemsEstimateResponseWFM() {}
    protected OrderItemsEstimateResponseWFM(Parcel in) {
        id = in.readString();
        action = in.readString();
        relatedOrderItem = in.readParcelable(RelatedOrderItem.class.getClassLoader());
        productOffering = in.readParcelable(ProductOfferingEstimate.class.getClassLoader());
        supportingResources = in.createTypedArrayList(SupportingResources.CREATOR);
        orderPrice = in.readParcelable(OrderPriceWFM.class.getClassLoader());
        quantity = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(action);
        parcel.writeParcelable(relatedOrderItem, i);
        parcel.writeParcelable(productOffering, i);
        parcel.writeTypedList(supportingResources);
        parcel.writeParcelable(orderPrice, i);
        parcel.writeString(quantity);

    }
}
