package com.tracfone.generic.myaccountlibrary.restrequest;

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

/**
 * Created by hserna on 8/29/2017.
 */

public class RewardTokenRetrievalRequest extends SpiceRequest<String> {
    public RewardTokenRetrievalRequest() {
        super(String.class);
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String url = RestfulURL.getUrl(RestfulURL.REWARD_TOKEN_RETRIEVAL, GlobalLibraryValues.getBrand());
        url = String.format(url, GlobalOauthValues.getAccountId());

        String result = null;

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }
}
