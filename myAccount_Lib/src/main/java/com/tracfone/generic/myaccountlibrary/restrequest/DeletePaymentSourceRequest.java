package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class will make to Delete Payment Source restful web service request.
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

public class DeletePaymentSourceRequest extends SpiceRequest<String> {

	String paymentSourceId;  
	String accountId;    

	public DeletePaymentSourceRequest(String paymentSourceId, String accountId ) {
		super(String.class);   
		this.paymentSourceId = paymentSourceId; 
		this.accountId = accountId; 
	} 

	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.DELETE_PAYMENT_SOURCE, GlobalLibraryValues.getBrand()); 
		url = String.format(url,accountId,paymentSourceId); 
 
		String result = null;   

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "DELETE", null, getClass().toString());
		result = execConnection.executeRequest();
		
		return result; 
	}


}
