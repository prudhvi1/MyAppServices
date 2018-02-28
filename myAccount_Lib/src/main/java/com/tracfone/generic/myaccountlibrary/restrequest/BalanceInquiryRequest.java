package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class will make Get Balance Inquiry restful web service request.
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
import com.tracfone.generic.myaccountlibrary.restcommon.CachedSpiceService;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.octo.android.robospice.SpiceManager;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class BalanceInquiryRequest extends SpiceRequest<String> {

	String min;
	String esn;


	public BalanceInquiryRequest(String min, String esn) {
		super(String.class);   
		this.min = min;
		this.esn = esn;
	}

	@Override
	public String loadDataFromNetwork() throws Exception {
		
		String url =  RestfulURL.getUrl(RestfulURL.GET_BALANCE_INQUIRY, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
		else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
		else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, "esn/" + esn);

		String result = null; 
    	
    	SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();

		//Remove any old cached data balances with the current min.  This will insure a new over air request is made.
		//To match this over the transaction ID request. This is required to make sure the responses match for the
		//two step balance request.
		SpiceManager spiceManager = new SpiceManager(CachedSpiceService.class);
		spiceManager.removeDataFromCache(String.class, FetchBalanceInquiryRequest.getCacheKey(min));

		return result; 
	}

	/**
	 * This method generates a unique cache key for this request. In this case our cache key is a combination of keyword Payment Sources and the min.
	 * @return
	 */
	public String createCacheKey() {
		if(esn==null || esn.isEmpty())
			return RestConstants.BALANCE_INQUIRY + min;
		else if(min==null || min.isEmpty())
			return RestConstants.BALANCE_INQUIRY + esn;
		return RestConstants.BALANCE_INQUIRY + esn;
	}

	public static String getCacheKey(String key) { return RestConstants.BALANCE_INQUIRY + key; }

}
