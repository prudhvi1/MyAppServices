package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class will perform a restful service call get a list of devices 
 * associated with the account. 
 *
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/
  
import com.octo.android.robospice.request.SpiceRequest; 
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;  
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;


public class AccountDetailsRequest extends SpiceRequest<String> {

	private String accountId; 

	public AccountDetailsRequest(String accountId) {
		super(String.class);  
		this.accountId = accountId;  
	}


	@Override
	public String loadDataFromNetwork() throws Exception {
		
		String result = null;

		String url =  RestfulURL.getUrl(RestfulURL.ACCOUNT_DETAILS, GlobalLibraryValues.getBrand()); 
		url = String.format(url,accountId);  	
		
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
 
		return result; 
	}

	/**
	 * This method generates a unique cache key for this request. In this case
	 * our cache key depends just on the keyword.
	 * @return
	 */
	public String createCacheKey() {
		return RestConstants.ACCOUNT_DETAILS + accountId;
	}
} 