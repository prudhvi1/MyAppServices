package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class will make to Get Device Data Usage restful web service request.
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

public class DataUsageRequest extends SpiceRequest<String> {

	String min;
	String esn;


	public DataUsageRequest(String min, String esn ) {
		super(String.class);   
		this.min = min;
		this.esn = esn;
	} 

	@Override
	public String loadDataFromNetwork() throws Exception {
		
		String url =  RestfulURL.getUrl(RestfulURL.DATA_USAGE, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
		else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
		else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, "esn/" + esn);
		  
		String result = null; 
    	
    	SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
    	 
		return result; 
	} 
	
	 /**
     * This method generates a unique cache key for this request. In this case
     * our cache key depends just on the keyword.
     * @return
     */
    public String createCacheKey() {
		if(esn==null || esn.isEmpty())
			return RestConstants.DATA_USAGE + min;
		else if(min==null || min.isEmpty())
			return RestConstants.DATA_USAGE  + esn;
		return RestConstants.DATA_USAGE  + esn;
    }

}
