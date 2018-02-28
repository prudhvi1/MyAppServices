package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Specifications;

import java.util.ArrayList;

/**
 * Created by skishore on 10/17/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseServiceProviders {


    public static class ServiceProviderResponse implements Parcelable{

        @JsonProperty("category")
        private String category;

        @JsonProperty("specifications")
        private ArrayList<Specifications> specifications = new ArrayList<Specifications>();

        public ArrayList<Specifications> getSpecifications() {
            return specifications;
        }

        public void setSpecifications(ArrayList<Specifications> specifications) {
            this.specifications = specifications;
        }
        
        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public ServiceProviderResponse() { }

        protected ServiceProviderResponse(Parcel in) {
            category = in.readString();
            in.readTypedList(specifications, Specifications.CREATOR);
        }

        public static final Creator<ServiceProviderResponse> CREATOR = new Creator<ServiceProviderResponse>() {
            @Override
            public ServiceProviderResponse createFromParcel(Parcel in) {
                return new ServiceProviderResponse(in);
            }

            @Override
            public ServiceProviderResponse[] newArray(int size) {
                return new ServiceProviderResponse[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(category);
            parcel.writeTypedList(specifications);

        }

    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ServiceProviderResponse serviceProviderResponse;

    public ResponseStatus getStatus() { return status; }
    public void setStatus(ResponseStatus s) { status = s; }

    public ServiceProviderResponse getResponse() { return serviceProviderResponse; }
    public void setResponse(ServiceProviderResponse v) { serviceProviderResponse = v; }


}
