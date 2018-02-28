package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestServiceOrder;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Individual;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;
import java.util.ArrayList;

/**
 * Created by hserna on 11/14/2017.
 */

public class LRPRewardsEnrollServiceOrderRequest extends SpiceRequest<String> {

    private String externalID;
    private String orderDate;
    private ArrayList<RelatedParties> relatedParties;
    private ArrayList<OrderItemsRequest> orderItems;
    private BillingAccount billingAccount;
    private ArrayList<RelatedServices> relatedServices;
    private String actionType;

    public LRPRewardsEnrollServiceOrderRequest(String actionType){
        super(String.class);
        this.actionType = actionType;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        RequestServiceOrder requestServiceOrder =  new RequestServiceOrder();
        RequestServiceOrder.ServiceOrderRequest serviceOrderRequest =  new RequestServiceOrder.ServiceOrderRequest();
        if(externalID!=null)
            serviceOrderRequest.setExternalID(externalID);
        if(orderDate!=null)
            serviceOrderRequest.setOrderDate(orderDate);
        if(relatedParties!=null)
            serviceOrderRequest.setRelatedParties(relatedParties);
        if(orderItems!=null)
            serviceOrderRequest.setOrderItems(orderItems);
        if(billingAccount!=null) {
            serviceOrderRequest.setBillingAccount(billingAccount);
        }
        if(relatedServices!=null) {
            serviceOrderRequest.setRelatedServices(relatedServices);
        }

        //set common request header
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestServiceOrder.setCommon(requestCommon);
        requestServiceOrder.setRequest(serviceOrderRequest);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //remove unwanted elements
        String jsonString = mapper.writeValueAsString(requestServiceOrder);

        String url = RestfulURL.getUrl(RestfulURL.SERVICE_ORDER_V2, GlobalLibraryValues.getBrand());
        if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, orderItems.get(0).getAction());

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString() );
        String result = execConnection.executeRequest();
        return result;
    }

    public static final String EXTERNAL_ID = "12345667890";
    public LRPRewardsEnrollServiceOrderRequest setExternalID(String externalID) {
        this.externalID = externalID;
        return this;
    }

    public LRPRewardsEnrollServiceOrderRequest setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public LRPRewardsEnrollServiceOrderRequest setRelatedParties(ArrayList<RelatedParties> relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public LRPRewardsEnrollServiceOrderRequest setOrderItems(ArrayList<OrderItemsRequest> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public LRPRewardsEnrollServiceOrderRequest setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
        return this;
    }

    public LRPRewardsEnrollServiceOrderRequest setRelatedServices(ArrayList<RelatedServices> relatedServices) {
        this.relatedServices = relatedServices;
        return this;
    }

    public void requestBuilderforServiceOrder() {
        //relatedPartiesArrayList Building
        ArrayList<RelatedParties> relatedPartiesArrayList = new ArrayList<RelatedParties>();
        RelatedParties relatedPartiesObj = new RelatedParties();

        //partyExtensionArrayList Building
        ArrayList<PartyExtension> partyExtensionArrayList = new ArrayList<>();
        PartyExtension partyExtensionObj = new PartyExtension();
        partyExtensionObj.setName(PartyExtension.PARTY_TRANSACTIONID);
        Long tsLong = System.currentTimeMillis() / 1000;
        partyExtensionObj.setValue(GlobalLibraryValues.getDeviceId() + tsLong.toString());
        partyExtensionArrayList.add(partyExtensionObj);

        PartyExtension partyExtensionObj1 = new PartyExtension();
        partyExtensionObj1.setName(PartyExtension.PARTY_SOURCE_SYSTEM);
        partyExtensionObj1.setValue(PartyExtension.PARTY_APP);
        partyExtensionArrayList.add(partyExtensionObj1);

        //partyObj Building
        Party partyObj = new Party();

        Individual individualObj = new Individual();
        //at this point we are already logged-in thus we can get accountId.
        individualObj.setId(GlobalOauthValues.getAccountId());

        partyObj.setIndividual(individualObj);
        relatedPartiesObj.setParty(partyObj);
        relatedPartiesObj.setRoleType(Party.PARTY_ROLE_TYPE_CUSTOMER);
        relatedPartiesArrayList.add(relatedPartiesObj);

        //partyObj Building-2
        RelatedParties relatedPartiesObj1 = new RelatedParties();
        Party partyObj1 = new Party();
        partyObj1.setPartyID(Party.PARTY_ID_TFAPP_BRAND);
        partyObj1.setLanguageAbility(Party.PARTY_LANGUAGE_AVAILABILITY_ENG);
        partyObj1.setPartyExtension(partyExtensionArrayList);
        relatedPartiesObj1.setParty(partyObj1);
        relatedPartiesObj1.setRoleType(Party.PARTY_ROLE_TYPE_APPLICATION);
        relatedPartiesArrayList.add(relatedPartiesObj1);
        setRelatedParties(relatedPartiesArrayList);
    }

    public ArrayList<OrderItemsRequest> buildOrderItems(){
        ArrayList<OrderItemsRequest> orderItemsArrayList = new ArrayList<>();

        OrderItemsRequest orderItemsObj = new OrderItemsRequest();
        orderItemsObj.setAction(OrderItemsRequest.ACTION_ENROLLMENT);

        ProductRequest productObj = new ProductRequest();
        ProductSpecification productSpecificationObj = new ProductSpecification();
        productSpecificationObj.setBrand(GlobalLibraryValues.getBrand());
        productObj.setProductSpecification(productSpecificationObj);

        ArrayList<RelatedServices> relatedServicesArrayList = new ArrayList<>();
        RelatedServices relatedServicesObj = new RelatedServices();
        relatedServicesObj.setCategory(RelatedServices.CATEGORY_LOYALTY_PROGRAM);
        relatedServicesObj.setType(RelatedServices.TYPE_PROGRAM_ENROLLMENT);
        relatedServicesObj.setBenefitType(RelatedServices.BENEFIT_TYPE_LOYALTY_POINTS);
        relatedServicesArrayList.add(relatedServicesObj);
        productObj.setRelatedServices(relatedServicesArrayList);

        orderItemsObj.setProduct(productObj);
        orderItemsObj.setId("1");
        orderItemsArrayList.add(orderItemsObj);

        return orderItemsArrayList;
    }

}
