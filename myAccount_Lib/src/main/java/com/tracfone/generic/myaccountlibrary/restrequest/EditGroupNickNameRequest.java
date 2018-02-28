package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditNickName;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

/**
 * Created by atatipally on 5/19/2016.
 */
public class EditGroupNickNameRequest extends SpiceRequest<String> {

    String newNickName;
    String groupId;
    String accountId;

    public EditGroupNickNameRequest(String newNickName,String groupId,String accountId) {
        super(String.class);
        this.newNickName = newNickName;
        this.groupId = groupId;
        this.accountId = accountId;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String result = null;

        String url =  RestfulURL.getUrl(RestfulURL.UPDATE_GROUP_NICKNAME, GlobalLibraryValues.getBrand());
        url = String.format(url,groupId);

        //Populate and create Body
        RequestEditNickName editNickName = new RequestEditNickName();
        RequestEditNickName.NickNameRequest nickNameRequest = new RequestEditNickName.NickNameRequest();
        nickNameRequest.setNickName(newNickName);
        nickNameRequest.setAccountId(Integer.parseInt(accountId));
        editNickName.setRequest(nickNameRequest);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        editNickName.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(editNickName);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "PUT", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }
}