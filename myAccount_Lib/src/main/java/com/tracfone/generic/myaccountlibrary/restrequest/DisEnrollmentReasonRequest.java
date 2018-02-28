package com.tracfone.generic.myaccountlibrary.restrequest;

/******************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class DisEnrollmentReasonRequest will get the reasons for de enrolling from the currently enrolled service plan.
 *
 * This class is invoked from ManageDeEnrollReasonActivity class.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class DisEnrollmentReasonRequest extends SpiceRequest<String> {

    private int accountId;

    public DisEnrollmentReasonRequest(String accountId) {
        super(String.class);
        this.accountId = Integer.parseInt(accountId);
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.DIS_ENROLLMENT_REASONS, GlobalLibraryValues.getBrand());

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";

        return result;
    }

    public String createCacheKey() {
        return RestConstants.DE_ENROLL_REASONS;
    }
}