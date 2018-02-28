package com.tracfone.generic.myaccountlibrary.restpojos;

/**
 * ********************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 * <p/>
 * CLASS DESCRIPTION:
 * <p/>
 * This class ResponseManufacturersAndModels defines the response POJO for the Manufacturers and Models List.
 * It corresponds to the restful service Get Manufacturers and Models List.
 * <p/>
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * *********************************************************************************************************
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseManufacturersAndModels {

    public static class ManufacturersModels {

        public static class ManufacturersList {

            @JsonProperty("manufacturerName")
            private String manufacturerName;
            @JsonProperty("models")
            private List<String> modelsList = new ArrayList<>();

            public String getManufacturerName() {
                return manufacturerName;
            }

            public void setManufacturerName(String manufacturerName) {
                this.manufacturerName = manufacturerName;
            }

            public List<String> getModelsList() {
                return modelsList;
            }

            public void setModelsList(List<String> modelsList) {
                this.modelsList = modelsList;
            }
        }

        @JsonProperty("manufacturers")
        private List<ManufacturersList> manufacturersList = new ArrayList<>();

        public List<ManufacturersList> getManufacturersList() {
            return manufacturersList;
        }

        public void setManufacturersList(List<ManufacturersList> manufacturersList) {
            this.manufacturersList = manufacturersList;
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private ManufacturersModels ManufacturersModels;

    public ResponseStatus getCommon() {
        return status;
    }

    public void setCommon(ResponseStatus s) {
        status = s;
    }

    public ManufacturersModels getResponse() {
        return ManufacturersModels;
    }

    public void setResponse(ManufacturersModels mm) {
        ManufacturersModels = mm;
    }


}
