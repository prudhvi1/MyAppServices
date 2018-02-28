package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:
 * This class AutoRefillEnrollTaxCalculationRequest will perform a restful service call to get the Tax calculation performed for the Auto ReUp Enrollment for
 * selected Service Plan.
 * This class is invoked from ReUpWithCCBillingBreakdownActivity class.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * **************************************************************************************************************************************************************/
  
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest; 
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues; 
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAutoRefillEnrollTax;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAutoRefillEnrollTax.AutoEnrollTaxRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class AutoRefillEnrollTaxCalculationRequest extends SpiceRequest<String> {

	String esn,promotionCode;
	int paymentSourceId,accountId,programId; 

	public AutoRefillEnrollTaxCalculationRequest(String paymentSourceId,String programId,String promotionCode,String accountId, String esn) {
		super(String.class); 
		this.paymentSourceId=Integer.parseInt(paymentSourceId);
		this.programId=Integer.parseInt(programId);
		if(promotionCode!=null && !promotionCode.isEmpty())	this.promotionCode=promotionCode;
		else this.promotionCode=null;
		this.accountId=Integer.parseInt(accountId);
		this.esn=esn;
	}

	/** Create the web service request URL by choosing the appropriate service number.
	 *  The Webservice's Request body is also created with the inputs - Payment Source Id of selected Credit Card, Promotion Code, Account Id,
	 *   Serial Number, selected credit cards billing zip code and cart List.
	 */
	@Override
	public String loadDataFromNetwork() throws Exception {

		String result = null;
		String url =  RestfulURL.getUrl(RestfulURL.CALCULATE_TOTAL_AUTO_REFILL, GlobalLibraryValues.getBrand());

		//Populate and create Body  
		RequestAutoRefillEnrollTax calculateAutoEnrollTax = new RequestAutoRefillEnrollTax();
		AutoEnrollTaxRequest autoEnrollTaxRequest = new AutoEnrollTaxRequest();
		autoEnrollTaxRequest.setPaymentSourceId(paymentSourceId); 
		autoEnrollTaxRequest.setProgramId(programId);
		autoEnrollTaxRequest.setPromotionCode(promotionCode);
		autoEnrollTaxRequest.setAccountId(accountId);		
		autoEnrollTaxRequest.setEsn(esn);		
		calculateAutoEnrollTax.setRequest(autoEnrollTaxRequest); 

		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		calculateAutoEnrollTax.setCommon(requestCommon);		

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String jsonString = mapper.writeValueAsString(calculateAutoEnrollTax); 

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "POST", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";

		return result; 
	}
}