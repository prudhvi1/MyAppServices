package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Location;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedResources;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceCategory;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Extension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceSpecification;

import java.util.ArrayList;

/**
 * Created by skishore on 10/18/2016.
 */

public class RequestServiceQualification {

    public static class ServiceQualificationRequest {
        @JsonProperty("relatedParties")
        private ArrayList<RelatedParties> relatedParties;

        @JsonProperty("serviceCategory")
        private ArrayList<ServiceCategory> serviceCategory;

        @JsonProperty("serviceSpecification")
        private ServiceSpecification serviceSpecification;

        @JsonProperty("relatedResources")
        private ArrayList<RelatedResources> relatedResources;

        @JsonProperty("resources")
        private ArrayList<RelatedResources> resources;

        @JsonProperty("location")
        private Location location;

        @JsonProperty("extension")
        private ArrayList<Extension> extension;


        public ArrayList<RelatedParties> getRelatedParties() {
            return relatedParties;
        }

        public void setRelatedParties(ArrayList<RelatedParties> relatedParties) {
            this.relatedParties = relatedParties;
        }

        public ArrayList<ServiceCategory> getServiceCategory() {
            return serviceCategory;
        }

        public void setServiceCategory(ArrayList<ServiceCategory> serviceCategory) {
            this.serviceCategory = serviceCategory;
        }

        public ServiceSpecification getServiceSpecification() {
            return serviceSpecification;
        }

        public void setServiceSpecification(ServiceSpecification serviceSpecification) {
            this.serviceSpecification = serviceSpecification;
        }

        public ArrayList<RelatedResources> getRelatedResources() {
            return relatedResources;
        }

        public void setRelatedResources(ArrayList<RelatedResources> relatedResources) {
            this.relatedResources = relatedResources;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public ArrayList<RelatedResources> getResources() {
            return resources;
        }

        public void setResources(ArrayList<RelatedResources> resources) {
            this.resources = resources;
        }

        public ArrayList<Extension> getExtension() {
            return extension;
        }

        public void setExtension(ArrayList<Extension> extension) {
            this.extension = extension;
        }
    }

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public ServiceQualificationRequest getRequest() {
        return request;
    }

    public void setRequest(ServiceQualificationRequest request) {
        this.request = request;
    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private ServiceQualificationRequest request;
}
