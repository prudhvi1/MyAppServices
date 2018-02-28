
package com.tracfone.generic.myaccountlibrary.oauth2serviceconnection;
/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class makes OAuth2 request and also adding additional parameters to request.
 * Response is returned to methods of this class.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

import android.util.Log;

import java.net.HttpURLConnection;
import java.util.HashMap;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.exception.InvalidTokenTypeException;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.exception.TokenRequestException;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseOauthCCU;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseOauthRO;


public class OAuth {

	private final String className = getClass().toString();

	private TracfoneLogger tfLogger;

	private String serverUrl;


	/**
	 * Constructs an OAuth-Object that handles the OAuth specific authorization
	 * process for all outgoing an incoming communications. Each OAuth-Object
	 * handles one Client and one service provider (Server) the Client connects
	 * to. <br>
	 * 
	 * @param serverUrl
	 *            URL of Oauth provider
	 */
	public OAuth(String serverUrl) {
		this.serverUrl = serverUrl;
	}


	/**
	 * Executes the CCU Request for an Access-Token by transmitting the
	 * <b>authorization code</b> with additional parameters. This method is
	 * <i>normally</i> used. The access token and the refresh token (if any) are
	 * automatically assigned to the client instance. See the OAuth 2.0
	 * specification for more details.<br>
	 * 
	 * @return Response containing the AccessToken or an error message from the
	 *         server.
	 * @throws Exception to RoboSpice Listener
	 */
	public Response executeCCUAccessTokenRequest() throws Exception {

		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put(OauthConstants.TITLE_GRANT_TYPE, OauthConstants.CC_GRANT_TYPE);
		parameter.put(OauthConstants.TITLE_SCOPE, OauthConstants.CCU_SCOPE);
		parameter.put(OauthConstants.TITLE_CLIENT_ID, GlobalOauthValues.getCCU_CLIENT_ID());
		parameter.put(OauthConstants.TITLE_CLIENT_SECRET, GlobalOauthValues.getCLIENT_SECRET_RO());
		parameter.put(OauthConstants.TITLE_BRAND_NAME, GlobalLibraryValues.getBrand());
		parameter.put(OauthConstants.TITLE_SOURCE_SYSTEM, OauthConstants.SOURCE_SYSTEM);

		tfLogger= new TracfoneLogger(DebugConfig.LOG_FILE);
		tfLogger.add(className,"executeCCUAccessTokenRequest","url: " + this.serverUrl);
		tfLogger.add(getClass().toString(), "executeCCUAccessTokenRequest", "Parameters CCU = " + parameter.toString());
		Log.v("Executing ccu request",this.serverUrl);
		Response response = Connection.httpPostRequest(parameter, this.serverUrl);
		tfLogger.add(className,"executeCCUAccessTokenRequest","CCU Token Request Status Code = " + response.getResponseStatusCode());
		tfLogger.add(className,"executeCCUAccessTokenRequest","CCU Token Request Response = " + response.getResponseString());
		tfLogger.close();

		if (response.getResponseStatusCode() == HttpURLConnection.HTTP_UNAUTHORIZED)
			 throw new TokenRequestException(TokenRequestException.CCU_TOKEN_REQUEST_FAILED);

		return response;
	}

