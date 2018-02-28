package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class will perform a restful service call to get a list of Transaction History 
* associated with the account. 
*
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
* ****************************************************************************/
    
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class TransactionHistoryRequest extends SpiceRequest<String> {
  
	private String esn;
	
	public TransactionHistoryRequest(String esn) {
        super(String.class);  
        this.esn = esn;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
  
		String url =  RestfulURL.getUrl(RestfulURL.TRANSACTION_HISTORY_V2, GlobalLibraryValues.getBrand());
		url = String.format(url,esn);
		
    	String result = null; 
		
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
		
		return result; 
    }
}