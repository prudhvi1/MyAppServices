package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for the CreateNewAcct web service
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/


import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestCreateNewAccount {
	
	public static class CreateAcctRequest {
		
		@JsonProperty("accountId")
		private int accountId;
		@JsonProperty("min")
		private String min;
		@JsonProperty("esn")
		private String esn;
		@JsonProperty("sim")
		private String sim;
		@JsonProperty("zipcode")
		private String zipcode;
		@JsonProperty("password")
		private String password;
		@JsonProperty("dateOfBirth")
		private String dob;
		@JsonProperty("securityCode")
		private String security_code;
		@JsonProperty("contactPhoneNumber")
		private String contactPhoneNumber;
		@JsonProperty("securityQuestionId")
		private int security_question_id;
		@JsonProperty("securityAnswer")
		private String security_answer;
		
		public static class SocialMediaJson {

			@JsonProperty("socialMediaUid")
			private String app_scoped_id;
			@JsonProperty("token_for_business")
			private String token_for_business;
			@JsonProperty("lastName")
			private String last_name;
			@JsonProperty("firstName")
			private String first_name;
			@JsonProperty("link")
			private String link;
			@JsonProperty("userName")
			private String user_name;
			@JsonProperty("gender")
			private String gender;
			@JsonProperty("locale")
			private String locale;
			@JsonProperty("ageRange")
			private String age_range;
			@JsonProperty("email")
			private String email;
			
			@JsonProperty("friendListNode")
			private String friendListNode;
			
			public String getApp_scoped_id() {
				return app_scoped_id;
			}
			public void setApp_scoped_id(String app_scoped_id) {
				this.app_scoped_id = app_scoped_id;
			}

			public String getToken_for_business() {
				return token_for_business;
			}
			public void setToken_for_business(String token_for_business) {
				this.token_for_business = token_for_business;
			}
			
			public String getLastName() { return last_name; }
			public void setLastName(String l) { last_name = l; }
		
			public String getFirstName() { return first_name; }
			public void setFirstName(String f) { first_name = f; }
			
			public String getLink() {
				return link;
			}
			public void setLink(String link) {
				this.link = link;
			}
			
			public String getUser_name() {
				return user_name;
			}
			public void setUser_name(String user_name) {
				this.user_name = user_name;
			}
			
			public String getGender() {
				return gender;
			}
			public void setGender(String gender) {
				this.gender = gender;
			}
			public String getLocale() {
				return locale;
			}
			public void setLocale(String locale) {
				this.locale = locale;
			}
			public String getAge_range() {
				return age_range;
			}
			public void setAge_range(String age_range) {
				this.age_range = age_range;
			}
		
			public String getEmail() { return email;}
			public void setEmail(String e) { email = e; }
			
			public String getFriendListNode() {
				return friendListNode;
			}
			public void setFriendListNode(String friendListNode) {
				this.friendListNode = friendListNode;
			}
		}

		public int getAccountId() {
			return accountId;
		}

		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}

		public String getMin() {
			return min;
		}

		public void setMin(String min) {
			this.min = min;
		}

		public String getEsn() {
			return esn;
		}

		public void setEsn(String esn) {
			this.esn = esn;
		}

		public String getSim() {
			return sim;
		}

		public void setSim(String sim) {
			this.sim = sim;
		}

		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getSecurity_code() {
			return security_code;
		}

		public void setSecurity_code(String securityCode) { this.security_code = securityCode; }

		public String getContactPhoneNumber() {
			return contactPhoneNumber;
		}

		public void setContactPhoneNumber(String contactPhoneNumber) { this.contactPhoneNumber = contactPhoneNumber; }

		public int getSecurity_question_id() {
			return security_question_id;
		}

		public void setSecurity_question_id(int security_question_id) {
			this.security_question_id = security_question_id;
		}

		public String getSecurity_answer() {
			return security_answer;
		}

		public void setSecurity_answer(String security_answer) {
			this.security_answer = security_answer;
		}
		
		@JsonProperty("socialMedia")
		private SocialMediaJson socialMediaJson ;

		public SocialMediaJson getSocialMediaJson() { return socialMediaJson; }
		public void setSocialMediaJson(SocialMediaJson socialMediaJson) { this.socialMediaJson = socialMediaJson; }
	}
 
	@JsonProperty("common")
	private RequestCommon common;
	@JsonProperty("request")
	private CreateAcctRequest request; 

	public RequestCommon getCommon() { return common; }
	public void setCommon(RequestCommon c) { common = c; }  
	
	public CreateAcctRequest getRequest() { return request; }
	public void setRequest(CreateAcctRequest r) { request = r; } 
	
}
