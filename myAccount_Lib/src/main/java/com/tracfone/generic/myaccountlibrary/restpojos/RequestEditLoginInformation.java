package com.tracfone.generic.myaccountlibrary.restpojos;

/******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for the body of the edit login information restful service.
 * 
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * 
 * *****************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestEditLoginInformation {

	public static class UpdateLoginInformationRequest {
		@JsonProperty("email")
		private String email;
		@JsonProperty("password")
		private String password; 
		@JsonProperty("newPassword")
		private String newPassword;
		@JsonProperty("securityPin")
		private String securityPin; 
		@JsonProperty("securityQuestionId")
		private int securityQuestionId;
		@JsonProperty("securityAnswer")
		private String securityAnswer;

		public String getEmail() { return email; }
		public void setEmail(String email) { this.email = email; }

		public String getPassword() {return password; }
		public void setPassword(String password) {this.password = password; }

		public String getNewPassword() {return newPassword; }
		public void setNewPassword(String newPassword) {this.newPassword = newPassword; }

		public String getSecurityPin() {return securityPin; }
		public void setSecurityPin(String securityPin) {this.securityPin = securityPin; }

		public int getSecurityQuestionId() {return securityQuestionId; }
		public void setSecurityQuestionId(int securityQuestionId) {this.securityQuestionId = securityQuestionId; }

		public String getSecurityAnswer() {return securityAnswer; }
		public void setSecurityAnswer(String securityAnswer) {this.securityAnswer = securityAnswer; }
	}
	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private UpdateLoginInformationRequest request; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon common) {this.common = common; }  

	public UpdateLoginInformationRequest getRequest() { return request; }
	public void setRequest(UpdateLoginInformationRequest request) {this.request = request; } 
}
