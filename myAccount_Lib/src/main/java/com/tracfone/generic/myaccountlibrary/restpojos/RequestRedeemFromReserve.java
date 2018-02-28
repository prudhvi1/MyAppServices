package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class RequestRedeemFromReserve defines the POJO for the request body of Redeem from Reserve restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestRedeemFromReserve {

    public static class RedeemFromReserve {

        @JsonProperty("redeemNow")
        private boolean redeemNow;

        public boolean isRedeemNow() { return redeemNow; }
        public void setRedeemNow(boolean redeemNow) { this.redeemNow = redeemNow; }
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private RedeemFromReserve request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public RedeemFromReserve getRequest() { return request; }
    public void setRequest(RedeemFromReserve r) { request = r; }
}
