package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for Device
 * It corresponds to the restful service Get Customer Account Details and Validate Device
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

@JsonIgnoreProperties(ignoreUnknown = true)

public class BillingAccountMultiLine implements Parcelable {


    public class CustomerBill implements Parcelable {

        @JsonProperty("paymentDueDate")
        private String paymentDueDate;


        public void setPaymentDueDate(String paymentDueDate) {
            this.paymentDueDate = paymentDueDate;
        }

        public String getPaymentDueDate() {
            return paymentDueDate;
        }


        public CustomerBill() {
        }

        protected CustomerBill(Parcel in) {
            paymentDueDate = in.readString();
        }

        public final Creator<CustomerBill> CREATOR = new Creator<CustomerBill>() {
            @Override
            public CustomerBill createFromParcel(Parcel in) {
                return new CustomerBill(in);
            }

            @Override
            public CustomerBill[] newArray(int size) {
                return new CustomerBill[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(paymentDueDate);
        }
    }

    public class BillingAccountExtension implements Parcelable {

        @JsonProperty("totalLines")
        private String totalLines;
        @JsonProperty("availableLines")
        private String availableLines;
        @JsonProperty("activeLines")
        private String activeLines;

        public void setTotalLines(String totalLines) {
            this.totalLines = totalLines;
        }

        public String getTotalLines() {
            return totalLines;
        }


        public void setAvailableLines(String availableLines) {
            this.availableLines = availableLines;
        }
        public String getAvailableLines() {
            return availableLines;
        }

        public void setActiveLines(String activeLines) {
            this.activeLines = activeLines;
        }

        public String getActiveLines() {
            return activeLines;
        }

        public BillingAccountExtension() {
        }

        protected BillingAccountExtension(Parcel in) {
            id = in.readString();
            availableLines = in.readString();
            activeLines = in.readString();
        }

        public final Creator<BillingAccountExtension> CREATOR = new Creator<BillingAccountExtension>() {
            @Override
            public BillingAccountExtension createFromParcel(Parcel in) {
                return new BillingAccountExtension(in);
            }

            @Override
            public BillingAccountExtension[] newArray(int size) {
                return new BillingAccountExtension[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(availableLines);
            parcel.writeString(activeLines);
        }
    }

    @JsonProperty("id")
    private String id;
    @JsonProperty("accountStatus")
    private String accountStatus;
    @JsonProperty("name")
    private String name;
    @JsonProperty("customerBill")
    private CustomerBill customerBill;
    @JsonProperty("billingAccountExtension")
    private BillingAccountExtension billingAccountExtension;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    //Account Statuses
    public static final String VALID_ACCOUNT = "VALID_ACCOUNT";
    public static final String DUMMY_ACCOUNT = "DUMMY_ACCOUNT";
    public static final String NO_ACCOUNT = "NO_ACCOUNT";
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
    public String getAccountStatus() {
        return "DEVICE_" + accountStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CustomerBill getCustomerBill() {
        return customerBill;
    }

    public void setCustomerBill(CustomerBill m) {
        customerBill = m;
    }

    public BillingAccountExtension getBillingAccountExtension() {
        return billingAccountExtension;
    }

    public void setBillingAccountExtension(BillingAccountExtension g) {
        billingAccountExtension = g;
    }


    public BillingAccountMultiLine() {
    }

    protected BillingAccountMultiLine(Parcel in) {
        id = in.readString();
        accountStatus = in.readString();
        name = in.readString();
        customerBill = in.readParcelable(CustomerBill.class.getClassLoader());
        billingAccountExtension = in.readParcelable(BillingAccountExtension.class.getClassLoader());
    }

    public static final Creator<BillingAccountMultiLine> CREATOR = new Creator<BillingAccountMultiLine>() {
        @Override
        public BillingAccountMultiLine createFromParcel(Parcel in) {
            return new BillingAccountMultiLine(in);
        }

        @Override
        public BillingAccountMultiLine[] newArray(int size) {
            return new BillingAccountMultiLine[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(accountStatus);
        parcel.writeString(name);
        parcel.writeParcelable(customerBill, i);
        parcel.writeParcelable(billingAccountExtension, i);
    }
}
