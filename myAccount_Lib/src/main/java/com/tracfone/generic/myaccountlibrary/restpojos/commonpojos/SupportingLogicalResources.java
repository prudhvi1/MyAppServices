package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class SupportingLogicalResources {

    @JsonProperty("resourceCategory")
    private String resourceCategory;
    @JsonProperty("resourceIdentifier")
    private String resourceIdentifier;

    public static final String RESOURCE_CATEGORY_CARRIER  = "CARRIER";
    public String getResourceCategory() {
        return resourceCategory;
    }

    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory;
    }

    public String getResourceIdentifier() {
        return resourceIdentifier;
    }

    public void setResourceIdentifier(String resourceIdentifier) {
        this.resourceIdentifier = resourceIdentifier;
    }
}
