package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseForgotUserNameQuestions {
public static class Questions{
	@JsonProperty("securityPin")
	private String availabilitySecurityPin;
	@JsonProperty("dateOfBirth")
	private String availabilityDateOfBirth;
	@JsonProperty("activationZipCode")
	private String availabilityActivationZipCode;

	public static class SecurityQuestion{
		@JsonProperty("availability")
		private String availabilitySecurityQuestion;
		@JsonProperty("question")
		private String securityQuestion;

		public String getavailabilitySecurityQuestion() {return availabilitySecurityQuestion;}
		public void setavailabilitySecurityQuestion(String availabilitySecurityQuestion) {this.availabilitySecurityQuestion = availabilitySecurityQuestion;}

		public String getSecurityQuestion() {return securityQuestion;}
		public void setSecurityQuestion(String securityQuestion) {this.securityQuestion = securityQuestion;}
	}

	@JsonProperty("securityQuestion")
	private SecurityQuestion securityQuestion;

	public String getAvailabilitySecurityPin() {return availabilitySecurityPin;}
	public void setAvailabilitySecurityPin(String availabilitySecurityPin) {this.availabilitySecurityPin = availabilitySecurityPin;}

	public String getAvailabilityDateOfBirth() {return availabilityDateOfBirth;}
	public void setAvailabilityDateOfBirth(String availabilityDateOfBirth) {this.availabilityDateOfBirth = availabilityDateOfBirth;}

	public String getAvailabilityActivationZipCode() {return availabilityActivationZipCode;}
	public void setAvailabilityActivationZipCode(String availabilityActivationZipCode) {this.availabilityActivationZipCode = availabilityActivationZipCode;}

	public SecurityQuestion getSecurityQuestion() {return securityQuestion;}
	public void setSecurityQuestion(SecurityQuestion securityQuestion) {this.securityQuestion = securityQuestion;}


	public void validateSecurityQuestion() throws MyAccountServiceException{
		boolean valid = true;
		if(availabilitySecurityPin == null) valid = false;
		if(availabilityDateOfBirth == null) valid = false;
		if(availabilityActivationZipCode == null) valid = false;
		if(securityQuestion.getavailabilitySecurityQuestion() == null) valid = false;
		if(securityQuestion.getSecurityQuestion() == null) valid = false;

		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}
}

@JsonProperty("status")
private ResponseStatus status;

@JsonProperty("response")
private Questions _questions; 

public ResponseStatus getCommon() { return status; }
public void setCommon(ResponseStatus s) { status = s; }  

public Questions getResponse() { return _questions; }
public void setResponse(Questions p) { _questions = p; }  
}
