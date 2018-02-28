package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *
 * This class will make App Support Versions restful web service request. 
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * *****************************************************************************************************************/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;
import com.tracfone.generic.myaccountlibrary.responselistner.ResponseListener;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEmpty;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class AppSupportVersionsRequest extends SpiceRequest<String>{

	private ResponseListener mListener;
	private Class<?> mResponseClassName;
	protected TracfoneLogger tfLogger;
	public AppSupportVersionsRequest() {
		super(String.class);
		tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
	}

	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.APP_SUPPORT_VERSION, GlobalLibraryValues.getBrand());

		String result = null;

		//Populate and create Body
		RequestEmpty emptyRequest = new RequestEmpty();
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		emptyRequest.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(emptyRequest);

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString() );
		result = execConnection.executeRequest();

		return result;
	}
}
