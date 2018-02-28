package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class ReservePinCardToTopRequest will move the selected reserve Pin Card to Top in the Reserve list.
 *
 * This class is invoked from ReUpWithStashActivity class.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ***************************************************************************************************************/
 
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEmpty;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class ReservePinCardToTopRequest extends SpiceRequest<String> {

	String min, esn;
	String pinCard; 

	public ReservePinCardToTopRequest(String min,String esn, String pinCard) {
		super(String.class);   
		this.min = min;
		this.esn = esn;
		this.pinCard=pinCard;
	} 
	/** Create the web service request URL by choosing the appropriate service number and 
	 * appending it with the phone number(min) and service pin card number(pinCard).  
	 */
	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.CARD_TO_TOP, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min,pinCard);
		else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn,pinCard);
		else if (!min.isEmpty() && !esn.isEmpty()) {
			if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min,pinCard);
			else url = String.format(url, "esn/" + esn,pinCard);
		}

		String result = null; 

		//Populate and create Body  
		RequestEmpty emptyRequest = new RequestEmpty(); 
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		emptyRequest.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(emptyRequest); 

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "PUT", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";

		return result; 
	}
}