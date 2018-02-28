package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class will make Link account restful web service request. 
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * *****************************************************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class LinkAccountRequest extends SpiceRequest<String> {

	public LinkAccountRequest() {
		super(String.class);  
	}

	@Override
	public String loadDataFromNetwork() throws Exception {
		String url =  RestfulURL.getUrl(RestfulURL.LINK_FACEBOOK_TF_ACCOUNT, GlobalLibraryValues.getBrand()); 
		url = String.format(url, GlobalOauthValues.getAccountId());

		String result = null; 

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO_CCP, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
		return result; 
	}


}
