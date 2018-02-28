package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.CheckPointsResources;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RequestVerificationCode;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;
import java.util.ArrayList;

/**
 * Created by hserna on 8/1/2017.
 */

public class DeviceVerificationCodeRequest extends SpiceRequest<String> {

    ArrayList<CheckPointsResources> checkPointsResources;
    String verificationCodeRequestType;
    public static final String VERIFICATION_REQUEST_TYPE_SEND = "send";
    public static final String VERIFICATION_REQUEST_TYPE_VALIDATE = "validate";

    public DeviceVerificationCodeRequest(ArrayList<CheckPointsResources> checkPointsResources, String verificationCodeRequestType) {
        super(String.class);
        this.checkPointsResources = checkPointsResources;
        this.verificationCodeRequestType = verificationCodeRequestType;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String result =null;
        String url = RestfulURL.getUrl(RestfulURL.VERIFICATION_CODE, GlobalLibraryValues.getBrand());
        if(verificationCodeRequestType.equals(DeviceVerificationCodeRequest.VERIFICATION_REQUEST_TYPE_VALIDATE)){
            url=String.format(url, "/"+VERIFICATION_REQUEST_TYPE_VALIDATE);
        }
       else {
            url=String.format(url, "");
        }
        RequestVerificationCode requestVerificationCode = new RequestVerificationCode();
        RequestVerificationCode.VerificationCodeRequest verificationCodeRequest = new RequestVerificationCode.VerificationCodeRequest();
        verificationCodeRequest.setCheckPointsResources(checkPointsResources);
        requestVerificationCode.setVerificationCodeRequest(verificationCodeRequest);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestVerificationCode.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(requestVerificationCode);
        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }
}
