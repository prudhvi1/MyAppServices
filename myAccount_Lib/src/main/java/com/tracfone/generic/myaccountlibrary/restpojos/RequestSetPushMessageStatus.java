package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class RequestSetPushMessageStatus defines the POJO for the request body of the APN Settings Instructions restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/


public class RequestSetPushMessageStatus {

    public static class SetPushMessageStatus  implements Parcelable {

        public static class MessageProperties implements Parcelable {

            @JsonProperty("name")
            private String name;
            @JsonProperty("value")
            private String value;

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


            public MessageProperties() { }
            protected MessageProperties(Parcel in) {
                name = in.readString();
                value = in.readString();

            }

            public static final Creator<MessageProperties> CREATOR = new Creator<MessageProperties>() {
                @Override
                public MessageProperties createFromParcel(Parcel in) {
                    return new MessageProperties(in);
                }

                @Override
                public MessageProperties[] newArray(int size) {
                    return new MessageProperties[size];
                }
            };
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

        @JsonProperty("messageProperties")
        private List<MessageProperties> messagePropertiesList = new ArrayList<MessageProperties>();


        public List<MessageProperties> getMessagePropertiesList() {
            return messagePropertiesList;
        }

        public void setMessagePropertiesList(List<MessageProperties> messagePropertiesList) {
            this.messagePropertiesList = messagePropertiesList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeTypedList(messagePropertiesList);
        }

        public static final Creator<SetPushMessageStatus> CREATOR = new Creator<SetPushMessageStatus>() {
            @Override
            public SetPushMessageStatus createFromParcel(Parcel in) {
                return new SetPushMessageStatus(in);
            }
            @Override
            public SetPushMessageStatus[] newArray(int size) {
                return new SetPushMessageStatus[size];
            }
        };

        protected SetPushMessageStatus(Parcel in) {
            messagePropertiesList = in.createTypedArrayList(MessageProperties.CREATOR);
        }


        public SetPushMessageStatus(){

        }

    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private SetPushMessageStatus request;

    public RequestCommon getCommon() {
        return common;
    }
    public void setCommon(RequestCommon common) {
        this.common = common;
    }
    public SetPushMessageStatus getRequest() {
        return request;
    }
    public void setRequest(SetPushMessageStatus request) {
        this.request = request;
    }

}



