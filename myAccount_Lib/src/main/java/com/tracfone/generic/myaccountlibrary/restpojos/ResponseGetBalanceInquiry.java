package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *
 * This class defines the POJO for a devices data usage
 * It corresponds to the restful service Get data usage details. 
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseGetBalanceInquiry{

	public static class BalanceInquiry{
		@JsonProperty("transactionId")
		private int trans_id;

		public int getTrans_id() {
			return trans_id;
		}

		public void setTrans_id(int trans_id) {
			this.trans_id = trans_id;
		}


	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private BalanceInquiry balanceInquiry;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }

	public BalanceInquiry getResponse() { return balanceInquiry; }
	public void setResponse(BalanceInquiry u) { balanceInquiry = u; }

	/**
	 * This method verifies all data returned from service is valid
	 *
	 * @return  true if all request data is valid
	 */
	public void  validateBalanceInquiry()throws MyAccountServiceException {
		boolean valid = true;
		if (balanceInquiry.getTrans_id() == 0) valid = false;
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}

}
