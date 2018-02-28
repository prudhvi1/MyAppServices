package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class RequestVASCounterIncrement defines the POJO for the request body of the Value Added Service Increment Counter restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestVASCounterIncrement {

    public static class CounterIncrementRequest {

        @JsonProperty("eventId")
        private String eventId;
        @JsonProperty("step")
        private int step;

        public String getEventId() { return eventId; }
        public void setEventId(String eventId) { this.eventId = eventId; }

        public int getStep() { return step; }
        public void setStep(int step) { this.step = step; }
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private CounterIncrementRequest request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public CounterIncrementRequest getRequest() { return request; }
    public void setRequest(CounterIncrementRequest r) { request = r; }
}