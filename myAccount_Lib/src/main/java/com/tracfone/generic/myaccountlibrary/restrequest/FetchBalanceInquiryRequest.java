package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make Fetch Balance Inquiry restful web service request.
 *
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class FetchBalanceInquiryRequest extends SpiceRequest<String> {

	String min, esn;
	int transactionId;

	public FetchBalanceInquiryRequest(String min, String esn, int transactionId) {
		super(String.class);
		this.min = min;
		this.esn = esn;
		this.transactionId = transactionId;
	}

	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.FETCH_BALANCE_INQUIRY, GlobalLibraryValues.getBrand());
		if(esn==null || esn.isEmpty()) url = String.format(url,"min/" + min, transactionId);
		else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn, transactionId);
		else if (!min.isEmpty() && !esn.isEmpty()) url = String.format(url, "esn/" + esn, transactionId);

		String result = null;

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();

		return result;
	}

	/**
	 * This method generates a unique cache key for this request. In this case our cache key is a combination of keyword Payment Sources and the transactionId.
	 * @return
	 */
	public String createCacheKey() {
		if(esn==null || esn.isEmpty())
			return RestConstants.FETCH_BALANCE_INQUIRY + min;
		else if(min==null || min.isEmpty())
			return RestConstants.FETCH_BALANCE_INQUIRY + esn;
		return RestConstants.FETCH_BALANCE_INQUIRY + esn;
	}

	public static String getCacheKey(String key) { return RestConstants.FETCH_BALANCE_INQUIRY + key; }
}


