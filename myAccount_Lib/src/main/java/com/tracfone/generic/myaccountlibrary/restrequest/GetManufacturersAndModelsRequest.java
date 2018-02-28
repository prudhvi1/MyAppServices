package com.tracfone.generic.myaccountlibrary.restrequest;

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class GetManufacturersAndModelsRequest extends SpiceRequest<String> {

    public GetManufacturersAndModelsRequest() {
        super(String.class);
    }

    @Override
    public String loadDataFromNetwork() throws Exception {


        String url = RestfulURL.getUrl(RestfulURL.MANUFACTURERS_AND_MODELS, GlobalLibraryValues.getBrand());

        String result = null;
        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();
        return result;
    }

    public String createCacheKey() {
        return RestConstants.MANUFACTURER_MODELS;
    }
}

