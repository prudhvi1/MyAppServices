package com.tracfone.generic.myaccountlibrary.restrequest;

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class HandsetProtectionProgramsRequest extends SpiceRequest<String> {

    private String min;
    public HandsetProtectionProgramsRequest(String min) {
        super(String.class);
        this.min = min;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.HANDSET_PROTECTION_AVAILABLE_PROGRAMS, GlobalLibraryValues.getBrand());
        url = String.format(url,min);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "GET", null, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }
    /**
     * This method generates a unique cache key for this request. In this case our cache key is a combination of keyword Payment Sources and the account Id.
     * @return
     */
    public String createCacheKey() {
        return RestConstants.PROTECTION_PLANS + min;
    }

}

