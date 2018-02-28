package com.tracfone.generic.myaccountlibrary.restpojos;

/**
 * ****************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 * <p/>
 * CLASS DESCRIPTION:
 * <p/>
 * This class define the POJO of Add device to account Web Service Request
 * <p/>
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************************************************
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class RequestAddDevice {

    public static class AddDeviceToAccountRequest {

        @JsonProperty("min")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private String min;
        @JsonProperty("esn")
        private String esn;
        @JsonProperty("groupId")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private String groupId;
        @JsonProperty("groupPlanId")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private int groupPlanId;

        public String getGroupId() {
            return groupId;
        }

        public int getGroupPlanId() {
            return groupPlanId;
        }

        public void setGroupPlanId(int groupPlanId) {
            this.groupPlanId = groupPlanId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }

        public String getEsn() {
            return esn;
        }

        public void setEsn(String esn) {
            this.esn = esn;
        }
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private AddDeviceToAccountRequest request;

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public AddDeviceToAccountRequest getRequest() {
        return request;
    }

    public void setRequest(AddDeviceToAccountRequest request) {
        this.request = request;
    }

}
