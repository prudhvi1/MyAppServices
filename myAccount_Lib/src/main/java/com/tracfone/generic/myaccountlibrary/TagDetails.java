package com.tracfone.generic.myaccountlibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by com.tracfone.preload on 6/8/2016.
 */
public class TagDetails implements Parcelable {


    String min;
    String nickName;
    String esn;
    Boolean preference;

    public TagDetails(){}

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEsn() {
        return esn;
    }

    public void setEsn(String esn) {
        this.esn = esn;
    }

    public Boolean getPreference() {
        return preference;
    }

    public void setPreference(Boolean preference) {
        this.preference = preference;
    }

    // Parcelling part
    public TagDetails(Parcel in){
        String[] data = new String[3];

        in.readStringArray(data);
        this.min = data[0];
        this.esn = data[1];
        this.nickName = data[2];
        this.preference = (in.readByte() != 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.min,
                this.esn,
                this.nickName
        });
        dest.writeByte((byte) (preference ? 1 : 0));
    }

    public static final Parcelable.Creator<TagDetails> CREATOR = new Parcelable.Creator<TagDetails>() {
        public TagDetails createFromParcel(Parcel in) {
            return new TagDetails(in);
        }

        public TagDetails[] newArray(int size) {
            return new TagDetails[size];
        }
    };
}
