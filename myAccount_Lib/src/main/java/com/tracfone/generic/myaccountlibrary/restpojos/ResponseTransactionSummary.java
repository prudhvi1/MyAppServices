package com.tracfone.generic.myaccountlibrary.restpojos;

/** ************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class defines the POJO for a transaction summary responses
 * It corresponds to the restful services:
 * Redeem Pin Card, Redeem Pin Card From Reserve, Manage Auto ReUp, Enroll Auto ReUp
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

public class ResponseTransactionSummary {

    public static class TransactionSummary implements Parcelable{

        @JsonProperty("confirmationMessage")
        private String confirmationMessage;
        @JsonProperty("transactionMessage")
        private String transactionMessage;
        @JsonProperty("nextPaymentDate")
        private String nextPaymentDate;
        @JsonProperty("serviceEndDate")
        private String serviceEndDate;
        @JsonProperty("enrolledInAutoRefill")
        private boolean enrolledInAutoRefill;
        @JsonProperty("reserveCount")
        private int reserveCount;

        public static class DeviceDetails implements Parcelable{

            @JsonProperty("esn")
            private String esn;
            @JsonProperty("min")
            private String min;
            @JsonProperty("deviceNickname")
            private String deviceNickName;

            public String getEsn() { return esn; }
            public void setEsn(String esn) { this.esn = esn; }

            public String getMin() { return min; }
            public void setMin(String min) { this.min = min; }

            public String getDeviceNickName() { return deviceNickName; }
            public void setDeviceNickName(String deviceNickName) { this.deviceNickName = deviceNickName; }

            public DeviceDetails() {}
            protected DeviceDetails(Parcel in) {
                esn = in.readString();
                min = in.readString();
                deviceNickName = in.readString();
            }

            public static final Creator<DeviceDetails> CREATOR = new Creator<DeviceDetails>() {
                @Override
                public DeviceDetails createFromParcel(Parcel in) {
                    return new DeviceDetails(in);
                }

                @Override
                public DeviceDetails[] newArray(int size) {
                    return new DeviceDetails[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(esn);
                parcel.writeString(min);
                parcel.writeString(deviceNickName);
            }
        }

        public static class GroupDetails implements Parcelable {

            @JsonProperty("groupId")
            private String groupId;
            @JsonProperty("groupName")
            private String groupName;

            public void setGroupId(String groupId) {
                this.groupId = groupId;
            }
            public String getGroupId() {
                return this.groupId;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }
            public String getGroupName() {
                return this.groupName;
            }

            public GroupDetails() {
            }

            protected GroupDetails(Parcel in) {
                groupId = in.readString();
                groupName = in.readString();
            }

            public static final Creator<GroupDetails> CREATOR = new Creator<GroupDetails>() {
                @Override
                public GroupDetails createFromParcel(Parcel in) {
                    return new GroupDetails(in);
                }

                @Override
                public GroupDetails[] newArray(int size) {
                    return new GroupDetails[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(groupId);
                parcel.writeString(groupName);
            }
        }

        public static class ServicePlanDetails implements Parcelable{

            @JsonProperty("servicePlanId")
            private String servicePlanId;
            @JsonProperty("servicePlanName")
            private String servicePlanName;
            @JsonProperty("servicePlanDescription")
            private String servicePlanDescription;
            @JsonProperty("servicePlanDescription2")
            private String servicePlanDescription2;
            @JsonProperty("servicePlanDescription3")
            private String servicePlanDescription3;
            @JsonProperty("servicePlanDescription4")
            private String servicePlanDescription4;
            @JsonProperty("rewardsPoints")
            private String rewardsPoints;
            @JsonProperty("accessNumber")
            private String accessNumber;

            public String getServicePlanId() { return servicePlanId; }
            public void setServicePlanId(String servicePlanId) { this.servicePlanId = servicePlanId; }

            public String getServicePlanName() { return servicePlanName; }
            public void setServicePlanName(String servicePlanName) { this.servicePlanName = servicePlanName; }

            public String getServicePlanDescription() { return servicePlanDescription; }
            public void setServicePlanDescription(String servicePlanDescription) { this.servicePlanDescription = servicePlanDescription; }

            public String getServicePlanDescription2() { return servicePlanDescription2; }
            public void setServicePlanDescription2(String servicePlanDescription2) { this.servicePlanDescription2 = servicePlanDescription2; }

            public String getServicePlanDescription3() { return servicePlanDescription3; }
            public void setServicePlanDescription3(String servicePlanDescription3) { this.servicePlanDescription3 = servicePlanDescription3; }

            public String getServicePlanDescription4() { return servicePlanDescription4; }
            public void setServicePlanDescription4(String servicePlanDescription4) { this.servicePlanDescription4 = servicePlanDescription4; }

            public double getRewardsPoints() {
                if(rewardsPoints!=null) {
                    return Double.parseDouble(rewardsPoints); }
                else
                    return 0; }
            public void setRewardsPoints(String rewardsPoints) { this.rewardsPoints = rewardsPoints; }

            public String getAccessNumber() { return accessNumber; }
            public void setAccessNumber(String accessNumber) { this.accessNumber = accessNumber; }

            public ServicePlanDetails() {}
            protected ServicePlanDetails(Parcel in) {
                servicePlanId = in.readString();
                servicePlanName = in.readString();
                servicePlanDescription = in.readString();
                servicePlanDescription2 = in.readString();
                servicePlanDescription3 = in.readString();
                servicePlanDescription4 = in.readString();
                rewardsPoints = in.readString();
                accessNumber = in.readString();
            }

            public static final Creator<ServicePlanDetails> CREATOR = new Creator<ServicePlanDetails>() {
                @Override
                public ServicePlanDetails createFromParcel(Parcel in) {
                    return new ServicePlanDetails(in);
                }

                @Override
                public ServicePlanDetails[] newArray(int size) {
                    return new ServicePlanDetails[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(servicePlanId);
                parcel.writeString(servicePlanName);
                parcel.writeString(servicePlanDescription);
                parcel.writeString(servicePlanDescription2);
                parcel.writeString(servicePlanDescription3);
                parcel.writeString(servicePlanDescription4);
                parcel.writeString(rewardsPoints);
                parcel.writeString(accessNumber);
            }
        }

        public static class TransactionDetails implements Parcelable{

            @JsonProperty("transactionTotal")
            private double transactionTotal;
            @JsonProperty("transactionTotalTax")
            private double transactionTotalTax;
            @JsonProperty("transactionId")
            private String transactionId;
            @JsonProperty("transactionDate")
            private String transactionDate;

            public double getTransactionTotal() { return transactionTotal; }
            public void setTransactionTotal(double transactionTotal) { this.transactionTotal = transactionTotal; }

            public double getTransactionTotalTax() { return transactionTotalTax; }
            public void setTransactionTotalTax(double transactionTotalTax) { this.transactionTotalTax = transactionTotalTax; }

            public String getTransactionId() { return transactionId; }
            public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

            public String getTransactionDate() { return transactionDate; }
            public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }

            public TransactionDetails() {}
            protected TransactionDetails(Parcel in) {
                transactionTotal = in.readDouble();
                transactionTotalTax = in.readDouble();
                transactionId = in.readString();
                transactionDate = in.readString();
            }

            public static final Creator<TransactionDetails> CREATOR = new Creator<TransactionDetails>() {
                @Override
                public TransactionDetails createFromParcel(Parcel in) {
                    return new TransactionDetails(in);
                }

                @Override
                public TransactionDetails[] newArray(int size) {
                    return new TransactionDetails[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeDouble(transactionTotal);
                parcel.writeDouble(transactionTotalTax);
                parcel.writeString(transactionId);
                parcel.writeString(transactionDate);
            }
        }

        public static class PaymentSourceDetails implements Parcelable{

            @JsonProperty("paymentSourceNickName")
            private String paymentSourceNickName;
            @JsonProperty("paymentSourceType")
            private String paymentSourceType;
            @JsonProperty("paymentSourceNumberMask")
            private String paymentSourceNumberMask;

            public String getPaymentSourceNickName() { return paymentSourceNickName; }
            public void setPaymentSourceNickName(String paymentSourceNickName) { this.paymentSourceNickName = paymentSourceNickName;  }

            public String getPaymentSourceType() { return paymentSourceType; }
            public void setPaymentSourceType(String paymentSourceType) { this.paymentSourceType = paymentSourceType; }

            public String getPaymentSourceNumberMask() { return paymentSourceNumberMask; }
            public void setPaymentSourceNumberMask(String paymentSourceNumberMask) { this.paymentSourceNumberMask = paymentSourceNumberMask; }

            public PaymentSourceDetails() {}
            protected PaymentSourceDetails(Parcel in) {
                paymentSourceNickName = in.readString();
                paymentSourceType = in.readString();
                paymentSourceNumberMask = in.readString();
            }

            public static final Creator<PaymentSourceDetails> CREATOR = new Creator<PaymentSourceDetails>() {
                @Override
                public PaymentSourceDetails createFromParcel(Parcel in) {
                    return new PaymentSourceDetails(in);
                }

                @Override
                public PaymentSourceDetails[] newArray(int size) {
                    return new PaymentSourceDetails[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(paymentSourceNickName);
                parcel.writeString(paymentSourceType);
                parcel.writeString(paymentSourceNumberMask);
            }
        }

        public static class VasPlanTransactionDetails implements Parcelable{
            public static class VasPlanDetails implements Parcelable{

                @JsonProperty("vasPlanId")
                private String vasPlanId;
                @JsonProperty("vasPlanName")
                private String vasPlanName;
                @JsonProperty("vasPlanDescription")
                private String vasPlanDescription;
                @JsonProperty("vasPlanDescription2")
                private String vasPlanDescription2;
                @JsonProperty("vasPlanDescription3")
                private String vasPlanDescription3;
                @JsonProperty("vasPlanDescription4")
                private String vasPlanDescription4;
                @JsonProperty("accessNumber")
                private String accessNumber;

                public String getVasPlanId() { return vasPlanId; }
                public void setVasPlanId(String vasPlanId) {  this.vasPlanId = vasPlanId; }

                public String getVasPlanName() { return vasPlanName; }
                public void setVasPlanName(String vasPlanName) { this.vasPlanName = vasPlanName; }

                public String getVasPlanDescription() { return vasPlanDescription; }
                public void setVasPlanDescription(String vasPlanDescription) { this.vasPlanDescription = vasPlanDescription; }

                public String getVasPlanDescription2() { return vasPlanDescription2; }
                public void setVasPlanDescription2(String vasPlanDescription2) { this.vasPlanDescription2 = vasPlanDescription2;  }

                public String getVasPlanDescription3() { return vasPlanDescription3; }
                public void setVasPlanDescription3(String vasPlanDescription3) { this.vasPlanDescription3 = vasPlanDescription3; }

                public String getVasPlanDescription4() { return vasPlanDescription4; }
                public void setVasPlanDescription4(String vasPlanDescription4) { this.vasPlanDescription4 = vasPlanDescription4;  }

                public String getAccessNumber() { return accessNumber; }
                public void setAccessNumber(String accessNumber) { this.accessNumber = accessNumber; }

                public VasPlanDetails() {}
                protected VasPlanDetails(Parcel in) {
                    vasPlanId = in.readString();
                    vasPlanName = in.readString();
                    vasPlanDescription = in.readString();
                    vasPlanDescription2 = in.readString();
                    vasPlanDescription3 = in.readString();
                    vasPlanDescription4 = in.readString();
                    accessNumber = in.readString();
                }

                public static final Creator<VasPlanDetails> CREATOR = new Creator<VasPlanDetails>() {
                    @Override
                    public VasPlanDetails createFromParcel(Parcel in) {
                        return new VasPlanDetails(in);
                    }

                    @Override
                    public VasPlanDetails[] newArray(int size) {
                        return new VasPlanDetails[size];
                    }
                };
                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(vasPlanId);
                    parcel.writeString(vasPlanName);
                    parcel.writeString(vasPlanDescription);
                    parcel.writeString(vasPlanDescription2);
                    parcel.writeString(vasPlanDescription3);
                    parcel.writeString(vasPlanDescription4);
                    parcel.writeString(accessNumber);
                }
            }

            public static class VasTransactionDetails implements Parcelable{

                @JsonProperty("transactionTotal")
                private double transactionTotal;
                @JsonProperty("transactionTotalTax")
                private double transactionTotalTax;
                @JsonProperty("transactionId")
                private String transactionId;
                @JsonProperty("transactionDate")
                private String transactionDate;

                public double getTransactionTotal() { return transactionTotal; }
                public void setTransactionTotal(double transactionTotal) { this.transactionTotal = transactionTotal; }

                public double getTransactionTotalTax() { return transactionTotalTax; }
                public void setTransactionTotalTax(double transactionTotalTax) { this.transactionTotalTax = transactionTotalTax; }

                public String getTransactionId() { return transactionId; }
                public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

                public String getTransactionDate() { return transactionDate; }
                public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }

                public VasTransactionDetails() {}
                protected VasTransactionDetails(Parcel in) {
                    transactionTotal = in.readDouble();
                    transactionTotalTax = in.readDouble();
                    transactionId = in.readString();
                    transactionDate = in.readString();
                }

                public static final Creator<VasTransactionDetails> CREATOR = new Creator<VasTransactionDetails>() {
                    @Override
                    public VasTransactionDetails createFromParcel(Parcel in) {
                        return new VasTransactionDetails(in);
                    }

                    @Override
                    public VasTransactionDetails[] newArray(int size) {
                        return new VasTransactionDetails[size];
                    }
                };
                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeDouble(transactionTotal);
                    parcel.writeDouble(transactionTotalTax);
                    parcel.writeString(transactionId);
                    parcel.writeString(transactionDate);
                }
            }

            @JsonProperty("planDetails")
            private VasPlanDetails vasPlanDetail = new VasPlanDetails();
            @JsonProperty("transactionDetails")
            private VasTransactionDetails vasTransactionDetail = new VasTransactionDetails();

            public VasPlanDetails getVasPlanDetail() { return vasPlanDetail; }
            public void setVasPlanDetail(VasPlanDetails vasPlanDetail) { this.vasPlanDetail = vasPlanDetail; }

            public VasTransactionDetails getVasTransactionDetail() { return vasTransactionDetail; }
            public void setVasTransactionDetail(VasTransactionDetails vasTransactionDetail) { this.vasTransactionDetail = vasTransactionDetail; }

            public VasPlanTransactionDetails() { }
            protected VasPlanTransactionDetails(Parcel in) {
                vasPlanDetail = in.readParcelable(VasPlanDetails.class.getClassLoader());
                vasTransactionDetail = in.readParcelable(VasTransactionDetails.class.getClassLoader());
            }

            public static final Creator<VasPlanTransactionDetails> CREATOR = new Creator<VasPlanTransactionDetails>() {
                @Override
                public VasPlanTransactionDetails createFromParcel(Parcel in) {
                    return new VasPlanTransactionDetails(in);
                }

                @Override
                public VasPlanTransactionDetails[] newArray(int size) {
                    return new VasPlanTransactionDetails[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeParcelable(vasPlanDetail, i);
                parcel.writeParcelable(vasTransactionDetail, i);
            }
        }

        @JsonProperty("moreInfo")
        private String moreInfo;
        @JsonProperty("deviceDetails")
        private DeviceDetails deviceDetail = new DeviceDetails();
        @JsonProperty("groupInfo")
        private GroupDetails groupDetail = new GroupDetails();
        @JsonProperty("servicePlanDetails")
        private ServicePlanDetails servicePlanDetail = new ServicePlanDetails();
        @JsonProperty("transactionDetails")
        private TransactionDetails transactionDetail = new TransactionDetails();
        @JsonProperty("paymentSourceDetails")
        private PaymentSourceDetails paymentSourceDetail = new PaymentSourceDetails();
        @JsonProperty("vasPlanDetails")
        private VasPlanTransactionDetails vasPlanTransactionDetail = new VasPlanTransactionDetails();

        public String getConfirmationMessage() { return confirmationMessage; }
        public void setConfirmationMessage(String confirmationMessage) { this.confirmationMessage = confirmationMessage; }

        public String getTransactionMessage() { return transactionMessage; }
        public void setTransactionMessage(String transactionMessage) { this.transactionMessage = transactionMessage; }

        public String getNextPaymentDate() { return nextPaymentDate; }
        public void setNextPaymentDate(String nextPaymentDate) { this.nextPaymentDate = nextPaymentDate; }

        public String getServiceEndDate() { return serviceEndDate; }
        public void setServiceEndDate(String serviceEndDate) { this.serviceEndDate = serviceEndDate;  }

        public boolean isEnrolledInAutoRefill() { return enrolledInAutoRefill; }
        public void setEnrolledInAutoRefill(boolean enrolledInAutoRefill) {  this.enrolledInAutoRefill = enrolledInAutoRefill; }

        public int getReserveCount() { return reserveCount; }
        public void setReserveCount(int reserveCount) { this.reserveCount = reserveCount; }

        public String getMoreInfo() { return moreInfo; }
        public void setMoreInfo(String moreInfo) { this.moreInfo = moreInfo; }

        public DeviceDetails getDeviceDetail() { return deviceDetail; }
        public void setDeviceDetail(DeviceDetails deviceDetail) { this.deviceDetail = deviceDetail; }

        public GroupDetails getGroupDetail() { return groupDetail; }
        public void setGroupDetail(GroupDetails groupDetail) { this.groupDetail = groupDetail; }

        public ServicePlanDetails getServicePlanDetail() { return servicePlanDetail;  }
        public void setServicePlanDetail(ServicePlanDetails servicePlanDetail) { this.servicePlanDetail = servicePlanDetail; }

        public TransactionDetails getTransactionDetail() { return transactionDetail; }
        public void setTransactionDetail(TransactionDetails transactionDetail) { this.transactionDetail = transactionDetail; }

        public PaymentSourceDetails getPaymentSourceDetail() { return paymentSourceDetail; }
        public void setPaymentSourceDetail(PaymentSourceDetails paymentSourceDetail) { this.paymentSourceDetail = paymentSourceDetail; }

        public VasPlanTransactionDetails getVasPlanTransactionDetail() { return vasPlanTransactionDetail; }
        public void setVasPlanTransactionDetail(VasPlanTransactionDetails vasPlanTransactionDetail) { this.vasPlanTransactionDetail = vasPlanTransactionDetail; }

        public TransactionSummary(){ }
        protected TransactionSummary(Parcel in) {
            confirmationMessage = in.readString();
            transactionMessage = in.readString();
            nextPaymentDate = in.readString();
            serviceEndDate = in.readString();
            enrolledInAutoRefill = in.readByte() != 0;
            reserveCount = in.readInt();
            moreInfo = in.readString();
            deviceDetail = in.readParcelable(DeviceDetails.class.getClassLoader());
            groupDetail = in.readParcelable(GroupDetails.class.getClassLoader());
            servicePlanDetail = in.readParcelable(ServicePlanDetails.class.getClassLoader());
            transactionDetail = in.readParcelable(TransactionDetails.class.getClassLoader());
            paymentSourceDetail = in.readParcelable(PaymentSourceDetails.class.getClassLoader());
            vasPlanTransactionDetail = in.readParcelable(VasPlanTransactionDetails.class.getClassLoader());
        }

        public static final Creator<TransactionSummary> CREATOR = new Creator<TransactionSummary>() {
            @Override
            public TransactionSummary createFromParcel(Parcel in) {
                return new TransactionSummary(in);
            }

            @Override
            public TransactionSummary[] newArray(int size) {
                return new TransactionSummary[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(confirmationMessage);
            parcel.writeString(transactionMessage);
            parcel.writeString(nextPaymentDate);
            parcel.writeString(serviceEndDate);
            parcel.writeByte((byte) (enrolledInAutoRefill ? 1 : 0));
            parcel.writeInt(reserveCount);
            parcel.writeString(moreInfo);
            parcel.writeParcelable(deviceDetail, i);
            parcel.writeParcelable(groupDetail, i);
            parcel.writeParcelable(servicePlanDetail, i);
            parcel.writeParcelable(transactionDetail, i);
            parcel.writeParcelable(paymentSourceDetail, i);
            parcel.writeParcelable(vasPlanTransactionDetail, i);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private TransactionSummary transactionSummary;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public TransactionSummary getResponse() { return transactionSummary; }
    public void setResponse(TransactionSummary s) { transactionSummary = s; }

    /**
     * This method varifies all data returned from service is valid
     *
     * @return true if all request data is valid
     */
    public boolean validateTransactionSummaryEnrollment() {
        boolean valid = true;
        if (transactionSummary.getNextPaymentDate() == null) valid = false;

        if (transactionSummary.getDeviceDetail().getEsn() == null) valid = false;
        if (transactionSummary.getDeviceDetail().getMin() == null) valid = false;

        if (transactionSummary.getTransactionDetail().getTransactionId() == null) valid = false;
        if (transactionSummary.getTransactionDetail().getTransactionDate() == null) valid = false;
        if (transactionSummary.getTransactionDetail().getTransactionTotal() == -1) valid = false;
        if (transactionSummary.getTransactionDetail().getTransactionTotalTax() == -1) valid = false;

        if (transactionSummary.getPaymentSourceDetail().getPaymentSourceNickName() == null) valid = false;
        if (transactionSummary.getPaymentSourceDetail().getPaymentSourceType() == null) valid = false;
        if (transactionSummary.getPaymentSourceDetail().getPaymentSourceNumberMask() == null) valid = false;

        return valid;
    }
    public boolean validateTransactionSummaryPurchase() {
        boolean valid = true;
        if (transactionSummary.getDeviceDetail().getEsn() == null) valid = false;
        if (transactionSummary.getDeviceDetail().getMin() == null) valid = false;

        if (transactionSummary.getTransactionDetail().getTransactionId() == null) valid = false;
        if (transactionSummary.getTransactionDetail().getTransactionDate() == null) valid = false;
        if (transactionSummary.getTransactionDetail().getTransactionTotal() == -1) valid = false;
        if (transactionSummary.getTransactionDetail().getTransactionTotalTax() == -1) valid = false;

        if (transactionSummary.getPaymentSourceDetail().getPaymentSourceNickName() == null) valid = false;
        if (transactionSummary.getPaymentSourceDetail().getPaymentSourceType() == null) valid = false;
        if (transactionSummary.getPaymentSourceDetail().getPaymentSourceNumberMask() == null) valid = false;

        return valid;
    }
    public void validateTransactionSummaryRedemption() throws MyAccountServiceException{
        boolean valid = true;
        if (transactionSummary.getDeviceDetail().getEsn() == null) valid = false;
        if (transactionSummary.getDeviceDetail().getMin() == null) valid = false;
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);

    }
}
