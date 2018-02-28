package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make to APN Settings & Instructions restful web service request.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestSettingsInstructions;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class APNSettingsInstructionsRequest extends SpiceRequest<String> {

    String min, esn, operatingSystemId;

    public APNSettingsInstructionsRequest(String min, String esn, String operatingSystemId) {
        super(String.class);
        this.min= min;
        this.esn= esn;
        this.operatingSystemId=operatingSystemId;
    }
    /** Create the web service request URL by choosing the appropriate service number.
     *
     */
    @Override
    public String loadDataFromNetwork() throws Exception {
        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.GET_APN_OPERATING_SYSTEMS_SETTINGS_INSTRUCTIONS, GlobalLibraryValues.getBrand());
        if(esn==null || esn.isEmpty()) url = String.format(url,min);
        else if(min==null || min.isEmpty()) url = String.format(url,esn);
        else if (!min.isEmpty() && !esn.isEmpty()) {
            if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url,min);
            else url = String.format(url,esn);
        }

        //Populate and create Body
        RequestSettingsInstructions settingsInstructions = new RequestSettingsInstructions();
        RequestSettingsInstructions.SettingInstructionRequest settingInstructionRequest = new RequestSettingsInstructions.SettingInstructionRequest();
        settingInstructionRequest.setOperatingSystemId(operatingSystemId);

        settingsInstructions.setRequest(settingInstructionRequest);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        settingsInstructions.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(settingsInstructions);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";
        jsonString = "";

        return result;
    }
}