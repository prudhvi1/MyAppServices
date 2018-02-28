package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class defines the POJO for the body of the redeem pin card request.
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
* ****************************************************************************/
   
import com.fasterxml.jackson.annotation.JsonProperty;  

public class RequestRedeemPinCard { 
	
	public static class RedeemRequest {
		
		@JsonProperty("min")
		private String min;
		@JsonProperty("esn")
		private String esn;
		@JsonProperty("promoCode")
		private String promoCode;
		@JsonProperty("redeemNow")
		private boolean redeemNow;

		public String getMin() { return min; }
		public void setMin(String m) { min = m; }
		
		public String getEsn() { return esn; }
		public void setEsn(String e) { esn = e; }

		public String getPromoCode() {return promoCode; }
		public void setPromoCode(String promoCode) { this.promoCode = promoCode; }

		public boolean isRedeemNow() { return redeemNow; }
		public void setRedeemNow(boolean redeemNow) { this.redeemNow = redeemNow; }
	}
 
	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private RedeemRequest request; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }  
	
	public RedeemRequest getRequest() { return request; }
	public void setRequest(RedeemRequest r) { request = r; }  
	
} 

 
