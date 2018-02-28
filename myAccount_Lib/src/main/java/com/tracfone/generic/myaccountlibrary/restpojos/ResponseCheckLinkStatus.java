
/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for a Check link status responses
 * It corresponds to the restful services:
 *     CheckLinkAccount
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/

package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;


@JsonIgnoreProperties(ignoreUnknown = true) 

public class ResponseCheckLinkStatus { 

	public static class CheckLinkStatusResponse{

		@JsonProperty("token_type")
		private String token_type;

		@JsonProperty("access_token")
		private String access_token;

		@JsonProperty("expires_in")
		private String expires_in;

		@JsonProperty("scope")
		private String scope;

		@JsonProperty("brandName")
		private String brandName;

		@JsonProperty("sourceSystem")
		private String sourceSystem;

		@JsonProperty("account_id")
		private String account_id;

		public String getToken_type() {
			return token_type;
		}

		public void setToken_type(String token_type) {
			this.token_type = token_type;
		}

		public String getAccess_token() {
			return access_token;
		}

		public void setAccess_token(String access_token) {
			this.access_token = access_token;
		}

		public String getExpires_in() {
			return expires_in;
		}

		public void setExpires_in(String expires_in) {
			this.expires_in = expires_in;
		}

		public String getScope() {
			return scope;
		}

		public void setScope(String scope) {
			this.scope = scope;
		}

		public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		public String getSourceSystem() {
			return sourceSystem;
		}

		public void setSourceSystem(String sourceSystem) {
			this.sourceSystem = sourceSystem;
		}

		public String getAccount_id() {
			return account_id;
		}

		public void setAccount_id(String account_id) {
			this.account_id = account_id;
		}

	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private CheckLinkStatusResponse checkLinkStatusResponse; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public CheckLinkStatusResponse getResponse() { return checkLinkStatusResponse; }
	public void setResponse(CheckLinkStatusResponse s) { checkLinkStatusResponse = s; }  


	/**
	 * This method verifies all data returned from service is valid
	 *
	 * @return  true if all request data is valid
	 */
	public boolean  validateCheckLinkStatusData(){
		boolean valid;
		valid = ((checkLinkStatusResponse.getAccess_token() != null) && (checkLinkStatusResponse.getAccount_id() != null)
				&& (checkLinkStatusResponse.getBrandName() != null) && (checkLinkStatusResponse.getExpires_in() != null) 
				&& (checkLinkStatusResponse.getScope() != null) && (checkLinkStatusResponse.getToken_type() != null)
				&& (checkLinkStatusResponse.getSourceSystem() != null));
		return valid;
	}

}
