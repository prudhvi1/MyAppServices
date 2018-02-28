package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 *
 *  * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for the response to a restful request to
 * view the Transaction History Payment.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2015,  All Rights Reserved
 *
 * Created by mgokhanilhan on 7/23/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseTransactionPaymentHistory {

    public static class TransactionPaymentHistory implements Parcelable {

        public static class Transaction implements Parcelable{

            @JsonProperty("transactionDate")
            private String tTransactionDate;
            @JsonProperty("transactionType")
            private String tTransactionType;
            @JsonProperty("transactionTotal")
            private String tTransactionTotal;
            @JsonProperty("discountTotal")
            private String tDiscountTotal;
            @JsonProperty("transactionId")
            private String tTransactionId;
            @JsonProperty("transactionStatus")
            private String tTransactionStatus;

            public String gettTransactionDate() {return tTransactionDate;}
            public void settTransactionDate(String tTransactionDate) {this.tTransactionDate = tTransactionDate;}

            public String gettTransactionType() {return tTransactionType;}
            public void settTransactionType(String tTransactionType) {this.tTransactionType = tTransactionType;}

            public String gettTransactionTotal() {return tTransactionTotal;}
            public void settTransactionTotal(String tTransactionTotal) {this.tTransactionTotal = tTransactionTotal;}

            public String gettDiscountTotal() {return tDiscountTotal;}
            public void settDiscountTotal(String tDiscountTotal) {this.tDiscountTotal = tDiscountTotal;}

            public String gettTransactionId() {return tTransactionId;}
            public void settTransactionId(String tTransactionId) {this.tTransactionId = tTransactionId;}

            public String gettTransactionStatus() {return tTransactionStatus;}
            public void settTransactionStatus(String tTransactionStatus) {this.tTransactionStatus = tTransactionStatus;}

            public static class PaymentSource implements Parcelable{
                @JsonProperty("paymentSourceNickName")
                private String pPaymentSourceNickName;
                @JsonProperty("paymentSourceType")
                private String pPaymentSourceType;
                @JsonProperty("paymentSourceNumberMask")
                private String pPaymentSourceNumberMask;

                public String getpPaymentSourceNickName() {return pPaymentSourceNickName;}
                public void setpPaymentSourceNickName(String pPaymentSourceNickName) {this.pPaymentSourceNickName = pPaymentSourceNickName;}

                public String getpPaymentSourceType() {return pPaymentSourceType;}
                public void setpPaymentSourceType(String pPaymentSourceType) {this.pPaymentSourceType = pPaymentSourceType;}

                public String getpPaymentSourceNumberMask() {return pPaymentSourceNumberMask;}
                public void setpPaymentSourceNumberMask(String pPaymentSourceNumberMask) {this.pPaymentSourceNumberMask = pPaymentSourceNumberMask;}

                public PaymentSource() { }
                protected PaymentSource(Parcel in) {
                    pPaymentSourceNickName = in.readString();
                    pPaymentSourceType = in.readString();
                    pPaymentSourceNumberMask = in.readString();
                }
                public static final Creator<PaymentSource> CREATOR = new Creator<PaymentSource>() {
                    @Override
                    public PaymentSource createFromParcel(Parcel in) {
                        return new PaymentSource(in);
                    }
                    @Override
                    public PaymentSource[] newArray(int size) {
                        return new PaymentSource[size];
                    }
                };
                @Override
                public int describeContents() {
                    return 0;
                }
                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(pPaymentSourceNickName);
                    parcel.writeString(pPaymentSourceType);
                    parcel.writeString(pPaymentSourceNumberMask);
                }
            }
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

            @JsonProperty("paymentSource")
            private PaymentSource pPaymentSource;
            public PaymentSource getpPaymentSource() {return pPaymentSource;}
            public void setpPaymentSource(PaymentSource pPaymentSource) {this.pPaymentSource = pPaymentSource;}

            @JsonProperty("device")
            private DeviceInfo deviceInfo;
            public DeviceInfo getDeviceInfo() {		return deviceInfo;	}
            public void setDeviceInfo(DeviceInfo deviceInfo) {	this.deviceInfo = deviceInfo;}

            @JsonProperty("groupInfo")
            private  GroupInfo groupInfo;
            public GroupInfo getGroupInfo() {return groupInfo;}
            public void setGroupInfo(GroupInfo groupInfo) {this.groupInfo = groupInfo;}

            public Transaction() { }
            protected Transaction(Parcel in) {
                tTransactionDate = in.readString();
                tTransactionType = in.readString();
                tTransactionTotal = in.readString();
                tDiscountTotal = in.readString();
                tTransactionId = in.readString();
                tTransactionStatus = in.readString();
                pPaymentSource = in.readParcelable(PaymentSource.class.getClassLoader());
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
                parcel.writeString(tTransactionTotal);
                parcel.writeString(tDiscountTotal);
                parcel.writeString(tTransactionId);
                parcel.writeString(tTransactionStatus);
                parcel.writeParcelable(pPaymentSource, i);
                parcel.writeParcelable(deviceInfo, i);
                parcel.writeParcelable(groupInfo, i);
            }
        }

        @JsonProperty("transactions")
        private List<Transaction> transaction = new ArrayList<Transaction>();
        public List<Transaction> getTransaction() { return transaction; }
        public void setTransaction(List<Transaction> t) { transaction = t;  }

        public TransactionPaymentHistory() { }
        protected TransactionPaymentHistory(Parcel in) {
            in.readTypedList(transaction,Transaction.CREATOR);
        }
        public static final Creator<TransactionPaymentHistory> CREATOR = new Creator<TransactionPaymentHistory>() {
            @Override
            public TransactionPaymentHistory createFromParcel(Parcel in) {
                return new TransactionPaymentHistory(in);
            }
            @Override
            public TransactionPaymentHistory[] newArray(int size) {
                return new TransactionPaymentHistory[size];
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
    private TransactionPaymentHistory transactionPaymentHistory;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public TransactionPaymentHistory getResponse() { return transactionPaymentHistory; }
    public void setResponse(TransactionPaymentHistory th) { transactionPaymentHistory = th; }

    /**
     * This method verifies all data returned from service is valid
     *
     * @return  true if all request data is valid
     */
    public void validateTransactionHistory() throws MyAccountServiceException {
        boolean valid = true;
        if ( transactionPaymentHistory.getTransaction().size() > RestConstants.TRANSACTION_HISTORY_LIMIT)  valid = false;
        for (int i = 0; i < transactionPaymentHistory.getTransaction().size(); i++) {
            if (transactionPaymentHistory.getTransaction().get(i).gettTransactionType() == null) valid = false;
            if (transactionPaymentHistory.getTransaction().get(i).gettDiscountTotal()==null) valid = false;
            if (transactionPaymentHistory.getTransaction().get(i).gettTransactionStatus()==null) valid = false;
            if (transactionPaymentHistory.getTransaction().get(i).getDeviceInfo().getDevMin() == null) valid = false;
        }
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);

    }

    /**
     * Custom comparator to sort the ticket ArrayList
     */
    public static class CustomComparator implements Comparator<TransactionPaymentHistory.Transaction> {

        private String sequence;

        CustomComparator(String sequence){
            this.sequence = sequence;
        }

        @Override
        public int compare(TransactionPaymentHistory.Transaction o1, TransactionPaymentHistory.Transaction o2) {
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
                return o1.getpPaymentSource().getpPaymentSourceType().compareTo(o2.getpPaymentSource().getpPaymentSourceType());
                //sort by type in decreasing
            else if(sequence.equals("TYPE-DEC"))
                return o2.getpPaymentSource().getpPaymentSourceType().compareTo(o1.getpPaymentSource().getpPaymentSourceType());
                //sort by status in increasing
            else if(sequence.equals("STATUS-INC"))
                return o1.gettTransactionStatus().compareTo(o2.gettTransactionStatus());
            //sort by status in decreasing
           return o2.gettTransactionStatus().compareTo(o1.gettTransactionStatus());
        }
    }
}
