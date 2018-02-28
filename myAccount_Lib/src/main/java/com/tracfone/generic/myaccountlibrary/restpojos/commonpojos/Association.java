package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class Association {

    @JsonProperty("role")
    private String role;

    public static final String ROLE_REGISTER  = "REGISTER";
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
