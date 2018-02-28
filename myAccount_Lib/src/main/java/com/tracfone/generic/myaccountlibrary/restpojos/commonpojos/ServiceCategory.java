package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class ServiceCategory {

    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private String value;

    public String getType() {
        return type;
    }

    public static final String TYPE_CONTEXT = "context";
    public void setType(String type) {
        this.type = type;
    }
    public static final String VALUE_TECHNOLOGY  = "TECHNOLOGY";
    public static final String VALUE_SERVICE_COMPATIBILITY  = "SERVICE_COMPATIBILITY";
    public static final String VALUE_STAGE_VALIDATION  = "STAGE_VALIDATION";
    public static final String VALUE_PORT_COVERAGE  = "PORT_COVERAGE";
    public static final String VALUE_ACTIVATION  = "ACTIVATION";
    public static final String VALUE_REACTIVATION  = "REACTIVATION";
    public static final String VALUE_EXTERNAL_PORT  = "EXTERNAL_PORT";
    public static final String VALUE_INTERNAL_PORT  = "INTERNAL_PORT";
    public static final String VALUE_PHONE_UPGRADE  = "PHONE_UPGRADE";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
