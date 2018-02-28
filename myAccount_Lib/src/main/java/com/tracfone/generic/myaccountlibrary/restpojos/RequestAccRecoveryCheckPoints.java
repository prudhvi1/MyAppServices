/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class define the POJO of Account Recovery Check Points Web Service Request
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) 

public class RequestAccRecoveryCheckPoints {

	public static class AccRecoveryVerifCodeRequest{

		@JsonProperty("verificationCode")
		@JsonInclude(JsonInclude.Include.NON_DEFAULT)
		private String verificationCode;

		@JsonProperty("activationZipCode")
		@JsonInclude(JsonInclude.Include.NON_DEFAULT)
		private String activationZipCode;

		public String getActivationZipCode() {
			return activationZipCode;
		}

		public void setActivationZipCode(String activationZipCode) {
			this.activationZipCode = activationZipCode;
		}

		public String getVerificationCode() { return verificationCode; }
		public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }
	}
	
	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private AccRecoveryVerifCodeRequest request; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }  
	
	public AccRecoveryVerifCodeRequest getRequest() { return request; }
	public void setRequest(AccRecoveryVerifCodeRequest r) { request = r; }  
}
