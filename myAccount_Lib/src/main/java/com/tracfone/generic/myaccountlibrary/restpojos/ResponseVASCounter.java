package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class ResponseVASCounter defines the POJO for the response body of the  Value Added Service Counter restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseVASCounter {

    public static class VASCounter {

        @JsonProperty("eventCount")
        private int eventCount;

        public int getEventCount() {  return eventCount;  }
        public void setEventCount(int eventCount) { this.eventCount = eventCount;  }
    }
    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private VASCounter vasCounter;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public VASCounter getResponse() { return vasCounter; }
    public void setResponse(VASCounter v) { vasCounter = v; }

    public void  validateVasCounter() throws MyAccountServiceException {
        boolean valid = true;
        if (vasCounter.getEventCount() == -1) valid = false;
        if(!valid)
           throw  new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);

    }
}
