package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true) 

public class ResponseAccRecoveryAccountStatus { 

	public static class RecoveredAccountStatus { 

		public static class AccRecoveryCheckPoints { 

			public static class AccRecoverySecurityQuestionResponse {
				@JsonProperty("availability")
				private String availabilitySecurityQuestion;
				@JsonProperty("question")
				private String securityQuestion;

				public String getAvailabilitySecurityQuestion() {
					return availabilitySecurityQuestion;
				} 
				public void setAvailabilitySecurityQuestion(
						String availabilitySecurityQuestion) {
					this.availabilitySecurityQuestion = availabilitySecurityQuestion;
				} 

				public String getSecurityQuestion() {
					return securityQuestion;
				} 
				public void setSecurityQuestion(String securityQuestion) {
					this.securityQuestion = securityQuestion;
				} 
			}

			@JsonProperty("securityQuestion")
			private AccRecoverySecurityQuestionResponse securityQuestionInfo;

			public AccRecoverySecurityQuestionResponse getAccRecoverySecurityQuestionResponse() {
				return securityQuestionInfo;
			} 
			public void setSecurityQuestion(
					AccRecoverySecurityQuestionResponse securityQuestionInfo) {
				this.securityQuestionInfo = securityQuestionInfo;
			}

			@JsonProperty("activationZipCode")
			private String activationZipCode;

			public String getActivationZipCode() {
				return activationZipCode;
			}

			public void setActivationZipCode(String activationZipCode) {
				this.activationZipCode = activationZipCode;
			}

			@JsonProperty("securityPin")
			private String availabilitySecurityPin;

			public String getAvailabilitySecurityPin() {
				return availabilitySecurityPin;
			}
			public void setAvailabilitySecurityPin(
					String availabilitySecurityPin) {
				this.availabilitySecurityPin = availabilitySecurityPin;
			} 
		}


		@JsonProperty("accountStatus")
		private String accRecoveryAccountStatus;
		@JsonProperty("checkPoints")
		private AccRecoveryCheckPoints accRecoveryCheckpoints;

		public String getAccRecoveryAccountStatus() {
			return accRecoveryAccountStatus;
		} 
		public void setAccRecoveryAccountStatus(String accRecoveryAccountStatus) {
			this.accRecoveryAccountStatus = accRecoveryAccountStatus;
		} 

		public AccRecoveryCheckPoints getAccRecoveryCheckpoints() {
			return accRecoveryCheckpoints;
		} 
		public void setAccRecoveryCheckpoints(AccRecoveryCheckPoints accRecoveryCheckpoints) {
			this.accRecoveryCheckpoints = accRecoveryCheckpoints;
		} 
		

	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private RecoveredAccountStatus recoveredAccountStatus;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }
	public RecoveredAccountStatus getAccRecoveryStatusResponse() {return recoveredAccountStatus;}
	public void setAccRecoveryStatusResponse(RecoveredAccountStatus recoveredAccountStatus) {this.recoveredAccountStatus = recoveredAccountStatus;}



	public void validateSecurityQuestion()throws MyAccountServiceException{
		boolean valid = true;
		if(recoveredAccountStatus.getAccRecoveryAccountStatus() == null) valid = false;
		if(recoveredAccountStatus.getAccRecoveryCheckpoints().getAvailabilitySecurityPin() == null) valid = false;
		if(recoveredAccountStatus.getAccRecoveryCheckpoints().getAccRecoverySecurityQuestionResponse().getAvailabilitySecurityQuestion() == null) valid = false;
		if(recoveredAccountStatus.getAccRecoveryCheckpoints().getAccRecoverySecurityQuestionResponse().getSecurityQuestion() == null) valid = false;
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	} 


}