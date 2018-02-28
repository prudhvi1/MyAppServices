package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by mgokhanilhan on 9/23/2015.
 */
public class RequestOauthCCU {

    @JsonProperty("grant_type")
    private String grantTypeOauthCCU;
    @JsonProperty("scope")
    private String scopeOauthCCU;
    @JsonProperty("client_id")
    private String clientIdOauthCCU;
    @JsonProperty("client_secret")
    private String clientSecretOauthCCU;
    @JsonProperty("brandName")
    private String brandNameOauthCCU;
    @JsonProperty("sourceSystem")
    private String sourceSystemOauthCCU;


    public String getGrantTypeOauthCCU() {
        return grantTypeOauthCCU;
    }

    public void setGrantTypeOauthCCU(String grantTypeOauthCCU) {
        this.grantTypeOauthCCU = grantTypeOauthCCU;
    }

    public String getScopeOauthCCU() {
        return scopeOauthCCU;
    }

    public void setScopeOauthCCU(String scopeOauthCCU) {
        this.scopeOauthCCU = scopeOauthCCU;
    }

    public String getClientIdOauthCCU() {
        return clientIdOauthCCU;
    }

    public void setClientIdOauthCCU(String clientIdOauthCCU) {
        this.clientIdOauthCCU = clientIdOauthCCU;
    }

    public String getClientSecretOauthCCU() {
        return clientSecretOauthCCU;
    }

    public void setClientSecretOauthCCU(String clientSecretOauthCCU) {
        this.clientSecretOauthCCU = clientSecretOauthCCU;
    }

    public String getBrandNameOauthCCU() {
        return brandNameOauthCCU;
    }

    public void setBrandNameOauthCCU(String brandNameOauthCCU) {
        this.brandNameOauthCCU = brandNameOauthCCU;
    }

    public String getSourceSystemOauthCCU() {
        return sourceSystemOauthCCU;
    }

    public void setSourceSystemOauthCCU(String sourceSystemOauthCCU) {
        this.sourceSystemOauthCCU = sourceSystemOauthCCU;
    }

    @Override
    public String toString() {
        return "RequestOauthCCU{" +
                "grantTypeOauthCCU='" + grantTypeOauthCCU + '\'' +
                ", scopeOauthCCU='" + scopeOauthCCU + '\'' +
                ", clientIdOauthCCU='" + clientIdOauthCCU + '\'' +
                ", clientSecretOauthCCU='" + clientSecretOauthCCU + '\'' +
                ", brandNameOauthCCU='" + brandNameOauthCCU + '\'' +
                ", sourceSystemOauthCCU='" + sourceSystemOauthCCU + '\'' +
                '}';
    }
}
