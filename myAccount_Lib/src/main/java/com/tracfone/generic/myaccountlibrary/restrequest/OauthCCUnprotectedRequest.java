package com.tracfone.generic.myaccountlibrary.restrequest;
/*************************************************************************** 
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 *  This class is making a request of OAUTH Client Credentials Unprotected in robospice 
 *  asynchronously 
 *   - GOKHAN
 *	
 * 	
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.OAuth;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.Response;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseOauthCCU;

public class OauthCCUnprotectedRequest extends SpiceRequest<String> {


	public OauthCCUnprotectedRequest() {
		super(String.class);
	}


	@Override
	public String loadDataFromNetwork() throws Exception {
		String url =  RestfulURL.getUrl(RestfulURL.OAUTH_TOKEN_CLIENT_CREDENTIALS_UNPROTECTED, GlobalLibraryValues.getBrand());

		TracfoneLogger tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);

		String result;

		OAuth oAuth = new OAuth(url);
		Response oauthResponse = oAuth.executeCCUAccessTokenRequest();

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		ResponseOauthCCU oauthCCUResponse;

		oauthCCUResponse  = mapper.readValue(oauthResponse.getResponseString(), ResponseOauthCCU.class);

		GlobalOauthValues.setAuthTokenCCU(oauthCCUResponse.getAccessToken());
		GlobalOauthValues.setExpiryCCU(oauthCCUResponse.getTokenExpiresIn());

		return oauthResponse.getResponseString();
	}

}
