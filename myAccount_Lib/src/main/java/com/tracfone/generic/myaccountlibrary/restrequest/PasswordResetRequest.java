package com.tracfone.generic.myaccountlibrary.restrequest;
/*************************************************************************** 
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 *  This class performs password reset request by asking user enter the email address
 *   - GOKHAN
 *	
 * 	
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues; 
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEmpty;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class PasswordResetRequest extends SpiceRequest<String> {
	  
	private String email; 

	public PasswordResetRequest(String email) {
		super(String.class);
		this.email = email;
	}

	@Override
	public String loadDataFromNetwork() throws Exception {

    	String url =  RestfulURL.getUrl(RestfulURL.PASSWORD_RESET, GlobalLibraryValues.getBrand()); 
		url = String.format(url,email);   
		
    	String result = null; 
		
		//Populate and create Body  
		RequestEmpty emptyRequest = new RequestEmpty(); 
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		emptyRequest.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(emptyRequest);   
		 
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "PUT", jsonString, getClass().toString());
		result = execConnection.executeRequest();
    	
		return result;
	}

}
