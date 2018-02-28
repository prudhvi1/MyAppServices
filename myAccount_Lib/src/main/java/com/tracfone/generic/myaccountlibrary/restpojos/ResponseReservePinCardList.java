package com.tracfone.generic.myaccountlibrary.restpojos; 

/***********************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class ResponseReservePinCardList defines the response POJO for Reserve Pin card list details.
 * It corresponds to the restful service Manage Pin Card Reserves.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * **********************************************************************************************************/

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List; 

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseReservePinCardList.ReservePinCardList.ReservePinCard;

@JsonIgnoreProperties(ignoreUnknown = true) 

public class ResponseReservePinCardList { 

	public static class ReservePinCardList {

		public static class ReservePinCard implements Parcelable{

			@JsonProperty("pinCard")
			private String rpPinCard;
			@JsonProperty("servicePlanId") 
			private String rpServicePlanId;
			@JsonProperty("servicePlanName")
			private String rpServicePlanName;
			@JsonProperty("servicePlanDescription")
			private String rpServicePlanDesc;
			@JsonProperty("servicePlanDescription2")
			private String rpServicePlanDesc2;
			@JsonProperty("servicePlanDescription3")
			private String rpServicePlanDesc3;
			@JsonProperty("servicePlanDescription4")
			private String rpServicePlanDesc4;
			@JsonProperty("voiceUnits")
			private String rpVoiceUnits;
			@JsonProperty("smsUnits")
			private String rpSmsUnits;
			@JsonProperty("dataUnits")
			private String rpDataUnits;
			@JsonProperty("serviceDays")
			private String rpServiceDays;
			@JsonProperty("reserveId")
			private String rpReserveId;
			@JsonProperty("reserveIndex")
			private String rpReserveIndex;
			@JsonProperty("price")
			private String rpPrice;

			public String getRpPinCard() {return rpPinCard;}
			public void setRpPinCard(String rpPinCard){this.rpPinCard = rpPinCard;}

			public int getRpServicePlanId() {
				if (rpServicePlanId != null) {
					return Integer.parseInt(rpServicePlanId);}
				else 
					return -1;
			}
			public void setRpServicePlanId(String rpServicePlanId) {this.rpServicePlanId = rpServicePlanId;}

			public void setRpServicePlanName(String rpServicePlanName) { this.rpServicePlanName = rpServicePlanName; } 
			public String getRpServicePlanName() { return rpServicePlanName; }  

			public void setRpServicePlanDesc(String rpServicePlanDesc) { this.rpServicePlanDesc = rpServicePlanDesc; } 
			public String getRpServicePlanDesc() { return rpServicePlanDesc; }  

			public void setRpServicePlanDesc2(String rpServicePlanDesc2) { this.rpServicePlanDesc2 = rpServicePlanDesc2; } 
			public String getRpServicePlanDesc2() { return rpServicePlanDesc2; }
			
			public void setRpServicePlanDesc3(String rpServicePlanDesc3) { this.rpServicePlanDesc3 = rpServicePlanDesc3; } 
			public String getRpServicePlanDesc3() { return rpServicePlanDesc3; }
			
			public void setRpServicePlanDesc4(String rpServicePlanDesc4) { this.rpServicePlanDesc4 = rpServicePlanDesc4; } 
			public String getRpServicePlanDesc4() { return rpServicePlanDesc4; }

			public String getRpVoiceUnits() { return rpVoiceUnits;}
			public void setRpVoiceUnits(String rpVoiceUnits) {this.rpVoiceUnits = rpVoiceUnits;}

			public String getRpSmsUnits() { return rpSmsUnits;}
			public void setRpSmsUnits(String rpSmsUnits) {this.rpSmsUnits = rpSmsUnits;}

			public void setRpDataUnits(String rpDataUnits) { this.rpDataUnits = rpDataUnits; } 
			public String getRpDataUnits() { return rpDataUnits; }  

			public String getRpServiceDays() {	return rpServiceDays;}
			public void setRpServiceDays(String rpServiceDays) {this.rpServiceDays = rpServiceDays;}   			

			public long getRpReserveId() {
				if (rpReserveId != null) {
					return Long.parseLong(rpReserveId);}
				else
					return -1;
			}
			public void setRpReserveId(String rpReserveId) {this.rpReserveId = rpReserveId;}

			public int getRpReserveIndex() {
				if (rpReserveIndex != null) {
					return Integer.parseInt(rpReserveIndex);}
				else
					return -1;
			}
			public void setRpReserveIndex(String rpReserveIndex) {this.rpReserveIndex = rpReserveIndex;}

