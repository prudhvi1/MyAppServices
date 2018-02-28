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

public class DeleteDeviceRequest extends SpiceRequest<String> {

	String esn;  
	String accountId;
	boolean isRemoveFromGroupPresent = false;

	public DeleteDeviceRequest(String esn, String accountId ,boolean isRemoveFromGroupPresent) {

		super(String.class);   
		this.esn = esn; 
		this.accountId = accountId;
		this.isRemoveFromGroupPresent = isRemoveFromGroupPresent;
	} 

	@Override
	public String loadDataFromNetwork() throws Exception { 

		String result = null;
		String url = null;


		if(isRemoveFromGroupPresent){
			url = RestfulURL.getUrl(RestfulURL.DELETE_DEVICE_GROUPID, GlobalLibraryValues.getBrand());
			url = String.format(url, accountId, esn);
		}else{
			url = RestfulURL.getUrl(RestfulURL.DELETE_DEVICE, GlobalLibraryValues.getBrand());
			url = String.format(url, accountId, esn);
		}

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "DELETE", null, getClass().toString());
		result = execConnection.executeRequest();
		
		return result; 
	} 

}
