package com.tracfone.generic.myaccountlibrary.restrequest;

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

/**
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will perform a restful service call to get a list of Transaction Payment History
 * associated with the account.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 * Created by mgokhanilhan on 7/23/2015.
 *
 *
 */
public class TransactionPaymentHistoryRequest extends SpiceRequest<String> {

    private String accountId;
    private String esn;

    public TransactionPaymentHistoryRequest(String accountId, String esn){
        super(String.class);
        this.accountId = accountId;
        this.esn = esn;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String url = RestfulURL.getUrl(RestfulURL.PAYMENT_HISTORY, GlobalLibraryValues.getBrand());
        url = String.format(url,accountId,esn);

        String result;
        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();
        return result;
    }
}
