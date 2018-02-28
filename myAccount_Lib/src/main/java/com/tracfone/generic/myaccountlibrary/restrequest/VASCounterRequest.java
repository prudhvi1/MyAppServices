package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make to Value Added Service Counter restful web service request.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class VASCounterRequest extends SpiceRequest<String> {
    private String min, esn, eventId;

    public VASCounterRequest(String min, String esn, String eventId) {
        super(String.class);
        this.min = min;
        this.esn=esn;
        this.eventId=eventId;
    }
    /** Create the web service request URL by choosing the appropriate service number and appending it with the phone number(min).
     */
    @Override
    public String loadDataFromNetwork() throws Exception {

        String url =  RestfulURL.getUrl(RestfulURL.GET_VAS_COUNTER, GlobalLibraryValues.getBrand());
        if (esn == null || esn.isEmpty()) url = String.format(url, "min/" + min,eventId);
        else if (min == null || min.isEmpty()) url = String.format(url, "esn/" + esn,eventId);
        else if (!min.isEmpty() && !esn.isEmpty()) {
            if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min,eventId);
            else url = String.format(url, "esn/" + esn,eventId);
        }

        String result = null;

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";

        return result;
    }
}