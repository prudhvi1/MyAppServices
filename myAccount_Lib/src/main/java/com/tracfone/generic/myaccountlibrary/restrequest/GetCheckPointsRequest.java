package com.tracfone.generic.myaccountlibrary.restrequest;

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

/**
 * Created by hserna on 8/1/2017.
 */

public class GetCheckPointsRequest extends SpiceRequest<String> {

    private String min;

    public GetCheckPointsRequest(String min){
        super(String.class);
        this.min = min;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String result = null;
        String url = RestfulURL.getUrl(RestfulURL.CHECK_POINTS, GlobalLibraryValues.getBrand());

        url = String.format(url, min);
        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }
}
