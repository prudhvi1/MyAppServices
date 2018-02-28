package com.tracfone.generic.myaccountlibrary.oauth2serviceconnection;
/*************************************************************************** 
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *
 * This class gets Oauth CCU response and parse parameters
 * @author mgokhanilhan
 *	
 * 	
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2015,  All Rights Reserved
 *
 *  
 * ****************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;

public class Response {

	private int statusCode;
	private String requestUrl;
	private String stringResponse = "";
	private HashMap<String, String> parameterList;
	private HttpURLConnection urlConnection;

	public Response() throws Exception{}

	public Response(HttpURLConnection urlConnection) throws Exception {
		this.urlConnection = urlConnection;
		this.statusCode = this.urlConnection.getResponseCode();
		StringBuffer response = null;
		if (statusCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}

		if(response != null) {
			if (response.toString() != null) {
				this.stringResponse = response.toString();
			} else {
				this.stringResponse = "";
			}
		}else{
			this.stringResponse = "";
		}
	}

	public String getResponseString() {
		return this.stringResponse;
	}

	public int getResponseStatusCode() {
		return this.statusCode;
	}

}
