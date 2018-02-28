package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make to Validate Promotions restful web service request.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestValidatePromotions;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class ValidatePromotionsRequest extends SpiceRequest<String> {

    private String esn,min,promotionCode,transactionType,transactionAmount;
    private RequestValidatePromotions.ValidatePromotionRequest.Cart cart=new RequestValidatePromotions.ValidatePromotionRequest.Cart();

    public ValidatePromotionsRequest(String esn,String min,String promotionCode, String transactionType, String transactionAmount, RequestValidatePromotions.ValidatePromotionRequest.Cart cart) {
        super(String.class);
        this.esn=esn;
        this.min=min;
        this.promotionCode=promotionCode;
        this.transactionType=transactionType;
        this.transactionAmount=transactionAmount;
        this.cart=cart;
    }
    /** Create the web service request URL by choosing the appropriate service number.
     *  The Webservice's Request body is also created with the inputs - Payment Source Id of selected Credit Card, Promotion Code, Account Id,
     *   Serial Number, selected credit cards billing zip code and cart List.
     */
    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.VALIDATE_PROMOTIONS, GlobalLibraryValues.getBrand());

        //Populate and create Body
        RequestValidatePromotions validatePromotions = new RequestValidatePromotions();
        RequestValidatePromotions.ValidatePromotionRequest validatePromoRequest = new RequestValidatePromotions.ValidatePromotionRequest();
        if (esn != null && !esn.isEmpty()) validatePromoRequest.setEsn(esn);
        if (min != null && !min.isEmpty()) validatePromoRequest.setMin(min);
        validatePromoRequest.setPromotionCode(promotionCode.trim());
        validatePromoRequest.setTransactionType(transactionType);
        validatePromoRequest.setTransactionAmount(transactionAmount);
        validatePromoRequest.setCarts(cart);
        validatePromotions.setRequest(validatePromoRequest);

        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        validatePromotions.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(validatePromotions);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";
        jsonString = "";

        return result;
    }
}