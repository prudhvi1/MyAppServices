package com.tracfone.generic.myaccountlibrary.restpojos; 

/*************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class ResponseCreditCardList defines the POJO for credit card list details response from the restful service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved.
 * ************************************************************************************************************************/

import java.util.ArrayList; 
import java.util.Collection;
import java.util.List; 

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseCreditCardList.CreditCardList.CreditCard;

@SuppressLint("DefaultLocale")
@JsonIgnoreProperties(ignoreUnknown = true) 

public class ResponseCreditCardList { 

	public static class CreditCardList implements Parcelable {

		public static class CreditCard implements Parcelable {

			@JsonProperty("paymentSourceId")
			private int ccPaymentSourceId;
			@JsonProperty("paymentSourceNickName") 
			private String ccNickName;
			@JsonProperty("paymentSourceType")
			private String ccType;
			@JsonProperty("paymentSourceNumberMask")
			private String ccPartialNumber;
			@JsonProperty("defaultPaymentSource")
			private String ccDefaultSource;
			@JsonProperty("billingZipCode")
			private String ccBillingZipCode;


			public static class AccountHolderName implements Parcelable{
				@JsonProperty("firstName")
				private String firstName;
				@JsonProperty("lastName")
				private String lastName;

				public AccountHolderName() { }

				protected AccountHolderName(Parcel in) {
					firstName = in.readString();
					lastName = in.readString();
				}

				public static final Creator<AccountHolderName> CREATOR = new Creator<AccountHolderName>() {
					@Override
					public AccountHolderName createFromParcel(Parcel in) {
						return new AccountHolderName(in);
					}

					@Override
					public AccountHolderName[] newArray(int size) {
						return new AccountHolderName[size];
					}
				};

				@Override
				public int describeContents() {
					return 0;
				}

				@Override
				public void writeToParcel(Parcel dest, int flags) {
					dest.writeString(firstName);
					dest.writeString(lastName);
				}

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
			}

			public static class ExpirationDate implements Parcelable{
				@JsonProperty("expirationMonth")
				private String expirationMonth;
				@JsonProperty("expirationYear")
				private String expirationYear;

				public ExpirationDate() { }

				protected ExpirationDate(Parcel in) {
					expirationMonth = in.readString();
					expirationYear = in.readString();
				}

				@Override
				public void writeToParcel(Parcel dest, int flags) {
					dest.writeString(expirationMonth);
					dest.writeString(expirationYear);
				}

				@Override
				public int describeContents() {
					return 0;
				}

				public static final Creator<ExpirationDate> CREATOR = new Creator<ExpirationDate>() {
					@Override
					public ExpirationDate createFromParcel(Parcel in) {
						return new ExpirationDate(in);
					}

					@Override
					public ExpirationDate[] newArray(int size) {
						return new ExpirationDate[size];
					}
				};

				public String getExpirationMonth() {
					return expirationMonth;
				}

				public void setExpirationMonth(String expirationMonth) {
					this.expirationMonth = expirationMonth;
				}

				public String getExpirationYear() {
					return expirationYear;
				}

				public void setExpirationYear(String expirationYear) {
					this.expirationYear = expirationYear;
				}
			}

			@JsonProperty("accountHolderName")
			private AccountHolderName ccAccountHolderName;
			@JsonProperty("expirationDate")
			private ExpirationDate ccExpirationDate;

			public void setCcPaymentSourceId(int ccPaymentSourceId) { this.ccPaymentSourceId = ccPaymentSourceId; }
			public String getCcPaymentSourceId() { return String.valueOf(ccPaymentSourceId); }  

			public void setCcNickName(String ccNickName) { this.ccNickName = ccNickName; } 
			public String getCcNickName() {
				if (ccNickName == null)  ccNickName = "";
				return ccNickName; }


			public static final String CCTYPE_VISA = "VISA";
			public static final String CCTYPE_MASTERCARD = "MASTER";
			public static final String CCTYPE_AMEX = "AMEX";
			public static final String CCTYPE_DISCOVER = "DISCOVER";
			public void setCcType(String ccType) { this.ccType = ccType.toUpperCase(); } 
			public String getCcType() { return ccType; }  

			public void setCcPartialNumber(String ccPartialNumber) { this.ccPartialNumber = ccPartialNumber; } 
			public String getCcPartialNumber() { return ccPartialNumber; }   

			public void setCcDefaultSource(String ccDefaultSource) { this.ccDefaultSource = ccDefaultSource; } 
			public boolean getCcDefaultSource() {   
				if (ccDefaultSource != null)  {
					return (ccDefaultSource.equals("true"))?true:false; 
				} else {
					return false;
				}
			}
			public String getCcDefaultSourceCheck() { return ccDefaultSource; }

			public String getCcBillingZipCode() { return ccBillingZipCode; }
			public void setCcBillingZipCode(String ccBillingZipCode) { this.ccBillingZipCode = ccBillingZipCode; }


			public AccountHolderName getCcAccountHolderName() {
				return ccAccountHolderName;
			}

			public void setCcAccountHolderName(AccountHolderName ccAccountHolderName) {
				this.ccAccountHolderName = ccAccountHolderName;
			}

			public ExpirationDate getCcExpirationDate() {
				return ccExpirationDate;
			}

			public void setCcExpirationDate(ExpirationDate ccExpirationDate) {
				this.ccExpirationDate = ccExpirationDate;
			}

