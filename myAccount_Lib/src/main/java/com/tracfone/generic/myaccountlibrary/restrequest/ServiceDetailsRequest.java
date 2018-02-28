package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class will make to Get Plan Details restful web service request.
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

public class ServiceDetailsRequest extends SpiceRequest<String> {

	String min;
	String esn;


	public ServiceDetailsRequest(String min, String esn ) {
		super(String.class);   
		this.min = min;
		this.esn = esn;
	} 

	@Override
	public String loadDataFromNetwork() throws Exception {

		//TODO
		String url =  RestfulURL.getUrl(RestfulURL.SERVICE_DETAILS, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,min, "LINE");
		else if(min==null || min.isEmpty()) url = String.format(url,esn, "HANDSET");
		else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, esn, "HANDSET");
		  
		String result = null; 
    	
    	SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
    	 
		return result; 
	}

}
