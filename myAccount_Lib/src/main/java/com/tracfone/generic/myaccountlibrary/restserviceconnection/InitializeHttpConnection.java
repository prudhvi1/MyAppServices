package com.tracfone.generic.myaccountlibrary.restserviceconnection;

import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;

import javax.net.ssl.HttpsURLConnection;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * Initialize UrlConnection based on http or https request
 * Created by mgokhanilhan on 10/14/2015.
 *
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2015,  All Rights Reserved
 *
 *
 * ****************************************************************************/

public class InitializeHttpConnection {

    /**
     * The method will create an open connection to the web service server
     *
     * @param url  the url of the web service
     * @return a https url connection
     */
    private static HttpsURLConnection setHttpsConnection(String url)  {
        HttpsURLConnection httpsConnection = null;
        if (ReleaseFlavorConfig.PRODUCTION_SSL) {
            //Secure server connection
            HttpsEstablishProdutionServerConnection serverHelper = new HttpsEstablishProdutionServerConnection();
            httpsConnection = serverHelper.SetupConnection(url);
        } else {
            //Insecure server connection
            HttpsEstablishDevServerConnection serverHelper = new HttpsEstablishDevServerConnection();
            httpsConnection = serverHelper.SetupConnection(url);
        }
        return httpsConnection;
    }
}
