package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class ReservePinCardsRequest will perform a restful service call to get a list of Reserve Pin Cards associated with the mobile number. 
 *
 * This class is invoked from ReUpWithStashActivity class.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *****************************************************************************************************************************************/
 
import com.octo.android.robospice.request.SpiceRequest; 
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class ReservePinCardsRequest extends SpiceRequest<String> {

	private String min, esn;

	public ReservePinCardsRequest(String min, String esn) {
		super(String.class);  
		this.min = min;
		this.esn = esn;
	} 
	/** Create the web service request URL by choosing the appropriate service number and appending it with the phone number(min).
	 */
	@Override
	public String loadDataFromNetwork() throws Exception {

		String result = null;
		String url =  RestfulURL.getUrl(RestfulURL.CARDS_IN_RESERVE, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
		else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
		else if (!min.isEmpty() && !esn.isEmpty()) {
			if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min);
			else url = String.format(url, "esn/" + esn);
		}

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";

		return result; 
	}
}
