package com.tracfone.generic.myaccountlibrary.restrequest;
/*************************************************************************** 
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 *  Making OAUTH2.0 Resource Owner Request with RoboSpice Library
 *  
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
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.OAuth;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.OauthConstants;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.Response;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseOauthRO;


public class OauthTokenRequest extends SpiceRequest<String> {

	public String username, password, tokenRequestType;


	public OauthTokenRequest(String username, String password, String tokenRequestType) {
		super(String.class);
		this.username = username;
		this.password = password;
		this.tokenRequestType = tokenRequestType;
	}


	@Override
	public String loadDataFromNetwork() throws Exception {
		String url =  RestfulURL.getUrl(RestfulURL.OAUTH_TOKEN_RESOURCE_OWNER, GlobalLibraryValues.getBrand());

		String result;

		OAuth oAuth = new OAuth(url);
		Response oauthResponse =  oAuth.executeAccessROTokenRequest(username, password, tokenRequestType);

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		ResponseOauthRO oauthROResponse;

		oauthROResponse  = mapper.readValue(oauthResponse.getResponseString(), ResponseOauthRO.class);

		if (tokenRequestType.equals(OauthConstants.RO_TOKEN)) {
			GlobalOauthValues.setAuthTokenROorCCP(oauthROResponse.getAccessToken());
			GlobalOauthValues.setRefreshTokenROorCCP(oauthROResponse.getRefreshToken());
			GlobalOauthValues.setExpiryROorCCP(oauthROResponse.getTokenExpiresIn());
		}
		if (tokenRequestType.equals(OauthConstants.RONS_TOKEN)) {
			GlobalOauthValues.setAuthTokenRONS(oauthROResponse.getAccessToken());
			GlobalOauthValues.setRefreshTokenRONS(oauthROResponse.getRefreshToken());
			GlobalOauthValues.setExpiryRONS(oauthROResponse.getTokenExpiresIn());
		}
		if (tokenRequestType.equals(OauthConstants.ROLIMITED_TOKEN)) {
			GlobalOauthValues.setAuthTokenROLimited(oauthROResponse.getAccessToken());
			GlobalOauthValues.setRefreshTokenROLimited(oauthROResponse.getRefreshToken());
			GlobalOauthValues.setExpiryROLimited(oauthROResponse.getTokenExpiresIn());
			GlobalOauthValues.setIsROLimitedLogin(true);
		}
		GlobalOauthValues.setAccountId(oauthROResponse.getAccountId());

		return oauthResponse.getResponseString();
	}

}
