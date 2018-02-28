package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class RequestDeEnrollPlan defines the POJO for the request body of the DeEnroll restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDeEnrollPlan {

    public static class DeEnrollRequest {
        @JsonProperty("reason")
        private String reason;

        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private DeEnrollRequest request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public DeEnrollRequest getRequest() { return request; }
    public void setRequest(DeEnrollRequest r) { request = r; }
}
