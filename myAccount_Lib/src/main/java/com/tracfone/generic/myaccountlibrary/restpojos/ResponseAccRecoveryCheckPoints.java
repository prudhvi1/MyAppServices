/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class define the POJO of Account Recovery Check Points Web Service Response
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
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAccRecoveryCheckPoints {

	public static class RecoveredCheckPoints { 

		public static class SecurityQuestion{
			@JsonProperty("availability")
			private String availabilitySecurityQuestion;
			@JsonProperty("question")
			private String securityQuestion;

			public String getAvailabilitySecurityQuestion() {return availabilitySecurityQuestion;}
			public void setAvailabilitySecurityQuestion(String availabilitySecurityQuestion) {this.availabilitySecurityQuestion = availabilitySecurityQuestion;}

			public String getSecurityQuestion() {return securityQuestion;}
			public void setSecurityQuestion(String securityQuestion) {this.securityQuestion = securityQuestion;}
		}

		@JsonProperty("securityPin")
		private String availabilitySecurityPin;
		@JsonProperty("paymentSource")
		private String availabilityPaymentSource; 
		@JsonProperty("securityQuestion")
		private SecurityQuestion securityQuestion;

		public String getAvailabilitySecurityPin() {return availabilitySecurityPin;}
		public void setAvailabilitySecurityPin(String availabilitySecurityPin) {this.availabilitySecurityPin = availabilitySecurityPin;}

		public String getAvailabilityPaymentSource() {return availabilityPaymentSource;}
		public void setAvailabilityPaymentSource(String availabilityPaymentSource) {this.availabilityPaymentSource = availabilityPaymentSource;}

		public SecurityQuestion getSecurityQuestion() {return securityQuestion;}
		public void setSecurityQuestion(SecurityQuestion securityQuestion) {this.securityQuestion = securityQuestion;}
	}
	
	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private RecoveredCheckPoints checkPointsResponse; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public RecoveredCheckPoints getResponse() { return checkPointsResponse; }
	public void setResponse(RecoveredCheckPoints checkPointsResponse) { this.checkPointsResponse = checkPointsResponse; } 

	public void validateSecurityQuestion() throws MyAccountServiceException{
		boolean valid = true;
		if(checkPointsResponse.getAvailabilitySecurityPin() == null) valid = false;
		if(checkPointsResponse.getAvailabilityPaymentSource() == null) valid = false;
		if(checkPointsResponse.getSecurityQuestion().getAvailabilitySecurityQuestion() == null) valid = false;
		if(checkPointsResponse.getSecurityQuestion().getSecurityQuestion() == null) valid = false;
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);
	}
}
