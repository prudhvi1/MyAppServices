package com.tracfone.generic.myaccountlibrary.restrequest;

/**
 * *****************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 * CLASS DESCRIPTION:
 * <p/>
 * This class will perform Service Qualification for a potential BYOP Device
 * <p/>
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * <p/>
 * *****************************************************************************
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEmpty;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;


public class BYOPCoverageRequest extends SpiceRequest<String> {

    String deviceType;
    String zipcode;
    String carrier;

    /**
     * Constuctor for Add Device Request
     */

    public BYOPCoverageRequest(String zipcode , String deviceType, String carrier) {
        super(String.class);
        this.zipcode = zipcode;
        this.deviceType = deviceType;
        this.carrier = carrier;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String url = RestfulURL.getUrl(RestfulURL.BYOP_COVERAGE, GlobalLibraryValues.getBrand());
        String carrierURLString = "";
        if (carrier != null && !carrier.isEmpty()) carrierURLString = "carrier/" + carrier;
        url = String.format(url, zipcode, deviceType, carrierURLString);

        String result = null;

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        return result;

    }
}

