package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Specifications;

import java.util.ArrayList;

/**
 * Created by skishore on 10/18/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePortCarrierConfig {

    public static class PortCarrierConfigResponse {
        @JsonProperty("category")
        private String category;
        @JsonProperty("specifications")
        private ArrayList<Specifications> specifications;

        public String isPhoneNumberRequired="";
        public String isEsnRequired="";
        public String isAccountNumberRequired="";
        public String isPasswordRequired="";
        public String isVKeysRequired="";
        public String isFullNmRequired="";
        public String isBillingAddrRequired="";
        public String isLast4SsnRequired="";
        public String isAccAlphaNumeric="";
        public String isPinAlphaNumer="";

        private String isMinToTransferRequired = "isMinToTransferRequired";
        private String isCurrentEsnRequired = "isCurrentEsnRequired";
        private String isAccountNumRequired = "isAccountNumRequired";
        private String isPasswordPinRequired ="isPasswordPinRequired";
        private String isVKeyRequired = "isVKeyRequired";
        private String isFullNameRequired = "isFullNameRequired";
        private String isBillingAddressRequired= "isBillingAddressRequired";
        private String isLast4SSNRequired= "isLast4SSNRequired";
        private String isAccountAlphaNumeric= "isAccountAlphaNumeric";
        private String isPinAlphaNumeric= "isPinAlphaNumeric";

        public static String VALUE_TRUE = "Y";
        public static String VALUE_FALSE = "N";


        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public ArrayList<Specifications> getSpecifications() {
            return specifications;
        }

        public void setSpecifications(ArrayList<Specifications> specifications) {
            this.specifications = specifications;
        }



        public void setSpecValues(){
            for(int i=0;i<specifications.size();i++){
                if(specifications.get(i).getName().equals(isMinToTransferRequired)){
                    this.isPhoneNumberRequired = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isCurrentEsnRequired)){
                    this.isEsnRequired = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isAccountNumRequired)){
                    this.isAccountNumberRequired = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isPasswordPinRequired)){
                    this.isPasswordRequired = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isVKeyRequired)){
                    this.isVKeysRequired = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isFullNameRequired)){
                    this.isFullNmRequired = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isBillingAddressRequired)){
                    this.isBillingAddrRequired = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isLast4SSNRequired)){
                    this.isLast4SsnRequired = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isAccountAlphaNumeric)){
                    this.isAccAlphaNumeric = specifications.get(i).getValue();
                }
                if(specifications.get(i).getName().equals(isPinAlphaNumeric)){
                    this.isPinAlphaNumer = specifications.get(i).getValue();
                }
            }
        }
    }
    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private PortCarrierConfigResponse portCarrierConfigResponse;

    public ResponseStatus getStatus() { return status; }
    public void setStatus(ResponseStatus s) { status = s; }

    public PortCarrierConfigResponse getResponse() { return portCarrierConfigResponse; }
    public void setResponse(PortCarrierConfigResponse v) { portCarrierConfigResponse = v; }
}
