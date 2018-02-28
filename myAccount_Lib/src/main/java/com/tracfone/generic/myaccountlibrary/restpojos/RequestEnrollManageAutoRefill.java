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
 * ************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestEnrollManageAutoRefill {

	public static class EnrollManageAutoRequest {

		@JsonProperty("paymentSourceId")
		private int paymentSourceId;
		@JsonProperty("accountId")
		private int accountId; 
		@JsonProperty("cvv")
		private String cvv; 
		@JsonProperty("enrollNow")
		private boolean enrollNow;
		@JsonProperty("servicePlanId")
		@JsonInclude(JsonInclude.Include.NON_DEFAULT)
		private int servicePlanId;


		public static class HandsetProtection {

			@JsonProperty("handsetProtectionProgram")
			private boolean handsetProtectionProgram;
			@JsonProperty("deviceModel")
			private String deviceModel;
			@JsonProperty("deviceManufacturer")
			private String deviceManufacturer;
			@JsonProperty("email")
			private String email;

			public boolean isHandsetProtectionProgram() { return handsetProtectionProgram;	}
			public void setHandsetProtectionProgram(boolean handsetProtectionProgram) {	this.handsetProtectionProgram = handsetProtectionProgram; }

			public String getDeviceModel() { return deviceModel; }
			public void setDeviceModel(String deviceModel) { this.deviceModel = deviceModel; }

			public String getDeviceManufacturer() {	return deviceManufacturer;	}
			public void setDeviceManufacturer(String deviceManufacturer) { this.deviceManufacturer = deviceManufacturer; }

			public String getEmail() {return email;}
			public void setEmail(String email) {this.email = email;}
		}

		public int getPaymentSourceId() { return paymentSourceId; }
		public void setPaymentSourceId(int paymentSourceId) { this.paymentSourceId = paymentSourceId; }

		public String getCvv() { return cvv; }
		public void setCvv(String cvv) { this.cvv = cvv; }

		public boolean isEnrollNow() { return enrollNow; }
		public void setEnrollNow(boolean enrollNow) { this.enrollNow = enrollNow; }

		public int getAccountId() { return accountId; }
		public void setAccountId(int n) { accountId = n; }

		public int getServicePlanId() { return servicePlanId; }
		public void setServicePlanId(int servicePlanId) { this.servicePlanId = servicePlanId; }


		@JsonProperty("handsetProtectionProgram")
		private HandsetProtection handsetProtection = new HandsetProtection();

		public HandsetProtection getHandsetProtection() { return handsetProtection; }
		public void setHandsetProtection(HandsetProtection handsetProtection) {	this.handsetProtection = handsetProtection; }
	}

	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private EnrollManageAutoRequest request; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }  

	public EnrollManageAutoRequest getRequest() { return request; }
	public void setRequest(EnrollManageAutoRequest r) { request = r; }
} 