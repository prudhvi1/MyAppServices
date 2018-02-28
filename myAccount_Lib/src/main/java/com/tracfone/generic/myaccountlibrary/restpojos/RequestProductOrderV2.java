package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.LocationEstimate;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductPromotions;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;

import java.util.ArrayList;

/**
 * Created by skishore on 10/18/2016.
 */

public class RequestProductOrderV2 {


    public static class ProductOrderRequest {

        @JsonProperty("externalID")
        private String externalID;
        @JsonProperty("orderDate")
        private String orderDate;
        @JsonProperty("relatedParties")
        private ArrayList<RelatedParties> relatedParties;
        @JsonProperty("productPromotions")
        private ArrayList<ProductPromotions> productPromotions;
        @JsonProperty("orderItems")
        private ArrayList<OrderItemsRequest> orderItems;
        @JsonProperty("quantity")
        private String quantity;
        @JsonProperty("billingAccount")
        private BillingAccount billingAccount;
        @JsonProperty("location")
        private ArrayList<LocationEstimate> locationEstimate;
        @JsonProperty("type")
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getExternalID() {
            return externalID;
        }

        public void setExternalID(String externalID) {
            this.externalID = externalID;
        }

        public ArrayList<LocationEstimate> getLocationEstimate() {
            return locationEstimate;
        }

        public void setLocationEstimate(ArrayList<LocationEstimate> locationEstimate) {
            this.locationEstimate = locationEstimate;}

        public BillingAccount getBillingAccount() {
            return billingAccount;
        }

        public void setBillingAccount(BillingAccount billingAccount) {
            this.billingAccount = billingAccount;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public ArrayList<OrderItemsRequest> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(ArrayList<OrderItemsRequest> orderItems) {
            this.orderItems = orderItems;
        }

        public ArrayList<ProductPromotions> getProductPromotions() {
            return productPromotions;
        }

        public void setProductPromotions(ArrayList<ProductPromotions> productPromotions) {
            this.productPromotions = productPromotions;
        }

        public ArrayList<RelatedParties> getRelatedParties() {
            return relatedParties;
        }

        public void setRelatedParties(ArrayList<RelatedParties> relatedParties) {
            this.relatedParties = relatedParties;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }
    }

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public ProductOrderRequest getRequest() {
        return request;
    }

    public void setRequest(ProductOrderRequest request) {
        this.request = request;
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private ProductOrderRequest request;
}
