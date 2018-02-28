package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class defines the POJO for a Promotion Validation responses
 * It corresponds to the restful services:
 *     Validate Promotions
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved.
 * ****************************************************************************/
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseValidatePromotions{

    public static class ValidatePromotions{

        @JsonProperty("promotionUnits")
        private String promotionUnits;
        @JsonProperty("promotionDays")
        private String promotionDays;
        @JsonProperty("promotionDiscount")
        private String promotionDiscount;

        public String getPromotionUnits() {  return promotionUnits; }
        public void setPromotionUnits(String promotionUnits) { this.promotionUnits = promotionUnits; }

        public String getPromotionDays() { return promotionDays; }
        public void setPromotionDays(String promotionDays) { this.promotionDays = promotionDays; }

        public String getPromotionDiscount() { return promotionDiscount; }
        public void setPromotionDiscount(String promotionDiscount) { this.promotionDiscount = promotionDiscount;  }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ValidatePromotions validatePromotions;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus v) { status = v; }

    public ValidatePromotions getResponse() { return validatePromotions; }
    public void setResponse(ValidatePromotions v) { validatePromotions = v; }
    /**
     * This method verifies all data returned from service is valid
     *
     * @return  true if all request data is valid
     */
    public void validatePromo()  throws MyAccountServiceException {
        boolean valid = true;
        if (validatePromotions.getPromotionUnits() == null) valid = false;
        if (validatePromotions.getPromotionDays() == null) valid = false;
        if (validatePromotions.getPromotionDiscount() == null) valid = false;

        if(!valid)
           throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);

    }
}
