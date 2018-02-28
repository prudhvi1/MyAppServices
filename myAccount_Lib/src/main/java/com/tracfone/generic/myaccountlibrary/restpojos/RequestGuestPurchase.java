package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartNumber;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PaymentMean;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.VasPlans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by com.tracfone.preload on 1/16/2017.
 */

public class RequestGuestPurchase {
    public static class GuestPurchaseJSONRequest {
        @JsonProperty("paymentMean")
        private PaymentMean paymentMean;
        @JsonProperty("vasPlans")
        private List<VasPlans> vasPlansList = new ArrayList<VasPlans>();
        @JsonProperty("redeemNow")
        private boolean redeemNow;
        @JsonProperty("servicePlanId")
        private int servicePlanId;
        @JsonProperty("isILDVas")
        private boolean isILDVas;
        @JsonProperty("promoCode")
        private String promoCode;
        @JsonProperty("cart")
        private List<PartNumber> cart =  new ArrayList<PartNumber>();

        public PaymentMean getPaymentMean() {
            return paymentMean;
        }

        public void setPaymentMean(PaymentMean paymentMean) {
            this.paymentMean = paymentMean;
        }


        public List<VasPlans> getVasPlansList() {
            return vasPlansList;
        }

        public void setVasPlansList(List<VasPlans> vasPlansList) {
            this.vasPlansList = vasPlansList;
        }

        public boolean isRedeemNow() {
            return redeemNow;
        }

        public void setRedeemNow(boolean redeemNow) {
            this.redeemNow = redeemNow;
        }

        public int getServicePlanId() {
            return servicePlanId;
        }

        public void setServicePlanId(int servicePlanId) {
            this.servicePlanId = servicePlanId;
        }

        public boolean getIsILDVas() {
            return isILDVas;
        }

        public void setIsILDVas(boolean isILDVas) {
            this.isILDVas = isILDVas;
        }

        public String getPromoCode() {
            return promoCode;
        }

        public void setPromoCode(String promoCode) {
            this.promoCode = promoCode;
        }

        public List<PartNumber> getCart() {
            return cart;
        }

        public void setCart(List<PartNumber> cart) {
            this.cart = cart;
        }

    }

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public RequestGuestPurchase.GuestPurchaseJSONRequest getRequest() {
        return request;
    }

    public void setRequest(RequestGuestPurchase.GuestPurchaseJSONRequest request) {
        this.request = request;
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private RequestGuestPurchase.GuestPurchaseJSONRequest request;

}
