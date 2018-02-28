package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class defines the POJO for the common portions of all restful responses.
* 
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/
   
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;  

@JsonIgnoreProperties(ignoreUnknown = true) 

public class ResponseStatus {
	
	@JsonProperty("code")
	private String responseCode;
	@JsonProperty("type")
	private String responseType; 
	@JsonProperty("description")
	private String responseDescription; 
	
	public String getResponseCode() { return responseCode; }
	public void setResponseCode(String c) { responseCode = c; }
	
	public static String SUCCESS = "SUCCESS";
	public static String FAILURE = "FAILURE";
	public String getResponseType() { return responseType; }
	public void setResponseType(String t) { responseType = t; }
	
	public String getResponseDescription() { return responseDescription; }
	public void setResponseDescription(String d) { responseDescription = d; }

}
