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


public class ServiceQualificationBYOPRequest extends SpiceRequest<String> {

    String serialNumber;
    String zipcode;
    String carrier;

    /**
     * Constuctor for Add Device Request
     */

    public ServiceQualificationBYOPRequest(String serialNumber , String zipcode, String carrier) {
        super(String.class);
        this.serialNumber = serialNumber;
        this.zipcode = zipcode;
        this.carrier = carrier;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String url = RestfulURL.getUrl(RestfulURL.SERVICE_QUALIFICATION_BYOP, GlobalLibraryValues.getBrand());
        String zipcodeURLString = "";
        if(zipcode != null && !zipcode.isEmpty()) zipcodeURLString = "/zipcode/" + zipcode;
        url = String.format(url, serialNumber, zipcodeURLString, carrier);

        String result = null;

        RequestEmpty emptyRequest = new RequestEmpty();
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        emptyRequest.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(emptyRequest);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        return result;

    }
}

