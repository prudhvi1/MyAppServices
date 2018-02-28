package com.tracfone.generic.myaccountlibrary.restpojos;
/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * Oauth Client Credentials Unprotected(CCU)  Response POJOs class
 * Created by mgokhanilhan on 9/22/2015.
 *
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2015,  All Rights Reserved
 *
 *
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseOauthCCU {

        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("brandName")
        private String tokenBrandName;
        @JsonProperty("expires_in")
        private int tokenExpiresIn;
        @JsonProperty("scope")
        private String tokenScope;
        @JsonProperty("sourceSystem")
        private String tokenSourceSystem;
        @JsonProperty("token_type")
        private String tokenType;


        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getTokenBrandName() {
            return tokenBrandName;
        }

        public void setTokenBrandName(String tokenBrandName) {
            this.tokenBrandName = tokenBrandName;
        }

        public int getTokenExpiresIn() {
            return tokenExpiresIn;
        }

        public void setTokenExpiresIn(int tokenExpiresIn) {
            this.tokenExpiresIn = tokenExpiresIn;
        }

        public String getTokenScope() {
            return tokenScope;
        }

        public void setTokenScope(String tokenScope) {
            this.tokenScope = tokenScope;
        }

        public String getTokenSourceSystem() {
            return tokenSourceSystem;
        }

        public void setTokenSourceSystem(String tokenSourceSystem) {
            this.tokenSourceSystem = tokenSourceSystem;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

    public boolean hasAccessToken() {
        return this.accessToken != null && this.accessToken != null && !this.accessToken.isEmpty();
    }



}
