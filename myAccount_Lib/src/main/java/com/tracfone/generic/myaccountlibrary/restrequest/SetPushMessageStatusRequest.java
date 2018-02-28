package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestSetPushMessageStatus;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestSetPushMessageStatus.SetPushMessageStatus;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestSetPushMessageStatus.SetPushMessageStatus.MessageProperties;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make to SetPushMessageStatusRequest restful web service request.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

public class SetPushMessageStatusRequest extends SpiceRequest<String> {

    ArrayList<MessageProperties> MessagePropertiesList;

    public SetPushMessageStatusRequest(ArrayList<MessageProperties> MessagePropertiesList) {
        super(String.class);
        this.MessagePropertiesList = MessagePropertiesList;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.SET_PUSH_MESSAGE_STATUS, GlobalLibraryValues.getBrand());

        RequestSetPushMessageStatus requestSetPushMessageStatus =  new RequestSetPushMessageStatus();
        SetPushMessageStatus setPushMessageStatus = new SetPushMessageStatus();
        setPushMessageStatus.setMessagePropertiesList(MessagePropertiesList);
        requestSetPushMessageStatus.setRequest(setPushMessageStatus);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestSetPushMessageStatus.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(requestSetPushMessageStatus);
        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();
        return result;
    }
}
