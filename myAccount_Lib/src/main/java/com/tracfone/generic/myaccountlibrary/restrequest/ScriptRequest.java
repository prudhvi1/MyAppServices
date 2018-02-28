package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:
*  This class will perform a restful service call get a list of  html scripts
*
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
* ****************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.List;

public class ScriptRequest extends SpiceRequest<String> {

    List<String> scriptIds;

	public ScriptRequest(List<String> scriptIds) {
        super(String.class);

        this.scriptIds = scriptIds;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
    	
    	String url =  RestfulURL.getUrl(RestfulURL.SCRIPTS, GlobalLibraryValues.getBrand());
    	String scriptIDsString = "";
        for(String script : scriptIds) {
            scriptIDsString = scriptIDsString + script + ",";
        }
        scriptIDsString = scriptIDsString.substring(0, scriptIDsString.length()-1);
        url = String.format(url, scriptIDsString);

    	String result = null; 
    	
    	SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
     
    	return result; 
    }
}