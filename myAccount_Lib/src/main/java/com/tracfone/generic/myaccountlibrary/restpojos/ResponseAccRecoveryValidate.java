/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class define POJO of Account Recovery Validate Web Service Response
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
public class ResponseAccRecoveryValidate {
	
	public static class RecoveredValidate {

		@JsonProperty("accountId")
		private String ValidateAccountId;
		@JsonProperty("email")
		private String ValidateEmail;

		public String getValidateAccountId() {return ValidateAccountId;}
		public void setValidateAccountId(String validateAccountId) {ValidateAccountId = validateAccountId;}

		public String getValidateEmail() {return ValidateEmail;}
		public void setValidateEmail(String validateEmail) {ValidateEmail = validateEmail;}
	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private RecoveredValidate validateResponse; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public RecoveredValidate getResponse() { return validateResponse; }
	public void setResponse(RecoveredValidate validateResponse) { this.validateResponse = validateResponse; } 

	public boolean validateAccRecovery(){
		boolean valid = true;

		if(validateResponse.getValidateAccountId() == null) valid = false;

		return valid;
	} 
}
