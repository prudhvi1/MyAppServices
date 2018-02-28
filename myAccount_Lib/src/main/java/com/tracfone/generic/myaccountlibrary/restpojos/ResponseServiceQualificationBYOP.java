package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceCharacteristic;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceSpecification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skishore on 10/17/2016.
 */

public class ResponseServiceQualificationBYOP {

    public static class ServiceQualificationBYOPResponse {

        @JsonProperty("relatedParties")
        private ArrayList<RelatedParties> relatedParties;
        @JsonProperty("serviceSpecification")
        private ServiceSpecification serviceSpecification;
        @JsonProperty("serviceCharacteristics")
        private List<ServiceCharacteristic> serviceCharacteristics = new ArrayList<ServiceCharacteristic>();

        public ArrayList<RelatedParties> getRelatedParties() {
            return relatedParties;
        }

        public void setRelatedParties(ArrayList<RelatedParties> relatedParties) {
            this.relatedParties = relatedParties;
        }

        public ServiceSpecification getServiceSpecification() {
            return serviceSpecification;
        }

        public void setServiceSpecification(ServiceSpecification serviceSpecification) {
            this.serviceSpecification = serviceSpecification;
        }

        public List<ServiceCharacteristic> getServiceCharacteristics() {
            return serviceCharacteristics;
        }

        public void setServiceCharacteristics(List<ServiceCharacteristic> p) {
            serviceCharacteristics = p;
        }
    }


    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ServiceQualificationBYOPResponse serviceQualificationBYOPResponse;


    public ResponseStatus getStatus() {
        return status;
    }
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public ServiceQualificationBYOPResponse getResponse() {
        return serviceQualificationBYOPResponse;
    }
    public void setResponse(ServiceQualificationBYOPResponse u) {
        serviceQualificationBYOPResponse = u;
    }
}
