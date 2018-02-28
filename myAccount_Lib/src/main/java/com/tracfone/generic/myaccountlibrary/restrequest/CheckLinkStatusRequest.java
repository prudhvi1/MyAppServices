package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class will make check link status web service request. 
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * *****************************************************************************************************************/
 
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class CheckLinkStatusRequest extends SpiceRequest<String> {

	public CheckLinkStatusRequest() {
		super(String.class);  
	}
	
	@Override
	public String loadDataFromNetwork() throws Exception {
		String url =  RestfulURL.getUrl(RestfulURL.CHECK_FACEBOOK_TF_LINK_STATUS, GlobalLibraryValues.getBrand()); 
 
		String result = null; 
		
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU_FB, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
		return result; 
	}

	 
}
