package com.tracfone.generic.myaccountlibrary.restrequest;

/**
 * ***************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 * <p/>
 * CLASS DESCRIPTION:
 * This class GetHandsetProtectionEnrolledProgramRequest will perform Current Enrollment Plan restful web service request to get the currently
 * enrolled Handset protection plan.
 * <p/>
 * This class is invoked from ProtectPhoneProgramEnrolledActivity class.
 * <p/>
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ***************************************************************************************************************************************************
 */


import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;


public class GetHandsetProtectionEnrolledProgramRequest extends SpiceRequest<String> {

    String min, esn;


    public GetHandsetProtectionEnrolledProgramRequest(String min, String esn) {
        super(String.class);
        this.min = min;
        this.esn = esn;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url = RestfulURL.getUrl(RestfulURL.HANDSET_PROTECTION_ENROLLED_PROGRAM, GlobalLibraryValues.getBrand());
        if (esn == null || esn.isEmpty()) url = String.format(url, "min/" + min);
        else if (min == null || min.isEmpty()) url = String.format(url, "esn/" + esn);
        else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, "min/" + min);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }

}
