package com.tracfone.generic.myaccountlibrary.restpojos;

/*********************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 * This class RequestAutoRefillEnrollTax defines the POJO for the Tax Calculation on Auto ReUp Enroll restful service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *********************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestAutoRefillEnrollTax {

	public static class AutoEnrollTaxRequest {

		@JsonProperty("paymentSourceId")
		private int paymentSourceId;
		@JsonProperty("programId")
		private int programId;
		@JsonProperty("promotionCode")
		private String promotionCode;
		@JsonProperty("accountId")
		private int accountId; 
		@JsonProperty("esn")
		private String esn;

		public int getPaymentSourceId() { return paymentSourceId; }
		public void setPaymentSourceId(int paymentSourceId) { this.paymentSourceId = paymentSourceId; }

		public int getProgramId() { return programId; }
		public void setProgramId(int programId) { this.programId = programId; }

		public String getPromotionCode() { return promotionCode; }
		public void setPromotionCode(String promotionCode) { this.promotionCode = promotionCode; }

		public String getEsn() { return esn; }
		public void setEsn(String esn) { this.esn = esn; }

		public int getAccountId() { return accountId; }
		public void setAccountId(int n) { accountId = n;}
	}

	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private AutoEnrollTaxRequest request; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }  

	public AutoEnrollTaxRequest getRequest() { return request; }
	public void setRequest(AutoEnrollTaxRequest r) { request = r; }  	
}