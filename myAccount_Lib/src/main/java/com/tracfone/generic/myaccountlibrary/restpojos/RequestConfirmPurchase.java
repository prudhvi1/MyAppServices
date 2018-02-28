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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.VasPlans;

import java.util.ArrayList;
import java.util.List;

public class RequestConfirmPurchase {

	public static class PurchaseRequest {

		@JsonProperty("min")
		private String min;
		@JsonProperty("esn")
		private String esn;
		@JsonProperty("accountId")
		private int accountId; 
		@JsonProperty("cvvNumber")
		private String cvvNumber;
		@JsonProperty("redeemNow")
		private boolean redeemNow;
		@JsonProperty("servicePlanId")
		private int servicePlanId;
		@JsonProperty("isILDVas")
		private String isILDVas;
		@JsonProperty("promoCode")
		private String promoCode;
		@JsonProperty("isLyltyRwrdsPurch")
		private boolean isLyltyRwrdsPurch;
		@JsonProperty("vasPlans")
		private List<VasPlans> vasPlansList = new ArrayList<VasPlans>();


		public String getMin() { return min; }
		public void setMin(String min) { this.min = min; }
		
		public String getEsn() { return esn; }
		public void setEsn(String esn) { this.esn = esn; }

		public String getCvvNumber() { return cvvNumber; }
		public void setCvvNumber(String cvvNumber) { this.cvvNumber = cvvNumber; }

		public int getAccountId() { return accountId; }
		public void setAccountId(int n) { accountId = n; }

		public boolean isRedeemNow() {	return redeemNow; }
		public void setRedeemNow(boolean redeemNow) { this.redeemNow = redeemNow; }

		public int getServicePlanId() {	return servicePlanId; }
		public void setServicePlanId(int servicePlanId) { this.servicePlanId = servicePlanId; }

		public boolean getIsILDVas() {
			if(isILDVas!=null)
				return (isILDVas.equals("true"))?true:false;
			else
				return false;
		}
		public void setIsILDVas(String isILDVas) {
			this.isILDVas = isILDVas;
		}

		public String getPromoCode() {return promoCode; }
		public void setPromoCode(String promoCode) { this.promoCode = promoCode; }

		public boolean getIsLyltyRwrdsPurch() {return isLyltyRwrdsPurch; }
		public void setIsLyltyRwrdsPurch(boolean isLyltyRwrdsPurch) { this.isLyltyRwrdsPurch = isLyltyRwrdsPurch; }

		public List<VasPlans> getVasPlansList() { return vasPlansList; }
		public void setVasPlansList(List<VasPlans> vasPlansList) { this.vasPlansList = vasPlansList; }

	}

	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private PurchaseRequest request; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }  

	public PurchaseRequest getRequest() { return request; }
	public void setRequest(PurchaseRequest r) { request = r; }  
}