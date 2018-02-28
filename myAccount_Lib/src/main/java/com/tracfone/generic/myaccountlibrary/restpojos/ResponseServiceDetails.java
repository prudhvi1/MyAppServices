package com.tracfone.generic.myaccountlibrary.restpojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceCharacteristic;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceSpecificationV2;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseServiceDetails {

    public static class ServiceDetailsList {


        public static class Service  {
            @JsonProperty("id")
            private String id;
            @JsonProperty("category")
            private String category;
            @JsonProperty("name")
            private String name;
            @JsonProperty("status")
            private String status;
            @JsonProperty("serviceSpecification")
            private ServiceSpecificationV2 serviceSpecification;
            @JsonProperty("serviceCharacteristics")
            private List<ServiceCharacteristic> serviceCharacteristics;

            public void setId(String id) { this.id = id; }
            public String getId() { return id; }

            public void setCategory(String category) { this.category = category; }
            public String getCategory() { return category; }

            public void setName(String name) { this.name = name; }
            public String getName() { return name; }

            public void setStatus(String status) { this.status = status; }
            public String getStatus() { return status; }

            public void setServiceSpecification(ServiceSpecificationV2 serviceSpecification) { this.serviceSpecification = serviceSpecification; }
            public ServiceSpecificationV2 getServiceSpecification() { return serviceSpecification; }

            public void setServiceCharacteristics(List<ServiceCharacteristic> serviceCharacteristics) { this.serviceCharacteristics = serviceCharacteristics; }
            public List<ServiceCharacteristic> getServiceCharacteristics() { return serviceCharacteristics; }
        }

        @JsonProperty("service")
        private List<Service> serviceList = new ArrayList<Service>();

        public List<Service> getServiceList() { return serviceList; }
        public void setServiceList(List<Service> sl) { serviceList = sl; }

    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ServiceDetailsList serviceDetailsList;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public ServiceDetailsList getServiceDetailsList() {
        return serviceDetailsList;
    }

    public void setServiceDetailsList(ServiceDetailsList serviceDetailsList) {
        this.serviceDetailsList = serviceDetailsList;
    }
}
