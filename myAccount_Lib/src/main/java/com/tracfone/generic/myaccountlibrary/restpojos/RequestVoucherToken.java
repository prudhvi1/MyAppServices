package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 * This class RequestConfirmPurchase defines the POJO for the request body of the Confirm Purchase restful web service.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *  
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RequestVoucherToken {

	public static class VoucherToken {

		@JsonProperty("subscriberId")
		private String subscriberId;
		@JsonProperty("programType")
		private String programType;
		@JsonProperty("benefitType")
		private String benefitType;


		public String getSubscriberId() {
			return subscriberId;
		}

		public void setSubscriberId(String subscriberId) {
			this.subscriberId = subscriberId;
		}

		public String getProgramType() {
			return programType;
		}

		public void setProgramType(String programType) {
			this.programType = programType;
		}

		public String getBenefitType() {
			return benefitType;
		}

		public void setBenefitType(String benefitType) {
			this.benefitType = benefitType;
		}

	}

	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private VoucherToken request;

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }  

	public VoucherToken getRequest() { return request; }
	public void setRequest(VoucherToken r) { request = r; }
}