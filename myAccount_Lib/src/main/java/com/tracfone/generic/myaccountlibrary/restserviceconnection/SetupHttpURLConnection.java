package com.tracfone.generic.myaccountlibrary.restserviceconnection;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 * This class contains methods whick will setup an HTTP URL connection
 * for accessing the tracfone backend.
 *  
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/


import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter; 
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.OauthConstants;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.exception.InvalidTokenTypeException;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.exception.TokenRequestException;
import com.tracfone.generic.myaccountlibrary.restrequest.RestfulURL;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues; 
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.OAuth;
import com.tracfone.generic.myaccountlibrary.Util;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseEmpty;


public class SetupHttpURLConnection {

	public static String OAUTH_TYPE_CCU = "TYPE_CCU";
	public static String OAUTH_TYPE_CCU_FB =  "TYPE_CCU_FB";
	public static String OAUTH_TYPE_RONS = "TYPE_RONS";
	public static String OAUTH_TYPE_RO = "TYPE_RO";
	public static String OAUTH_TYPE_ROLIMITED = "TYPE_ROLIMITED";
	public static String OAUTH_TYPE_RO_CCP = "TYPE_RO_CPP";
	public static int     ERROR_5000_EXPIRED_TOKEN = 5000;
	private String oauthMinimumAccessRequestType;

	private TracfoneLogger tfLogger;
	private HttpURLConnection connection = null;
	private String url,method,body,className;

	
	/**
	 * Constructor which will use the OAUTH access token for the request
	 */
	public SetupHttpURLConnection (String oauthMinimumAccessRequestType, String url, String method, String body, String className){
		this.oauthMinimumAccessRequestType = oauthMinimumAccessRequestType;
		this.url = url;
		this.method = method;
		this.body = body;
		this.className = className;
	}

