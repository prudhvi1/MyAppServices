package com.tracfone.generic.myaccountlibrary.restrequest;

/*****************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class RedeemPinCardFromReserveRequest will perform Redeem pin card From Reserve restful web service request to 
 * redeem the selected Reserve Pin Card for the specific phone number. 
 * 
 * This class is invoked from StashCheckOutActivity class.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *  
 * ******************************************************************************************************************************/
 
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestRedeemFromReserve;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class RedeemPinCardFromReserveRequest extends SpiceRequest<String> {

	private String min,esn;
	private boolean redeemNow;

	public RedeemPinCardFromReserveRequest(String min,String esn,boolean redeemNow) {
		super(String.class);   
		this.min = min;
		this.esn = esn;
		this.redeemNow=redeemNow;
	} 
	/** Create the web service request URL by choosing the appropriate service number and appending it with the phone number(min).
	 */
	@Override
	public String loadDataFromNetwork() throws Exception {

		String result = null;
		String url =  RestfulURL.getUrl(RestfulURL.REDEEM_CARD_FROM_RESERVE, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
		else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
		else if (!min.isEmpty() && !esn.isEmpty()) {
			if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min);
			else url = String.format(url, "esn/" + esn);
		}

		//Populate and create Body  
		RequestRedeemFromReserve redeemFromReserve = new RequestRedeemFromReserve();
		RequestRedeemFromReserve.RedeemFromReserve request=new RequestRedeemFromReserve.RedeemFromReserve();
		request.setRedeemNow(redeemNow);
		redeemFromReserve.setRequest(request);
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		redeemFromReserve.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(redeemFromReserve);

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "POST", jsonString, getClass().toString());
		result = execConnection.executeRequest();


		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";

		return result; 
	}
}