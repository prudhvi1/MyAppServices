package com.tracfone.generic.myaccountlibrary.restpojos; 

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for the response to a restful request to 
 * Customer Support - Technical Support & FAQ.  
 * 
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;

@JsonIgnoreProperties(ignoreUnknown = true)   

public class ResponseCustomerSupport { 

	public static class ScriptList {

		public static class Script {
			@JsonProperty("scriptId")
			private String sId; 
			@JsonProperty("scriptContent")
			private String sContent;

			public String getsId() { return sId; }
			public void setsId(String sId) { this.sId = sId; }

			public String getsContent() {	return sContent; }
			public void setsContent(String sContent) {	this.sContent = sContent;	}					
		}

		@JsonProperty("scripts")
		private List<Script> scripts = new ArrayList<Script>();

		public List<Script> getScript() { return scripts; } 
		public void setScript(List<Script> t) { scripts = t;  }
	}
	
	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private ScriptList scriptList; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public ScriptList getResponse() { return scriptList; }
	public void setResponse(ScriptList s) { scriptList = s; } 
	
	/**
	 * This method verifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void validateScriptList() throws MyAccountServiceException {
		boolean valid = true;
		for (int i = 0; i < scriptList.getScript().size(); i++) {
			if(scriptList.getScript().get(i).getsId() == null) valid = false;
			if(scriptList.getScript().get(i).getsContent() == null) valid = false;
		}
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}

} 
