package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Resource;

import java.util.ArrayList;

/**
 * Created by skishore on 10/17/2016.
 */

public class RequestPhoneBranding {


    public static class PhoneBrandingRequest {
        @JsonProperty("relatedParties")
        private RelatedParties relatedParties;
        @JsonProperty("resource")
        private Resource resource;

        public RelatedParties getRelatedParties() {
            return relatedParties;
        }

        public void setRelatedParties(RelatedParties relatedParties) {
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
    private PhoneBrandingRequest request;

    public RequestCommon getCommon() {
        return common;
    }

    public void setCommon(RequestCommon common) {
        this.common = common;
    }

    public PhoneBrandingRequest getRequest() {
        return request;
    }

    public void setRequest(PhoneBrandingRequest request) {
        this.request = request;
    }
}
