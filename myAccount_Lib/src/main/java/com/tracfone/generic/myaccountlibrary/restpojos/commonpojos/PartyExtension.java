package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

public class PartyExtension implements Parcelable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    public static final String PARTY_TRANSACTIONID = "partyTransactionID";
    public static final String PARTY_SOURCE_SYSTEM = "sourceSystem";

    //WFM values
    public static final String PARTY_SOURCE_SYSTEM_WFM = "partySecret";
    public static final String PARTY_APP_WFM = "1231";

    public PartyExtension(){}
    protected PartyExtension(Parcel in) {
        name = in.readString();
        value = in.readString();
    }

    public static final Creator<PartyExtension> CREATOR = new Creator<PartyExtension>() {
        @Override
        public PartyExtension createFromParcel(Parcel in) {
            return new PartyExtension(in);
        }

        @Override
        public PartyExtension[] newArray(int size) {
            return new PartyExtension[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final String PARTY_APP = "APP";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(value);
    }
}
