package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class PhysicalResource {

    @JsonProperty("resourceCategory")
    private String resourceCategory;
    @JsonProperty("resourceSubCategory")
    private String resourceSubCategory;
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("supportingResources")
    private ArrayList<SupportingResources> supportingResources;


    public static final String RESOURCE_SUB_CATEGORY_BYOP = "BYOP";
    public static final String RESOURCE_SUB_CATEGORY_BYOT = "BYOT";
    public String getResourceSubCategory() {
        return resourceSubCategory;
    }

    public void setResourceSubCategory(String resourceSubCategory) {
        this.resourceSubCategory = resourceSubCategory;
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    public static final String RESOURCE_CATEGORY_HANDSET = "HANDSET";
    public String getResourceCategory() {
        return resourceCategory;
    }

    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory;
    }


    public ArrayList<SupportingResources> getSupportingResources() {
        return supportingResources;
    }

    public void setSupportingResources(ArrayList<SupportingResources> supportingResources) {
        this.supportingResources = supportingResources;
    }


}
