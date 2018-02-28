/*************************************************************************** 
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * HTTP connection Class 
 *   - GOKHAN
 *	
 * 	
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/
package com.tracfone.generic.myaccountlibrary.oauth2serviceconnection;
/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class is SetUp HttpUrlConnection for Oauth requests
 * @author mgokhanilhan
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2015,  All Rights Reserved
 *
 *
 * ****************************************************************************/
import android.util.Log;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.HttpsEstablishDevServerConnection;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.HttpsEstablishProdutionServerConnection;
import javax.net.ssl.HttpsURLConnection;


/**
 * The Connection class contains static methods used to connect to any url given.
 * In addition to the methods it holds predefined values that can be used to identify
 * the http-method in a standardized way.
 */
public class Connection {

	/**
	 *
	 * Makes a standard http post request. The list of NameValuePairs can contain
	 * all parameters and parameter designations for the request.
	 *
	 * #@param parameterList
	 * #@param url
	 * #@return <code>Response</code> with the servers response
	 * #@throws Exception
	 */
	public static Response httpPostRequest(HashMap<String,String> parameterList, String url) throws Exception{

		HttpURLConnection cont =  setHttpsConnection(url);
		/*HttpURLConnection cont = null;
		if (url.substring(0, 5).equals("https")) {
			cont = setHttpsConnection(url);
		} else {
			cont = (HttpURLConnection) new URL(url).openConnection();
		}*/


		cont.setRequestMethod("POST");
		cont.setDoInput(true);
		cont.setDoOutput(true);
		cont.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		OutputStream output = cont.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
		writer.write(getPostDataString(parameterList));

		writer.flush();
		writer.close();
		output.close();

		Response response = new Response(cont);

		return response;

	}

	private static String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException{
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for(Map.Entry<String, String> entry : params.entrySet()){
			if (first)
				first = false;
			else
				result.append("&");

			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		return result.toString();
	}


	/**
	 * The method will create an open connection to the web service server
	 *
	 * @param url  the url of the web service
	 * @return a https url connection
	 */
	public static HttpsURLConnection setHttpsConnection(String url)  {
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
