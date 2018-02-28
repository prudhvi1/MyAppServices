
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
 * 	WARNING WARNING WARNING: THIS CLASS IS NOT TO BE USED IN A RELEASE CONFIGURATION
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * *************************************************************************************/

import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.LibraryConstants;

import android.util.Log;

/**
 * @author sramprasad
 *
 */
public class HttpsEstablishDevServerConnection {

	public HttpsURLConnection httpsConnection = null;

	/*
	 *  @author: sramprasad
	 *  @method: SetupDevConnection
	 *  @param: url: The absolute url in string format providing the location of the resource.
	 *  @return: The return value is an NULL if the code errors out. Otherwise it is a valid connection.
	 *  @see: HttpsURLConnection.
	 */
	public HttpsURLConnection SetupConnection(String url) 
	{

		// If not https URL, return NULL.
		if (url.substring(0, 5).equals("https")) 
		{

			// Imports: javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager
			try {
				// Create a trust manager that does not validate certificate chains
				final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
					@Override
					public void checkClientTrusted( final X509Certificate[] chain, final String authType ) {
					}
					@Override
					public void checkServerTrusted( final X509Certificate[] chain, final String authType ) {
					}
					@Override
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
				} };

				// Install the all-trusting trust manager
				final SSLContext sslContext = SSLContext.getInstance( "TLS" );

				sslContext.init( null, trustAllCerts, new java.security.SecureRandom() );

				// Create an ssl socket factory with our all-trusting manager
				final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

				// Create all-trusting host name verifier
				HostnameVerifier allHostsValid = new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}};

					// Install the all-trusting host verifier
					HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid); 		    


					// All set up, we can get a resource through https now:
					httpsConnection = (HttpsURLConnection) new URL( url ).openConnection();

					// Tell the url connection object to use our socket factory which bypasses security checks
					httpsConnection.setSSLSocketFactory( sslSocketFactory );

					// 60 second connect timeout.
					httpsConnection.setConnectTimeout(60000);

					// 40 second read timeout.
					httpsConnection.setReadTimeout(40000);

			}
			catch (Exception e)
			{
				if (DebugConfig.DEBUG)Log.d(LibraryConstants.TAG, "exception in creating secure socket to dev server");
			}

		}
		return httpsConnection;

	}


}
