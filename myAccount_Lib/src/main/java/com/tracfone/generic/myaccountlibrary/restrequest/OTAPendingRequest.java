package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class will make to Clear OTA Pending restful web service request.
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

public class OTAPendingRequest extends SpiceRequest<String> {

	String esn;
	String min;


	public OTAPendingRequest(String min, String esn) {
		super(String.class);
		this.min = min;
		this.esn = esn;
	} 

	@Override
	public String loadDataFromNetwork() throws Exception { 

		String result = null;  
		
		String url =  RestfulURL.getUrl(RestfulURL.OTA_PENDING, GlobalLibraryValues.getBrand());
		String minEsn = "";
		if (!min.isEmpty()) {
			minEsn = "min/" + min;
		} else {
			minEsn = "esn/" + esn;
		}

		url = String.format(url,minEsn);
		 
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
		String cacheKey = "";
		if (!min.isEmpty()) {
			cacheKey = min;
		} else {
			cacheKey = esn;
		}
		return RestConstants.OTA_REQUEST + cacheKey;
	}


}
