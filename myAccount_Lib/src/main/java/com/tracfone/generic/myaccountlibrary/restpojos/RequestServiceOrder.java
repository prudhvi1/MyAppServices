package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductPromotions;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices;
import java.util.ArrayList;

/**
 * Created by skishore on 10/17/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestServiceOrder {

    public static class ServiceOrderRequest {
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
        @JsonProperty("billingAccount")
        private BillingAccount billingAccount;
        @JsonProperty("relatedServices")
        private ArrayList<RelatedServices> relatedServices;
        @JsonProperty("type")
        private String type;

        public ArrayList<RelatedServices> getRelatedServices() {
            return relatedServices;
        }

        public void setRelatedServices(ArrayList<RelatedServices> relatedServices) {
            this.relatedServices = relatedServices;
        }

        public BillingAccount getBillingAccount() {
            return billingAccount;
        }

        public void setBillingAccount(BillingAccount billingAccount) {
            this.billingAccount = billingAccount;
        }

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

        public ArrayList<ProductPromotions> getProductPromotions() {
            return productPromotions;
        }

        public void setProductPromotions(ArrayList<ProductPromotions> productPromotions) {
            this.productPromotions = productPromotions;
        }

        public ArrayList<OrderItemsRequest> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(ArrayList<OrderItemsRequest> orderItems) {
            this.orderItems = orderItems;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public ServiceOrderRequest getRequest() {
        return request;
    }

    public void setRequest(ServiceOrderRequest request) {
        this.request = request;
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private ServiceOrderRequest request;
}
