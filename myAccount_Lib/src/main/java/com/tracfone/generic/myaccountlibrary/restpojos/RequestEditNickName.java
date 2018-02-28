package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class defines the POJO for the body of the edit nickname restful
* service.
* 
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/
   
import com.fasterxml.jackson.annotation.JsonProperty;  

public class RequestEditNickName { 
	
	public static class NickNameRequest {
		
		@JsonProperty("nickName")
		private String nickName;
		@JsonProperty("accountId")
		private int accountId; 

		public String getNickName() { return nickName; }
		public void setNickName(String n) { nickName = n; }
		
		public int getAccountId() { return accountId; }
		public void setAccountId(int n) { accountId = n; }
	}
 
	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private NickNameRequest request; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }  
	
	public NickNameRequest getRequest() { return request; }
	public void setRequest(NickNameRequest r) { request = r; }  
	
} 

 
