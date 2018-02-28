package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class will make to Delete Device restful web service request.
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
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class DeleteDeviceActivationRequest extends SpiceRequest<String> {

	String esn;
	String accountId;

	public DeleteDeviceActivationRequest(String esn, String accountId) {
		super(String.class);   
		this.esn = esn; 
		this.accountId = accountId;
	} 

	@Override
	public String loadDataFromNetwork() throws Exception { 

		String result = null;
		String url = null;

		url = RestfulURL.getUrl(RestfulURL.DELETE_DEVICE_ACTIVATION, GlobalLibraryValues.getBrand());
		url = String.format(url, accountId, esn);

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "DELETE", null, getClass().toString());
		result = execConnection.executeRequest();
		
		return result; 
	} 

}
