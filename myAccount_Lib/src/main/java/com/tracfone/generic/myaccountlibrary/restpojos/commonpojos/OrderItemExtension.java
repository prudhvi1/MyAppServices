package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class OrderItemExtension implements Parcelable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    public static final String NAME_CURRENT_MIN = "currentMIN";
    public static final String NAME_CURRENT_SERVICE_PROVIDER = "currentServiceProvider";
    public static final String NAME_CURRENT_ACCOUNT_NUMBER = "currentAccountNumber";
    public static final String NAME_CURRENT_PIN = "currentPin";
    public static final String NAME_CURRENT_VKEY = "currentVKey";
    public static final String NAME_CURRENT_CONTACT_PHONE = "contactPhone";
    public static final String NAME_CURRENT_FULL_NAME = "currentFullName";
    public static final String NAME_CURRENT_CARRIER_TYPE = "currentCarrierType";
    public static final String NAME_CURRENT_ADDRESS_LINE1 = "currentAddressLine1";
    public static final String NAME_CURRENT_ADDRESS_LINE2 = "currentAddressLine2";
    public static final String NAME_CURRENT_ADDRESS_CITY = "currentAddressCity";
    public static final String NAME_CURRENT_ADDRESS_STATE = "currentAddressState";
    public static final String NAME_CURRENT_ADDRESS_ZIP = "currentAddressZip";
    public static final String NAME_UNIT_NUMBER = "unitNumber";
    public static final String NAME_HOUSE_NUMBER = "houseNumber";
    public static final String NAME_STREET_NAME = "streetName";
    public static final String NAME_STREET_DIRECTION = "direction";
    public static final String NAME_STREET_TYPE = "streetType";
    public static final String NAME_CURRENT_CARRIER = "currentCarrier";
    public static final String NAME_CURRENT_SSN_LAST4 = "ssnLast4Digits";
    public static final String NAME_CURRENT_GROUP_IDENTIFIER = "groupIdentifier";
    public static final String NAME_CURRENT_LEASE_APPLICATION_ID = "leaseApplicationId";
    public static final String NAME_TICKET = "ticket";
    public static final String NEXT_REFILL_DATE ="nextRefillDate";
    public static final String IS_ENROLLED ="isEnrolled";
    public static final String PLAN_DESCRIPTION=  "planDescription";
    public static final String PLAN_DESCRIPTION2=  "planDescription2";
    public static final String PLAN_DESCRIPTION3=  "planDescription3";
    public static final String VAS_PLAN_DESCRIPTION=  "vasPlanDescription";
    public static final String VAS_PLAN_DESCRIPTION2=  "vasPlanDescription2";
    public static final String VAS_PLAN_DESCRIPTION3=  "vasPlanDescription3";
    public static final String PAYMENT_SOURCETYPE= "paymentSourceType";
    public static final String PAYMENT_SOURCENUMBERMASK= "paymentSourceNumberMask";
    public static final String TRANSACTION_TOTAL= "transactionTotal";
    public static final String TRANSACATION_ID= "transactionId";
    public static final String GROUP_NAME = "groupName";
    public static final String GROUP_ID = "groupIdentifier";
    public static final String CONFIRMATION_MSG = "confirmationMsg";
    public static final String TRANSACTION_MSG = "transactionMsg";
    public static final String VAS_ACCESS_NUMBER = "vasAccessNumber";
    public static final String UPGRADE_REWARD_POINTS = "rewardPoints";
    public static final String POINTS_ACCRUED = "pointsAccrued";




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OrderItemExtension() {}
    protected OrderItemExtension(Parcel in) {
        name = in.readString();
        value = in.readString();
    }

    public static final Parcelable.Creator<OrderItemExtension> CREATOR = new Parcelable.Creator<OrderItemExtension>() {
        @Override
        public com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemExtension createFromParcel(Parcel in) {
            return new com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemExtension(in);
        }

        @Override
        public com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemExtension[] newArray(int size) {
            return new com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemExtension[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(value);
    }
}
