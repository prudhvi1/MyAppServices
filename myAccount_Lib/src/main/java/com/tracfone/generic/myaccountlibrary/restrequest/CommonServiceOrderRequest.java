package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.ActivationRequestDataHolder;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestServiceOrder;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.CharacteristicSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Individual;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Location;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PostalAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductPromotions;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.SupportingResources;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by skishore on 10/19/2016.
 */

public class CommonServiceOrderRequest extends SpiceRequest<String>{


    private String externalID;
    private String orderDate;
    private ArrayList<RelatedParties> relatedParties;
    private ArrayList<ProductPromotions> productPromotions;
    private ArrayList<OrderItemsRequest> orderItems;
    private HashMap<String, String> orderItemsMap;
    private BillingAccount billingAccount;
    private ArrayList<RelatedServices> relatedServices;
    private String actionType;

    public CommonServiceOrderRequest(String actionType){
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

        //set common request header
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestServiceOrder.setCommon(requestCommon);
        requestServiceOrder.setRequest(serviceOrderRequest);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //remove unwanted elements
        String jsonString = mapper.writeValueAsString(requestServiceOrder);

        String url = RestfulURL.getUrl(RestfulURL.SERVICE_ORDER, GlobalLibraryValues.getBrand());
        if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, orderItems.get(0).getAction());

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString() );
        String result = execConnection.executeRequest();
        return result;
    }

    public static final String EXTERNAL_ID = "12345667890";
    public CommonServiceOrderRequest setExternalID(String externalID) {
        this.externalID = externalID;
        return this;
    }

    public CommonServiceOrderRequest setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public CommonServiceOrderRequest setRelatedParties(ArrayList<RelatedParties> relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public CommonServiceOrderRequest setProductPromotions(ArrayList<ProductPromotions> productPromotions) {
        this.productPromotions = productPromotions;
        return this;
    }

    public CommonServiceOrderRequest setOrderItems(ArrayList<OrderItemsRequest> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public CommonServiceOrderRequest setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
        return this;
    }

    public CommonServiceOrderRequest setRelatedServices(ArrayList<RelatedServices> relatedServices) {
        this.relatedServices = relatedServices;
        return this;
    }


    //Common Request Builder
    public void requestBuilderforServiceOrder(ActivationRequestDataHolder activationRequestDataHolder) {
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
        partyObj.setPartyID(Party.PARTY_ID_CUST_HASH);
        Individual individualObj = new Individual();
        if (GlobalOauthValues.isLoggedIn()) {
            individualObj.setId(GlobalOauthValues.getAccountId());
        } else {
            if(activationRequestDataHolder.getFlowActionType().equals(OrderItemsRequest.ACTION_PHONE_UPGRADE)) {
                individualObj.setId(activationRequestDataHolder.getValidatedFromMin().getValidateDeviceAccountId());
            } else {
                individualObj.setId(activationRequestDataHolder.getValidatedESN().getValidateDeviceAccountId());
            }
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
        relatedPartiesObj1.setRoleType(Party.PARTY_ROLE_TYPE_APPLICATION);
        relatedPartiesArrayList.add(relatedPartiesObj1);

        setRelatedParties(relatedPartiesArrayList);

        //ProductRequest Promotions building
        if(activationRequestDataHolder.getPromoCode()!=null && !activationRequestDataHolder.getPromoCode().isEmpty()) {
            ArrayList<ProductPromotions> productPromotionsArrayList = new ArrayList<ProductPromotions>();
            ProductPromotions productPromotionsObj = new ProductPromotions();
            productPromotionsObj.setId(activationRequestDataHolder.getPromoCode());
            productPromotionsArrayList.add(productPromotionsObj);
            setProductPromotions(productPromotionsArrayList);
        }

        //Related resources is built in activity

    }

    public ArrayList<OrderItemsRequest> buildOrderItems(ActivationRequestDataHolder activationRequestDataHolder, boolean autoRefillOrder){
        ArrayList<OrderItemsRequest> orderItemsArrayList = new ArrayList<>();

        OrderItemsRequest orderItemsObj = new OrderItemsRequest();
        //should decide action
        orderItemsObj.setAction(actionType);

        ProductRequest productObj = new ProductRequest();
        if(activationRequestDataHolder.getActivationElectronicSerialNumber()!=null) {
            productObj.setProductSerialNumber(activationRequestDataHolder.getActivationElectronicSerialNumber());
            productObj.setProductCategory(ProductRequest.CATEGORY_HANDSET);
        }
        ProductSpecification productSpecificationObj = new ProductSpecification();
        productSpecificationObj.setBrand(GlobalLibraryValues.getBrand());
        productObj.setProductSpecification(productSpecificationObj);

        ArrayList<SupportingResources> supportingResourcesArrayList = new ArrayList<>();
        if(activationRequestDataHolder.getAirTimePin() != null && !activationRequestDataHolder.getAirTimePin().isEmpty()) {
            SupportingResources supportingResourcesObj = new SupportingResources();
            supportingResourcesObj.setSerialNumber(activationRequestDataHolder.getAirTimePin());
            supportingResourcesObj.setResourceType(SupportingResources.RESOURCE_TYPE_AIRTIME_CARD);
            supportingResourcesArrayList.add(supportingResourcesObj);
        }
        if(activationRequestDataHolder.getActivationSimCardSerialNumber()!=null) {
            SupportingResources supportingResourcesObj1 = new SupportingResources();
            supportingResourcesObj1.setSerialNumber(activationRequestDataHolder.getActivationSimCardSerialNumber());
            supportingResourcesObj1.setResourceType(SupportingResources.RESOURCE_TYPE_SIM_CARD);
            supportingResourcesArrayList.add(supportingResourcesObj1);
        }
        productObj.setSupportingResources(supportingResourcesArrayList);

        ArrayList<RelatedServices> relatedServicesArrayList = new ArrayList<>();
        RelatedServices relatedServicesObj = new RelatedServices();
        if(activationRequestDataHolder.getSelectedPlan() != null){
            relatedServicesObj.setId(activationRequestDataHolder.getSelectedPlan().getPlanId());
            relatedServicesObj.setCategory(RelatedServices.CATEGORY_SERVICE_PLAN);
            ArrayList<CharacteristicSpecification> characteristicSpecificationArrayList = new ArrayList<>();
            CharacteristicSpecification characteristicSpecification = new CharacteristicSpecification();
            if (autoRefillOrder) {
                characteristicSpecification.setName(CharacteristicSpecification.NAME_RELATED_PROGRAM);
                characteristicSpecification.setValue(activationRequestDataHolder.getSelectedPlan().getPlanProgramId());
            }
            characteristicSpecificationArrayList.add(characteristicSpecification);
            relatedServicesObj.setCharacteristicSpecification(characteristicSpecificationArrayList);
            relatedServicesArrayList.add(relatedServicesObj);
        }
        productObj.setRelatedServices(relatedServicesArrayList);

        orderItemsObj.setProduct(productObj);
        orderItemsObj.setOrderItemExtension(buildOrderItemExtension(activationRequestDataHolder));

        orderItemsObj.setId("1");
        orderItemsObj.setQuantity("1");

        Location locationObj = new Location();
        PostalAddress postalAddressObj = new PostalAddress();
        if (activationRequestDataHolder.getActivationZipCode() == null || activationRequestDataHolder.getActivationZipCode().isEmpty()) {
            postalAddressObj.setZipcode(Location.DEFAULT_ZIPCODE);
        } else {
            postalAddressObj.setZipcode(activationRequestDataHolder.getActivationZipCode());
        }
        locationObj.setPostalAddress(postalAddressObj);
        orderItemsObj.setLocation(locationObj);

        orderItemsArrayList.add(orderItemsObj);

        return orderItemsArrayList;
    }

    private ArrayList<OrderItemExtension> buildOrderItemExtension(ActivationRequestDataHolder activationRequestDataHolder) {
        orderItemsMap=new HashMap<String, String>();

        if (actionType.equals(OrderItemsRequest.ACTION_PHONE_UPGRADE)) {
            orderItemsPut(OrderItemExtension.NAME_CURRENT_MIN, activationRequestDataHolder.getActivationCurrentMinNumber());
        }

        if (actionType.equals(OrderItemsRequest.ACTION_PORT)) {
            orderItemsPut(OrderItemExtension.NAME_CURRENT_CARRIER_TYPE, activationRequestDataHolder.getPortCarrierType());
            orderItemsPut(OrderItemExtension.NAME_CURRENT_MIN, activationRequestDataHolder.getActivationCurrentMinNumber());
            if (activationRequestDataHolder.getPortServiceProvider() != null && !activationRequestDataHolder.getPortServiceProvider().isEmpty() ) {
                //External Port
                orderItemsPut(OrderItemExtension.NAME_CURRENT_SERVICE_PROVIDER, activationRequestDataHolder.getPortServiceProvider());
            } else {
                //Internal port
                orderItemsPut(OrderItemExtension.NAME_CURRENT_SERVICE_PROVIDER, activationRequestDataHolder.getPortCurrentBrand());
            }
            if (activationRequestDataHolder.getPortPortAccountDetails() != null) {
                orderItemsPut(OrderItemExtension.NAME_CURRENT_ACCOUNT_NUMBER, activationRequestDataHolder.getPortPortAccountDetails().getCurrentAccountNumber());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_FULL_NAME, activationRequestDataHolder.getPortPortAccountDetails().getCurrentFullName());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_PIN, activationRequestDataHolder.getPortPortAccountDetails().getCurrentPin());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_VKEY, activationRequestDataHolder.getPortPortAccountDetails().getCurrentVKey());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_SSN_LAST4, activationRequestDataHolder.getPortPortAccountDetails().getSsnLast4Digits());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_CONTACT_PHONE, activationRequestDataHolder.getPortPortAccountDetails().getContactPhonee());
            }
            if (activationRequestDataHolder.getPortValidatedAddress() != null) {
                orderItemsPut(OrderItemExtension.NAME_CURRENT_ADDRESS_LINE1, activationRequestDataHolder.getPortValidatedAddress().getAddressLine1());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_ADDRESS_LINE2, activationRequestDataHolder.getPortValidatedAddress().getAddressLine2());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_ADDRESS_CITY, activationRequestDataHolder.getPortValidatedAddress().getCity());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_ADDRESS_STATE, activationRequestDataHolder.getPortValidatedAddress().getStateOrProvince());
                orderItemsPut(OrderItemExtension.NAME_CURRENT_ADDRESS_ZIP, activationRequestDataHolder.getPortValidatedAddress().getZipCode());
            }

            if (activationRequestDataHolder.getPortValidateMoreAddress() != null) {
                orderItemsPut(OrderItemExtension.NAME_UNIT_NUMBER, activationRequestDataHolder.getPortValidateMoreAddress().getUnitNumber());
                orderItemsPut(OrderItemExtension.NAME_HOUSE_NUMBER, activationRequestDataHolder.getPortValidateMoreAddress().getHouseNumber());
                orderItemsPut(OrderItemExtension.NAME_STREET_NAME, activationRequestDataHolder.getPortValidateMoreAddress().getStreetName());
                orderItemsPut(OrderItemExtension.NAME_STREET_DIRECTION, activationRequestDataHolder.getPortValidateMoreAddress().getStreetDirection());
                orderItemsPut(OrderItemExtension.NAME_STREET_TYPE, activationRequestDataHolder.getPortValidateMoreAddress().getStreetType());
            }
        }

        //Optional values not filled
        //orderItemsPut(OrderItemExtension.NAME_HANDSET_LAST_FOUR, );
        //orderItemsPut(OrderItemExtension.NAME_CURRENT_CARRIER, );

        //only for total wireless
        orderItemsPut(OrderItemExtension.NAME_CURRENT_GROUP_IDENTIFIER,  activationRequestDataHolder.getGroupGroupId());
        orderItemsPut(OrderItemExtension.NAME_CURRENT_LEASE_APPLICATION_ID, "");

        ArrayList<OrderItemExtension> orderItemExtensionArrayList = new ArrayList<>();
        Iterator myVeryOwnIterator = orderItemsMap.keySet().iterator();
        while(myVeryOwnIterator.hasNext()) {
            OrderItemExtension orderItemExtensionObj = new OrderItemExtension();
            String name=(String)myVeryOwnIterator.next();
            String value=(String)orderItemsMap.get(name);
            orderItemExtensionObj.setName(name);
            orderItemExtensionObj.setValue(value);
            orderItemExtensionArrayList.add(orderItemExtensionObj);
        }
        return orderItemExtensionArrayList;
    }

    private void orderItemsPut(String key,String value){
        if(value!=null && !value.isEmpty()) {
            orderItemsMap.put(key, value);
        }
    }

}
