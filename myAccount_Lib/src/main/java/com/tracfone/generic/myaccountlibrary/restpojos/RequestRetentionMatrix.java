package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class RequestRetentionMatrix defines the POJO for the request body of the Retention Matrix restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RequestRetentionMatrix {

    public static class RetentionMatrixSelection {

        public static class PlanIdentifier {

            @JsonProperty("pinCard")
            private String planActionPinCard;
            @JsonProperty("servicePlanId")
            private int planActionPlanID;

            public void setPlanActionPinCard(String i) { planActionPinCard = i; }
            public String getPlanActionPinCard() { return planActionPinCard; }

            public void setPlanActionPlanID(int t) { planActionPlanID = t; }
            public int getPlanActionPlanID() { return planActionPlanID; }
        }

        @JsonProperty("context")
        private String retentionContext;
        @JsonProperty("planIdentifier")
        private PlanIdentifier retentionPlanIdentifiers = new PlanIdentifier();

        public static String RETENTION_CONTEXT_REDEMPTION = "REDEMPTION";
        public static String RETENTION_CONTEXT_PURCHASE = "PURCHASE";
        public static String RETENTION_CONTEXT_MANAGE_RESERVE = "MANAGE_RESERVE";
        public static String RETENTION_CONTEXT_APPLY_NOW = "APPLY_NOW";
        public static String RETENTION_CONTEXT_ENROLL_IN_AUTO_REFILL = "ENROLL_IN_AUTO_REFILL";
        public static String RETENTION_CONTEXT_SWITCH_PLAN = "SWITCH_PLAN";
        public static String RETENTION_CONTEXT_VALUE_PLAN_ENROLLMENT = "VALUE_PLAN_ENROLLMENT";
        public static String RETENTION_CONTEXT_CHANGE_VALUE_PLAN = "CHANGE_VALUE_PLAN";

        public String getRetentionContext() { return retentionContext; }
        public void setRetentionContext(String m) { retentionContext = m; }

        public PlanIdentifier getRetentionPlanIdentifiers() { return retentionPlanIdentifiers; }
        public void setRetentionPlanIdentifiers(PlanIdentifier retentionPlanIdentifiers) { this.retentionPlanIdentifiers = retentionPlanIdentifiers; }
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private RetentionMatrixSelection request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public RetentionMatrixSelection getRequest() { return request; }
    public void setRequest(RetentionMatrixSelection r) { request = r; }
}