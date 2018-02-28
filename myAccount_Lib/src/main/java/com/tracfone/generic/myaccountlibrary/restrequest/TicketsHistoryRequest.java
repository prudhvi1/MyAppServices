package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class will perform a restful service call to get a list of Tickets History
 * associated with the account.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *****************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class TicketsHistoryRequest extends SpiceRequest<String> {

    private String min,esn;

    public TicketsHistoryRequest(String min,String esn) {
        super(String.class);
        this.min = min;
        this.esn = esn;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String url =  RestfulURL.getUrl(RestfulURL.TICKETS_HISTORY, GlobalLibraryValues.getBrand());
        if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
        else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
        else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, "esn/" + esn);

        String result = null;

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }

}
