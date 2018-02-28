package com.tracfone.generic.myaccountlibrary.restrequest;

/******************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 * This class ConfirmPurchaseRequest will perform Confirm Purchase restful web service request to post the purchase of a service plan performing a transaction.
 *
 * This class is invoked from ReUpWithCCBillingBreakdownActivity class.
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestVoucherToken;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class VoucherTokenRequest extends SpiceRequest<String> {

	String subscriberId, benefitType;

	public VoucherTokenRequest(String subscriberId, String benefitType) {
		super(String.class);   
		this.subscriberId = subscriberId;
		this.benefitType =benefitType;
	} 
	/** Create the web service request URL by choosing the appropriate service number and appending it with the 
	 *  selected Service plan's Part Number and the selected Credit Card's Payment Source Id.
	 *  The Webservice's Request body is also created with the inputs - Phone Number, Account Id and entered CVV of selected credit card.
	 */
	@Override
	public String loadDataFromNetwork() throws Exception {

		String result = null;
		String url =  RestfulURL.getUrl(RestfulURL.VOUCHER_TOKEN, GlobalLibraryValues.getBrand());
		url = String.format(url);

		RequestVoucherToken requestVoucher = new RequestVoucherToken();
		RequestVoucherToken.VoucherToken voucherToken = new RequestVoucherToken.VoucherToken();
		voucherToken.setSubscriberId(subscriberId);
		voucherToken.setProgramType("UPGRADE_PLANS");
		voucherToken.setBenefitType(benefitType);
		requestVoucher.setRequest(voucherToken);

		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		requestVoucher.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		String jsonString = mapper.writeValueAsString(requestVoucher);

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "POST", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		return result; 
	}
}