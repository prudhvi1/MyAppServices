package com.tracfone.generic.myaccountlibrary.restrequest;

/******************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class PlanListRequest will perform a restful service call get a list of Service Plans which can be purchased or added for the specified device.
 * 
 * This class is invoked from :
 * HomeActivity, AutoReUpManageActivity, AutoReupEnrollActivity, ReUpWithCCActivity, ReUpWithCCGuestActivity.
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *  
 * *****************************************************************************************************************************************************/
  
import com.octo.android.robospice.request.SpiceRequest; 
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class PlanListRequest extends SpiceRequest<String> {

	private String min;
	private String esn; 

	public PlanListRequest(String min, String esn) {
        super(String.class);  
        this.min = min;  
        this.esn = esn;  
	} 
	/** Create the web service request URL by choosing the appropriate service number and appending it with the phone number(min) and serial number(esn)  
	 */ 
	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.AVAILABLE_PLANS, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
		else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
		else if (!min.isEmpty() && !esn.isEmpty()) {
			if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min);
			else url = String.format(url, "esn/" + esn);
		} 

		String result = null;  

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();

		return result; 
	}
	public String createCacheKey() {
		String minOrEsn="";
		if (esn == null || esn.isEmpty()) minOrEsn = min;
		else if (min == null || min.isEmpty()) minOrEsn = esn;
		else if (!min.isEmpty() && !esn.isEmpty()) {
			if (ReleaseFlavorConfig.TEST_MOCKABLE) minOrEsn = min;
			else minOrEsn = esn;
		}
		return RestConstants.AVAILABLE_PLANS+minOrEsn;
	}
	 
} 
