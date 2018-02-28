package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make to Value Added Service Counter Increment restful web service request.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestVASCounterIncrement;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class VASCounterIncrementRequest extends SpiceRequest<String> {
    private String min, esn, eventId;
    private int step;

    public VASCounterIncrementRequest(String min, String esn, String eventId, int step) {
        super(String.class);
        this.min = min;
        this.esn = esn;
        this.eventId = eventId;
        this.step=step;
    }

    /**
     * Create the web service request URL by choosing the appropriate service number and appending it with the phone number(min).
     */
    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url = RestfulURL.getUrl(RestfulURL.VAS_COUNTER_INCREMENT, GlobalLibraryValues.getBrand());
        if (esn == null || esn.isEmpty()) url = String.format(url, "min/" + min);
        else if (min == null || min.isEmpty()) url = String.format(url, "esn/" + esn);
        else if (!min.isEmpty() && !esn.isEmpty()) {
            if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min);
            else url = String.format(url, "esn/" + esn);
        }

        RequestVASCounterIncrement incrementRequest=new RequestVASCounterIncrement();
        RequestVASCounterIncrement.CounterIncrementRequest counterIncrementRequest=new RequestVASCounterIncrement.CounterIncrementRequest();
        counterIncrementRequest.setEventId(eventId);
        counterIncrementRequest.setStep(step);
        incrementRequest.setRequest(counterIncrementRequest);

        RequestCommon requestCommon=new RequestCommon();
        requestCommon.setAll();
        incrementRequest.setCommon(requestCommon);
        ObjectMapper mapper=new ObjectMapper();
        String jsonString=mapper.writeValueAsString(incrementRequest);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";
        jsonString = "";

        return result;
    }
}