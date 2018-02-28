package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by gmateti on 4/18/2017.
 */

public class RelatedOrderItem implements Parcelable {

    @JsonProperty("characteristicSpecification")
    private ArrayList<CharacteristicSpecification2> characteristicSpecification;
    @JsonProperty("relationshipType")
    private String relationshipType;

    public RelatedOrderItem() {}

    protected RelatedOrderItem(Parcel in) {
        characteristicSpecification = in.createTypedArrayList(CharacteristicSpecification2.CREATOR);
        relationshipType = in.readString();
    }

    public static final Creator<RelatedOrderItem> CREATOR = new Creator<RelatedOrderItem>() {
        @Override
        public RelatedOrderItem createFromParcel(Parcel in) {
            return new RelatedOrderItem(in);
        }

        @Override
        public RelatedOrderItem[] newArray(int size) {
            return new RelatedOrderItem[size];
        }
    };

    public ArrayList<CharacteristicSpecification2> getCharacteristicSpecification() {
        return characteristicSpecification;
    }

    public void setCharacteristicSpecification(ArrayList<CharacteristicSpecification2> characteristicSpecification) {
        this.characteristicSpecification = characteristicSpecification;
    }

    public final static String RELATIONSHIP_TYPE_RELATEDTO = "relatedTo";
    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(characteristicSpecification);
        parcel.writeString(relationshipType);
    }
}
