package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for the response to a restful request to 
 * provide the list of html scripts.
 * 
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseScript {

	public static class ScriptList {

		public static class Script {

			@JsonProperty("scriptId")
			private String scriptId;
			@JsonProperty("scriptContent")
			private String scriptContent;

			public void setScriptId(String i) { scriptId = i; }
			public String getScriptId() { return scriptId; }

			public void setScriptContent(String t) { scriptContent = t; }
			public String getScriptContent() { return scriptContent; }

		}

		@JsonProperty("securityQuestions")
		private List<Script> scripts = new ArrayList<Script>();

		public List<Script> getScripts() { return scripts; }
		public void setScripts(List<Script> s) { scripts = s;  }

	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private ScriptList scriptList;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public ScriptList getResponse() { return scriptList; }
	public void setResponse(ScriptList s) { scriptList = s; }

} 