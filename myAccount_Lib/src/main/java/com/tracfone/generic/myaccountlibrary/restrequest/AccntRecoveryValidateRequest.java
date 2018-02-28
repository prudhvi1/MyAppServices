package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class will perform Account Recovery Validate Restful Web Service request to show user name (email) to user
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *****************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAccRevoceryValidate;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAccRevoceryValidate.RecoveredSecurityQuestionRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAccRevoceryValidate.RecoveredSecurityQuestionRequest.AccRevocerySecurityQuestionRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class AccntRecoveryValidateRequest extends SpiceRequest<String> {

	private String min,securityPin,question,answer,paymentSource,activationZipcode;

	public AccntRecoveryValidateRequest(String min,String securityPin,String question, String answer,String paymentSource,String activationZipcode) {
		super(String.class);

		this.min = min;
		this.securityPin = securityPin;
		this.question = question;
		this.answer = answer;
		this.paymentSource = paymentSource;
		this.activationZipcode = activationZipcode;
	}

	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.ACCOUNT_RECOVERY_VALIDATE, GlobalLibraryValues.getBrand()); 
		url = String.format(url,min); 

		String result = null; 

		RequestAccRevoceryValidate accRecoveryValidate = new RequestAccRevoceryValidate();
		RecoveredSecurityQuestionRequest recoveredSecurityQuestion = new RecoveredSecurityQuestionRequest();
		AccRevocerySecurityQuestionRequest securityQuestion = new AccRevocerySecurityQuestionRequest();

		securityQuestion.setAnswer(answer);
		if (answer == null) {
			securityQuestion.setQuestion(null);
			recoveredSecurityQuestion.setSecurityQuestion(null);
		} else {
		    securityQuestion.setQuestion(question);
		    recoveredSecurityQuestion.setSecurityQuestion(securityQuestion);
		}
		 
		recoveredSecurityQuestion.setSecurityPin(securityPin);
		recoveredSecurityQuestion.setPaymentSource(paymentSource);
		recoveredSecurityQuestion.setActivationZipCode(activationZipcode);

		accRecoveryValidate.setRequest(recoveredSecurityQuestion);

		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		accRecoveryValidate.setCommon(requestCommon);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		String jsonString = mapper.writeValueAsString(accRecoveryValidate);

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";

		return result;
	}
}