package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

import java.text.DecimalFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class ResponseFetchBalanceInquiry{

	public static class BalanceInquiryResponse{

		@JsonProperty("voiceBalance")
		private String voice_bal;

		@JsonProperty("smsBalance")
		private String sms_bal;

		@JsonProperty("dataBalance")
		private String data_bal;

		@JsonProperty("serviceEndDate")
		private String service_enddate;

		@JsonProperty("transactionId")
		private int trans_id;

		@JsonProperty("transactionDate")
		private String transactionDate;


		public static final String UNLIMITED_VOICE = "999999";
		public String getVoice_bal() {
			return voice_bal;
		}
		public void setVoice_bal(String voice_bal) {
			this.voice_bal = voice_bal;
		}

		public static final String UNLIMITED_SMS = "999999";
		public String getSms_bal() {
			return sms_bal;
		}
		public void setSms_bal(String sms_bal) {
			this.sms_bal = sms_bal;
		}

		public static final String UNLIMITED_DATA = "9999.9";
		public String getData_bal() {
			//Convert KB to MB
			if (data_bal.isEmpty()) {
				return "0";
			} else {
				double x = Double.parseDouble(data_bal);
				x = x / 1024;
				DecimalFormat df = new DecimalFormat("#.#");
				String data_bal_mb = df.format(x);
				return data_bal_mb;
			}
		}
		public void setData_bal(String data_bal) {
			this.data_bal = data_bal;
		}

		public String getService_enddate() {
			return service_enddate;
		}

		public void setService_enddate(String service_enddate) {
			this.service_enddate = service_enddate;
		}

		public int getTrans_id() {
			return trans_id;
		}

		public void setTrans_id(int trans_id) {
			this.trans_id = trans_id;
		}

		public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }
		public String getTransactionDate() {
			String d;
			if (transactionDate != null) {
				d = transactionDate.replace("-", "/");
			} else {
				//If the date is not included in service use todays date.
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				d = dateFormat.format(new Date());
			}
			return d;
		}

	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private BalanceInquiryResponse balanceInquiryResponse;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }

	public BalanceInquiryResponse getResponse() { return balanceInquiryResponse; }
	public void setResponse(BalanceInquiryResponse u) { balanceInquiryResponse = u; }

	/**
	 * This method verifies all data returned from service is valid
	 *
	 * @return  true if all request data is valid
	 */
	public void validateFetchBalanceInquiry() throws MyAccountServiceException {
		boolean valid = true;
		if (balanceInquiryResponse.getData_bal() == null) valid = false;
		if (balanceInquiryResponse.getSms_bal() == null) valid = false;
		if (balanceInquiryResponse.getVoice_bal() == null) valid = false;
		if (balanceInquiryResponse.getService_enddate() == null) valid = false;
		if (balanceInquiryResponse.getTrans_id() == 0) valid = false;
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}

}
