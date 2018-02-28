package com.tracfone.generic.myaccountlibrary.restrequest;

/******************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 * This class DeEnrollPlanRequest will de enroll from the currently enrolled service plan.
 *
 * This class is invoked from ManageDeEnrollReasonActivity class.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************************************************************************************/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestDeEnrollPlan;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class DeEnrollPlanRequest extends SpiceRequest<String> {

    private String min, esn, servicePlanProgramId, reason;

    public DeEnrollPlanRequest(String min, String esn, String servicePlanProgramId, String reason) {
        super(String.class);
        this.min = min;
        this.esn=esn;
        this.servicePlanProgramId = servicePlanProgramId;
        this.reason = reason;
    }
    /** Create the web service request URL by choosing the appropriate service number and appending it with the
     *  selected Service plan's Part Number and the selected Credit Card's Payment Source Id.
     *  The Webservice's Request body is also created with the inputs - Phone Number, Account Id and entered CVV of selected credit card.
     */
    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.DE_ENROLL_PLAN, GlobalLibraryValues.getBrand());
        if(esn==null || esn.isEmpty()) url = String.format(url,"min/" +min,servicePlanProgramId);
        else if(min==null || min.isEmpty()) url = String.format(url,"esn/" +esn, servicePlanProgramId);
        else if (!min.isEmpty() && !esn.isEmpty()) {
            if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, "min/" + min,servicePlanProgramId);
            else url = String.format(url, "esn/" + esn,servicePlanProgramId);
        }

        RequestDeEnrollPlan deEnrollPlanRequest = new RequestDeEnrollPlan();
        RequestDeEnrollPlan.DeEnrollRequest deEnrollPlan=new RequestDeEnrollPlan.DeEnrollRequest();
        deEnrollPlan.setReason(reason);
        deEnrollPlanRequest.setRequest(deEnrollPlan);

        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        deEnrollPlanRequest.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(deEnrollPlanRequest);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        //For security purposes erase url and body of request which may reside on heap
        url = "";
        jsonString = "";

        return result;
    }
}