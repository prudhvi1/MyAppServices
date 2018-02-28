package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by skishore on 10/17/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedParties implements Parcelable {

    @JsonProperty("party")
    private Party party;
    @JsonProperty("roleType")
    private String roleType;

    public RelatedParties(){}

    protected RelatedParties(Parcel in) {
        party = in.readParcelable(Party.class.getClassLoader());
        roleType = in.readString();
    }

    public static final Creator<RelatedParties> CREATOR = new Creator<RelatedParties>() {
        @Override
        public RelatedParties createFromParcel(Parcel in) {
            return new RelatedParties(in);
        }

        @Override
        public RelatedParties[] newArray(int size) {
            return new RelatedParties[size];
        }
    };

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(party, flags);
        dest.writeString(roleType);
    }
}
