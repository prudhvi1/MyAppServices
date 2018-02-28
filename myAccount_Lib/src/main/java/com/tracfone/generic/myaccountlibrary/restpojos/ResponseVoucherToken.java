package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for a create new account responses
 * It corresponds to the restful services:
 *     Create New Account
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/

@JsonIgnoreProperties(ignoreUnknown = true) 

public class ResponseVoucherToken {

	public static class VoucherTokenResponse{

		@JsonProperty("voucherAccessToken")
		private String voucherAccessToken;
		@JsonProperty("redirectURL")
		private String redirectURL;


		public String getRedirectURL() {
			return redirectURL;
		}

		public void setRedirectURL(String redirectURL) {
			this.redirectURL = redirectURL;
		}

		public String getVoucherAccessToken() {
			return voucherAccessToken;
		}

		public void setVoucherAccessToken(String voucherAccessToken) {
			this.voucherAccessToken = voucherAccessToken;
		}
	}
	
	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private VoucherTokenResponse voucherTokenResponse;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public VoucherTokenResponse getResponse() { return voucherTokenResponse; }
	public void setResponse(VoucherTokenResponse s) { voucherTokenResponse = s; }
	
	
	 /**
	    * This method verifies all data returned from service is valid
	    *
	     * @return  true if all request data is valid
	    */
		public void  validateVoucherToken()throws MyAccountServiceException {
			boolean valid = true;
			if (voucherTokenResponse.getVoucherAccessToken() == null)
				valid = false;
			if (voucherTokenResponse.getRedirectURL() == null)
				valid = false;
			if (!valid)
				throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);
		}
}
