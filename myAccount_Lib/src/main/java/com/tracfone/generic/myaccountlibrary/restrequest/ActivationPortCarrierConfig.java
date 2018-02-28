package com.tracfone.generic.myaccountlibrary.restrequest;

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.net.URLEncoder;

/**
 * Created by skishore on 10/19/2016.
 */

public class ActivationPortCarrierConfig extends SpiceRequest<String> {
    String name;
    String lineType;

    public ActivationPortCarrierConfig(String name,String portType) {
        super(String.class);
        this.name = name;
        this.lineType = portType;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String url =  RestfulURL.getUrl(RestfulURL.PORT_CARRIER_CONFIG, GlobalLibraryValues.getBrand());
        name = URLEncoder.encode(name, "UTF-8");
        lineType = URLEncoder.encode(lineType, "UTF-8");
        url = String.format(url,name,lineType);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString() );
        String result = execConnection.executeRequest();

        return result;
    }
}
