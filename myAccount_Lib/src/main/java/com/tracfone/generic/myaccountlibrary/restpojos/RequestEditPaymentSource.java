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
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;


public class RequestEditPaymentSource {

	public static class EditPaymentSourceRequest {
		@JsonProperty("expirationMonth")
		private String expirationMonth;
		@JsonProperty("expirationYear")
		private String expirationYear; 
		@JsonProperty("paymentSourceNickName")
		private String paymentSourceNickName;
		@JsonProperty("defaultPaymentSource")
		private boolean defaultPaymentSource; 
		@JsonProperty("accountId")
		private int accountId;
		@JsonProperty("creditCardType")
		private String creditCardType;
		public String getExpirationMonth() {
			return expirationMonth;
		}
		public void setExpirationMonth(String expirationMonth) {
			this.expirationMonth = expirationMonth;
		}
		public String getExpirationYear() {
			return expirationYear;
		}
		public void setExpirationYear(String expirationYear) {
			this.expirationYear = expirationYear;
		}
		public String getPaymentSourceNickName() {
			return paymentSourceNickName;
		}
		public void setPaymentSourceNickName(String paymentSourceNickName) {
			this.paymentSourceNickName = paymentSourceNickName;
		}
		public boolean getDefaultPaymentSource() {
			return defaultPaymentSource;
		}
		public void setDefaultPaymentSource(boolean defaultPaymentSource) {
			this.defaultPaymentSource = defaultPaymentSource;
		}
		public int getAccountId() {
			return accountId;
		}
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		public String getCreditCardType() {
			return creditCardType;
		}
		public void setCreditCardType(String creditCardType) {
			this.creditCardType = creditCardType;
		}

	}
	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private EditPaymentSourceRequest request;
	public RequestCommon getCommon() {
		return common;
	}
	public void setCommon(RequestCommon common) {
		this.common = common;
	}
	public EditPaymentSourceRequest getRequest() {
		return request;
	}
	public void setRequest(EditPaymentSourceRequest request) {
		this.request = request;
	} 



}
