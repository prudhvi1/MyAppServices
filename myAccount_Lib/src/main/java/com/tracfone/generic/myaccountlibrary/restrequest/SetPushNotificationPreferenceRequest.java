package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.TagDetails;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestSetPushNotificationPreference;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.ArrayList;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make to SetPushNotificationPreferenceRequest restful web service request.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/
public class SetPushNotificationPreferenceRequest extends SpiceRequest<String> {

    int accountId;
    ArrayList<TagDetails> prefTagList;

    public SetPushNotificationPreferenceRequest(int accountId, ArrayList<TagDetails> prefTagList) {
        super(String.class);
        this.accountId = accountId;
        this.prefTagList = prefTagList;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.SET_PUSH_PREF, GlobalLibraryValues.getBrand());

        //Convert preference date to correct format for service
        ArrayList<RequestSetPushNotificationPreference.PushNotificationPreferenceRequest.Devices> prefListDevices = new ArrayList<>();
        for(TagDetails tagDetails : prefTagList){
            RequestSetPushNotificationPreference.PushNotificationPreferenceRequest.Devices devices = new RequestSetPushNotificationPreference.PushNotificationPreferenceRequest.Devices();
            devices.setMin(tagDetails.getMin());
            devices.setEsn(tagDetails.getEsn());
            if(tagDetails.getPreference())
                devices.setPreference(true);
            else
                devices.setPreference(false);
            prefListDevices.add(devices);
        }

        RequestSetPushNotificationPreference setPreference = new RequestSetPushNotificationPreference();
        RequestSetPushNotificationPreference.PushNotificationPreferenceRequest preferenceRequest = new RequestSetPushNotificationPreference.PushNotificationPreferenceRequest();
        preferenceRequest.setAccountId(accountId);
        preferenceRequest.setDevicesList(prefListDevices);
        setPreference.setRequest(preferenceRequest);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        setPreference.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(setPreference);
        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";
        jsonString = "";

        return result;
    }

}
