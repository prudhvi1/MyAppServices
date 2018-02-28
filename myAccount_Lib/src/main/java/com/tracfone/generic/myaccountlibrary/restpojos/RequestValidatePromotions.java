package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for the request body of the Validate Promotions request.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RequestValidatePromotions {

    public static class ValidatePromotionRequest {

        @JsonProperty("esn")
        private String esn;
        @JsonProperty("min")
        private String min;
        @JsonProperty("promotionCode")
        private String promotionCode;
        @JsonProperty("transactionType")
        private String transactionType;
        @JsonProperty("transactionAmount")
        private String transactionAmount;

        public static class Cart {

            @JsonProperty("pinCard")
            private String pinCard;
            @JsonProperty("partNumber")
            private String partNumber;

            public String getPinCard() { return pinCard; }
            public void setPinCard(String pinCard) { this.pinCard = pinCard; }

            public String getPartNumber() {	return partNumber;	}
            public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
        }

        public String getPromotionCode() { return promotionCode; }
        public void setPromotionCode(String promotionCode) { this.promotionCode = promotionCode; }

        public String getEsn() { return esn; }
        public void setEsn(String esn) { this.esn = esn; }

        public String getMin() { return min; }
        public void setMin(String min) { this.min = min; }

        public String getTransactionType() { return transactionType;  }
        public void setTransactionType(String transactionType) {  this.transactionType = transactionType; }

        public String getTransactionAmount() { return transactionAmount;  }
        public void setTransactionAmount(String transactionAmount) { this.transactionAmount = transactionAmount; }

        @JsonProperty("cardIdentifier")
        private Cart carts = new Cart();

        public Cart getCarts() { return carts; }
        public void setCarts(Cart carts) { this.carts = carts; }
    }

    public static String PROMOTION_VALIDATION_TYPE_PURCHASE = "PURCHASE";
    public static String PROMOTION_VALIDATION_TYPE_PROMO_ENROLLMENT = "PROMOENROLLMENT";
    public static String PROMOTION_VALIDATION_TYPE_REDEMPTION = "REDEMPTION";

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private ValidatePromotionRequest request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public ValidatePromotionRequest getRequest() { return request; }
    public void setRequest(ValidatePromotionRequest r) { request = r; }
}
