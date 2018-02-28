package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by skishore on 10/17/2016.
 */

public class Resource {

    @JsonProperty("location")
    private Location location;
    @JsonProperty("association")
    private Association association;
    @JsonProperty("resourceSpecification")
    private ResourceSpecification resourceSpecification;
    @JsonProperty("physicalResource")
    private PhysicalResource physicalResource;
    @JsonProperty("supportingLogicalResources")
    private ArrayList<SupportingLogicalResources> supportingLogicalResources;


    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public ResourceSpecification getResourceSpecification() {
        return resourceSpecification;
    }

    public void setResourceSpecification(ResourceSpecification resourceSpecification) {
        this.resourceSpecification = resourceSpecification;
    }

    public PhysicalResource getPhysicalResource() {
        return physicalResource;
    }

    public void setPhysicalResource(PhysicalResource physicalResource) {
        this.physicalResource = physicalResource;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public ArrayList<SupportingLogicalResources> getSupportingLogicalResources() {
        return supportingLogicalResources;
    }

    public void setSupportingLogicalResources(ArrayList<SupportingLogicalResources> supportingLogicalResources) {
        this.supportingLogicalResources = supportingLogicalResources;
    }

}


