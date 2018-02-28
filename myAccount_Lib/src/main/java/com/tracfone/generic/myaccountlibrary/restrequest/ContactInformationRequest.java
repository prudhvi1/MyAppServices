package com.tracfone.generic.myaccountlibrary.restrequest;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class will make to Update contact information restful web service request. 
 *
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * *****************************************************************************************************************/
  
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues; 
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditContactInformation;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEditContactInformation.UpdateContactInformationRequest;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class ContactInformationRequest extends SpiceRequest<String> {
 
	String accountId, firstName, password, lastName, dateOfBirth, contactPhonenumber, address1, address2, city,state, zipcode;

	public ContactInformationRequest(String accountId, String firstName, String password, String lastName, String dateOfBirth, String contactPhonenumber, String address1, String address2, String city, String state, String zipcode) {
		super(String.class);
		this.accountId = accountId;
		this.firstName = firstName;
		this.password = password;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.contactPhonenumber = contactPhonenumber;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	@Override
	public String loadDataFromNetwork() throws Exception {		
		String url =  RestfulURL.getUrl(RestfulURL.UPDATE_PROFILE_CONTACT, GlobalLibraryValues.getBrand()); 
		url = String.format(url,accountId);  
		 
		String result = null; 

		//Populate and create Body  
		RequestEditContactInformation editContact = new RequestEditContactInformation();
		UpdateContactInformationRequest editcontactinfo = new UpdateContactInformationRequest();
		editcontactinfo.setFirstName(firstName);
		editcontactinfo.setPassword(password);
		editcontactinfo.setLastName(lastName);
		editcontactinfo.setDateOfBirth(dateOfBirth);
		editcontactinfo.setContactPhoneNumber(contactPhonenumber);
		editcontactinfo.setAddress1(address1);
		editcontactinfo.setAddress2(address2 );
		editcontactinfo.setCity(city);
		editcontactinfo.setState(state);
		editcontactinfo.setZipcode(zipcode); 
		
		editContact.setRequest(editcontactinfo); 
		RequestCommon requestCommon = new RequestCommon();
		requestCommon.setAll();
		editContact.setCommon(requestCommon); 
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(editContact);
		 
		SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RONS, url, "PUT", jsonString, getClass().toString());
		result = execConnection.executeRequest();

		//For security purposes erase url and body of request which may reside on heap
		url = "";
		jsonString = "";
		
		return result; 
	}
}
