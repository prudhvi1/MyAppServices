package com.tracfone.generic.myaccountlibrary.restpojos;
/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class defines the POJO for account device details.
* It corresponds to the restful service Get Customer Account Details.
*
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccountMultiLine;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseAccountDetails {

	public class AccountDetails {

		@JsonProperty("billingAccount")
		private BillingAccountMultiLine billingAccountMultiLine;

		@JsonProperty("isLoyaltyRewardsEnrolled")
		private boolean isLoyaltyRewardsEnrolled;

		@JsonProperty("loyaltyRewardsInfo")
		private LoyaltyRewardsInfo loyaltyRewardsInfo;

		@JsonProperty("devices")
		private List<Device> devices = new ArrayList<Device>();

		public BillingAccountMultiLine getBillingAccountMultiLine() { return billingAccountMultiLine; }
		public void setBillingAccountMultiLine(BillingAccountMultiLine ba) { billingAccountMultiLine = ba; }

		public boolean getIsLoyaltyRewardsEnrolled() { return isLoyaltyRewardsEnrolled; }
		public void setIsLoyaltyRewardsEnrolled(boolean ilr) { isLoyaltyRewardsEnrolled = ilr; }

		public LoyaltyRewardsInfo getLoyaltyRewardsInfo() { return loyaltyRewardsInfo; }
		public void setLoyaltyRewardsInfo(LoyaltyRewardsInfo lri) { loyaltyRewardsInfo = lri; }

		public List<Device> getDevices() { return devices; }
		public void setDevices(List<Device> sm) { devices = sm; }
	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private AccountDetails accountDetails;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  
	
	public AccountDetails getResponse() { return accountDetails; }
	public void setResponse(AccountDetails r) { accountDetails = r; }
	
	/**
	 * This method verifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void  validateGroupDeviceList() throws MyAccountServiceException {
		boolean valid = true;
		if (accountDetails.getDevices().size() > RestConstants.DEVICE_LIMIT) valid = false;
		for (int i = 0; i < accountDetails.getDevices().size(); i++) {
			if (accountDetails.getDevices().get(i).getDeviceMin() == null) valid = false;
			if (accountDetails.getDevices().get(i).getDeviceEsn() == null) valid = false;
			if (accountDetails.getDevices().get(i).getDeviceStatus() == null) valid = false;
			if (accountDetails.getDevices().get(i).getServicePlanName() == null) valid = false;
			if (accountDetails.getDevices().get(i).getServicePlanDescription() == null) valid = false;
			if (accountDetails.getDevices().get(i).getServicePlanDescription2() == null) valid = false;
			if (accountDetails.getDevices().get(i).getServicePlanDescription3() == null) valid = false;
			if (accountDetails.getDevices().get(i).getServicePlanDescription4() == null) valid = false;
			//if (accountDetails.getDevices().get(i).getServicePlanId() == -1) valid = false;
			if (accountDetails.getDevices().get(i).getLastDayService() == null) valid = false;
			//if (accountDetails.getDevices().get(i).getReserveCount() == -1) valid = false;
			if (accountDetails.getDevices().get(i).getDeviceNickName() == null) valid = false;
			if (accountDetails.getDevices().get(i).getDevicePartClass() == null) valid = false;
			// if (accountDetails.getDevices().get(i).getAccountDetailsDevicePaymentSourceId() == null) valid = false;
			if (accountDetails.getDevices().get(i).getDeviceType() == null) valid = false;
			//if (accountDetails.getDevices().get(i).getInquiryType() == null) valid = false;
			if(accountDetails.getDevices().get(i).getGroup()!=null){
				if (accountDetails.getDevices().get(i).getGroup().getNumberOfLines() < 1)valid = false;
			}
		}
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);
	}
} 