	/**
	 * Executes the R0 Request for an Access-Token by transmitting the resource
	 * owners password credentials (username and password). This method
	 * should only be used under special circumstances and with great care. The
	 * access token and the refresh token (if any) are automatically assigned to
	 * the client instance. See the OAuth 2.0 specification for more details.
	 *
	 * @throws Exception to RoboSpice Listener
	 *
	 * @return Response containing the AccessToken or an error message from the
	 *         server.
	 */
	public Response executeAccessROTokenRequest(String username, String password, String tokenRequestType) throws Exception {

		HashMap<String,String>  parameterRO = new HashMap<String, String>();
		parameterRO.put(OauthConstants.TITLE_GRANT_TYPE, OauthConstants.RO_GRANT_TYPE);
		parameterRO.put(OauthConstants.TITLE_USERNAME, username);
		parameterRO.put(OauthConstants.TITLE_PASSWORD, password);
		if (tokenRequestType.equals(OauthConstants.RO_TOKEN)) {
			parameterRO.put(OauthConstants.TITLE_SCOPE, OauthConstants.RO_SCOPE);
			parameterRO.put(OauthConstants.TITLE_CLIENT_ID, GlobalOauthValues.getCLIENT_ID_RO());
			parameterRO.put(OauthConstants.TITLE_CLIENT_SECRET, GlobalOauthValues.getCLIENT_SECRET_RO());
		}
		if (tokenRequestType.equals(OauthConstants.RONS_TOKEN)) {
			parameterRO.put(OauthConstants.TITLE_SCOPE, OauthConstants.RONS_SCOPE);
			parameterRO.put(OauthConstants.TITLE_CLIENT_ID, GlobalOauthValues.getCLIENT_ID_RONS());
			parameterRO.put(OauthConstants.TITLE_CLIENT_SECRET, GlobalOauthValues.getCLIENT_SECRET_RONS());
		}
		if (tokenRequestType.equals(OauthConstants.ROLIMITED_TOKEN)) {
			parameterRO.put(OauthConstants.TITLE_SCOPE, OauthConstants.ROLIMITED_SCOPE);
			parameterRO.put(OauthConstants.TITLE_CLIENT_ID, GlobalOauthValues.getCLIENT_ID_ROLIMITED());
			parameterRO.put(OauthConstants.TITLE_CLIENT_SECRET, GlobalOauthValues.getCLIENT_SECRET_ROLIMITED());
		}
		parameterRO.put(OauthConstants.TITLE_BRAND_NAME, GlobalLibraryValues.getBrand());
		parameterRO.put(OauthConstants.TITLE_SOURCE_SYSTEM, OauthConstants.SOURCE_SYSTEM);

		tfLogger= new TracfoneLogger(DebugConfig.LOG_FILE);
		tfLogger.add(className,"executeAccessROTokenRequest","url: " + this.serverUrl);
		tfLogger.add(getClass().toString(), "executeAccessROTokenRequest",tokenRequestType + " Parameters " + tokenRequestType + ": " + parameterRO.toString());
		Response response = Connection.httpPostRequest(parameterRO, this.serverUrl);
		tfLogger.add(className,"executeAccessROTokenRequest",tokenRequestType + " Request Status Code = " + response.getResponseStatusCode());
		tfLogger.add(className,"executeAccessROTokenRequest",tokenRequestType + " Request Response = " + response.getResponseString());
		tfLogger.close();

		if (response.getResponseStatusCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
			if (tokenRequestType.equals(OauthConstants.RO_TOKEN)) throw new TokenRequestException(TokenRequestException.RO_TOKEN_REQUEST_FAILED);
			if (tokenRequestType.equals(OauthConstants.RONS_TOKEN)) throw new TokenRequestException(TokenRequestException.RONS_TOKEN_REQUEST_FAILED);
			if (tokenRequestType.equals(OauthConstants.ROLIMITED_TOKEN)) throw new TokenRequestException(TokenRequestException.ROLIMITED_TOKEN_REQUEST_FAILED);
		}


		return response;
	}

	/**
	 * Executes the Request for an Access-Token by transmitting the refresh token. This method
	 * should only be used under special circumstances and with great care. The
	 * access token and the refresh token (if any) are automatically assigned to
	 * the client instance. See the OAuth 2.0 specification for more details.
	 *
	 * @throws Exception
	 *
	 * @return Response containing the AccessToken or an error message from the
	 *         server.
	 */
	public Response executeRefreshAccessTokenRequest(String refreshToken, String tokenRequestType) throws Exception {



		HashMap<String,String> parameterList = new HashMap<String,String>();
		parameterList.put(OauthConstants.TITLE_GRANT_TYPE, OauthConstants.REFRESH_GRANT_TYPE);
		if (tokenRequestType.equals(OauthConstants.RO_TOKEN)) {
			parameterList.put(OauthConstants.TITLE_CLIENT_ID, GlobalOauthValues.getCLIENT_ID_RO());
			parameterList.put(OauthConstants.TITLE_CLIENT_SECRET, GlobalOauthValues.getCLIENT_SECRET_RO());
		}
		if (tokenRequestType.equals(OauthConstants.RONS_TOKEN)) {
			parameterList.put(OauthConstants.TITLE_CLIENT_ID, GlobalOauthValues.getCLIENT_ID_RONS());
			parameterList.put(OauthConstants.TITLE_CLIENT_SECRET, GlobalOauthValues.getCLIENT_SECRET_RONS());
		}
		if (tokenRequestType.equals(OauthConstants.ROLIMITED_TOKEN)) {
			parameterList.put(OauthConstants.TITLE_CLIENT_ID, GlobalOauthValues.getCLIENT_ID_ROLIMITED());
			parameterList.put(OauthConstants.TITLE_CLIENT_SECRET, GlobalOauthValues.getCLIENT_SECRET_ROLIMITED());
		}
		parameterList.put(OauthConstants.TITLE_REFERESH_TOKEN, refreshToken);

		tfLogger= new TracfoneLogger(DebugConfig.LOG_FILE);
		tfLogger.add(className,"executeRefreshAccessTokenRequest","url: " + this.serverUrl);
		tfLogger.add(getClass().toString(), "executeRefreshAccessTokenRequest", tokenRequestType + " Refresh Parameters " + tokenRequestType + ": " + parameterList.toString());
		Response response = Connection.httpPostRequest(parameterList, this.serverUrl);
		tfLogger.add(className, "executeRefreshAccessTokenRequest", tokenRequestType + " Refresh Request Status Code = " + response.getResponseStatusCode());
		tfLogger.add(className, "executeRefreshAccessTokenRequest", tokenRequestType + " Refresh Response = " + response.getResponseString());
		tfLogger.close();

		if (response.getResponseStatusCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
			if (tokenRequestType.equals(OauthConstants.RO_TOKEN)) throw new TokenRequestException(TokenRequestException.RO_CCP_REFRESH_FAILURE);
			if (tokenRequestType.equals(OauthConstants.RONS_TOKEN)) throw new TokenRequestException(TokenRequestException.RONS_REFRESH_FAILURE);
			if (tokenRequestType.equals(OauthConstants.ROLIMITED_TOKEN)) throw new TokenRequestException(TokenRequestException.ROLIMITED_REFRESH_FAILURE);

		}

		return response;
	}


