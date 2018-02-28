package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:
*  This class will perform a restful service call to validate a specific
*  device using an mdn.
*
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
* ****************************************************************************/
    
import android.util.Log;

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class ValidateDeviceRequest extends SpiceRequest<String> {
  
	private String min, esn, sim=null;
	
	public ValidateDeviceRequest(String min, String esn) {
        super(String.class);  
        this.min = min;
        this.esn = esn;
    }
    public ValidateDeviceRequest(String sim) {
        super(String.class);
        this.sim = sim;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        Log.v("hds","here--");
      	String result = null;
        String url = RestfulURL.getUrl(RestfulURL.VALIDATE_DEVICE, GlobalLibraryValues.getBrand());
        if(sim !=null){
            url = String.format(url, "sim/" + sim);
        }else {
            if (esn == null || esn.isEmpty()) url = String.format(url, "min/" + min);
            else if (min == null || min.isEmpty()) url = String.format(url, "esn/" + esn);
            else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, "esn/" + esn);
        }
        Log.v("hds","here");
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
        String minOrEsnOrSim="";

        if(sim !=null) {
            if (esn == null || esn.isEmpty()) minOrEsnOrSim = min;
            else if (min == null || min.isEmpty()) minOrEsnOrSim = esn;
            else if (!min.isEmpty() && !esn.isEmpty()) {
                if (ReleaseFlavorConfig.TEST_MOCKABLE) minOrEsnOrSim = min;
                else minOrEsnOrSim = esn;
            }
        }
        else{
            minOrEsnOrSim = sim;
        }

        return RestConstants.VALIDATE_DEVICE + minOrEsnOrSim;
    }
} 