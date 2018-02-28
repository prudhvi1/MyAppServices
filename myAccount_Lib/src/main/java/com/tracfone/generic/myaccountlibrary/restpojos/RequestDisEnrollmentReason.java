package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class RequestDisEnrollmentReason defines the POJO for the request body of the DisEnrollment Reason restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDisEnrollmentReason {

    public static class DeEnrollReasonRequest {
        @JsonProperty("accountId")
        private int accountId;

        public int getAccountId() { return accountId; }
        public void setAccountId(int accountId) { this.accountId = accountId; }
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private DeEnrollReasonRequest request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public DeEnrollReasonRequest getRequest() { return request; }
    public void setRequest(DeEnrollReasonRequest r) { request = r; }
}
