package com.tracfone.generic.myaccountlibrary.restrequest;
  
/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class will make Create New Account web service request. 
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * *****************************************************************************************************************/

import android.os.Bundle; 

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues; 
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCreateNewAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCreateNewAccount.CreateAcctRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCreateNewAccount.CreateAcctRequest.SocialMediaJson;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class CreateAccountRequest extends SpiceRequest<String> {
	String email, min, esn, sim, zipCode, password, dob, securityAnswer;
	int securityQuestionId, accountId;
	String securityCode;
	String contactNumber;
	SocialMediaJson socialMediaJson = new SocialMediaJson();
	private Bundle socialProfileBundle; 

    /**
     * Constuctor for Create Account Request
     *
     */
	public CreateAccountRequest(int accountId, String email, String min, String esn, String sim, String zipCode, String password, String dob, String securityCode,
								String securityQuestionId, String securityAnswer, String contactNumber, Bundle socialProfileBundle) {
		super(String.class);
		this.accountId = accountId;
		this.email = email;
		this.min = min;
		this.esn = esn;
		this.sim = sim;
		this.zipCode = zipCode;
		this.password = password;
		this.dob = dob;
		this.securityCode = securityCode;
		if(securityQuestionId!=null)
			this.securityQuestionId = Integer.parseInt(securityQuestionId);
		else
			this.securityQuestionId = 0;
		this.securityAnswer = securityAnswer;
		this.contactNumber = contactNumber;
		this.socialProfileBundle = socialProfileBundle;
	}

	@Override
	public String loadDataFromNetwork() throws Exception {
		String url =  RestfulURL.getUrl(RestfulURL.CREATE_NEW_ACCOUNT, GlobalLibraryValues.getBrand()); 
		url = String.format(url, email); 
		 
		String result = null; 
		
		//Populate and create Body  
		RequestCreateNewAccount createNewAcct = new RequestCreateNewAccount();
		CreateAcctRequest createRequest = new CreateAcctRequest();
		createRequest.setAccountId(accountId);
		if (min != null && !min.isEmpty()) createRequest.setMin(min);
		if (esn != null && !esn.isEmpty()) createRequest.setEsn(esn);
		if (sim != null && !sim.isEmpty())createRequest.setSim(sim);
		if (!zipCode.isEmpty()) createRequest.setZipcode(zipCode);
		createRequest.setContactPhoneNumber(contactNumber);
		createRequest.setPassword(password);
		createRequest.setDob(dob);
		createRequest.setSecurity_question_id(securityQuestionId);
		createRequest.setSecurity_code(securityCode);
		createRequest.setSecurity_answer(securityAnswer);
		
		// set social profile data to json object
		if(socialProfileBundle!=null){
			socialMediaJson.setApp_scoped_id(socialProfileBundle.getString("id"));
			socialMediaJson.setToken_for_business(socialProfileBundle.getString("token_for_business"));
			socialMediaJson.setFirstName(socialProfileBundle.getString("first_name"));
			socialMediaJson.setLastName(socialProfileBundle.getString("last_name"));
			socialMediaJson.setLink(socialProfileBundle.getString("link"));
			socialMediaJson.setUser_name(socialProfileBundle.getString("name"));
			socialMediaJson.setGender(socialProfileBundle.getString("gender"));
			socialMediaJson.setLocale(socialProfileBundle.getString("locale"));
			socialMediaJson.setAge_range(socialProfileBundle.getString("age_range"));
			socialMediaJson.setEmail(socialProfileBundle.getString("email"));
			socialMediaJson.setFriendListNode(socialProfileBundle.getString("friendListNode"));
		}
		
		createRequest.setSocialMediaJson(socialMediaJson);
		createNewAcct.setRequest(createRequest);
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		createNewAcct.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_DEFAULT);
		mapper.setSerializationInclusion(Include.NON_NULL);
		String jsonString = mapper.writeValueAsString(createNewAcct);  
		
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";
		
		return result; 
	}
}
