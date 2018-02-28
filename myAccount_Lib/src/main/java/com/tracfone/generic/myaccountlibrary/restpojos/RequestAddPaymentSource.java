package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) 

public class RequestAddPaymentSource {
	
	public static class AddPaymentRequest{
		
		@JsonProperty("paymentSourceNickName")
		private String c_NickName;
		@JsonProperty("creditCardType")
		private String c_Type;
		@JsonProperty ("paymentSourceType")
		private String paymentSourceType;
		@JsonProperty("paymentSourceNumber")
		private String c_Number;
		@JsonProperty("expirationMonth")
		private String c_expirationMonth;
		@JsonProperty("expirationYear")
		private String c_expirationYear;
		@JsonProperty("firstName")
		private String c_firstName;
		@JsonProperty("lastName")
		private String c_lastName;
		@JsonProperty("addressLine1")
		private String c_addressLine1;
		@JsonProperty("addressLine2")
		private String c_addressLine2;
		@JsonProperty("city")
		private String c_city;
		@JsonProperty("country")
		private String c_country;
		@JsonProperty("state")
		private String c_state;
		@JsonProperty("zipcode")
		private String c_zip_Code;
		@JsonProperty("phoneNumber")
		private String c_contact_number;
		@JsonProperty("defaultPaymentSource")
		private boolean c_isDefault;
		public String getC_NickName() {
			return c_NickName;
		}
		public void setC_NickName(String c_NickName) {
			this.c_NickName = c_NickName;
		}
		public String getC_Type() {
			return c_Type;
		}
		public void setC_Type(String c_Type) {
			this.c_Type = c_Type;
		}
		
		public String getPaymentSourceType() {
			return paymentSourceType;
		}
		public void setPaymentSourceType(String paymentSourceType) {
			this.paymentSourceType = paymentSourceType;
		}
		public String getC_Number() {
			return c_Number;
		}
		public void setC_Number(String c_Number) {
			this.c_Number = c_Number;
		}
		public String getC_expirationMonth() {
			return c_expirationMonth;
		}
		public void setC_expirationMonth(String c_expirationMonth) {
			this.c_expirationMonth = c_expirationMonth;
		}
		public String getC_expirationYear() {
			return c_expirationYear;
		}
		public void setC_expirationYear(String c_expirationYear) {
			this.c_expirationYear = c_expirationYear;
		}
		public String getC_firstName() {
			return c_firstName;
		}
		public void setC_firstName(String c_firstName) {
			this.c_firstName = c_firstName;
		}
		public String getC_lastName() {
			return c_lastName;
		}
		public void setC_lastName(String c_lastName) {
			this.c_lastName = c_lastName;
		}
		public String getC_addressLine1() {
			return c_addressLine1;
		}
		public void setC_addressLine1(String c_addressLine1) {
			this.c_addressLine1 = c_addressLine1;
		}
		public String getC_addressLine2() {
			return c_addressLine2;
		}
		public void setC_addressLine2(String c_addressLine2) {
			this.c_addressLine2 = c_addressLine2;
		}
		public String getC_city() {
			return c_city;
		}
		public void setC_city(String c_city) {
			this.c_city = c_city;
		}
		public String getC_state() {
			return c_state;
		}
		public void setC_state(String c_state) {
			this.c_state = c_state;
		}
		public String getC_zip_Code() {
			return c_zip_Code;
		}
		public void setC_zip_Code(String c_zip_Code) {
			this.c_zip_Code = c_zip_Code;
		}
		public String getC_country() {
			return c_country;
		}
		public void setC_country(String c_country) {
			this.c_country = c_country;
		}
		public String getC_contact_number() {
			return c_contact_number;
		}
		public void setC_contact_number(String c_contact_number) {
			this.c_contact_number = c_contact_number;
		}
		public boolean getC_isDefault() {
			return c_isDefault;
		}
		public void setC_isDefault(boolean c_isDefault) {
			this.c_isDefault = c_isDefault;
		}
		
	}
	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private AddPaymentRequest request;
	public RequestCommon getCommon() {return common;}
	public void setCommon(RequestCommon common) {this.common = common;}
	public AddPaymentRequest getRequest() {return request;}
	public void setRequest(AddPaymentRequest request) {this.request = request;}
	
}