	/**
	 *  This method will execute a web service request.  The method will determine the correct type of
	 *  request to be made.
	 *
	 * @return 			  The json response from the server or null upon failure
	 */
	public String executeRequest() throws Exception {
		String result="";
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_CCU)) {
			Log.v("hds","here1");
			result = executeCCURequest();
		}
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_CCU_FB)) {
			result = executeCCURequest();
		}
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_RONS)) {
			result = executeRORequest();
		}
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_RO)) {
			if (!GlobalOauthValues.getIsROLimitedLogin()) {
				result = executeRORequest();
			} else {
				//Change request to Limited if logged in with limited credentials
				oauthMinimumAccessRequestType = OAUTH_TYPE_ROLIMITED;
				result = executeRORequest();
			}
		}
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_RO_CCP)) {
			result = executeRORequest();
		}

		return result;
	}

	/**
	 *  This method will setup and execute a CCU web service request.  It will handle the case where a CCU
	 *  token is not available.  If the token is not available a token request will be made.
	 *
	 * @return 			  The json response from the server or null upon failure
	 */
	private String executeCCURequest() throws Exception {
		Log.v("hds","here2");
		tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_CCU)) {
			tfLogger.add(className,"loadDataFromNetwork","CCU Service Request");
		}
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_CCU_FB)) {
			tfLogger.add(className,"loadDataFromNetwork","CCU FB Service Request");
		}

		if (!GlobalOauthValues.isTokenValidCCU()) {
			tfLogger.add(className,"loadDataFromNetwork","Request new CCU token");
			try {
				String authorizationUrl = RestfulURL.getUrl(RestfulURL.OAUTH_TOKEN_CLIENT_CREDENTIALS_UNPROTECTED, GlobalLibraryValues.getBrand());
				Log.v("Authorization URL", authorizationUrl);
				OAuth oAuth = new OAuth(authorizationUrl);
				oAuth.requestCCUToken();
			}
			catch (Exception e) {
				tfLogger.add(className,"loadDataFromNetwork","CCU token Request Exception");
				tfLogger.close();
				throw e;
			}
		}

		tfLogger.add(className,"loadDataFromNetwork", method + " url: " + url);
		if (body != null) tfLogger.add(className,"loadDataFromNetwork","request body: " + body);
		connection = initializeConnection(connection, oauthMinimumAccessRequestType, url, method, body);

		int statusCode = -1;
		String result="";
		String response="";
		try {
			statusCode  = connection.getResponseCode();
			tfLogger.add(className,"loadDataFromNetwork","request response code: " + statusCode);
			if (statusCode == HttpURLConnection.HTTP_OK) { // 200
				result = Util.streamToString(connection.getInputStream());

			}
		}
		finally {
			connection.disconnect();
			tfLogger.close();
			url = ""; //clear url to remove from heap (security purposes)
			body = ""; //clear body to remove from heap (security purposes)
		}
		tfLogger.close();  //additional disconnect for security audit
		return result;
	}


	/**
	 *  This method will execute a RO web service request.  It will handle the case where a oauth token expires
	 *  and will attempt to get a new token and retry the service with the new token.
	 *
	 * @return 			  The json response from the server or null upon failure
	 */
	public String executeRORequest() throws Exception {

		String requestType = ""; //The type of R0 request to be made

		tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
		//An exception will occur if the refresh token request fails
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_RONS)) {
			GlobalOauthValues.isTokenValidRONS(); //Called to log token status
			tfLogger.add(className, "loadDataFromNetwork", "R0NS Service Request");
			if (GlobalOauthValues.isTokenRONSPresent()) {
				requestType = OAUTH_TYPE_RONS;
			} else {
				//This may be a FB or Limted login.  If R0NS not present attempt R0 or ROLimted request
				tfLogger.add(className, "loadDataFromNetwork", "Switch to R0 FB CCP request or ROLimited Request");
				//Check is the R0 or ROLimted token is present
				GlobalOauthValues.isTokenValidROorCCP(); //Called to log token status
				GlobalOauthValues.isTokenValidROLimited(); //Called to log token status
				if (GlobalOauthValues.isTokenROorCCPPresent()) {
					tfLogger.add(className, "loadDataFromNetwork", "R0 FB CPP Service Request");
					requestType = OAUTH_TYPE_RO_CCP;
				} else if (GlobalOauthValues.isTokenROLimitedPresent()) {
					tfLogger.add(className, "loadDataFromNetwork", "R0Limited Service Request");
					requestType = OAUTH_TYPE_ROLIMITED;
				} else {
					throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_RO_CCP_AUTH_TOKEN);
				}
			}
		}
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_RO)) {
			GlobalOauthValues.isTokenValidROorCCP(); //Called to log token status
			tfLogger.add(className, "loadDataFromNetwork", "R01 Service Request");
			requestType = OAUTH_TYPE_RO;
			if (!GlobalOauthValues.isTokenROorCCPPresent()) {
				throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_RO_CCP_AUTH_TOKEN);
			}
		}
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_ROLIMITED)) {
			GlobalOauthValues.isTokenValidROLimited(); //Called to log token status
			tfLogger.add(className, "loadDataFromNetwork", "R0Limited Service Request");
			requestType = OAUTH_TYPE_ROLIMITED;
			if (!GlobalOauthValues.isTokenROLimitedPresent()) {
				throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_ROLIMITED_REFRESH_TOKEN);
			}
		}
		if (oauthMinimumAccessRequestType.equals(OAUTH_TYPE_RO_CCP)) {
			GlobalOauthValues.isTokenValidROorCCP(); //Called to log token status
			tfLogger.add(className, "loadDataFromNetwork", "R01 FB Service Request");
			requestType = OAUTH_TYPE_RO_CCP;
			if (!GlobalOauthValues.isTokenROorCCPPresent()) {
				throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_RO_CCP_AUTH_TOKEN);
			}
		}

		tfLogger.add(className,"loadDataFromNetwork", method + " url: " + url);
		if (body != null) tfLogger.add(className,"loadDataFromNetwork","request body: " + body);
		connection = initializeConnection(connection, requestType, url, method, body);

		int statusCode = -1;
		String result="";
		String response="";
		try {
			statusCode  = connection.getResponseCode();
			tfLogger.add(className,"loadDataFromNetwork","request response code: " + statusCode);
			if (statusCode == HttpURLConnection.HTTP_OK) { // 200
				result = Util.streamToString(connection.getInputStream());
			}
			if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_INTERNAL_ERROR) { // 401 or 500
				response = Util.streamToString(connection.getErrorStream());
				tfLogger.add(className,"loadDataFromNetwork","HTTP error result: " + response);
				ObjectMapper mapper = new ObjectMapper();
				ResponseEmpty failureResponse;
				failureResponse  = mapper.readValue(response, ResponseEmpty.class);
				if(failureResponse.getStatus().getResponseType().equals("FAILURE")) {
					result = response;
				}
				result = TokenExpiryCheck(failureResponse, statusCode, requestType);
			}

		}
		catch (IOException e) {
			statusCode = connection.getResponseCode();
			ResponseEmpty failureResponse;
			tfLogger.add(className,"loadDataFromNetwork","request exception response code: " + statusCode);
			if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED  || statusCode == HttpURLConnection.HTTP_INTERNAL_ERROR) { // 401 or 500
				response = Util.streamToString(connection.getErrorStream());
				tfLogger.add(className,"loadDataFromNetwork","exception result: " + response);
				ObjectMapper mapper = new ObjectMapper();
				failureResponse  = mapper.readValue(response, ResponseEmpty.class);
				if(failureResponse.getStatus().getResponseType().equals("FAILURE")) {
					result = TokenExpiryCheck(failureResponse, statusCode, requestType);
				} else {
					throw e;
				}
			}
			else {
				throw e;
			}
		}
		finally {
			connection.disconnect();
			tfLogger.close();
			url = ""; //clear url to remove from heap (security purposes)
			body = ""; //clear body to remove from heap (security purposes)
		}
		url = ""; //clear url to remove from heap (security purposes)
		body = ""; //clear body to remove from heap (security purposes)
		connection.disconnect(); //additional disconnect for security audit
		tfLogger.close();  //additional disconnect for security audit
		return result;
	}

	//this method will check if the Oauth Access Token is expired then it will request new Access Token with Refresh Token
	private String TokenExpiryCheck(ResponseEmpty failureResponse, int statusCode, String requestType) throws Exception{

		String result2="";
		String response2="";

		if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED && failureResponse.getStatus().getResponseCode().equals(Integer.toString(ERROR_5000_EXPIRED_TOKEN))) {
			// The oauth token is expired
			tfLogger.add(className,"loadDataFromNetwork","Request new token");
			String authorizationUrl = RestfulURL.getUrl(RestfulURL.OAUTH_TOKEN_RESOURCE_OWNER, GlobalLibraryValues.getBrand());
			OAuth oAuth = new OAuth(authorizationUrl);

			//An exception will occur if no refresh token available
			if (requestType.equals(OAUTH_TYPE_RONS)) {
				if(GlobalOauthValues.isRefreshTokenRONSPresent()) {
					oAuth.refreshAccessToken(OauthConstants.RONS_TOKEN);
				} else {
					throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_RONS_REFRESH_TOKEN);
				}
			}
			if (requestType.equals(OAUTH_TYPE_RO)) {
				if(GlobalOauthValues.isRefreshTokenROorCCPPresent()) {
					oAuth.refreshAccessToken(OauthConstants.RO_TOKEN);
				} else {
					throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_RO_CCP_REFRESH_TOKEN);
				}
			}
			if (requestType.equals(OAUTH_TYPE_ROLIMITED)) {
				if(GlobalOauthValues.isRefreshTokenROLimitedPresent()) {
					oAuth.refreshAccessToken(OauthConstants.ROLIMITED_TOKEN);
				} else {
					throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_ROLIMITED_REFRESH_TOKEN);
				}
			}
			if (requestType.equals(OAUTH_TYPE_RO_CCP)) {
				if(GlobalOauthValues.isRefreshTokenROorCCPPresent()) {
					oAuth.refreshAccessToken(OauthConstants.RO_TOKEN);
				} else {
					throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_RO_CCP_REFRESH_TOKEN);
				}
			}

			//Attempt request again with new token
			tfLogger.add(className, "loadDataFromNetwork", "New Token Received");
			HttpURLConnection connection2 = null;
			connection2 = initializeConnection(connection2, requestType, url, method, body);

			int statusCode2 = -1;

			try {
				statusCode2  = connection2.getResponseCode();
				tfLogger.add(className,"loadDataFromNetwork","request response code 2: " + statusCode2);
				if (statusCode2 == HttpURLConnection.HTTP_OK) { // 200
					result2 = Util.streamToString(connection2.getInputStream());

				}
				if (statusCode2 == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode2 == HttpURLConnection.HTTP_INTERNAL_ERROR) { // 401 or 500
					response2 = Util.streamToString(connection2.getErrorStream());
					tfLogger.add(className,"loadDataFromNetwork","HTTP error 2 result: " + response2);
					ObjectMapper mapper2 = new ObjectMapper();
					ResponseEmpty failureResponse2;
					failureResponse2  = mapper2.readValue(response2, ResponseEmpty.class);
					if(failureResponse2.getStatus().getResponseType().equals("FAILURE")) {
						if (Integer.parseInt(failureResponse2.getStatus().getResponseCode()) == TokenRequestException.REFRESH_TOKEN_EXPIRED_SERVICE_FAILURE_CODE) {
							if (requestType.equals(OAUTH_TYPE_RONS)) {
								throw new TokenRequestException(TokenRequestException.RONS_REFRESH_FAILURE);
							}
							if (requestType.equals(OAUTH_TYPE_RO) || requestType.equals(OAUTH_TYPE_RO_CCP)) {
								throw new TokenRequestException(TokenRequestException.RO_CCP_REFRESH_FAILURE);
							}
							if (requestType.equals(OAUTH_TYPE_ROLIMITED)) {
								throw new TokenRequestException(TokenRequestException.ROLIMITED_REFRESH_FAILURE);
							}
						} else {
							if (requestType.equals(OAUTH_TYPE_RONS)) {
								throw new TokenRequestException(TokenRequestException.RONS_REFRESH_FAILURE + failureResponse2.getStatus().getResponseCode() );
							}
							if (requestType.equals(OAUTH_TYPE_RO) || requestType.equals(OAUTH_TYPE_RO_CCP)) {
								throw new TokenRequestException(TokenRequestException.RO_CCP_UNKNOWN_REFRESH_FAILURE + failureResponse2.getStatus().getResponseCode());
							}
							if (requestType.equals(OAUTH_TYPE_ROLIMITED)) {
								throw new TokenRequestException(TokenRequestException.ROLIMITED_UNKNOWN_REFRESH_FAILURE + failureResponse2.getStatus().getResponseCode());
							}
						}
					}
				}
			} catch (IOException e) {
				statusCode2 = connection2.getResponseCode();
				tfLogger.add(className,"loadDataFromNetwork","request exception 2 response code: " + statusCode2);
				if (statusCode2 == HttpURLConnection.HTTP_UNAUTHORIZED  || statusCode2 == HttpURLConnection.HTTP_INTERNAL_ERROR) { // 401 or 500
					response2 = Util.streamToString(connection2.getErrorStream());
					tfLogger.add(className,"loadDataFromNetwork","exception 2 result: " + response2);
					ObjectMapper mapper2 = new ObjectMapper();
					ResponseEmpty failureResponse2;
					failureResponse2  = mapper2.readValue(response2, ResponseEmpty.class);
					if(failureResponse2.getStatus().getResponseType().equals("FAILURE")) {
						if (Integer.parseInt(failureResponse2.getStatus().getResponseCode()) == TokenRequestException.REFRESH_TOKEN_EXPIRED_SERVICE_FAILURE_CODE) {
							if (requestType.equals(OAUTH_TYPE_RONS)) {
								throw new TokenRequestException(TokenRequestException.RONS_REFRESH_FAILURE);
							}
							if (requestType.equals(OAUTH_TYPE_RO) || requestType.equals(OAUTH_TYPE_RO_CCP)) {
								throw new TokenRequestException(TokenRequestException.RO_CCP_REFRESH_FAILURE);
							}
							if (requestType.equals(OAUTH_TYPE_ROLIMITED)) {
								throw new TokenRequestException(TokenRequestException.ROLIMITED_REFRESH_FAILURE);
							}
						} else {
							if (requestType.equals(OAUTH_TYPE_RONS)) {
								throw new TokenRequestException(TokenRequestException.RONS_REFRESH_FAILURE + failureResponse2.getStatus().getResponseCode() );
							}
							if (requestType.equals(OAUTH_TYPE_RO) || requestType.equals(OAUTH_TYPE_RO_CCP)) {
								throw new TokenRequestException(TokenRequestException.RO_CCP_UNKNOWN_REFRESH_FAILURE + failureResponse2.getStatus().getResponseCode());
							}
							if (requestType.equals(OAUTH_TYPE_ROLIMITED)) {
								throw new TokenRequestException(TokenRequestException.ROLIMITED_UNKNOWN_REFRESH_FAILURE + failureResponse2.getStatus().getResponseCode());
							}
						}
					}
				} else {
					throw e;
				}
			}
			finally {
				connection2.disconnect();
			}
			connection2.disconnect();
		} else {
			String ErrorResponse = "\nStatus Code  "+String.valueOf(statusCode)+"\nResponse Code  "+failureResponse.getStatus().getResponseCode()
					+ "\nResponse Description  " + failureResponse.getStatus().getResponseDescription() + "\nResponse Status  " + failureResponse.getStatus().getResponseType();
			throw new UnexpectedException(ErrorResponse);
		}
		return result2;
	}

	/**
	 * This method will initialize the url connection
	 * 
	 * @param cont
	 * @param url
	 * @param method
	 * @param body
	 * @return
	 * @throws Exception
	 */
	private HttpURLConnection initializeConnection(HttpURLConnection cont, String requestType, String url, String method, String body) throws Exception {

		cont = setHttpsConnection(url);
		/*if (url.substring(0, 5).equals("https")) {
			cont = setHttpsConnection(url); 
		} else {
			cont = (HttpURLConnection) new URL(url).openConnection();
		}*/
		setHeader(cont, requestType);
		cont.setRequestMethod(method); 
		if(method.equals("POST") || method.equals("PUT")) cont.setDoOutput(true);

		if (body != null) {
			//Write Body
			OutputStreamWriter out = new   OutputStreamWriter(cont.getOutputStream());
			out.write(body);
			out.close();  
		}

		return cont; 
	}

	/**
	 * Set up the header information of the URL connection
	 * 
	 * @param connection  
	 * @throws Exception
	 */
	private void setHeader(HttpURLConnection connection, String oauthRequestType) throws Exception{
		
		connection.setRequestProperty("Content-type", "application/json");

		//Set access token
		if (oauthRequestType.equals(OAUTH_TYPE_CCU)) {
			connection.setRequestProperty("Authorization", "Bearer " + URLEncoder.encode(GlobalOauthValues.getAuthTokenCCU(), "UTF-8"));
		}
		if (oauthRequestType.equals(OAUTH_TYPE_CCU_FB)) {
			connection.setRequestProperty("Authorization", "Bearer " + URLEncoder.encode(GlobalOauthValues.getAuthTokenCCU(), "UTF-8"));
			connection.setRequestProperty("FBToken",  URLEncoder.encode(GlobalOauthValues.getAuthTokenFB(),"UTF-8"));
		}
		if (oauthRequestType.equals(OAUTH_TYPE_RONS)) {
			connection.setRequestProperty("Authorization", "Bearer " + URLEncoder.encode(GlobalOauthValues.getAuthTokenRONS(), "UTF-8"));
		}
		if (oauthRequestType.equals(OAUTH_TYPE_RO)) {
			connection.setRequestProperty("Authorization", "Bearer " + URLEncoder.encode(GlobalOauthValues.getAuthTokenROorCCP(), "UTF-8"));
		}
		if (oauthRequestType.equals(OAUTH_TYPE_RO_CCP)) {
			connection.setRequestProperty("Authorization", "Bearer " + URLEncoder.encode(GlobalOauthValues.getAuthTokenROorCCP(), "UTF-8"));
			connection.setRequestProperty("FBToken",  URLEncoder.encode(GlobalOauthValues.getAuthTokenFB(),"UTF-8"));
		}
		if (oauthRequestType.equals(OAUTH_TYPE_ROLIMITED)) {
			connection.setRequestProperty("Authorization", "Bearer " + URLEncoder.encode(GlobalOauthValues.getAuthTokenROLimited(), "UTF-8"));
		}
	}


	/**
	 * The method will create an open connection to the web service server
	 * 
	 * @param url  the url of the web service
	 * @return a https url connection
	 */
	private HttpsURLConnection setHttpsConnection(String url)  {
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