	/**
	 * With this method the RefreshToken (if any) is used to refresh the
	 * AccessToken.
	 * The result is an Response-Instance containing the new Access-Token or
	 * throwing an Exception if the server responds with an error.
	 * 
	 * @param requestTokenType  R01 or R02 type token
	 *            <code>String</code> value of the http-method used.
	 * @throws Exception
	 */

	public void refreshAccessToken(String requestTokenType) throws Exception {

		String refreshToken = null;
		if (requestTokenType.equals(OauthConstants.RO_TOKEN)) {
			if(!GlobalOauthValues.isRefreshTokenROorCCPPresent())
				throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_RO_CCP_REFRESH_TOKEN);
			refreshToken = GlobalOauthValues.getRefreshTokenROorCCP();
		} else if (requestTokenType.equals(OauthConstants.RONS_TOKEN)) {
			if(!GlobalOauthValues.isRefreshTokenRONSPresent())
				throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_RONS_REFRESH_TOKEN);
			refreshToken = GlobalOauthValues.getRefreshTokenRONS();
		} else if (requestTokenType.equals(OauthConstants.ROLIMITED_TOKEN)) {
			if(!GlobalOauthValues.isRefreshTokenROLimitedPresent())
				throw new InvalidTokenTypeException(InvalidTokenTypeException.NO_ROLIMITED_REFRESH_TOKEN);
			refreshToken = GlobalOauthValues.getRefreshTokenROLimited();
		} else {
			throw new InvalidTokenTypeException(InvalidTokenTypeException.INVALID_REFRESH_TOKEN);
		}


		Response response = executeRefreshAccessTokenRequest(refreshToken, requestTokenType);

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ResponseOauthRO oauthROResponse;
		oauthROResponse  = mapper.readValue(response.getResponseString(), ResponseOauthRO.class);

		if (requestTokenType.equals(OauthConstants.RO_TOKEN)) {
			GlobalOauthValues.setAuthTokenROorCCP(oauthROResponse.getAccessToken());
			GlobalOauthValues.setRefreshTokenROorCCP(oauthROResponse.getRefreshToken());
			GlobalOauthValues.setExpiryROorCCP(oauthROResponse.getTokenExpiresIn());
		}
		if (requestTokenType.equals(OauthConstants.RONS_TOKEN)) {
			GlobalOauthValues.setAuthTokenRONS(oauthROResponse.getAccessToken());
			GlobalOauthValues.setRefreshTokenRONS(oauthROResponse.getRefreshToken());
			GlobalOauthValues.setExpiryRONS(oauthROResponse.getTokenExpiresIn());
		}
		if (requestTokenType.equals(OauthConstants.ROLIMITED_TOKEN)) {
			GlobalOauthValues.setAuthTokenROLimited(oauthROResponse.getAccessToken());
			GlobalOauthValues.setRefreshTokenROLimited(oauthROResponse.getRefreshToken());
			GlobalOauthValues.setExpiryROLimited(oauthROResponse.getTokenExpiresIn());
			GlobalOauthValues.setIsROLimitedLogin(true);
		}
	}

	/**
	 * With this method the CCU Token request will be made.
	 * The result is an Response-Instance containing the new Access-Token or
	 * throwing an Exception if the server responds with an error.
	 *
	 * @throws Exception
	 */

	public void requestCCUToken() throws Exception {

		Response response = executeCCUAccessTokenRequest();

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ResponseOauthCCU oauthCCUResponse;
		oauthCCUResponse  = mapper.readValue(response.getResponseString(), ResponseOauthCCU.class);
		GlobalOauthValues.setAuthTokenCCU(oauthCCUResponse.getAccessToken());
		GlobalOauthValues.setExpiryCCU(oauthCCUResponse.getTokenExpiresIn());

	}
}
