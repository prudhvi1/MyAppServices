package com.tracfone.generic.myaccountlibrary.restpojos; 

/*************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class ResponseCreditCardList defines the POJO for credit card list details response from the restful service.
 * 
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ************************************************************************************************************************/

/*************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class ResponseCreditCardList defines the POJO for credit card list details response from the restful service.
 * 
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ************************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true) 

public class ResponseAddPaymentSource { 

	public static class AddPaymentSource{ 
			@JsonProperty("paymentSourceId")
			private int ccPaymentSourceId;

			public int getCcPaymentSourceId() {
				return ccPaymentSourceId;
			}

			public void setCcPaymentSourceId(int ccPaymentSourceId) {
				this.ccPaymentSourceId = ccPaymentSourceId;
			}

		}

		@JsonProperty("status")
		private ResponseStatus status;
		@JsonProperty("response")
		private AddPaymentSource addPaymentSource;
		public ResponseStatus getCommon() { return status; }
		public void setCommon(ResponseStatus s) { status = s; }  
		public AddPaymentSource getResponse() { return addPaymentSource; }
		public void setResponse(AddPaymentSource aps) { addPaymentSource = aps; } 
	/**
	 * This method verifies all data returned from service is valid
	 *
	 * @return  true if all request data is valid
	 */
	public void validateAddPaymentSource()throws MyAccountServiceException {
		boolean valid = true;
		if (addPaymentSource.getCcPaymentSourceId() == 0) valid = false;
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}
} 
