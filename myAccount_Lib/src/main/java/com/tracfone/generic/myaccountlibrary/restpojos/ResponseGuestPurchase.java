package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 4/3/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseGuestPurchase {

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private GuestTransaction guestTransaction;

    public ResponseStatus getCommon() {
        return status;
    }

    public void setCommon(ResponseStatus s) {
        status = s;
    }


    public GuestTransaction getResponse() {
        return guestTransaction;
    }

    public void setResponse(GuestTransaction g) {
        guestTransaction = g;
    }


    public  static  class  GuestTransaction {
        public GuestTransaction(){}

        @JsonProperty("dynamicTransactionDetails")
        DynamicTransactionDetails dynamicTransactionDetails;

        public DynamicTransactionDetails getDynamicTransactionDetails() {
            return dynamicTransactionDetails;}
        public void setDynamicTransactionDetails(DynamicTransactionDetails dynamicTransactionDetails) {
            this.dynamicTransactionDetails = dynamicTransactionDetails;
        }


    }

    public static class DynamicTransactionDetails  implements  Parcelable{
        @JsonProperty("serviceEndDate")
        private String serviceEndDate;
        @JsonProperty("vasPlanDetails")
        private VasPlanDetails vasPlanDetails;
        @JsonProperty("enrolledInAutoRefill")
        private boolean enrolledInAutoRefill;
        @JsonProperty("paymentSourceDetails")
        private PaymentSourceDetails paymentSourceDetails;
        @JsonProperty("servicePlanDetails")
        private ServicePlanDetails servicePlanDetails;
        @JsonProperty("deviceDetails")
        private DeviceDetails deviceDetails;
        @JsonProperty("confirmationMsg")
        private String confirmationMsg;
        @JsonProperty("reserveCount")
        private String reserveCount;

        protected DynamicTransactionDetails(Parcel in) {
            serviceEndDate = in.readString();
            vasPlanDetails = in.readParcelable(VasPlanDetails.class.getClassLoader());
            enrolledInAutoRefill = in.readByte() != 0;
            paymentSourceDetails = in.readParcelable(PaymentSourceDetails.class.getClassLoader());
            servicePlanDetails = in.readParcelable(ServicePlanDetails.class.getClassLoader());
            deviceDetails = in.readParcelable(DeviceDetails.class.getClassLoader());
            confirmationMsg = in.readString();
            reserveCount = in.readString();
        }
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(serviceEndDate);
            dest.writeParcelable(vasPlanDetails,flags);
            dest.writeByte((byte) (enrolledInAutoRefill ? 1 : 0));
            dest.writeParcelable(paymentSourceDetails,flags);
            dest.writeParcelable(servicePlanDetails,flags);
            dest.writeParcelable(deviceDetails,flags);
            dest.writeString(confirmationMsg);
            dest.writeString(reserveCount);
        }
        public static final Creator<DynamicTransactionDetails> CREATOR = new Creator<DynamicTransactionDetails>() {
            @Override
            public DynamicTransactionDetails createFromParcel(Parcel in) {
                return new DynamicTransactionDetails(in);
            }

            @Override
            public DynamicTransactionDetails[] newArray(int size) {
                return new DynamicTransactionDetails[size];
            }
        };

        @Override
            public int describeContents() {
                return 0;
            }


public DynamicTransactionDetails (){}



        public String getServiceEndDate ()
        {
            return serviceEndDate;
        }

        public void setServiceEndDate (String serviceEndDate)
        {
            this.serviceEndDate = serviceEndDate;
        }

        public VasPlanDetails getVasPlanDetails ()
        {
            return vasPlanDetails;
        }

        public void setVasPlanDetails (VasPlanDetails vasPlanDetails)
        {
            this.vasPlanDetails = vasPlanDetails;
        }
        public boolean isEnrolledInAutoRefill() { return enrolledInAutoRefill; }
        public void setEnrolledInAutoRefill(boolean enrolledInAutoRefill) {  this.enrolledInAutoRefill = enrolledInAutoRefill; }
        public PaymentSourceDetails getPaymentSourceDetails ()
        {
            return paymentSourceDetails;
        }

        public void setPaymentSourceDetails (PaymentSourceDetails paymentSourceDetails)
        {
            this.paymentSourceDetails = paymentSourceDetails;
        }

        public ServicePlanDetails getServicePlanDetails ()
        {
            return servicePlanDetails;
        }

        public void setServicePlanDetails (ServicePlanDetails servicePlanDetails)
        {
            this.servicePlanDetails = servicePlanDetails;
        }

        public DeviceDetails getDeviceDetails ()
        {
            return deviceDetails;
        }

        public void setDeviceDetails (DeviceDetails deviceDetails)
        {
            this.deviceDetails = deviceDetails;
        }

        public String getConfirmationMsg ()
        {
            return confirmationMsg;
        }

        public void setConfirmationMsg (String confirmationMsg)
        {
            this.confirmationMsg = confirmationMsg;
        }

        public String getReserveCount ()
        {
            return reserveCount;
        }

        public void setReserveCount (String reserveCount)
        {
            this.reserveCount = reserveCount;
        }



    }
    public static class PaymentSourceDetails implements Parcelable {
        @JsonProperty("maskedCardNumber")
        private String maskedCardNumber;
        @JsonProperty("cardType")
        private String cardType;

        protected PaymentSourceDetails(Parcel in) {
            maskedCardNumber = in.readString();
            cardType = in.readString();
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
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(maskedCardNumber);
            dest.writeString(cardType);
        }
        public PaymentSourceDetails() {

        }

        public String getMaskedCardNumber ()
        {
            return maskedCardNumber;
        }

        public void setMaskedCardNumber (String maskedCardNumber)
        {
            this.maskedCardNumber = maskedCardNumber;
        }

        public String getCardType ()
        {
            return cardType;
        }

        public void setCardType (String cardType)
        {
            this.cardType = cardType;
        }



    }


    public static class VasPlanDetails implements Parcelable {
        @JsonProperty("planDetails")
        private PlanDetails planDetails;
        @JsonProperty("trasactionInfo")
        private TrasactionInfo trasactionInfo;

        public VasPlanDetails( ) {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(planDetails, flags);
            dest.writeParcelable(trasactionInfo, flags);
        }

        protected VasPlanDetails(Parcel in) {
            planDetails = in.readParcelable(PlanDetails.class.getClassLoader());
            trasactionInfo = in.readParcelable(TrasactionInfo.class.getClassLoader());
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

        public PlanDetails getPlanDetails ()
        {
            return planDetails;
        }

        public void setPlanDetails (PlanDetails planDetails)
        {
            this.planDetails = planDetails;
        }

        public TrasactionInfo getTrasactionInfo ()
        {
            return trasactionInfo;
        }

        public void setTrasactionInfo (TrasactionInfo trasactionInfo)
        {
            this.trasactionInfo = trasactionInfo;
        }


    }


    public static  class ServicePlanDetails implements Parcelable { @JsonProperty("planDetails")
        private PlanDetails planDetails;
        @JsonProperty("trasactionInfo")
        private TrasactionInfo trasactionInfo;

        public ServicePlanDetails() {
        }
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(planDetails, flags);
            dest.writeParcelable(trasactionInfo,flags);



        }

        protected ServicePlanDetails(Parcel in) {
            planDetails = in.readParcelable(PlanDetails.class.getClassLoader());
            trasactionInfo = in.readParcelable(TrasactionInfo.class.getClassLoader());


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

        public PlanDetails getPlanDetails ()
        {
            return planDetails;
        }

        public void setPlanDetails (PlanDetails planDetails)
        {
            this.planDetails = planDetails;
        }

        public TrasactionInfo getTrasactionInfo ()
        {
            return trasactionInfo;
        }

        public void setTrasactionInfo (TrasactionInfo trasactionInfo)
        {
            this.trasactionInfo = trasactionInfo;
        }



    }



    public static class TrasactionInfo implements Parcelable
    { @JsonProperty("transactionId")
        private String transactionId;
        @JsonProperty("transactionTotal")
        private String transactionTotal;
        @JsonProperty("transactionTotalTax")
        private String transactionTotalTax;
        @JsonProperty("transactionDate")
        private String transactionDate;
 public TrasactionInfo (){}
        protected TrasactionInfo(Parcel in) {
            transactionId = in.readString();
            transactionTotal = in.readString();
            transactionTotalTax = in.readString();
            transactionDate = in.readString();
        }

        public static final Creator<TrasactionInfo> CREATOR = new Creator<TrasactionInfo>() {
            @Override
            public TrasactionInfo createFromParcel(Parcel in) {
                return new TrasactionInfo(in);
            }

            @Override
            public TrasactionInfo[] newArray(int size) {
                return new TrasactionInfo[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(transactionId);
            dest.writeString(transactionTotal);
            dest.writeString(transactionTotalTax);
            dest.writeString(transactionDate);
        }

        public String getTransactionId ()
        {
            return transactionId;
        }

        public void setTransactionId (String transactionId)
        {
            this.transactionId = transactionId;
        }

        public String getTransactionTotal ()
        {
            return transactionTotal;
        }

        public void setTransactionTotal (String transactionTotal)
        {
            this.transactionTotal = transactionTotal;
        }

        public String getTransactionTotalTax ()
        {
            return transactionTotalTax;
        }

        public void setTransactionTotalTax (String transactionTotalTax)
        {
            this.transactionTotalTax = transactionTotalTax;
        }

        public String getTransactionDate ()
        {
            return transactionDate;
        }

        public void setTransactionDate (String transactionDate)
        {
            this.transactionDate = transactionDate;
        }



    }

    public static class PlanDetails implements Parcelable
    { @JsonProperty("planName")
        private String planName;
        @JsonProperty("planId")
        private String planId;
        @JsonProperty("planDescription2")
        private String planDescription2;
        @JsonProperty("planDescription")
        private String planDescription;
        @JsonProperty("planDescription3")
        private String planDescription3;
        @JsonProperty("planDescription4")
        private String planDescription4;
        @JsonProperty("accessNumber")
        private String accessNumber;


        protected PlanDetails(Parcel in) {
            planName = in.readString();
            planId = in.readString();
            planDescription2 = in.readString();
            planDescription = in.readString();
            planDescription3=in.readString();
            planDescription4=in.readString();
            accessNumber=in.readString();
        }

        public static final Creator<PlanDetails> CREATOR = new Creator<PlanDetails>() {
            @Override
            public PlanDetails createFromParcel(Parcel in) {
                return new PlanDetails(in);
            }

            @Override
            public PlanDetails[] newArray(int size) {
                return new PlanDetails[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(planName);
            dest.writeString(planId);
            dest.writeString(planDescription2);
            dest.writeString(planDescription);
            dest.writeString(planDescription3);
            dest.writeString(planDescription4);
            dest.writeString(accessNumber);
        }

        public PlanDetails( ) {}
        public String getPlanName ()
        {
            return planName;
        }

        public void setPlanName (String planName)
        {
            this.planName = planName;
        }

        public String getPlanDescription2 ()
        {
            return planDescription2;
        }

        public void setPlanDescription2 (String planDescription2)
        {
            this.planDescription2 = planDescription2;
        }

        public String getPlanDescription ()
        {
            return planDescription;
        }

        public void setPlanDescription (String planDescription)
        {
            this.planDescription = planDescription;
        }

        public String getPlanId ()
        {
            return planId;
        }

        public void setPlanId (String planId)
        {
            this.planId = planId;
        }

        public String getAccessNumber() {
            return accessNumber;
        }

        public void setAccessNumber(String accessNumber) {
            this.accessNumber = accessNumber;
        }
        public String getPlanDescription3() {
            return planDescription3;
        }

        public void setPlanDescription3(String planDescription3) {
            this.planDescription3 = planDescription3;
        }

        public String getPlanDescription4() {
            return planDescription4;
        }

        public void setPlanDescription4(String planDescription4) {
            this.planDescription4 = planDescription4;
        }

    }

    public static class DeviceDetails implements Parcelable {
        public DeviceDetails( ) {
        }
        @JsonProperty("min")
        private String min;
        @JsonProperty("esn")
        private String esn;
        @JsonProperty("deviceNickname")
        private String deviceNickname;


        protected DeviceDetails(Parcel in) {
            min = in.readString();
            esn = in.readString();
            deviceNickname = in.readString();
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
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(min);
            dest.writeString(esn);
            dest.writeString(deviceNickname);
        }



        public String getMin ()
        {
            return min;
        }

        public void setMin (String min)
        {
            this.min = min;
        }

        public String getEsn ()
        {
            return esn;
        }

        public void setEsn (String esn)
        {
            this.esn = esn;
        }

        public String getDeviceNickname ()
        {
            return deviceNickname;
        }

        public void setDeviceNickname (String deviceNickname)
        {
            this.deviceNickname = deviceNickname;
        }


    }




}
