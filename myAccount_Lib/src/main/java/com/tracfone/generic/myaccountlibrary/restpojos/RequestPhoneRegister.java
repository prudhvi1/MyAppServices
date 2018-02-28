package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Association;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PhysicalResource;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Resource;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ResourceSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.SupportingLogicalResources;

import java.util.ArrayList;

/**
 * Created by skishore on 10/17/2016.
 */

public class RequestPhoneRegister {

    public static class PhoneRegisterRequest {
        @JsonProperty("relatedParties")
        private ArrayList<RelatedParties> relatedParties;
        @JsonProperty("resource")
        private Resource resource;

        public ArrayList<RelatedParties>  getRelatedParties() {
            return relatedParties;
        }

        public void setRelatedParties(ArrayList<RelatedParties> relatedParties) {
            this.relatedParties = relatedParties;
        }

        public Resource getResource() {
            return resource;
        }

        public void setResource(Resource resource) {
            this.resource = resource;
        }

    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private PhoneRegisterRequest request;

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public PhoneRegisterRequest getRequest() {
        return request;
    }

    public void setRequest(PhoneRegisterRequest request) {
        this.request = request;
    }
}
