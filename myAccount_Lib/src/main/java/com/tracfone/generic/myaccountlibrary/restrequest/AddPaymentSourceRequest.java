package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class will make to Redeem Pin Card restful web service request. 
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
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAddPaymentSource;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestAddPaymentSource.AddPaymentRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class AddPaymentSourceRequest extends SpiceRequest<String> {

	 String accountId;
	 String c_NickName;
	 String c_Type;
	 String paymentSourceType;
	 String c_Number;
	 String c_expirationMonth;
	 String c_expirationYear;
	 String c_firstName;
	 String c_lastName;
	 String c_addressLine1;
	 String c_addressLine2;
	 String c_city;
	 String c_state;
	 String c_zip_Code;
	 String c_country;
	 String c_contact_number;
	 boolean c_isDefault; 

    /**
     * Constuctor for Add Payment Source Request
     * 
     */
	public AddPaymentSourceRequest(String accountId,String c_NickName, String c_Type, 
			String paymentSourceType,String c_Number,String c_expirationMonth,String c_expirationYear,
			String c_firstName,String c_lastName,String c_addressLine1,
			String c_addressLine2,String c_city,String c_state,
			String c_zip_Code,String c_country, String c_contact_number,boolean c_isDefault) {
		super(String.class);   
		this.accountId = accountId;
		this.c_NickName = c_NickName;
		this.c_Type = c_Type;
		this.paymentSourceType = paymentSourceType;
		this.c_Number = c_Number;
		this.c_expirationMonth = c_expirationMonth;
		this.c_expirationYear = c_expirationYear;
		this.c_firstName  = c_firstName;
		this.c_lastName = c_lastName;
		this.c_addressLine1 = c_addressLine1;
		this.c_addressLine2 = c_addressLine2;
		this.c_city = c_city;
		this.c_state  = c_state;
		this.c_zip_Code = c_zip_Code;
		this.c_country = c_country;
		this.c_contact_number = c_contact_number;
		this.c_isDefault = c_isDefault;
	}  

	@Override
	public String loadDataFromNetwork() throws Exception {
		
		String url =  RestfulURL.getUrl(RestfulURL.ADD_PAYMENT_SOURCE, GlobalLibraryValues.getBrand()); 
		url = String.format(url,accountId); 
		 
		String result = null; 
		
		//Populate and create Body  
		RequestAddPaymentSource addPaymentSource = new RequestAddPaymentSource();
		AddPaymentRequest addPaymentRequest = new AddPaymentRequest();
		addPaymentRequest.setC_NickName(c_NickName);
		addPaymentRequest.setC_Type(c_Type);
		addPaymentRequest.setPaymentSourceType(paymentSourceType);
		addPaymentRequest.setC_Number(c_Number);
		addPaymentRequest.setC_expirationMonth(c_expirationMonth);
		addPaymentRequest.setC_expirationYear(c_expirationYear);
		addPaymentRequest.setC_firstName(c_firstName);
		addPaymentRequest.setC_lastName(c_lastName);
		addPaymentRequest.setC_addressLine1(c_addressLine1);
		addPaymentRequest.setC_addressLine2(c_addressLine2);
		addPaymentRequest.setC_city(c_city);
		addPaymentRequest.setC_state(c_state);
		addPaymentRequest.setC_zip_Code(c_zip_Code);
		addPaymentRequest.setC_country(c_country);
		addPaymentRequest.setC_contact_number(c_contact_number);
		addPaymentRequest.setC_isDefault(c_isDefault);
		addPaymentSource.setRequest(addPaymentRequest); 
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		addPaymentSource.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(addPaymentSource);  
		
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "POST", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";
		
		return result; 
	}


}
