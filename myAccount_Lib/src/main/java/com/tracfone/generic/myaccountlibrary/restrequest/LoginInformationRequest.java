package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class will make to Update login information restful web service request. 
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * *****************************************************************************************************************/

import java.net.HttpURLConnection;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditLoginInformation;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditLoginInformation.UpdateLoginInformationRequest;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class LoginInformationRequest extends SpiceRequest<String> {


	HttpURLConnection connection;
	String accountId, email, password, newPassword,securityAnswer, securityPin;
	int securityQuestionId;

	public LoginInformationRequest(String accountId, String email, String password, String newPassword, String securityPin, String securityQuestionId, String securityAnswer) {
		super(String.class);   		
		this.accountId = accountId;
		this.email = email;
		this.password = password;
		this.newPassword = newPassword;
		this.securityPin = securityPin;
		if(securityQuestionId != null)
			this.securityQuestionId = Integer.parseInt(securityQuestionId);
		else
			this.securityQuestionId = 0;
		this.securityAnswer = securityAnswer;
	} 
	@Override
	public String loadDataFromNetwork() throws Exception {
		String url =  RestfulURL.getUrl(RestfulURL.UPDATE_PROFILE_LOGIN, GlobalLibraryValues.getBrand()); 
		url = String.format(url,accountId);  

		String result = null; ; 

		//Populate and create Body  
		RequestEditLoginInformation editLogin = new RequestEditLoginInformation();
		UpdateLoginInformationRequest editlogininfo = new UpdateLoginInformationRequest();


		editlogininfo.setEmail(email);
		editlogininfo.setPassword(password);
		editlogininfo.setNewPassword(newPassword);
		editlogininfo.setSecurityPin(securityPin);
		editlogininfo.setSecurityQuestionId(securityQuestionId);
		editlogininfo.setSecurityAnswer(securityAnswer);

		editLogin.setRequest(editlogininfo);
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		editLogin.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_DEFAULT);
		String jsonString = mapper.writeValueAsString(editLogin);

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "PUT", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";

		return result;
	}
}
