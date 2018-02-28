package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 * This class will perform Account Recovery Check Points Restful Web Service request to be able to get security question
 * of user profile
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *****************************************************************************************************************/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAccRecoveryCheckPoints;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAccRecoveryCheckPoints.AccRecoveryVerifCodeRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class AccntRecoveryCheckPointsRequest extends SpiceRequest<String> {

	private String verificationCode,activationZipCode;
	private String min;

	public AccntRecoveryCheckPointsRequest(String min, String verificationCode,String activationZipCode) {
		super(String.class);
		this.verificationCode = verificationCode;
		this.activationZipCode = activationZipCode;
		this.min = min;
	}

	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.ACCOUNT_RECOVERY_CHECK_POINTS, GlobalLibraryValues.getBrand()); 
		url = String.format(url,min); 

		String result = null; 

		RequestAccRecoveryCheckPoints accRecoveryCheckPoints = new RequestAccRecoveryCheckPoints();
		AccRecoveryVerifCodeRequest accRecoveryVerifCodeRequest = new AccRecoveryVerifCodeRequest();
		if(verificationCode!=null) {
			accRecoveryVerifCodeRequest.setVerificationCode(verificationCode);
		}
		if(activationZipCode!=null){
			accRecoveryVerifCodeRequest.setActivationZipCode(activationZipCode);
		}
		accRecoveryCheckPoints.setRequest(accRecoveryVerifCodeRequest);

		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		accRecoveryCheckPoints.setCommon(requestCommon);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(accRecoveryCheckPoints);


		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString() );
		result = execConnection.executeRequest();

		return result;
	}
}