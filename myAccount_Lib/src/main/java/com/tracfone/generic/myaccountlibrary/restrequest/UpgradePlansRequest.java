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
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;


public class UpgradePlansRequest extends SpiceRequest<String> {

    private String min;

    public UpgradePlansRequest(String min) {
        super(String.class);
        this.min = min;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String url =  RestfulURL.getUrl(RestfulURL.REWARD_DETAILS, GlobalLibraryValues.getBrand());
        url = String.format(url,min);

        String result = null;

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }

}
