package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class defines the POJO for the body of a request which has not parameters
* specific to the reqeust. 
* 
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/
   
import com.fasterxml.jackson.annotation.JsonProperty;  

public class RequestEmpty {  
 
	@JsonProperty("common")
	private RequestCommon common; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }   
	
} 

 
