package com.tracfone.generic.myaccountlibrary.restrequest;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class will make to Retention Matrix restful web service request.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestRetentionMatrix;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestRetentionMatrix.RetentionMatrixSelection;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestRetentionMatrix.RetentionMatrixSelection.PlanIdentifier;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class RetentionMatrixRequest extends SpiceRequest <String> {

    private String min, esn, pin;
    private String retentionContext;
    private String servicePlanId;

    /**
     *
     * @param min  Device Min (either min or esn must be null,  the other must be set)
     * @param esn  Device esn (either min or esn must be null,  the other must be set)
     * @param retentionContext Type of retention matrix requested
     * @param servicePlanId plan id for which the retention request is made. (either servicePlanId or pin must be null,  the other must be set)
     * @param pin pin for which the retention request is made.(either servicePlanId or pin must be null,  the other must be set)
     */
    public RetentionMatrixRequest(String min, String esn, String retentionContext, String servicePlanId, String pin) {
        super(String.class);
        this.min = min;
        this.esn = esn;
        this.retentionContext = retentionContext;
        this.servicePlanId= servicePlanId;
        this.pin = pin;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.RETENTION_MATRIX, GlobalLibraryValues.getBrand());
        if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min);
        else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn);
        else if (!min.isEmpty() && !esn.isEmpty()) {
            if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min);
            else url = String.format(url, "esn/" + esn);
        }

        //Populate and create Body
        RequestRetentionMatrix requestRetentionMatrix = new RequestRetentionMatrix();
        RetentionMatrixSelection retentionMatrixSelection = new RetentionMatrixSelection();
        PlanIdentifier planIdentifier = new PlanIdentifier();

        // pin or servicePlanId should be null
        if (servicePlanId != null) planIdentifier.setPlanActionPlanID(Integer.parseInt(servicePlanId));
        planIdentifier.setPlanActionPinCard(pin);

        retentionMatrixSelection.setRetentionContext(retentionContext);
        retentionMatrixSelection.setRetentionPlanIdentifiers(planIdentifier);

        requestRetentionMatrix.setRequest(retentionMatrixSelection);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestRetentionMatrix.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        String jsonString = mapper.writeValueAsString(requestRetentionMatrix);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";
        jsonString = "";

        return result;
    }
}