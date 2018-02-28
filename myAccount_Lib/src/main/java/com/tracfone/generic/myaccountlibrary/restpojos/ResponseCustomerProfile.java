package com.tracfone.generic.myaccountlibrary.restpojos; 

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for the response to a restful request to 
 * get the Profile Details of Customer Account.  
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved.
 * ****************************************************************************/

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.*;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)   

public class ResponseCustomerProfile { 

	public static class ProfileInformation implements Parcelable {

		public static class ContactInformation implements Parcelable {
			@JsonProperty("firstName")
			private String firstName; 
			@JsonProperty("lastName")
			private String lastName;
			@JsonProperty("dateOfBirth")
			private String dateOfBirth;
			@JsonProperty("contactPhoneNumber")
			private String contactPhoneNumber; 
			@JsonProperty("address1")
			private String address1; 
			@JsonProperty("address2")
			private String address2; 
			@JsonProperty("city")
			private String city; 
			@JsonProperty("state")
			private String state;
			@JsonProperty("zipcode")
			private String zipcode;
			@JsonProperty("securityCode")
			private String securityCode;

			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
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
				this.state = state;
			}
			public String getZipcode() {
				return zipcode;
			}
			public void setZipcode(String zipcode) {
				this.zipcode = zipcode;
			}
			public String getSecurityCode() {
				return securityCode;
			}
			public void setSecurityCode(String securityCode) {
				this.securityCode = securityCode;
			}

			public ContactInformation() { }
			protected ContactInformation(Parcel in) {
				firstName = in.readString();
				lastName = in.readString();
				dateOfBirth = in.readString();
				contactPhoneNumber = in.readString();
				address1 = in.readString();
				address2 = in.readString();
				city = in.readString();
				state = in.readString();
				zipcode = in.readString();
				securityCode = in.readString();
			}
			public static final Creator<ContactInformation> CREATOR = new Creator<ContactInformation>() {
				@Override
				public ContactInformation createFromParcel(Parcel in) {
					return new ContactInformation(in);
				}
				@Override
				public ContactInformation[] newArray(int size) {
					return new ContactInformation[size];
				}
			};
			@Override
			public int describeContents() {
				return 0;
			}
			@Override
			public void writeToParcel(Parcel parcel, int i) {
				parcel.writeString(firstName);
				parcel.writeString(lastName);
				parcel.writeString(dateOfBirth);
				parcel.writeString(contactPhoneNumber);
				parcel.writeString(address1);
				parcel.writeString(address2);
				parcel.writeString(city);
				parcel.writeString(state);
				parcel.writeString(zipcode);
				parcel.writeString(securityCode);
			}
		}

		public static class LoginInformation implements Parcelable {
			@JsonProperty("email")
			private String email;

			public String getEmail() { return email; }
			public void setEmail(String email) {
				this.email = email;
			}

			public LoginInformation() { }
			protected LoginInformation(Parcel in) {
				email = in.readString();
			}
			public static final Creator<LoginInformation> CREATOR = new Creator<LoginInformation>() {
				@Override
				public LoginInformation createFromParcel(Parcel in) {
					return new LoginInformation(in);
				}
				@Override
				public LoginInformation[] newArray(int size) {
					return new LoginInformation[size];
				}
			};
			@Override
			public int describeContents() {
				return 0;
			}
			@Override
			public void writeToParcel(Parcel parcel, int i) {
				parcel.writeString(email);
			}
		}

		@JsonProperty("contactInformation")
		private ContactInformation contactInfo;
		@JsonProperty("loginInformation")
		private LoginInformation loginInfo;

		public ContactInformation getContactInfo() { return contactInfo; }
		public void setContactInfo(ContactInformation contactInfo) { this.contactInfo = contactInfo; }

		public LoginInformation getLoginInfo() { return loginInfo;	}
		public void setLoginInfo(LoginInformation loginInfo) {	this.loginInfo = loginInfo;	}

		public ProfileInformation() { }
		protected ProfileInformation(Parcel in) {
			contactInfo = in.readParcelable(ContactInformation.class.getClassLoader());
			loginInfo = in.readParcelable(LoginInformation.class.getClassLoader());
		}
		public static final Creator<ProfileInformation> CREATOR = new Creator<ProfileInformation>() {
			@Override
			public ProfileInformation createFromParcel(Parcel in) {
				return new ProfileInformation(in);
			}
			@Override
			public ProfileInformation[] newArray(int size) {
				return new ProfileInformation[size];
			}
		};
		@Override
		public int describeContents() {
			return 0;
		}
		@Override
		public void writeToParcel(Parcel parcel, int i) {
			parcel.writeParcelable(contactInfo, i);
			parcel.writeParcelable(loginInfo, i);
		}
	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private ProfileInformation profileInfo; ; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public ProfileInformation getResponse() { return profileInfo; }
	public void setResponse(ProfileInformation p) { profileInfo = p; } 

	/**
	 * This method verifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void validateCustomerProfile()throws MyAccountServiceException {
		boolean valid = true;

		if (profileInfo.getContactInfo().getFirstName()== null) valid = false; 
		if(profileInfo.getContactInfo().getLastName()==null) valid = false;
		if(profileInfo.getContactInfo().getDateOfBirth()==null) valid = false;
		if(profileInfo.getContactInfo().getContactPhoneNumber()==null) valid = false;
		if(profileInfo.getContactInfo().getAddress1()==null) valid = false;
		if(profileInfo.getContactInfo().getAddress2()==null) valid=false;
		if(profileInfo.getContactInfo().getCity()==null) valid= false;
		if(profileInfo.getContactInfo().getState()==null)valid= false;
		if(profileInfo.getContactInfo().getZipcode()==null)valid=false;
		if(profileInfo.getContactInfo().getSecurityCode()==null)valid=false;
		if(profileInfo.getLoginInfo().getEmail()==null)valid=false;

		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}
}