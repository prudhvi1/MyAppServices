package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEmpty;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

/**
 * Created by skishore on 10/19/2016.
 */

public class ActivationServiceProviderRequest extends SpiceRequest<String> {

    public ActivationServiceProviderRequest(){ super(String.class );
    }
    @Override
    public String loadDataFromNetwork() throws Exception {

        String url =  RestfulURL.getUrl(RestfulURL.SERVICE_PROVIDER_CONFIG, GlobalLibraryValues.getBrand());
        String result = null;

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString() );
        result = execConnection.executeRequest();

        return result;
    }
}
