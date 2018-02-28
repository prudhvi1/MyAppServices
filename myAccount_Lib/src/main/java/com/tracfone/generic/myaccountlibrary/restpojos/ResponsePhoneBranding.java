package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by skishore on 10/17/2016.
 */

public class ResponsePhoneBranding {

    public static class PhoneBranding {
        @JsonProperty("status")
        private Status status;

        public static class Status {
            @JsonProperty("code")
            private String code;
            @JsonProperty("message")
            private String message;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    }


    @JsonProperty("status")
    private ResponseStatus status;

    public PhoneBranding getPhoneBranding() {
        return phoneBranding;
    }

    public void setPhoneBranding(PhoneBranding phoneBranding) {
        this.phoneBranding = phoneBranding;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    @JsonProperty("response")
    private PhoneBranding phoneBranding;
}
