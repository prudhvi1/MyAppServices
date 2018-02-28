package com.tracfone.generic.myaccountlibrary.restrequest;

/**
 * ***************************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 * <p/>
 * CLASS DESCRIPTION:
 * This class EnrollAutoRefillRequest will perform Enroll AutoRefill restful web service request to enroll the selected plan for Refill.
 * <p/>
 * This class is invoked from ReUpWithCCBillingBreakdownActivity class.
 * <p/>
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * <p/>
 * ***************************************************************************************************************************************************
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEnrollManageAutoRefill;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEnrollManageAutoRefill.EnrollManageAutoRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestEnrollManageAutoRefill.EnrollManageAutoRequest.HandsetProtection;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

public class EnrollAutoRefillRequest extends SpiceRequest<String> {

    private String min, esn, cvvNumber, servicePlanProgramId;
    private boolean enrollNow;
    private int paymentSourceId, accountId, servicePlanId;
    private EnrollManageAutoRequest.HandsetProtection handsetProtection = new EnrollManageAutoRequest.HandsetProtection();

    public EnrollAutoRefillRequest(String min, String esn, String servicePlanProgramId, String paymentSourceId, String accountId, String cvvNumber, boolean enrollNow, String servicePlanId, HandsetProtection handsetProtection) {
        super(String.class);
        this.min = min;
        this.esn = esn;
        this.servicePlanProgramId = servicePlanProgramId;
        this.paymentSourceId = Integer.parseInt(paymentSourceId);
        this.accountId = Integer.parseInt(accountId);
        this.cvvNumber = cvvNumber;
        this.enrollNow = enrollNow;
        this.servicePlanId = Integer.parseInt(servicePlanId);
        this.handsetProtection = handsetProtection;
    }
    /** Create the web service request URL by choosing the appropriate service number and appending it with the
     *  selected Service plan's Part Number and the selected Credit Card's Payment Source Id.
     *  The Webservice's Request body is also created with the inputs - Phone Number, Account Id and entered CVV of selected credit card.
     */
    @Override
    public String loadDataFromNetwork() throws Exception {

        String result = null;
        String url = RestfulURL.getUrl(RestfulURL.ENROLL_AUTO_REFILL, GlobalLibraryValues.getBrand());
        if (esn == null || esn.isEmpty())
            url = String.format(url, "min/" + min, servicePlanProgramId);
        else if (min == null || min.isEmpty())
            url = String.format(url, "esn/" + esn, servicePlanProgramId);
        else if (!min.isEmpty() && !esn.isEmpty()) {
            if (ReleaseFlavorConfig.TEST_MOCKABLE)
                url = String.format(url, "min/" + min, servicePlanProgramId);
            else url = String.format(url, "esn/" + esn, servicePlanProgramId);
        }

        RequestEnrollManageAutoRefill enrollAutoRefill = new RequestEnrollManageAutoRefill();
        EnrollManageAutoRequest enrollRequest = new EnrollManageAutoRequest();
        enrollRequest.setPaymentSourceId(paymentSourceId);
        enrollRequest.setAccountId(accountId);
        enrollRequest.setCvv(cvvNumber);
        enrollRequest.setEnrollNow(enrollNow);
        if (servicePlanId!=-1)
            enrollRequest.setServicePlanId(servicePlanId);
        enrollRequest.setHandsetProtection(handsetProtection);
        enrollAutoRefill.setRequest(enrollRequest);

        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        enrollAutoRefill.setCommon(requestCommon);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(enrollAutoRefill);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_RO, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }
}