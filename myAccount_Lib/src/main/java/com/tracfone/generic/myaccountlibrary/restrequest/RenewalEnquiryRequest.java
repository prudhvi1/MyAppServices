package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class will perform Account Recovery Account Status Restful Web Service request to send user a verificationCode
 * via SMS
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *****************************************************************************************************************/

import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;


public class RenewalEnquiryRequest extends SpiceRequest<String>{

	public static final String CATEGORY_BAN = "BAN";
	public static final String CATEGORY_LINE = "LINE";

	private String category;
	private String identifier;
	private String zipcode;

	/**
	 * Sets the units of coffee in the Inventory
	 *
	 * @param category selects Billing Account or Line enquiry (CATEGORY_BAN or CATEGORY_LINE)
	 * @param identifer min/esn if CATEGORY_LINE      billing account id if CATEGORY_BAN
	 * @param zipcode billing/activation zipcode
	 */
	public RenewalEnquiryRequest(String category, String identifer, String zipcode ) {
		super(String.class);
		this.category = category;
		this.identifier = identifer;
		this.zipcode = zipcode;
	}


	@Override
	public String loadDataFromNetwork() throws Exception {

		String url =  RestfulURL.getUrl(RestfulURL.RENEWAL_ENQUIRY, GlobalLibraryValues.getBrand());
		String parameters = "&" + "category=" + category + "&identifier=" + identifier + "&zipcode=" + zipcode + "&lineInquiry=true";
		url = url + parameters;
		String result = null; 

		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "GET", null, getClass().toString());
		result = execConnection.executeRequest();

		return result; 
	}
}