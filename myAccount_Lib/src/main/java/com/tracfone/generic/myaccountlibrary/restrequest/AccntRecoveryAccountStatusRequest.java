package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class will perform Account Recovery Account Status Restful Web Service request to send user a verificationCode
 * via SMS
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *****************************************************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class AccntRecoveryAccountStatusRequest extends SpiceRequest<String>{

	private String min;

	public AccntRecoveryAccountStatusRequest(String min) {
		super(String.class);
		this.min = min;
	}

	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.ACCOUNT_RECOVERY_ACCOUNT_STATUS, GlobalLibraryValues.getBrand());  
		url = String.format(url,min);
		String result = null; 

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();

		return result; 
	}
}