			public void setCcDefault() {
				this.ccPaymentSourceId = 0; 
				this.ccNickName = "---";  
				this.ccType = "--";   
				this.ccPartialNumber = "************----";
				this.ccDefaultSource = "false";
				this.ccBillingZipCode = "--"; 
			}

			public void setCcAll(int ccPaymentSourceId, String ccNickName, String ccType, String ccPartialNumber, String ccDefaultSource, String ccBillingZipCode, AccountHolderName ccAccountHolderName, ExpirationDate ccExpirationDate) {
				this.ccPaymentSourceId = ccPaymentSourceId; 
				this.ccNickName = ccNickName;  
				this.ccType = ccType;  
				this.ccPartialNumber = ccPartialNumber; 
				this.ccDefaultSource = ccDefaultSource;
				this.ccBillingZipCode = ccBillingZipCode;
				this.ccAccountHolderName = ccAccountHolderName;
				this.ccExpirationDate = ccExpirationDate;
			}

			public CreditCard() { }
			protected CreditCard(Parcel in) {
				ccPaymentSourceId = in.readInt();
				ccNickName = in.readString();
				ccType = in.readString();
				ccPartialNumber = in.readString();
				ccDefaultSource = in.readString();
				ccBillingZipCode = in.readString();
				ccAccountHolderName = in.readParcelable(AccountHolderName.class.getClassLoader());
				ccExpirationDate = in.readParcelable(ExpirationDate.class.getClassLoader());
			}
			public static final Creator<CreditCard> CREATOR = new Creator<CreditCard>() {
				@Override
				public CreditCard createFromParcel(Parcel in) {
					return new CreditCard(in);
				}
				@Override
				public CreditCard[] newArray(int size) {
					return new CreditCard[size];
				}
			};
			@Override
			public int describeContents() {
				return 0;
			}
			@Override
			public void writeToParcel(Parcel parcel, int i) {
				parcel.writeInt(ccPaymentSourceId);
				parcel.writeString(ccNickName);
				parcel.writeString(ccType);
				parcel.writeString(ccPartialNumber);
				parcel.writeString(ccDefaultSource);
				parcel.writeString(ccBillingZipCode);
				parcel.writeParcelable(ccAccountHolderName, i);
				parcel.writeParcelable(ccExpirationDate, i);
			}
		}
		@JsonProperty("paymentSources")
		private List<CreditCard> creditCard = new ArrayList<CreditCard>(); 

		public List<CreditCard> getCreditCard() { return creditCard; } 
		public void setCreditCard(List<CreditCard> c) { creditCard = c; }

		public CreditCardList() {}
		protected CreditCardList(Parcel in) {
			in.readTypedList(creditCard,CreditCard.CREATOR);
		}
		public static final Creator<CreditCardList> CREATOR = new Creator<CreditCardList>() {
			@Override
			public CreditCardList createFromParcel(Parcel in) {
				return new CreditCardList(in);
			}
			@Override
			public CreditCardList[] newArray(int size) {
				return new CreditCardList[size];
			}
		};
		@Override
		public int describeContents() {
			return 0;
		}
		@Override
		public void writeToParcel(Parcel parcel, int i) {
			parcel.writeTypedList(creditCard);
		}
	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private CreditCardList creditCardList; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public CreditCardList getResponse() { return creditCardList; }
	public void setResponse(CreditCardList c) { creditCardList = c; }   

	/**
	 * This method verifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void validateCreditCardList() throws MyAccountServiceException{
		boolean valid = true;
		for (int i = 0; i < creditCardList.getCreditCard().size(); i++) {
			if (creditCardList.getCreditCard().get(i).getCcPaymentSourceId() == null) valid = false;
			if (creditCardList.getCreditCard().get(i).getCcNickName() == null) valid = false;
			if (creditCardList.getCreditCard().get(i).getCcType() == null) valid = false; 
			if (creditCardList.getCreditCard().get(i).getCcPartialNumber() == null) valid = false; 
			if (creditCardList.getCreditCard().get(i).getCcDefaultSourceCheck() == null) valid = false;
			if (creditCardList.getCreditCard().get(i).getCcBillingZipCode() == null) valid = false;   
		} 
		if(valid)
			reOrderCreditCardList();
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}
	public void reOrderCreditCardList()
	{
		int defaultPosition=0;
		Collection<CreditCard> beforeDefaultCC;
		Collection<CreditCard> afterDefaultCC;
		Collection<CreditCard> reOrderedCCList;
		CreditCard defaultCC;
		for(int i=0; i<creditCardList.getCreditCard().size();i++)
		{
			if (creditCardList.getCreditCard().get(i).getCcDefaultSource())
			{
				defaultPosition=i;
				break;
			}
		}
		if(defaultPosition>0)
		{
			beforeDefaultCC=creditCardList.getCreditCard().subList(0, defaultPosition);
			afterDefaultCC=creditCardList.getCreditCard().subList(defaultPosition+1, creditCardList.getCreditCard().size());
			defaultCC=creditCardList.getCreditCard().get(defaultPosition);
			reOrderedCCList=new ArrayList<CreditCard>();
			reOrderedCCList.add(defaultCC);
			reOrderedCCList.addAll(beforeDefaultCC);
			reOrderedCCList.addAll(afterDefaultCC);
			creditCardList.getCreditCard().clear();
			creditCardList.getCreditCard().addAll(reOrderedCCList);
		}
	}
}