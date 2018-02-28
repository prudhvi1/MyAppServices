package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class PaymentSourcesRequest will perform a restful service call to get the list of credit cards associated with the account. 
 *
 * This class is invoked from :
 *  HomeActivity, AutoReupEnrollActivity, ReUpWithCCActivity, ReUpWithCCGuestActivity.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved 
 * ****************************************************************************************************************************************************************/
  
import com.octo.android.robospice.request.SpiceRequest; 
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;  
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class PaymentSourcesRequest extends SpiceRequest<String> {

	private String accountId; 

	public PaymentSourcesRequest(String accountId) {
		super(String.class);  
		this.accountId = accountId;  
	}
	/** Create the web service request URL by choosing the appropriate service number and appending it with the Account Id.  
	 */
	@Override
	public String loadDataFromNetwork() throws Exception { 
    	String result = null;

		String url =  RestfulURL.getUrl(RestfulURL.PAYMENT_SOURCES, GlobalLibraryValues.getBrand()); 
		url = String.format(url,accountId);   
		
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
     
    	return result; 
    }

	/**
	 * This method generates a unique cache key for this request. In this case our cache key is a combination of keyword Payment Sources and the account Id.
	 * @return
	 */
	public String createCacheKey() {
		return RestConstants.PAYMENT_SOURCES + accountId;
	}
} 
