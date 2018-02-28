package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:
*  This class will perform a restful service call which will get a list of 
*  retailers which are close to a specified search center. The data includes
*  gps coordinates which allows the list to be mapped.  
*
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
* ****************************************************************************/
 
import com.octo.android.robospice.request.SpiceRequest; 
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class RetailersRequest extends SpiceRequest<String> {

    private double lat, lng;
    private String searchString; 
	private int searchType;   
    
    //Search Types
    static final int ZIPCODE_SEARCH = 0;   
	static final int LATLNG_SEARCH = 1;   
	
	public RetailersRequest(String searchString) {
        super(String.class); 
        searchType = ZIPCODE_SEARCH; 
        this.searchString = searchString;  
    }

    public RetailersRequest(double lat, double lng) {
        super(String.class); 
        searchType = LATLNG_SEARCH;
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
  
		String url =  RestfulURL.getUrl(RestfulURL.RETAILERS, GlobalLibraryValues.getBrand());
    	switch (searchType) { 
    	case LATLNG_SEARCH:   
    		url = url + String.format("%.6f,%.6f", lat,lng); 
    		break; 
    	case ZIPCODE_SEARCH:
    		url = url + searchString;
    		break;   
    	}
    	 
    	String result = null; 
    	
    	SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();
		
    	return result; 
    }

} 