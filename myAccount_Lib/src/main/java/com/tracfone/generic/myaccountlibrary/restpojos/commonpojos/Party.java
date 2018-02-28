package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import java.util.ArrayList;

/**
 * Created by psamdrala on 11/8/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Party implements Parcelable{

    @JsonProperty("partyID")
    private String partyID;
    @JsonProperty("languageAbility")
    private String languageAbility;
    @JsonProperty("partyExtension")
    private ArrayList<PartyExtension> partyExtension;
    @JsonProperty("roleType")
    private String roleType;
    @JsonProperty("individual")
    private Individual individual;

    public static final String PARTY_ID_TFAPP_BRAND = "TFAPP-" + GlobalLibraryValues.getBrand();

    public static final String PARTY_ID_CUST_HASH = "CUST_HASH";

    public static final String PARTY_ID_WFM = "WFMAPP";

    public Party(){}
    protected Party(Parcel in) {
        partyID = in.readString();
        languageAbility = in.readString();
        partyExtension = in.createTypedArrayList(PartyExtension.CREATOR);
        roleType = in.readString();
        individual = in.readParcelable(Individual.class.getClassLoader());

    }

    public static final Creator<Party> CREATOR = new Creator<Party>() {
        @Override
        public Party createFromParcel(Parcel in) {
            return new Party(in);
        }

        @Override
        public Party[] newArray(int size) {
            return new Party[size];
        }
    };

    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    public static final String PARTY_LANGUAGE_AVAILABILITY_ENG = "ENG";

    public String getLanguageAbility() {
        return languageAbility;
    }

    public void setLanguageAbility(String languageAbility) {
        this.languageAbility = languageAbility;
    }

    public ArrayList<PartyExtension> getPartyExtension() {
        return partyExtension;
    }

    public void setPartyExtension(ArrayList<PartyExtension> partyExtension) {
        this.partyExtension = partyExtension;
    }

    public static final String PARTY_ROLE_TYPE_APPLICATION = "application";
    public static final String PARTY_ROLE_TYPE_CUSTOMER = "customer";
    public static final String PARTY_ROLE_TYPE_INTERNAL = "internal";

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(partyID);
        parcel.writeString(languageAbility);
        parcel.writeTypedList(partyExtension);
        parcel.writeString(roleType);
        parcel.writeParcelable(individual, i);
    }
}
