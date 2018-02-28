package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class RequestSettingsInstructions defines the POJO for the request body of the APN Settings Instructions restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestSettingsInstructions {

    public static class SettingInstructionRequest {

        @JsonProperty("operatingSystemId")
        private String operatingSystemId;

        public String getOperatingSystemId() {
            return operatingSystemId;
        }

        public void setOperatingSystemId(String operatingSystemId) {
            this.operatingSystemId = operatingSystemId;
        }
    }
    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private SettingInstructionRequest request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public SettingInstructionRequest getRequest() { return request; }
    public void setRequest(SettingInstructionRequest r) { request = r; }
}