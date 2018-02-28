package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for the response to a restful request to provide the list of Security Questions.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import java.util.ArrayList;
import java.util.List;  

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseSecurityQuestionList { 

	public static class SecurityQuestionList {

		public static class SecurityQuestion {

			@JsonProperty("securityQuestionId")
			private String securityQuestionId;
			@JsonProperty("securityQuestionText")
			private String securityQuestionText;  

			public void setSecurityQuestionId(String i) { securityQuestionId = i; }  
			public String getSecurityQuestionId() { return securityQuestionId; }   

			public void setSecurityQuestionText(String t) { securityQuestionText = t; }  
			public String getSecurityQuestionText() { return securityQuestionText; }   

		}

		@JsonProperty("securityQuestions")
		private List<SecurityQuestion> securityQuesitons = new ArrayList<SecurityQuestion>();

		public List<SecurityQuestion> getSecurityQuestions() { return securityQuesitons; } 
		public void setSecurityQuestions(List<SecurityQuestion> sq) { securityQuesitons = sq;  }

	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private SecurityQuestionList securityQuestionList; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public SecurityQuestionList getResponse() { return securityQuestionList; }
	public void setResponse(SecurityQuestionList s) { securityQuestionList = s; } 

	/**
	 * This method varifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void validateSecurityQuestionsList() throws MyAccountServiceException{
		boolean valid = true;
		if (securityQuestionList.getSecurityQuestions().size() > RestConstants.SECURITY_QUESTION_LIMIT) valid = false;
		for (int i = 0; i < securityQuestionList.getSecurityQuestions().size(); i++) {
			if (securityQuestionList.getSecurityQuestions().get(i).getSecurityQuestionId() == null) valid = false; 
			if (securityQuestionList.getSecurityQuestions().get(i).getSecurityQuestionText() == null) valid = false; 
		}
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}

} 