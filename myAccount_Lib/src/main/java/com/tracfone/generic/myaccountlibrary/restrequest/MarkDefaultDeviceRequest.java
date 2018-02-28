package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestMarkDefaultDevice;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestMarkDefaultDevice.MarkDefaultRequest;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make to MarkDefaultDeviceRequest restful web service request.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

public class MarkDefaultDeviceRequest extends SpiceRequest<String> {

    String accountId;
    String min;
    String esn;

    public MarkDefaultDeviceRequest(String min , String esn , String accountId){
        super(String.class);
        this.accountId = accountId;
        this.min = min;
        this.esn = esn;
    }
    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.MARK_DEFAULT_DEVICE, GlobalLibraryValues.getBrand());
        if(esn==null || esn.isEmpty()) url = String.format(url,"min/" + min);
        else if(min==null || min.isEmpty()) url = String.format(url,"esn/" + esn);
        else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, "min/" + min);


        RequestMarkDefaultDevice requestMarkDefaultDevice =  new RequestMarkDefaultDevice();
        MarkDefaultRequest markDefaultRequest = new MarkDefaultRequest();
        if(accountId!= null) markDefaultRequest.setAccountId(Integer.parseInt(accountId));
        requestMarkDefaultDevice.setRequest(markDefaultRequest);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestMarkDefaultDevice.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_DEFAULT);
        String jsonString = mapper.writeValueAsString(requestMarkDefaultDevice);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "PUT", jsonString, getClass().toString());
        result = execConnection.executeRequest();
        return result;

    }
}
