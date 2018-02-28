package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for the body of the RequestMarkDefaultDevice restful
 * service.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

public class RequestMarkDefaultDevice {


    public static class MarkDefaultRequest {

        @JsonProperty("accountId")
        private int accountId;

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private MarkDefaultRequest request;

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public MarkDefaultRequest getRequest() {
        return request;
    }

    public void setRequest(MarkDefaultRequest request) {
        this.request = request;
    }

}
