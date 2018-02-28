package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for the response to a restful request to
 * view the Transaction History.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved.
 * ****************************************************************************/

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseTransactionHistory {

	public static class TransactionHistory implements Parcelable {

		public static class Transaction implements Parcelable {
			@JsonProperty("transactionDate")
			private String tTransactionDate;
			@JsonProperty("transactionType")
			private String tTransactionType;
			@JsonProperty("transactionId")
			private String tTransactionId;
			@JsonProperty("servicePlanDescription")
			private String tServicePlanDescription;
			@JsonProperty("servicePlanDescription2")
			private String tServicePlanDescription2;
			@JsonProperty("servicePlanDescription3")
			private String tServicePlanDescription3;
			@JsonProperty("servicePlanDescription4")
			private String tServicePlanDescription4;

			public String gettTransactionDate() {return tTransactionDate;}
			public void settTransactionDate(String tTransactionDate) {this.tTransactionDate = tTransactionDate;}

			public String gettTransactionType() {return tTransactionType;}
			public void settTransactionType(String tTransactionType) {this.tTransactionType = tTransactionType;}

			public String gettTransactionId() {return tTransactionId;}
			public void settTransactionId(String tTransactionId) {this.tTransactionId = tTransactionId;}

			public String gettServicePlanDescription() {return tServicePlanDescription;}
			public void settServicePlanDescription(String tServicePlanDescription) {this.tServicePlanDescription = tServicePlanDescription;}

			public String gettServicePlanDescription2() {return tServicePlanDescription2;}
			public void settServicePlanDescription2(String tServicePlanDescription2) {this.tServicePlanDescription2 = tServicePlanDescription2;}

			public String gettServicePlanDescription3() {return tServicePlanDescription3;}
			public void settServicePlanDescription3(String tServicePlanDescription3) {this.tServicePlanDescription3 = tServicePlanDescription3;}

			public String gettServicePlanDescription4() {return tServicePlanDescription4;}
			public void settServicePlanDescription4(String tServicePlanDescription4) {this.tServicePlanDescription4 = tServicePlanDescription4; }

			public static class DeviceInfo implements Parcelable {

				@JsonProperty("deviceNickName")
				private String devNickName;
				@JsonProperty("min")
				private String devMin;

				public String getDevNickName() { return devNickName;	}
				public void setDevNickName(String devNickName) { this.devNickName = devNickName;	}

				public String getDevMin() {	return devMin;	}
				public void setDevMin(String devMin) { this.devMin = devMin; }

				public DeviceInfo() { }
				protected DeviceInfo(Parcel in) {
					devNickName = in.readString();
					devMin = in.readString();
				}

				public static final Creator<DeviceInfo> CREATOR = new Creator<DeviceInfo>() {
					@Override
					public DeviceInfo createFromParcel(Parcel in) {
						return new DeviceInfo(in);
					}
					@Override
					public DeviceInfo[] newArray(int size) {
						return new DeviceInfo[size];
					}
				};
				@Override
				public int describeContents() {
					return 0;
				}
				@Override
				public void writeToParcel(Parcel parcel, int i) {
					parcel.writeString(devNickName);
					parcel.writeString(devMin);
				}
			}

			@JsonProperty("device")
			private DeviceInfo deviceInfo;

			public DeviceInfo getDeviceInfo() {	return deviceInfo;	}
			public void setDeviceInfo(DeviceInfo deviceInfo) {	this.deviceInfo = deviceInfo; }
			public static class GroupInfo implements Parcelable {

				@JsonProperty("groupId")
				private String groupId;
				@JsonProperty("groupName")
				private String groupName;

				public String getGroupId() {
					return groupId;
				}
				public void setGroupId(String groupId) {
					this.groupId = groupId;
				}
				public String getGroupName() {
					return groupName;
				}
				public void setGroupName(String groupName) {
					this.groupName = groupName;
				}

				public GroupInfo() { }
				protected GroupInfo(Parcel in) {
					groupId = in.readString();
					groupName = in.readString();
				}
				public static final Creator<GroupInfo> CREATOR = new Creator<GroupInfo>() {
					@Override
					public GroupInfo createFromParcel(Parcel in) {
						return new GroupInfo(in);
					}
					@Override
					public GroupInfo[] newArray(int size) {
						return new GroupInfo[size];
					}
				};
				@Override
				public int describeContents() {
					return 0;
				}
				@Override
				public void writeToParcel(Parcel parcel, int i) {
					parcel.writeString(groupId);
					parcel.writeString(groupName);
				}
			}
			@JsonProperty("groupInfo")
			private GroupInfo groupInfo;
			public GroupInfo getGroupInfo() {return groupInfo;}
			public void setGroupInfo(GroupInfo groupInfo) {this.groupInfo = groupInfo;}
			public Transaction() { }
			protected Transaction(Parcel in) {
				tTransactionDate = in.readString();
				tTransactionType = in.readString();
				tTransactionId = in.readString();
				tServicePlanDescription = in.readString();
				tServicePlanDescription2 = in.readString();
				tServicePlanDescription3 = in.readString();
				tServicePlanDescription4 = in.readString();
				deviceInfo = in.readParcelable(DeviceInfo.class.getClassLoader());
				groupInfo = in.readParcelable(GroupInfo.class.getClassLoader());
			}
			public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
				@Override
				public Transaction createFromParcel(Parcel in) {
					return new Transaction(in);
				}
				@Override
				public Transaction[] newArray(int size) {
					return new Transaction[size];
				}
			};
			@Override
			public int describeContents() {
				return 0;
			}
			@Override
			public void writeToParcel(Parcel parcel, int i) {
				parcel.writeString(tTransactionDate);
				parcel.writeString(tTransactionType);
				parcel.writeString(tTransactionId);
				parcel.writeString(tServicePlanDescription);
				parcel.writeString(tServicePlanDescription2);
				parcel.writeString(tServicePlanDescription3);
				parcel.writeString(tServicePlanDescription4);
				parcel.writeParcelable(deviceInfo, i);
				parcel.writeParcelable(groupInfo,i);			}
		}

		@JsonProperty("transactions")
		private List<Transaction> transaction = new ArrayList<Transaction>();

		public List<Transaction> getTransaction() { return transaction; }
		public void setTransaction(List<Transaction> t) { transaction = t;  }

		public TransactionHistory() { }
		protected TransactionHistory(Parcel in) {
			in.readTypedList(transaction,Transaction.CREATOR);
		}

		public static final Creator<TransactionHistory> CREATOR = new Creator<TransactionHistory>() {
			@Override
			public TransactionHistory createFromParcel(Parcel in) {
				return new TransactionHistory(in);
			}
			@Override
			public TransactionHistory[] newArray(int size) {
				return new TransactionHistory[size];
			}
		};
		@Override
		public int describeContents() {
			return 0;
		}
		@Override
		public void writeToParcel(Parcel parcel, int i) {
			parcel.writeTypedList(transaction);
		}
		// method to sort transactions list
		public void sortedTicket(String sequence)
		{
			Collections.sort(transaction, new CustomComparator(sequence));
		}
	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private TransactionHistory transactionHistory;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }

	public TransactionHistory getResponse() { return transactionHistory; }
	public void setResponse(TransactionHistory th) { transactionHistory = th; }

	/**
	 * This method verifies all data returned from service is valid
	 *
	 * @return  true if all request data is valid
	 */
	public void  validateTransactionHistory() throws MyAccountServiceException {
		boolean valid = true;
		if ( transactionHistory.getTransaction().size() > RestConstants.TRANSACTION_HISTORY_LIMIT)  valid = false;
		for (int i = 0; i < transactionHistory.getTransaction().size(); i++) {
			if (transactionHistory.getTransaction().get(i).gettTransactionType() == null) valid = false;
			if (transactionHistory.getTransaction().get(i).getDeviceInfo().getDevNickName() == null) valid = false;
		}
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);
	}

	/**
	 * Custom comparator to sort the ticket ArrayList
	 */
	public static class CustomComparator implements Comparator<TransactionHistory.Transaction> {

		private String sequence;

		CustomComparator(String sequence){
			this.sequence = sequence;
		}

		@Override
		public int compare(TransactionHistory.Transaction o1, TransactionHistory.Transaction o2) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
			//sort by date in increasing
			if(sequence.equals("DATE-INC")) {
				try {
					return sdf.parse(o1.gettTransactionDate()).compareTo(sdf.parse(o2.gettTransactionDate()));
				} catch (ParseException e) {
				}
			}
			//sort by date in decreasing
			else if(sequence.equals("DATE-DEC")) {
				try {
					return  sdf.parse(o2.gettTransactionDate()).compareTo(sdf.parse(o1.gettTransactionDate()));
				} catch (ParseException e) {
				}
			}
			//sort by type in increasing
			else if(sequence.equals("TYPE-INC"))
				return o1.gettTransactionType().compareTo(o2.gettTransactionType());
				//sort by type in decreasing

				return o2.gettTransactionType().compareTo(o1.gettTransactionType());
		}
	}

}
