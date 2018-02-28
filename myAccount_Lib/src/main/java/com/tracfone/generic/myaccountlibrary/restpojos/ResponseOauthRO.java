package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * Oauth Client Resource Owner(RO) Response POJOs class
 * Created by mgokhanilhan on 10/1/2015.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2015,  All Rights Reserved
 *
 *
 * ****************************************************************************/

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseOauthRO {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("brandName")
    private String tokenBrandName;
    @JsonProperty("expires_in")
    private int tokenExpiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("scope")
    private String tokenScope;
    @JsonProperty("sourceSystem")
    private String tokenSourceSystem;
    @JsonProperty("token_type")
    private String tokenType;

    public String getAccessToken() {return accessToken;}
    public void setAccessToken(String accessToken) {this.accessToken = accessToken;}

    public String getAccountId() {return accountId;}
    public void setAccountId(String accountId) {this.accountId = accountId;}

    public String getTokenBrandName() {return tokenBrandName;}
    public void setTokenBrandName(String tokenBrandName) {this.tokenBrandName = tokenBrandName;}

    public int getTokenExpiresIn() {return tokenExpiresIn;}
    public void setTokenExpiresIn(int tokenExpiresIn) {this.tokenExpiresIn = tokenExpiresIn;}

    public String getRefreshToken() {return refreshToken;}
    public void setRefreshToken(String refreshToken) {this.refreshToken = refreshToken;}

    public String getTokenScope() {return tokenScope;}
    public void setTokenScope(String tokenScope) {this.tokenScope = tokenScope;}

    public String getTokenSourceSystem() {return tokenSourceSystem;}
    public void setTokenSourceSystem(String tokenSourceSystem) {this.tokenSourceSystem = tokenSourceSystem;}

    public String getTokenType() {return tokenType;}
    public void setTokenType(String tokenType) {this.tokenType = tokenType;}

    public boolean hasAccessToken() {
        return this.accessToken != null && this.accessToken != null && !this.accessToken.isEmpty();
    }
}
