package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class defines the POJO for the response to a request which only contains
* the response status and nothing specific to the request. 
* 
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseEmpty {  
	
	@JsonProperty("status")
	private ResponseStatus status;

	public ResponseStatus getStatus() { return status; }
	public void setStatus(ResponseStatus s) { status = s; }

}
