package com.tracfone.generic.myaccountlibrary.restpojos;

/******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for the body of the edit contact information restful service.
 * 
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * 
 * *****************************************************************************************************************/

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestEditContactInformation {

	public static class UpdateContactInformationRequest {

		@JsonProperty("firstName")
		private String firstName;
		@JsonProperty("password")
		private String password;
		@JsonProperty("lastName")
		private String lastName;
		@JsonProperty("dateOfBirth")
		private String dateOfBirth;
		@JsonProperty("contactPhoneNumber")
		private String contactPhoneNumber;
		@JsonProperty("address1")
		private String address1;
		@JsonProperty("address 2")
		private String address2;
		@JsonProperty("city")
		private String city;
		@JsonProperty("state")
		private String state;
		@JsonProperty("zipcode")
		private String zipcode;

		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getContactPhoneNumber() {
			return contactPhoneNumber;
		}
		public void setContactPhoneNumber(String contactPhoneNumber) {
			this.contactPhoneNumber = contactPhoneNumber;
		}
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state ;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

	}

	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private UpdateContactInformationRequest request;

	public RequestCommon getCommon() {
		return common;
	}
	public void setCommon(RequestCommon common) {
		this.common = common;
	}
	public UpdateContactInformationRequest getRequest() {
		return request;
	}
	public void setRequest(UpdateContactInformationRequest request) {
		this.request = request;
	}

}
