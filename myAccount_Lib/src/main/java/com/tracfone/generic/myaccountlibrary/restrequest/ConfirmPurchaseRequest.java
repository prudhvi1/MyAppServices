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
import com.tracfone.generic.myaccountlibrary.restpojos.RequestConfirmPurchase;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestConfirmPurchase.PurchaseRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponsePlanList;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.VasPlans;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;
import java.util.ArrayList;
import java.util.List;
public class ConfirmPurchaseRequest extends SpiceRequest<String> {

	private String partNumber, min, esn, paymentSourceId, cvvNumber, ildVasFlagCPR, promoCode;
	private int accountId, servicePlanId;
	private boolean redeemNow, isRewardPointsPayment ;
	private ArrayList<ResponsePlanList.PlanList.Plan> vasPlans= new ArrayList<>();

	public ConfirmPurchaseRequest(String partNumber, String paymentSourceId, String min, String esn, String accountId, String cvvNumber, boolean redeemNow, String servicePlanId, boolean ildVasFlagArg, String promoCode, ArrayList<ResponsePlanList.PlanList.Plan> vasPlans, boolean isRewardPointsPayment) {
		super(String.class);   
		this.partNumber = partNumber;
		this.paymentSourceId =paymentSourceId;
		if (min.equals("")) min=null;
		if (esn.equals("")) esn=null;		
		this.min = min;
		this.esn = esn;
		this.accountId = Integer.parseInt(accountId);
		this.cvvNumber = cvvNumber;
		this.redeemNow = redeemNow;
		this.servicePlanId=Integer.parseInt(servicePlanId);
		this.ildVasFlagCPR = String.valueOf(ildVasFlagArg);
		this.vasPlans = vasPlans;
		this.isRewardPointsPayment = isRewardPointsPayment;
		if(promoCode!=null && !promoCode.isEmpty())	this.promoCode=promoCode;
	} 
	/** Create the web service request URL by choosing the appropriate service number and appending it with the 
	 *  selected Service plan's Part Number and the selected Credit Card's Payment Source Id.
	 *  The Webservice's Request body is also created with the inputs - Phone Number, Account Id and entered CVV of selected credit card.
	 */
	@Override
	public String loadDataFromNetwork() throws Exception {

		String result = null;
		String url =  RestfulURL.getUrl(RestfulURL.CONFIRM_PURCHASE, GlobalLibraryValues.getBrand());
		if(isRewardPointsPayment){
			url = String.format(url, partNumber);
		} else {
			url = String.format(url, partNumber + "/paymentSource/"+paymentSourceId);
		}

		RequestConfirmPurchase confirmPurchase = new RequestConfirmPurchase(); 
		PurchaseRequest purchaseRequest=new PurchaseRequest();
		purchaseRequest.setMin(min);
		purchaseRequest.setEsn(esn);
		purchaseRequest.setAccountId(accountId);
		purchaseRequest.setCvvNumber(cvvNumber);
		purchaseRequest.setRedeemNow(redeemNow);
		purchaseRequest.setServicePlanId(servicePlanId);
		purchaseRequest.setIsILDVas(ildVasFlagCPR);
		List<VasPlans> vasPlansList = new ArrayList<>();
		if (vasPlans != null) {
			VasPlans vasPlanForRequest = new VasPlans();
			for (int i = 0; i < vasPlans.size(); i++) {
				vasPlanForRequest.setPartNumber(vasPlans.get(i).getPlanPartNumber());
				vasPlanForRequest.setVasPlanId(Integer.valueOf(vasPlans.get(i).getPlanId()));
				vasPlanForRequest.setQuantity(1);
				vasPlansList.add(vasPlanForRequest);
			}
		}
		purchaseRequest.setVasPlansList(vasPlansList);
		purchaseRequest.setPromoCode(promoCode);
		purchaseRequest.setIsLyltyRwrdsPurch(isRewardPointsPayment);
		confirmPurchase.setRequest(purchaseRequest);

		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		confirmPurchase.setCommon(requestCommon);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		String jsonString = mapper.writeValueAsString(confirmPurchase); 

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "POST", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";

		return result; 
	}
}