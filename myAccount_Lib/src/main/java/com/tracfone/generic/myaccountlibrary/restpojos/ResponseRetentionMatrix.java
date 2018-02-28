package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for the response to a restful request to
 * provide a plans retention matrix.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved.
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseRetentionMatrix {

    public static class PlanActionList {

        public static class PlanAction {

            @JsonProperty("pinCard")
            private String planActionPinCard;
            @JsonProperty("servicePlanId")
            private int planActionPlanID;
            @JsonProperty("actions")
            private List<String> planActionAction = new ArrayList<>();
            @JsonProperty("displayWarning")
            private String planDisplayWarning;
            @JsonProperty("actionWarning")
            private String planActionWarning;

            public void setPlanActionPinCard(String i) { planActionPinCard = i; }
            public String getPlanActionPinCard() { return planActionPinCard; }

            public void setPlanActionPlanID(int t) { planActionPlanID = t; }
            public int getPlanActionPlanID() { return planActionPlanID; }

            public void setPlanActionAction(List<String> pa) { planActionAction = pa;  }
            public List<String> getPlanActionAction() { return planActionAction; }

            public String getPlanDisplayWarning() { return planDisplayWarning; }
            public void setPlanDisplayWarning(String planDisplayWarning) { this.planDisplayWarning = planDisplayWarning; }

            public String getPlanActionWarning() { return planActionWarning; }
            public void setPlanActionWarning(String w) { planActionWarning = w; }

        }
        @JsonProperty("planActions")
        private PlanAction planActions = new PlanAction();

        public static String RETENTION_ACTION_ADD_NOW = "ADD_NOW";
        public static String RETENTION_ACTION_ADD_TO_RESERVE = "ADD_TO_RESERVE";
        public static String RETENTION_ACTION_APPLY_NOW = "APPLY_NOW";
        public static String RETENTION_ACTION_ENROLL_NOW= "ENROLL_NOW";
        public static String RETENTION_ACTION_ENROLL_ON_DUE_DATE= "ENROLL_ON_DUE_DATE";
        public static String RETENTION_ACTION_SKIP = "SKIP"; //This is an app defined action. It is determined by the app.
        public static String RETENTION_ACTION_CANCEL = "CANCEL"; //This is an app defined action. It is determined by the app.




        public PlanAction getPlanActions() { return planActions; }
        public void setPlanActions(PlanAction planActions) { this.planActions = planActions; }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private PlanActionList planActionList;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public PlanActionList getResponse() { return planActionList; }
    public void setResponse(PlanActionList p) { planActionList = p; }

    /**
     * This method verifies all data returned from service is valid
     *
     * @return  true if all request data is valid
     */
    public void validateRetentionMatrix() throws MyAccountServiceException {
        boolean valid = true;
       // if(planActionList.getPlanActions().getPlanActionWarning()==null)valid=false;
        if(planActionList.getPlanActions().getPlanActionAction().get(0)==null)valid=false;
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


    }
}