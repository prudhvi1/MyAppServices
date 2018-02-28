package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class will make to Update device Nickname restful web service request. 
*
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/
  
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;   
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon; 
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditNickName;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditNickName.NickNameRequest;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class EditNickNameRequest extends SpiceRequest<String> {

	String esn;
	String newNickName;
	String accountId;
	String min;

	public EditNickNameRequest(String esn,String min, String newNickName, String accountId) {
		super(String.class);   
		this.esn = esn;
		this.min = min;
		this.newNickName = newNickName;
		this.accountId = accountId;
	} 

	@Override
	public String loadDataFromNetwork() throws Exception { 
		
		String result = null;
		
		String url =  RestfulURL.getUrl(RestfulURL.UPDATE_DEVICE_NICKNAME, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
		else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
		else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, "esn/" + esn);

		//Populate and create Body  
		RequestEditNickName editNickName = new RequestEditNickName();
		NickNameRequest nickNameRequest = new NickNameRequest();
		nickNameRequest.setNickName(newNickName);
		nickNameRequest.setAccountId(Integer.parseInt(accountId)); 
		editNickName.setRequest(nickNameRequest); 
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		editNickName.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(editNickName);  
		
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "PUT", jsonString, getClass().toString());
		result = execConnection.executeRequest();
		
		return result; 
	} 

}
