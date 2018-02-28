
package com.tracfone.generic.myaccountlibrary.restserviceconnection;
/*************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 *  This class will establish a Https connection to the Development Tracfone server.
 * 	If invoked from a non-debug signed application, this will return NULL.
 *
 * 	THIS CLASS IS ONLY TO BE USED IN A PRODUCTION SSL CONFIGURATION
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 * sramprasad: Add linkage to the querying of the specific Production Trust Manager.
 * *************************************************************************************/
 
import java.net.URL;  
import javax.net.ssl.HttpsURLConnection;

import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.LibraryConstants;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.ssl.MyCustomTrustManager;

import android.util.Log;

/**
 * @author dsalihi
 *
 */
public class HttpsEstablishProdutionServerConnection {

	public HttpsURLConnection httpsConnection = null;

	/**
	 *  @author: dsalihi
	 *  @method: SetupDevConnection
	 *  @param: url: The absolute url in string format providing the location of the resource.
	 *  @return: The return value is an NULL if the code errors out. Otherwise it is a valid connection.
	 *  @see: HttpsURLConnection.
	 */
	public HttpsURLConnection SetupConnection(String url) 
	{

		try {
			// Create a custom trust manager now.
			TrustManager tm[] = { new MyCustomTrustManager() };
			assert (null != tm);

			// Set the protocol of the custom trustmanager to use TLS.
			SSLContext sslContext;
			if (GlobalOauthValues.getIsTLS12()) {
				sslContext = SSLContext.getInstance("TLSv1.2");
			} else {
				sslContext = SSLContext.getInstance("TLS");
			}
			assert (null != sslContext);
			// This initializes the new trust manager with the defined sslContext.
			sslContext.init(null, tm, null);


			httpsConnection = (HttpsURLConnection) new URL( url ).openConnection();

			assert (null != httpsConnection);

			if(httpsConnection instanceof HttpsURLConnection) {

				// Now ensure the new sslContext method is called.
				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
			}

		} catch (Exception e) { 
			if (DebugConfig.DEBUG)Log.d(LibraryConstants.TAG, "exception in creating secure socket to dev server");
		} 

		// 60 second connect timeout.
		httpsConnection.setConnectTimeout(60000);

		// 40 second read timeout.
		httpsConnection.setReadTimeout(40000);  
		return httpsConnection;

	}

}
