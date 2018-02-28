/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class define the POJO of Account Recovery Validate Web Service Request
 * 
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * *****************************************************************************************************************/
package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) 

public class RequestAccRevoceryValidate {

	public static class RecoveredSecurityQuestionRequest{
		
		@JsonProperty("securityPin")
		private String securityPin;
		@JsonProperty("paymentSource")
		private String paymentSource;
		@JsonProperty("activationZipCode")
		private String activationZipCode;

		public String getActivationZipCode() {
			return activationZipCode;
		}

		public void setActivationZipCode(String activationZipCode) {
			this.activationZipCode = activationZipCode;
		}

		public static class AccRevocerySecurityQuestionRequest{
			@JsonProperty("answer")
			private String answer;
			@JsonProperty("question")
			private String question;

			public String getAnswer() {return answer;}
			public void setAnswer(String availability) {this.answer = availability;}

			public String getQuestion() {return question;}
			public void setQuestion(String question) {this.question = question;}
			
		}



		public String getSecurityPin() {return securityPin;}
		public void setSecurityPin(String securityPin) {this.securityPin = securityPin;}

		public String getPaymentSource() {return paymentSource;}
		public void setPaymentSource(String paymentSource) {this.paymentSource = paymentSource;}
		
		@JsonProperty("securityQuestion")
		private AccRevocerySecurityQuestionRequest securityQuestion;

		public AccRevocerySecurityQuestionRequest getSecurityQuestion() {return securityQuestion;}
		public void setSecurityQuestion(AccRevocerySecurityQuestionRequest securityQuestion) {this.securityQuestion = securityQuestion;} 

	}

	@JsonProperty("common")
	private RequestCommon common;

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon common) {this.common = common; }  
	
	@JsonProperty("request")
	private RecoveredSecurityQuestionRequest request;

	public RecoveredSecurityQuestionRequest getRequest() { return request; }
	public void setRequest(RecoveredSecurityQuestionRequest request) {this.request = request; } 

}
