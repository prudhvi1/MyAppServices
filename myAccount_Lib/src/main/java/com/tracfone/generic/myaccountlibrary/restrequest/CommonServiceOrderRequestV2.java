package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restpojos.Device;
import com.tracfone.generic.myaccountlibrary.restpojos.RedemptionRequestDataHolder;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestServiceOrder;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Individual;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Location;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PostalAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductPromotions;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.SupportingResources;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by skishore on 10/19/2016.
 */

public class CommonServiceOrderRequestV2 extends SpiceRequest<String>{


    private String externalID;
    private String orderDate;
    private ArrayList<RelatedParties> relatedParties;
    private ArrayList<ProductPromotions> productPromotions;
    private ArrayList<OrderItemsRequest> orderItems;
    private HashMap<String, String> orderItemsMap;
    private BillingAccount billingAccount;
    private ArrayList<RelatedServices> relatedServices;
    private String type;
    private String actionType;

    public CommonServiceOrderRequestV2(String actionType){
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
        if(productPromotions!=null)
        serviceOrderRequest.setProductPromotions(productPromotions);
        if(orderItems!=null)
        serviceOrderRequest.setOrderItems(orderItems);
        if(billingAccount!=null) {
            serviceOrderRequest.setBillingAccount(billingAccount);
        }
        if(relatedServices!=null) {
            serviceOrderRequest.setRelatedServices(relatedServices);
        }
        if(type!=null) {
            serviceOrderRequest.setType(type);
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
    public CommonServiceOrderRequestV2 setExternalID(String externalID) {
        this.externalID = externalID;
        return this;
    }

    public CommonServiceOrderRequestV2 setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public CommonServiceOrderRequestV2 setRelatedParties(ArrayList<RelatedParties> relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public CommonServiceOrderRequestV2 setProductPromotions(ArrayList<ProductPromotions> productPromotions) {
        this.productPromotions = productPromotions;
        return this;
    }

    public CommonServiceOrderRequestV2 setOrderItems(ArrayList<OrderItemsRequest> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public CommonServiceOrderRequestV2 setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
        return this;
    }

    public CommonServiceOrderRequestV2 setRelatedServices(ArrayList<RelatedServices> relatedServices) {
        this.relatedServices = relatedServices;
        return this;
    }

    public static final String TYPE_REDEEM_LINE = "REDEEM_LINE";
    public static final String TYPE_REDEEM_BAN = "REDEEM_BAN";
    public static final String TYPE_ACTIVATE_BAN = "ACTIVATE_BAN";
    public static final String TYPE_ACTIVATE_LINE = "ACTIVATE_LINE";
    public static final String TYPE_REACTIVATE_LINE = "REACTIVATE_LINE";
    public CommonServiceOrderRequestV2 setType(String type) {
        this.type = type;
        return this;
    }

    //Pin Redemption Common Request Builder
    public void requestBuilderforServiceOrderPinRedemption(RedemptionRequestDataHolder redemptionRequestDataHolder) {
        //relatedPartiesArrayList Building
        ArrayList<RelatedParties> relatedPartiesArrayList = new ArrayList<RelatedParties>();
        RelatedParties relatedPartiesObj = new RelatedParties();

        //partyExtensionArrayList Building
        ArrayList<PartyExtension> partyExtensionArrayList = new ArrayList<>();
        PartyExtension partyExtensionObj = new PartyExtension();
        partyExtensionObj.setName(PartyExtension.PARTY_TRANSACTIONID);
        Long tsLong = System.currentTimeMillis()/1000;
        partyExtensionObj.setValue(GlobalLibraryValues.getDeviceId() +  tsLong.toString());
        partyExtensionArrayList.add(partyExtensionObj);
        PartyExtension partyExtensionObj1 = new PartyExtension();
        partyExtensionObj1.setName(PartyExtension.PARTY_SOURCE_SYSTEM);
        partyExtensionObj1.setValue(PartyExtension.PARTY_APP);
        partyExtensionArrayList.add(partyExtensionObj1);

        //partyObj Building
        Party partyObj = new Party();
        Individual individualObj = new Individual();
        if (redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getValidateDeviceAccountId().isEmpty()) {
            individualObj.setId(GlobalOauthValues.getAccountId());
        } else {
            individualObj.setId(redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getValidateDeviceAccountId());
        }
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
        relatedPartiesObj1.setRoleType(Party.PARTY_ROLE_TYPE_INTERNAL);
        relatedPartiesArrayList.add(relatedPartiesObj1);

        setRelatedParties(relatedPartiesArrayList);


        if (redemptionRequestDataHolder.isMultiLineAccount()) {
            //Billing Account
            if (!redemptionRequestDataHolder.getBillingAccountId().isEmpty()) {
                BillingAccount billingAccountObj = new BillingAccount();
                billingAccountObj.setId(redemptionRequestDataHolder.getBillingAccountId());
                setBillingAccount(billingAccountObj);
            }
        }

        //ProductRequest Promotions building
        if(redemptionRequestDataHolder.getPromoCode()!=null && !redemptionRequestDataHolder.getPromoCode().isEmpty()) {
            ArrayList<ProductPromotions> productPromotionsArrayList = new ArrayList<ProductPromotions>();
            ProductPromotions productPromotionsObj = new ProductPromotions();
            productPromotionsObj.setId(redemptionRequestDataHolder.getPromoCode());
            productPromotionsArrayList.add(productPromotionsObj);
            setProductPromotions(productPromotionsArrayList);
        }

        //Related resources is built in activity

    }

    public ArrayList<OrderItemsRequest> buildOrderItemsPinRedemption(RedemptionRequestDataHolder redemptionRequestDataHolder){
        ArrayList<OrderItemsRequest> orderItemsArrayList = new ArrayList<>();

        OrderItemsRequest orderItemsObj = new OrderItemsRequest();
        //should decide action
        if (redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceStatus().equals(Device.DEVICE_ACTIVE)) {
            orderItemsObj.setAction(actionType);
        } else {
            orderItemsObj.setAction(OrderItemsRequest.ACTION_REACTIVATION);
        }


        ProductRequest productObj = new ProductRequest();
        if(redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceMin() != null && !redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceMin().isEmpty()) {
            productObj.setProductSerialNumber(redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceMin());
            productObj.setProductCategory(ProductRequest.CATEGORY_LINE);
        } else if(redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceEsn() !=null) {
            productObj.setProductSerialNumber(redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceEsn());
            productObj.setProductCategory(ProductRequest.CATEGORY_HANDSET);
        }

        ProductSpecification productSpecificationObj = new ProductSpecification();
        productSpecificationObj.setBrand(GlobalLibraryValues.getBrand());
        productObj.setProductSpecification(productSpecificationObj);

        ArrayList<SupportingResources> supportingResourcesArrayList = new ArrayList<>();
        SupportingResources supportingResourcesObj = new SupportingResources();
        supportingResourcesObj.setSerialNumber(redemptionRequestDataHolder.getAirTimeCardSerialNumber());
        supportingResourcesObj.setResourceType(SupportingResources.RESOURCE_TYPE_AIRTIME_CARD);
        supportingResourcesArrayList.add(supportingResourcesObj);

        if(redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceMin()!=null || redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceMin().isEmpty() ) {
            SupportingResources supportingResourcesObj2 = new SupportingResources();
            supportingResourcesObj2.setSerialNumber(redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceMin());
            supportingResourcesObj2.setResourceType(SupportingResources.RESOURCE_TYPE_LINE);
            supportingResourcesArrayList.add(supportingResourcesObj2);
        }

        productObj.setSupportingResources(supportingResourcesArrayList);

        ArrayList<RelatedServices> relatedServicesArrayList = new ArrayList<>();
        RelatedServices relatedServicesObj = new RelatedServices();
        relatedServicesObj.setIsRedeemNow(redemptionRequestDataHolder.isRedeemNow());
        relatedServicesArrayList.add(relatedServicesObj);
        productObj.setRelatedServices(relatedServicesArrayList);

        orderItemsObj.setProduct(productObj);

        Location locationObj = new Location();
        PostalAddress postalAddressObj = new PostalAddress();
        if (redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getZipcode().isEmpty()) {
            postalAddressObj.setZipcode(Location.DEFAULT_ZIPCODE);
        } else {
            postalAddressObj.setZipcode(redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getZipcode());
        }
        locationObj.setPostalAddress(postalAddressObj);
        orderItemsObj.setLocation(locationObj);

        orderItemsArrayList.add(orderItemsObj);

        return orderItemsArrayList;

    }

}
