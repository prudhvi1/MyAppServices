package com.tracfone.generic.myaccountlibrary.restrequest;

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.net.URLEncoder;

/**
 * Created by skishore on 10/19/2016.
 */

public class ActivationPortCarrierList extends SpiceRequest<String> {

    public ActivationPortCarrierList() {
        super(String.class);

    }


    @Override
    public String loadDataFromNetwork() throws Exception {
        String url =  RestfulURL.getUrl(RestfulURL.PORT_CARRIER_LIST, GlobalLibraryValues.getBrand());


        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString() );
        String result = execConnection.executeRequest();

        return result;
    }
}