			public double getRpPrice() {
				if(rpPrice!=null) {
					return Double.parseDouble(rpPrice); }
				else
					return -1;
			}
			public void setRpPrice(String rpPrice) {
				this.rpPrice = rpPrice;
			}


			public ReservePinCard() { }
			protected ReservePinCard(Parcel in) {
				rpPinCard = in.readString();
				rpServicePlanId = in.readString();
				rpServicePlanName = in.readString();
				rpServicePlanDesc = in.readString();
				rpServicePlanDesc2 = in.readString();
				rpServicePlanDesc3 = in.readString();
				rpServicePlanDesc4 = in.readString();
				rpVoiceUnits = in.readString();
				rpSmsUnits = in.readString();
				rpDataUnits = in.readString();
				rpServiceDays = in.readString();
				rpReserveId = in.readString();
				rpReserveIndex = in.readString();
				rpPrice = in.readString();
			}
			public static final Creator<ReservePinCard> CREATOR = new Creator<ReservePinCard>() {
				@Override
				public ReservePinCard createFromParcel(Parcel in) {
					return new ReservePinCard(in);
				}
				@Override
				public ReservePinCard[] newArray(int size) {
					return new ReservePinCard[size];
				}
			};
			@Override
			public int describeContents() {
				return 0;
			}
			@Override
			public void writeToParcel(Parcel parcel, int i) {
				parcel.writeString(rpPinCard);
				parcel.writeString(rpServicePlanId);
				parcel.writeString(rpServicePlanName);
				parcel.writeString(rpServicePlanDesc);
				parcel.writeString(rpServicePlanDesc2);
				parcel.writeString(rpServicePlanDesc3);
				parcel.writeString(rpServicePlanDesc4);
				parcel.writeString(rpVoiceUnits);
				parcel.writeString(rpSmsUnits);
				parcel.writeString(rpDataUnits);
				parcel.writeString(rpServiceDays);
				parcel.writeString(rpReserveId);
				parcel.writeString(rpReserveIndex);
				parcel.writeString(rpPrice);
			}


			public void setRpDefault() {
				this.rpPinCard = "----------"; 
				this.rpServicePlanId = "--";  
				this.rpServicePlanName = "--";   
				this.rpServicePlanDesc = "----------------";
				this.rpServicePlanDesc2 = "----------------";
				this.rpServicePlanDesc3 = "----------------";
				this.rpServicePlanDesc4 = "----------------";
				this.rpVoiceUnits = "--"; 
				this.rpSmsUnits = "--";  
				this.rpDataUnits = "---";   
				this.rpServiceDays = "--";
				this.rpReserveId = "--";
				this.rpReserveIndex = "--";
				this.rpPrice="0";
			} 
			 
		} 

		@JsonProperty("reserve")
		private List<ReservePinCard> reservePinCard = new ArrayList<ReservePinCard>(); 

		public List<ReservePinCard> getReservePinCard() { return reservePinCard ; } 
		public void setReservePinCard(List<ReservePinCard> r) { reservePinCard = r;  }
	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private ReservePinCardList reservePinCardList; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public ReservePinCardList getResponse() { return reservePinCardList; }
	public void setResponse(ReservePinCardList r) { reservePinCardList = r; }   
	/**
	 * This method verifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void validateReservePinCardList() throws MyAccountServiceException {
		boolean valid = true;
		for (int i = 0; i < reservePinCardList.getReservePinCard().size(); i++) {
			if (reservePinCardList.getReservePinCard().get(i).getRpPinCard() == null) valid = false; 
			if (reservePinCardList.getReservePinCard().get(i).getRpServicePlanId() == -1) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpServicePlanName() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpServicePlanDesc() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpServicePlanDesc2() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpServicePlanDesc3() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpServicePlanDesc4() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpVoiceUnits() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpSmsUnits() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpDataUnits() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpServiceDays() == null) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpReserveId() == -1) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpReserveIndex() == -1) valid = false;
			if (reservePinCardList.getReservePinCard().get(i).getRpPrice() == -1) valid = false;
		} 
		if(valid)
			reOrderReserveList();
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);
	}
	public void reOrderReserveList()
	{
		Collections.sort(reservePinCardList.getReservePinCard(), new Comparator<ReservePinCard>() {
			@Override
			public int compare(ReservePinCard rpc1, ReservePinCard rpc2) {				
				Integer i1=new Integer(Integer.parseInt(rpc1.rpReserveIndex));
				Integer i2=new Integer(Integer.parseInt(rpc2.rpReserveIndex));
				return i1.compareTo(i2);
			}
		});
	}
} 