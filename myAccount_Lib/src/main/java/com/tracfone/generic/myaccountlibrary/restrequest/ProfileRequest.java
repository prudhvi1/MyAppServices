package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class will make to Get Customer account profile restful web service request.
 *
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ******************************************************************************************************************/
  
import com.octo.android.robospice.request.SpiceRequest; 
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class ProfileRequest extends SpiceRequest<String> {

	private String accountId; 

	public ProfileRequest(String accountId) {
		super(String.class);  
		this.accountId = accountId;
	}
	
	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.ACCOUNT_PROFILE, GlobalLibraryValues.getBrand()); 
		url = String.format(url,accountId);  
		
		String result = null;  
		
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
		 
		return result; 
	}
} 
