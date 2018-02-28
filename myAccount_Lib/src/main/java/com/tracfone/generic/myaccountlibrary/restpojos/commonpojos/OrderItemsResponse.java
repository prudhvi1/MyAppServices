package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by skishore on 10/17/2016.
 */

public class OrderItemsResponse implements Parcelable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("action")
    private String action;
    @JsonProperty("product")
    private Product product;   //ProductSpecification,RelatedServices,SupportingResources
    @JsonProperty("location")
    private Location location;
    @JsonProperty("orderItemExtension")
    private ArrayList<OrderItemExtension> orderItemExtension;
    @JsonProperty("quantity")
    private String quantity;
    @JsonProperty("billingAccount")
    private BillingAccount billingAccount;
    @JsonProperty("productOffering")
    private ProductOffering productOffering;
    @JsonProperty("service")
    private Service service;


    public static final String ACTION_ACTIVATION  = "ACTIVATION";
    public static final String ACTION_PROCESS  = "PROCESS";
    public static final String ACTION_PHONE_UPGRADE  = "PHONE_UPGRADE";
    public static final String ACTION_PORT  = "PORT";

    public static final Creator<OrderItemsResponse> CREATOR = new Creator<OrderItemsResponse>() {
        @Override
        public OrderItemsResponse createFromParcel(Parcel in) {
            return new OrderItemsResponse(in);
        }

        @Override
        public OrderItemsResponse[] newArray(int size) {
            return new OrderItemsResponse[size];
        }
    };

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<OrderItemExtension> getOrderItemExtension() {
        return orderItemExtension;
    }

    public void setOrderItemExtension(ArrayList<OrderItemExtension> orderItemExtension) {
        this.orderItemExtension = orderItemExtension;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public BillingAccount getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
    }

    public ProductOffering getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(ProductOffering productOffering) {
        this.productOffering = productOffering;
    }

    public OrderItemsResponse() {}
    protected OrderItemsResponse(Parcel in) {
        id = in.readString();
        action = in.readString();
        product = in.readParcelable(Product.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        orderItemExtension = in.createTypedArrayList(OrderItemExtension.CREATOR);
        quantity = in.readString();
        billingAccount = in.readParcelable(BillingAccount.class.getClassLoader());
        productOffering = in.readParcelable(ProductOffering.class.getClassLoader());
        service = in.readParcelable(Service.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(action);
        parcel.writeParcelable(product, i);
        parcel.writeParcelable(location, i);
        parcel.writeTypedList(orderItemExtension);
        parcel.writeString(quantity);
        parcel.writeParcelable(billingAccount, i);
        parcel.writeParcelable(productOffering, i);
        parcel.writeParcelable(service, i);
    }
}
