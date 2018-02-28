package com.tracfone.generic.myaccountlibrary.restrequest;

/******************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class CurrentEnrollmentPlanRequest will perform Current Enrollment Plan restful web service request to get the currently enrolled service plan.
 *
 * This class is invoked from AutoReUpManageActivity class.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class CurrentEnrollmentPlanRequest extends SpiceRequest<String> {

    private String min, esn;

    public CurrentEnrollmentPlanRequest(String min, String esn) {
        super(String.class);
        this.min = min;
        this.esn=esn;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.CURRENT_ENROLLMENT_PLAN, GlobalLibraryValues.getBrand());
        if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
        else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
        else if (!min.isEmpty() && !esn.isEmpty()) {
            if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min);
            else url = String.format(url, "esn/" + esn);
        }

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";

        return result;
    }
}