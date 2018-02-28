package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for the response to a restful request to
 * view the Transaction History.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseUpgradePlans {

    public static class UpgradePlans{
        @JsonProperty("totalPoints")
        private int totalPoints;
        @JsonProperty("pointsAccrued")
        private double pointsAccrued;
        @JsonProperty("benefits")
        private List<Benefits> benefits = new ArrayList<>();

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public double getPointsAccrued() {
            return pointsAccrued;
        }

        public void setPointsAccrued(double pointsAccrued) {
            this.pointsAccrued = pointsAccrued;
        }

        public List<Benefits> getBenefits() {
            return benefits;
        }

        public void setBenefits(List<Benefits> benefits) {
            this.benefits = benefits;
        }

        public static class Benefits {
            @JsonProperty("benefitId")
            private String benefitId;
            @JsonProperty("benefitType")
            private String benefitType;
            @JsonProperty("benefitValue")
            private String benefitValue;
            @JsonProperty("benefitOwnerType")
            private String benefitOwnerType;
            @JsonProperty("benefitOwnerValue")
            private String benefitOwnerValue;
            @JsonProperty("usageAllowPartial")
            private String usageAllowPartial;
            @JsonProperty("usagePurchaseType")
            private String usagePurchaseType;

            public String getBenefitId() {
                return benefitId;
            }

            public void setBenefitId(String benefitId) {
                this.benefitId = benefitId;
            }

            public String getBenefitType() {
                return benefitType;
            }

            public void setBenefitType(String benefitType) {
                this.benefitType = benefitType;
            }

            public String getBenefitValue() {
                return benefitValue;
            }

            public void setBenefitValue(String benefitValue) {
                this.benefitValue = benefitValue;
            }

            public String getBenefitOwnerType() {
                return benefitOwnerType;
            }

            public void setBenefitOwnerType(String benefitOwnerType) {
                this.benefitOwnerType = benefitOwnerType;
            }

            public String getBenefitOwnerValue() {
                return benefitOwnerValue;
            }

            public void setBenefitOwnerValue(String benefitOwnerValue) {
                this.benefitOwnerValue = benefitOwnerValue;
            }

            public String getUsageAllowPartial() {
                return usageAllowPartial;
            }

            public void setUsageAllowPartial(String usageAllowPartial) {
                this.usageAllowPartial = usageAllowPartial;
            }

            public String getUsagePurchaseType() {
                return usagePurchaseType;
            }

            public void setUsagePurchaseType(String usagePurchaseType) {
                this.usagePurchaseType = usagePurchaseType;
            }
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private UpgradePlans upgradePlans;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public UpgradePlans getResponse() { return upgradePlans; }
    public void setResponse(UpgradePlans up) { upgradePlans = up; }

    /**
     * This method verifies all data returned from service is valid
     *
     * @return  true if all request data is valid
     */
    public void  validateUpgradePlans() throws MyAccountServiceException{
        boolean valid = true;
        int size = upgradePlans.getBenefits().size();
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                if (upgradePlans.getBenefits().get(i).getBenefitId() == null) valid = false;
                if (upgradePlans.getBenefits().get(i).getBenefitType() == null) valid = false;
                if (upgradePlans.getBenefits().get(i).getBenefitValue() == null) valid = false;
                if (upgradePlans.getBenefits().get(i).getBenefitOwnerType() == null) valid = false;
                if (upgradePlans.getBenefits().get(i).getUsageAllowPartial() == null) valid = false;
                if (upgradePlans.getBenefits().get(i).getUsagePurchaseType() == null) valid = false;
                if (upgradePlans.getBenefits().get(i).getBenefitOwnerValue() == null) valid = false;
            }
        }
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);

    }
}

