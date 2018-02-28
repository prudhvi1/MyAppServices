package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for response of new Access Token with Expired Refresh Token.
 * Created by mgokhanilhan on 11/6/2015.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2015,  All Rights Reserved
 *
 *
 * ****************************************************************************/

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseExpiredRefreshTokenStatus {

    public class ResponseStatus {

        @JsonProperty("error")
        private String responseError;

        @JsonProperty("description")
        private String responseDescription;

        public String getResponseCode() { return responseError; }
        public void setResponseCode(String c) { responseError = c; }

        public String getResponseDescription() { return responseDescription; }
        public void setResponseDescription(String d) { responseDescription = d; }

    }


}
