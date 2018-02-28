package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedResources;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceCharacteristic;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Status;

import java.util.ArrayList;

/**
 * Created by skishore on 10/18/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseServiceQualification {

    public static class ServiceQualificationResponse implements Parcelable {
        @JsonProperty("status")
        private Status status;

        @JsonProperty("relatedParties")
        private ArrayList<RelatedParties> relatedParties;
        @JsonProperty("serviceCharacteristics")
        private ArrayList<ServiceCharacteristic> serviceCharacteristics;
        @JsonProperty("relatedResources")
        private ArrayList<RelatedResources> relatedResources;
        @JsonProperty("serviceSpecification")
        private ServiceSpecification serviceSpecification;
        @JsonProperty("qualificationResult")
        private String qualificationResult;

        public ServiceQualificationResponse() {

        }

        protected ServiceQualificationResponse(Parcel in) {
            status = in.readParcelable(Status.class.getClassLoader());
            relatedParties = in.createTypedArrayList(RelatedParties.CREATOR);
            serviceCharacteristics = in.createTypedArrayList(ServiceCharacteristic.CREATOR);
            relatedResources = in.createTypedArrayList(RelatedResources.CREATOR);
            serviceSpecification = in.readParcelable(ServiceSpecification.class.getClassLoader());
            qualificationResult = in.readString();
            flowScenario = in.readString();
            executionPlan = in.readString();
            balanceTransactionId = in.readString();
            activationEligible = in.readString();
            allowedCapacityLines = in.readString();
            isLTE = in.readString();
            isBYOPEligible = in.readString();
        }

        public static final Creator<ServiceQualificationResponse> CREATOR = new Creator<ServiceQualificationResponse>() {
            @Override
            public ServiceQualificationResponse createFromParcel(Parcel in) {
                return new ServiceQualificationResponse(in);
            }

            @Override
            public ServiceQualificationResponse[] newArray(int size) {
                return new ServiceQualificationResponse[size];
            }
        };

        public ArrayList<RelatedResources> getRelatedResources() {
            return relatedResources;
        }

        public void setRelatedResources(ArrayList<RelatedResources> relatedResources) {
            this.relatedResources = relatedResources;
        }

        public static final String QUALIFICATION_RESULT_QUALIFIED = "qualified";

        public String getQualificationResult() {
            return qualificationResult;
        }

        public void setQualificationResult(String qualificationResult) {
            this.qualificationResult = qualificationResult;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public ArrayList<RelatedParties> getRelatedParties() {
            return relatedParties;
        }

        public void setRelatedParties(ArrayList<RelatedParties> relatedParties) {
            this.relatedParties = relatedParties;
        }

        public ArrayList<ServiceCharacteristic> getServiceCharacteristics() {
            return serviceCharacteristics;
        }

        public void setServiceCharacteristics(ArrayList<ServiceCharacteristic> serviceCharacteristics) {
            this.serviceCharacteristics = serviceCharacteristics;
        }

        public ServiceSpecification getServiceSpecification() {
            return serviceSpecification;
        }

        public void setServiceSpecification(ServiceSpecification serviceSpecification) {
            this.serviceSpecification = serviceSpecification;
        }


        public String flowScenario = "flowScenario";
        public String executionPlan = "executionPlan";
        public String balanceTransactionId = "balanceTransactionId";
        public String activationEligible = "activationEligible";
        public String allowedCapacityLines = "allowedCapacityLines";
        public String isLTE = "isLTE";
        public String isBYOPEligible = "isBYOPEligible";
        public String currentSIM = "currentSIM";
        public String currentBrand = "currentBrand";
        public String fromPhoneSerialNumber = "fromPhoneSerialNumber";
        public String isStaged = "isStaged";
        public String isPinAvailable = "isPINAvailable";
        public String servicePlanId = "servicePlanId";

        public static String FLOW_SCENARIO_PIN_REQUIRED = "PIN Is Required";
        public static String FLOW_SCENARIO_PIN_NOT_REQUIRED = "PIN Is Not Required";
        public static String FLOW_SCENARIO_PIN_OPTIONAL = "PIN Is Optional";

        public String getFlowScenario() {
            return flowScenario;
        }

        public String getExecutionPlan() {
            return executionPlan;
        }

        public String getBalanceTransactionId() {
            return balanceTransactionId;
        }

        public String getActivationEligible() {
            return activationEligible;
        }

        public String getAllowedCapacityLines() {
            return allowedCapacityLines;
        }

        public String getIsLTE() {
            return isLTE;
        }

        public String getIsBYOPEligible() {
            return isBYOPEligible;
        }

        public String getCurrentSIM() { return currentSIM; }

        public String getCurrentBrand() { return currentBrand;  }

        public String getfromPhoneSerialNumber() {
            return fromPhoneSerialNumber;
        }

        public String getIsStaged() { return isStaged; }

        public String getIsPinAvailable() {
            return isPinAvailable;
        }

        public String getServicePlanId() {
            return servicePlanId;
        }

        public void setServiceCharacteristicsValues() {
            for (int i = 0; i < serviceCharacteristics.size(); i++) {
                if (serviceCharacteristics.get(i).getName().equals(flowScenario)) {
                    this.flowScenario = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(executionPlan)) {
                    this.executionPlan = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(balanceTransactionId)) {
                    this.balanceTransactionId = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(activationEligible)) {
                    this.activationEligible = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(allowedCapacityLines)) {
                    this.allowedCapacityLines = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(isLTE)) {
                    this.isLTE = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(isBYOPEligible)) {
                    this.isBYOPEligible = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(currentSIM)) {
                    this.currentSIM = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(currentBrand)) {
                    this.currentBrand = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(fromPhoneSerialNumber)) {
                    this.fromPhoneSerialNumber = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(isStaged)) {
                    this.isStaged = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(isPinAvailable)) {
                    this.isPinAvailable = serviceCharacteristics.get(i).getValue();
                }
                if (serviceCharacteristics.get(i).getName().equals(servicePlanId)) {
                    this.servicePlanId = serviceCharacteristics.get(i).getValue();
                }
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(status, flags);
            dest.writeTypedList(relatedParties);
            dest.writeTypedList(serviceCharacteristics);
            dest.writeTypedList(relatedResources);
            dest.writeParcelable(serviceSpecification, flags);
            dest.writeString(qualificationResult);
            dest.writeString(flowScenario);
            dest.writeString(executionPlan);
            dest.writeString(balanceTransactionId);
            dest.writeString(activationEligible);
            dest.writeString(allowedCapacityLines);
            dest.writeString(isLTE);
            dest.writeString(isBYOPEligible);
        }
    }


    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ServiceQualificationResponse serviceQualificationResponse;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus s) {
        status = s;
    }

    public ServiceQualificationResponse getResponse() {
        return serviceQualificationResponse;
    }

    public void setResponse(ServiceQualificationResponse v) {
        serviceQualificationResponse = v;
    }

}
