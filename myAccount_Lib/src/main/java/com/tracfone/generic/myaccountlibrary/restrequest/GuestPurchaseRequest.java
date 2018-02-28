package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestGuestPurchase;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponsePlanList;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartNumber;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PaymentMean;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.VasPlans;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by com.tracfone.preload on 1/16/2017.
 */

public class GuestPurchaseRequest extends SpiceRequest<String> {

    private String partNum, esn;
    private PaymentMean paymentMean;
    private String  promoCode;
    private boolean ildVasFlag;
    private int servicePlanId;
    private boolean redeemNow ;
    ArrayList<ResponsePlanList.PlanList.Plan> vasPlans = new ArrayList<>();

    public GuestPurchaseRequest(String partNum, String esn, PaymentMean paymentMean, boolean redeemNow,String servicePlanId, boolean ildVasFlag, String promoCode, ArrayList<ResponsePlanList.PlanList.Plan> vasPlans){
        super(String.class);
        this.esn = esn;
        this.partNum = partNum;
        this.paymentMean = paymentMean;
        this.redeemNow = redeemNow;
        this.servicePlanId=Integer.parseInt(servicePlanId);
        this.ildVasFlag = ildVasFlag;
        this.vasPlans = vasPlans;
        if(promoCode!=null && !promoCode.isEmpty())	this.promoCode=promoCode;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.GUEST_PURCHASE, GlobalLibraryValues.getBrand());
        url = String.format(url, esn);

        RequestGuestPurchase requestGuestPurchase = new RequestGuestPurchase();
        RequestGuestPurchase.GuestPurchaseJSONRequest guestPurchaseJSONRequest = new RequestGuestPurchase.GuestPurchaseJSONRequest();
        guestPurchaseJSONRequest.setPaymentMean(paymentMean);
        guestPurchaseJSONRequest.setRedeemNow(redeemNow);
        guestPurchaseJSONRequest.setServicePlanId(servicePlanId);
        guestPurchaseJSONRequest.setIsILDVas(ildVasFlag);
        List<VasPlans> vasPlansList = new ArrayList<>();
        if (vasPlans != null) {
            VasPlans vasPlanForRequest = new VasPlans();
            for (int i = 0; i < vasPlans.size(); i++) {
                vasPlanForRequest.setPartNumber(vasPlans.get(i).getPlanPartNumber());
                vasPlanForRequest.setVasPlanId(Integer.valueOf(vasPlans.get(i).getPlanId()));
                vasPlanForRequest.setQuantity(1);
                vasPlansList.add(vasPlanForRequest);
            }
        }
        guestPurchaseJSONRequest.setVasPlansList(vasPlansList);
        guestPurchaseJSONRequest.setPromoCode(promoCode);
        PartNumber part = new PartNumber();
        part.setQuantity(1);
        part.setPartNumber(partNum);
        List<PartNumber> cart =  new ArrayList<PartNumber>();
        cart.add(part);
        guestPurchaseJSONRequest.setCart(cart);

        requestGuestPurchase.setRequest(guestPurchaseJSONRequest);
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestGuestPurchase.setCommon(requestCommon);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(requestGuestPurchase);
        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());

        result = execConnection.executeRequest();
        return result;
    }
}
