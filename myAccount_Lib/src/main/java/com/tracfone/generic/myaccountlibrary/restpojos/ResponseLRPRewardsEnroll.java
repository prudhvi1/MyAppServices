package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

/**
 * Created by hserna on 11/13/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseLRPRewardsEnroll {

    public static class LRPRewardsEnrollResponse{

        @JsonProperty("token_type")
        private String token_type;
        @JsonProperty("access_token")
        private String access_token;
        @JsonProperty("expires_in")
        private String expires_in;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("brandName")
        private String brandName;
        @JsonProperty("sourceSystem")
        private String sourceSystem;
        @JsonProperty("refresh_token")
        private String refresh_token;
        @JsonProperty("client_id")
        private String client_id;
        @JsonProperty("accountId")
        private String accountId;

        public void setTokenType(String token_type) {  this.token_type = token_type; }
        public String getTokenType() {  return token_type; }

        public void setAccessToken(String access_token) {  this.access_token = access_token; }
        public String getAccessToken() {  return access_token; }

        public void setExpiresIn(String expires_in) {  this.expires_in = expires_in; }
        public int getExpiresIn() {
            int expiresIn = 1800; //Assume 30 minutes
            try {
                expiresIn = Integer.parseInt(expires_in);
            } catch (Exception e) {

            }
            return expiresIn;
        }

        public void setScope(String scope) {  this.scope = scope; }
        public String getScope() {  return scope; }

        public void setBrandName(String brandName) {  this.brandName = brandName; }
        public String getBrandName() {  return brandName; }

        public void setSourceSystem(String sourceSystem) {  this.sourceSystem = sourceSystem; }
        public String getSourceSystem() {  return sourceSystem; }

        public void setRefreshToken(String refresh_token) {  this.refresh_token = refresh_token; }
        public String getRefreshToken() {  return refresh_token; }

        public void setClientId(String client_id) {  this.client_id = client_id; }
        public String getClientId() {  return client_id; }

        public void setAccountId(String s) { accountId = s; }
        public String getAccountId() {  return accountId; }

    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private LRPRewardsEnrollResponse lRPRewardsEnrollResponse;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public LRPRewardsEnrollResponse getResponse() {
        return lRPRewardsEnrollResponse;
    }
    public void setResponse(LRPRewardsEnrollResponse lRPRewardsEnrollResponse) {
        this.lRPRewardsEnrollResponse = lRPRewardsEnrollResponse;
    }


    /**
     * This method verifies all data returned from service is valid
     *
     * @return  true if all request data is valid
     */
    public void validateRewardsEnrollResponseData() throws MyAccountServiceException {
        boolean valid = true;
        if (lRPRewardsEnrollResponse.getAccountId() == null)
            valid = false;
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


    }
}