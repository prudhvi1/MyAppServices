package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class defines the POJO for the response to a restful request for the
 * reasons for DisEnrollment.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDisEnrollmentReasons {

    public static class DisEnrollmentReasonList {

        public static class DisEnrollmentReason {

            @JsonProperty("reason")
            private String reason;

            public String getReason() { return reason; }
            public void setReason(String reason) { this.reason = reason; }
        }
        @JsonProperty("reasons")
        private List<DisEnrollmentReason> disEnrollmentReasons = new ArrayList<DisEnrollmentReason>();

        public List<DisEnrollmentReason> getDisEnrollmentReasons() { return disEnrollmentReasons; }
        public void setDisEnrollmentReasons(List<DisEnrollmentReason> disEnrollmentReasons) { this.disEnrollmentReasons = disEnrollmentReasons; }
    }
    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private DisEnrollmentReasonList disEnrollmentReasonList;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public DisEnrollmentReasonList getResponse() { return disEnrollmentReasonList; }
    public void setResponse(DisEnrollmentReasonList u) { disEnrollmentReasonList = u; }
}