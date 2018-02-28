package com.tracfone.generic.myaccountlibrary.restrequest;
/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  This class will perform a restful service call get a list of security
*  questions.  
*
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
* ****************************************************************************/
   
import com.octo.android.robospice.request.SpiceRequest; 
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues; 
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class SecurityQuestionsRequest extends SpiceRequest<String> { 
	  
	
	public SecurityQuestionsRequest() {
        super(String.class);   
    }
 

    @Override
    public String loadDataFromNetwork() throws Exception {
    	
    	String url =  RestfulURL.getUrl(RestfulURL.SECURITY_QUESTIONS, GlobalLibraryValues.getBrand());  
    	
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
        return RestConstants.SECURITY_QUESTIONS;
    }
} 