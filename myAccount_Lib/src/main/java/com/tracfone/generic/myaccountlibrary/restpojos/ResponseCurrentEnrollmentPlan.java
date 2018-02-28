package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class defines the POJO for the response to a restful request for the
 * currently Enrolled Plan.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCurrentEnrollmentPlan {

    public static class CurrentEnrollmentPlan implements Parcelable {

        @JsonProperty("nextChargeDate")
        private String nextChargeDate;

        public static class PaymentSource implements Parcelable{
            @JsonProperty("paymentSourceId")
            private String paymentSourceId;
            @JsonProperty("paymentSourceNickName")
            private String paymentSourceNickName;
            @JsonProperty("paymentSourceType")
            private String paymentSourceType;
            @JsonProperty("paymentSourceNumberMask")
            private String paymentSourceNumberMask;

            public String getPaymentSourceId() { return paymentSourceId; }
            public void setPaymentSourceId(String paymentSourceId) { this.paymentSourceId = paymentSourceId; }

            public String getPaymentSourceNickName() {
                String name = paymentSourceNickName;
                if (name == null) name = "    ";
                return name; }
            public void setPaymentSourceNickName(String paymentSourceNickName) { this.paymentSourceNickName = paymentSourceNickName; }

            public String getPaymentSourceType() { return paymentSourceType; }
            public void setPaymentSourceType(String paymentSourceType) { this.paymentSourceType = paymentSourceType; }

            public String getPaymentSourceNumberMask() { return paymentSourceNumberMask; }
            public void setPaymentSourceNumberMask(String paymentSourceNumberMask) { this.paymentSourceNumberMask = paymentSourceNumberMask; }

            public PaymentSource() {}
            protected PaymentSource(Parcel in) {
                paymentSourceId = in.readString();
                paymentSourceNickName = in.readString();
                paymentSourceType = in.readString();
                paymentSourceNumberMask = in.readString();
            }
            public static final Creator<PaymentSource> CREATOR = new Creator<PaymentSource>() {
                @Override
                public PaymentSource createFromParcel(Parcel in) {
                    return new PaymentSource(in);
                }
                @Override
                public PaymentSource[] newArray(int size) {
                    return new PaymentSource[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }
            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(paymentSourceId);
                parcel.writeString(paymentSourceNickName);
                parcel.writeString(paymentSourceType);
                parcel.writeString(paymentSourceNumberMask);
            }
        }
        public static class ServicePlan implements Parcelable {
            @JsonProperty("servicePlanId")
            private String planId;
            @JsonProperty("servicePlanName")
            private String planName;
            @JsonProperty("servicePlanDescription")
            private String planDescription;
            @JsonProperty("servicePlanDescription2")
            private String planDescription2;
            @JsonProperty("servicePlanDescription3")
            private String planDescription3;
            @JsonProperty("servicePlanDescription4")
            private String planDescription4;
            @JsonProperty("servicePlanType")
            private String planType;
            @JsonProperty("voiceUnits")
            private String planVoiceUnits;
            @JsonProperty("smsUnits")
            private String planSmsUnits;
            @JsonProperty("dataUnits")
            private String planDataUnits;
            @JsonProperty("serviceDays")
            private String planServiceDays;
            @JsonProperty("price")
            private double planPrice;
            @JsonProperty("recurringPlan")
            private String planRecurring;
            @JsonProperty("partNumber")
            private String planPartNumber;
            @JsonProperty("programId")
            private String planProgramId;
            @JsonProperty("voiceConversionFactor")
            private int planVoiceConversionFactor;
            @JsonProperty("enrollmentPromotion")
            private EnrollmentPromotion promo;

            public void setPlanId(String planId) {
                this.planId = planId;
            }
            public String getPlanId() {
                return planId;
            }

            public void setPlanName(String planName) {
                this.planName = planName;
            }
            public String getPlanName() {
                return planName;
            }

            public void setPlanDescription(String planDescription) { this.planDescription = planDescription; }
            public String getPlanDescription() {
                return planDescription;
            }

            public void setPlanDescription2(String planDescription2) { this.planDescription2 = planDescription2; }
            public String getPlanDescription2() {
                return planDescription2;
            }

            public void setPlanDescription3(String planDescription3) { this.planDescription3 = planDescription3; }
            public String getPlanDescription3() {
                return planDescription3;
            }

            public void setPlanDescription4(String planDescription4) { this.planDescription4 = planDescription4; }
            public String getPlanDescription4() {
                return planDescription4;
            }

            public void setPlanVoiceUnits(String planVoiceUnits) { this.planVoiceUnits = planVoiceUnits; }
            public String getPlanVoiceUnits() {
                return planVoiceUnits;
            }

            public void setPlanSmsUnits(String planSmsUnits) {
                this.planSmsUnits = planSmsUnits;
            }
            public String getPlanSmsUnits() {
                return planSmsUnits;
            }

            public void setPlanDataUnits(String planDataUnits) { this.planDataUnits = planDataUnits; }
            public String getPlanDataUnits() {
                return planDataUnits;
            }

            public void setPlanServiceDays(String planServiceDays) { this.planServiceDays = planServiceDays; }
            public String getPlanServiceDays() {
                return planServiceDays;
            }

            public void setPlanPrice(double planPrice) {
                this.planPrice = planPrice;
            }

            public String getPlanPrice() {
                String planPriceString = "";
                if (planPrice == (long) planPrice)
                    planPriceString = String.format("%d", (long) planPrice);
                else {
                    //round off to two decimal places
                    planPrice = (double) Math.round(planPrice * 100) / 100;
                    //display only two decimal places
                    planPriceString = String.format("%.2f", planPrice);
                }
                return planPriceString;
            }

            public double getPlanPriceDouble() {
                return planPrice;
            }

            public void setPlanRecurring(String planRecurring) { this.planRecurring = planRecurring; }
            public boolean getPlanRecurring() {
                if (planRecurring != null) {
                    return (planRecurring.equals("true")) ? true : false;
                } else {
                    return false;
                }
            }
            public String getPlanRecurringCheck() {
                return planRecurring;
            }

            public void setPlanPartNumber(String planPartNumber) { this.planPartNumber = planPartNumber; }
            public String getPlanPartNumber() {
                return planPartNumber;
            }

            public String getPlanType() {
                return planType;
            }
            public void setPlanType(String planType) {
                this.planType = planType;
            }

            public String getPlanProgramId() {
                return planProgramId;
            }
            public void setPlanProgramId(String planProgramId) { this.planProgramId = planProgramId; }

            public void setPlanVoiceConversionFactor(int planVoiceConversionFactor) { this.planVoiceConversionFactor = planVoiceConversionFactor; }
            public int getPlanVoiceConversionFactor() {
                if (planVoiceConversionFactor != -1) {
                    return planVoiceConversionFactor;
                } else
                    return -1;
            }

            public static class EnrollmentPromotion implements Parcelable{
                @JsonProperty("promoUnits")
                private String planPromoUnits;
                @JsonProperty("promoPrice")
                private double planPromoPrice;
                @JsonProperty("promoMessage")
                private String planPromoMessage;

                public void setPlanPromoUnits(String planPromoUnits) { this.planPromoUnits = planPromoUnits; }
                public String getPlanPromoUnits() { return planPromoUnits; }

                public void setPlanPromoPrice(double planPromoPrice) { this.planPromoPrice = planPromoPrice; }
                public String getPlanPromoPrice() {
                    String planPromoPriceString = "";
                    if (planPromoPrice == (long) planPromoPrice)
                        planPromoPriceString = String.format("%d", (long) planPromoPrice);
                    else
                        planPromoPriceString = String.format("%.2f", planPromoPrice);
                    return planPromoPriceString;
                }

                public double getPlanPromoPriceDouble() { return planPromoPrice; }

                public void setPlanPromoMessage(String planPromoMessage) { this.planPromoMessage = planPromoMessage; }
                public String getPlanPromoMessage() {
                    return planPromoMessage;
                }

                public EnrollmentPromotion(){ }
                protected EnrollmentPromotion(Parcel in) {
                    planPromoUnits = in.readString();
                    planPromoPrice = in.readDouble();
                    planPromoMessage = in.readString();
                }
                public static final Creator<EnrollmentPromotion> CREATOR = new Creator<EnrollmentPromotion>() {
                    @Override
                    public EnrollmentPromotion createFromParcel(Parcel in) {
                        return new EnrollmentPromotion(in);
                    }
                    @Override
                    public EnrollmentPromotion[] newArray(int size) {
                        return new EnrollmentPromotion[size];
                    }
                };
                @Override
                public int describeContents() {
                    return 0;
                }
                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(planPromoUnits);
                    parcel.writeDouble(planPromoPrice);
                    parcel.writeString(planPromoMessage);
                }
            }
            public EnrollmentPromotion getPromo() { return promo; }
            public void setPromo(EnrollmentPromotion promo) { this.promo = promo; }

            public ServicePlan() { }
            protected ServicePlan(Parcel in) {
                planId = in.readString();
                planName = in.readString();
                planDescription = in.readString();
                planDescription2 = in.readString();
                planDescription3 = in.readString();
                planDescription4 = in.readString();
                planType = in.readString();
                planVoiceUnits = in.readString();
                planSmsUnits = in.readString();
                planDataUnits = in.readString();
                planServiceDays = in.readString();
                planPrice = in.readDouble();
                planRecurring = in.readString();
                planPartNumber = in.readString();
                planProgramId = in.readString();
                planVoiceConversionFactor = in.readInt();
                promo= in.readParcelable(ServicePlan.class.getClassLoader());
            }
            public static final Creator<ServicePlan> CREATOR = new Creator<ServicePlan>() {
                @Override
                public ServicePlan createFromParcel(Parcel in) {
                    return new ServicePlan(in);
                }
                @Override
                public ServicePlan[] newArray(int size) {
                    return new ServicePlan[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }
            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(planId);
                parcel.writeString(planName);
                parcel.writeString(planDescription);
                parcel.writeString(planDescription2);
                parcel.writeString(planDescription3);
                parcel.writeString(planDescription4);
                parcel.writeString(planType);
                parcel.writeString(planVoiceUnits);
                parcel.writeString(planSmsUnits);
                parcel.writeString(planDataUnits);
                parcel.writeString(planServiceDays);
                parcel.writeDouble(planPrice);
                parcel.writeString(planRecurring);
                parcel.writeString(planPartNumber);
                parcel.writeString(planProgramId);
                parcel.writeInt(planVoiceConversionFactor);
                parcel.writeParcelable(promo,i);
            }
        }

        public String getNextChargeDate() { return nextChargeDate; }
        public void setNextChargeDate(String nextChargeDate) { this.nextChargeDate = nextChargeDate; }

        @JsonProperty("servicePlan")
        private ServicePlan plan = new ServicePlan();
        @JsonProperty("paymentSource")
        private PaymentSource paymentSource = new PaymentSource();

        public ServicePlan getPlan() { return plan; }
        public void setPlan(ServicePlan plan) { this.plan = plan; }

        public PaymentSource getPaymentSource() { return paymentSource; }
        public void setPaymentSource(PaymentSource paymentSource) { this.paymentSource = paymentSource; }

        public CurrentEnrollmentPlan() { }
        protected CurrentEnrollmentPlan(Parcel in) {
            nextChargeDate = in.readString();
            plan= in.readParcelable(CurrentEnrollmentPlan.class.getClassLoader());
            paymentSource= in.readParcelable(CurrentEnrollmentPlan.class.getClassLoader());
        }
        public static final Creator<CurrentEnrollmentPlan> CREATOR = new Creator<CurrentEnrollmentPlan>() {
            @Override
            public CurrentEnrollmentPlan createFromParcel(Parcel in) {
                return new CurrentEnrollmentPlan(in);
            }
            @Override
            public CurrentEnrollmentPlan[] newArray(int size) {
                return new CurrentEnrollmentPlan[size];
            }
        };
        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(nextChargeDate);
            parcel.writeParcelable(plan, i);
            parcel.writeParcelable(paymentSource,i);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private CurrentEnrollmentPlan currentEnrollmentPlan;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public CurrentEnrollmentPlan getResponse() { return currentEnrollmentPlan; }
    public void setResponse(CurrentEnrollmentPlan c) { currentEnrollmentPlan = c; }

    /**
     * This method verifies all data returned from service is valid
     *
     * @return  true if all request data is valid
     */
    public void validateCurrentEnrollmentPlan() throws MyAccountServiceException{
        boolean valid = true;
        if (currentEnrollmentPlan.getNextChargeDate() == null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanId()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanDataUnits()==null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanDescription()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanDescription2()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanDescription3()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanDescription4()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanName()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanPartNumber()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanPrice()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanVoiceConversionFactor()== -1) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanProgramId()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanServiceDays()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanSmsUnits()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanVoiceUnits()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanRecurringCheck()== null) valid = false;
        if (currentEnrollmentPlan.getPlan().getPlanType()== null) valid = false;
        if(currentEnrollmentPlan.getPlan().getPromo()!=null) {
            if (currentEnrollmentPlan.getPlan().getPromo().getPlanPromoMessage() == null)
                valid = false;
            if (currentEnrollmentPlan.getPlan().getPromo().getPlanPromoPrice() == null)
                valid = false;
            if (currentEnrollmentPlan.getPlan().getPromo().getPlanPromoUnits() == null)
                valid = false;
        }
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


    }
}