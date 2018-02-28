package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by atatipally on 5/19/2016.
 */
public class RequestEditGroupNickName {

    public static class GroupNickNameRequest {

        @JsonProperty("nickName")
        private String nickName;

        public String getNickName() { return nickName; }
        public void setNickName(String n) { nickName = n; }

    }

    @JsonProperty("common")
    private RequestCommon common;
    @JsonProperty("request")
    private GroupNickNameRequest request;

    public RequestCommon getCommon() { return common; }
    public void setCommon(RequestCommon c) { common = c; }

    public GroupNickNameRequest getRequest() { return request; }
    public void setRequest(GroupNickNameRequest r) { request = r; }

}
