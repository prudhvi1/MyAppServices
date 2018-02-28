package com.tracfone.generic.myaccountlibrary.restrequest;

/**
 * *****************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 * <p/>
 * CLASS DESCRIPTION:
 * <p/>
 * This class will perform Add device Restful web service request to add user
 * device into the account.
 * <p/>
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * <p/>
 * *****************************************************************************
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAddDevice;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAddDevice.AddDeviceToAccountRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;


public class AddDeviceAccountRequest extends SpiceRequest<String> {

    int accountId;
    String min;
    String esn;
    String groupId;
    int groupPlanId;

    /**
     * Constuctor for Add Device Request
     */

    public AddDeviceAccountRequest(String accountId, String min, String esn , String groupId,int groupPlanId) {
        super(String.class);
        this.accountId = Integer.parseInt(accountId);
        this.min = min;
        this.esn = esn;
        this.groupId = groupId;
        this.groupPlanId = groupPlanId;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String url = RestfulURL.getUrl(RestfulURL.ADD_DEVICE_TO_ACCOUNT, GlobalLibraryValues.getBrand());
        url = String.format(url, accountId);
        if (esn == null || esn.isEmpty()) url = String.format(url, "min/" + min);
        else if (min == null || min.isEmpty()) url = String.format(url, "esn/" + esn);
        else if (!min.isEmpty() && !esn.isEmpty()) {
            if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min);
            else url = String.format(url, "esn/" + esn);
        }

        String result = null;

        //populate and create body
        RequestAddDevice addDevice = new RequestAddDevice();
        AddDeviceToAccountRequest addDeviceRequest = new AddDeviceToAccountRequest();

        if(!min.isEmpty())
        addDeviceRequest.setMin(min);
        addDeviceRequest.setEsn(esn);
        if(groupId!=null)
        addDeviceRequest.setGroupId(groupId);
        if(groupPlanId !=-1)
        addDeviceRequest.setGroupPlanId(groupPlanId);

        addDevice.setRequest(addDeviceRequest);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        addDevice.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
     //   mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(addDevice);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        return result;

    }
}

