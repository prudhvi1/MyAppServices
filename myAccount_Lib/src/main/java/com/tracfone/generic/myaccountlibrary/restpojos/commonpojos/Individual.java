package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Individual implements Parcelable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;

    public Individual(){}
    protected Individual(Parcel in) {
        id = in.readString();
        firstname = in.readString();
        lastname = in.readString();
    }

    public static final Creator<Individual> CREATOR = new Creator<Individual>() {
        @Override
        public Individual createFromParcel(Parcel in) {
            return new Individual(in);
        }

        @Override
        public Individual[] newArray(int size) {
            return new Individual[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(firstname);
        parcel.writeString(lastname);
    }
}
