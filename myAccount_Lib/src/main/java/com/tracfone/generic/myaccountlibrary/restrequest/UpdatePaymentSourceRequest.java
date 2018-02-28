package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class UpdatePaymentSourceRequest will update the details of the selected Payment Source in the Payment Sources list.
 *
 * This class is invoked from CreditCardActivity class.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *  
 * ***************************************************************************************************************/
 
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;  
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditPaymentSource;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditPaymentSource.EditPaymentSourceRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class UpdatePaymentSourceRequest extends SpiceRequest<String> {
 
	String paymentSourceId;
	String expirationMonth;
	String expirationYear;
	String paymentSourceNickName;
	boolean defaultPaymentSource;
	int accountId;
	String creditCardType;
	
	public UpdatePaymentSourceRequest(String paymentSourceId, String expirationMonth, String expirationYear,String paymentSourceNickName,boolean defaultPaymentSource,String accountId,String creditCardType) {
		super(String.class);   
		this.paymentSourceId = paymentSourceId;
		this.expirationMonth = expirationMonth;
		this.expirationYear=expirationYear;
		this.paymentSourceNickName=paymentSourceNickName;
		this.defaultPaymentSource=defaultPaymentSource;
		this.accountId=Integer.parseInt(accountId);
		this.creditCardType=creditCardType;
	} 
	/** Create the web service request URL by choosing the appropriate service number
	 */
	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.UPDATE_PAYMENT_SOURCE, GlobalLibraryValues.getBrand()); 
		url = String.format(url,paymentSourceId);   
		
		String result = null; 

		//Populate and create Body  
		RequestEditPaymentSource updatePaymentSource = new RequestEditPaymentSource();
		EditPaymentSourceRequest updatePaymentSourceRequest = new EditPaymentSourceRequest();
		updatePaymentSourceRequest.setExpirationMonth(expirationMonth);
		updatePaymentSourceRequest.setExpirationYear(expirationYear);
		updatePaymentSourceRequest.setPaymentSourceNickName(paymentSourceNickName);
		updatePaymentSourceRequest.setDefaultPaymentSource(defaultPaymentSource);
		updatePaymentSourceRequest.setAccountId(accountId);
		updatePaymentSourceRequest.setCreditCardType(creditCardType);
		updatePaymentSource.setRequest(updatePaymentSourceRequest); 
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		updatePaymentSource.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(updatePaymentSource); 
		 
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "PUT", jsonString, getClass().toString());
		result = execConnection.executeRequest();
		
		return result; 
	}
}
