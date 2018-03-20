package com.trac.preload.accountservices.services;

import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restrequest.RestfulURL;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will create the request for Validate Device restful web service.
 *
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 * Created by tjana on 1/18/2018.
 * ****************************************************************************/

public class ValidateDeviceSyncRequest {

    private String min, esn, sim;

    private ValidateDeviceSyncRequest(String min, String esn, String sim) {
        this.min = min;
        this.esn = esn;
        this.sim = sim;
    }

    public String loadDataFromNetwork() throws Exception {
        String result = null;
        String url = RestfulURL.getUrl(RestfulURL.VALIDATE_DEVICE, GlobalLibraryValues.getBrand());
        if(!sim.isEmpty())
            url = String.format(url, "sim/" + sim);
        else if(!esn.isEmpty())
            url = String.format(url, "esn/" + esn);
        else
            url = String.format(url, "min/" + min);
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
        if(!sim.isEmpty()) minOrEsnOrSim = sim;
        else if(!esn.isEmpty()) minOrEsnOrSim = esn;
        else minOrEsnOrSim = min;
        return RestConstants.VALIDATE_DEVICE + minOrEsnOrSim;
    }
}