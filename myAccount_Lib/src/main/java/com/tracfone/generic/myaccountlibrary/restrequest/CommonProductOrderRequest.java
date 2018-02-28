package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restpojos.ActivationRequestDataHolder;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestProductOrder;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.CharacteristicSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.CreditCard;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Individual;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Location;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PaymentMean;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PaymentPlan;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PostalAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductOffering;
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

public class CommonProductOrderRequest extends SpiceRequest<String> {

    private String externalID;
    private String orderDate;
    private ArrayList<RelatedParties> relatedParties;
    private ArrayList<ProductPromotions> productPromotions;
    private ArrayList<OrderItemsRequest> orderItems;
    private String quantity;
    private BillingAccount billingAccount;
    private Location location;
    private HashMap<String, String> orderItemsMap;
    private String type;
    private String actionType;

    public CommonProductOrderRequest(String actionType) {
        super(String.class);
        this.actionType = actionType;
    }


    @Override
    public String loadDataFromNetwork() throws Exception {
        RequestProductOrder requestProductOrder =  new RequestProductOrder();
        RequestProductOrder.ProductOrderRequest productOrderRequest = new RequestProductOrder.ProductOrderRequest();
        if(externalID!=null)
        productOrderRequest.setExternalID(externalID);
        if(orderDate!=null)
        productOrderRequest.setOrderDate(orderDate);
        if(relatedParties!=null)
        productOrderRequest.setRelatedParties(relatedParties);
        if(productPromotions!=null)
        productOrderRequest.setProductPromotions(productPromotions);
        if(orderItems!=null)
        productOrderRequest.setOrderItems(orderItems);
        if(quantity!=null)
        productOrderRequest.setQuantity(quantity);
        if(billingAccount!=null)
        productOrderRequest.setBillingAccount(billingAccount);
        if(location!=null)
        productOrderRequest.setLocation(location);
        if(type!=null) {
            productOrderRequest.setType(type);
        }
        //set common request header
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestProductOrder.setCommon(requestCommon);
        requestProductOrder.setRequest(productOrderRequest);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //remove unwanted elements
        String jsonString = mapper.writeValueAsString(requestProductOrder);

        String url;
        url = RestfulURL.getUrl(RestfulURL.PRODUCT_ORDER, GlobalLibraryValues.getBrand());
        if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, actionType);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString() );
        String result = execConnection.executeRequest();
        return result;
    }

    public static final String EXTERNAL_ID = "12345667890";
    public static final String PURCHASE_REUP_CC = "PurchaseReUpCC";
    public static final String PURCHASE_REUP_GUEST = "PurchaseReUpGuest";
    public static final String PURCHASE_ENROLL = "PurchaseEnrollReUp";
    public static final String PURCHASE_MANAGE = "PurchaseManageReUp";
    public static final String PURCHASE_MANAGE_APPLY_NOW = "PurchaseManageReUpApplyNow";
    public CommonProductOrderRequest setExternalID(String externalID) {
        this.externalID = externalID;
        return this;
    }

    public CommonProductOrderRequest setLocation(Location location) {
        this.location = location;
        return this;
    }

    public CommonProductOrderRequest setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
        return this;
    }

    public CommonProductOrderRequest setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public CommonProductOrderRequest setOrderItems(ArrayList<OrderItemsRequest> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public CommonProductOrderRequest setProductPromotions(ArrayList<ProductPromotions> productPromotions) {
        this.productPromotions = productPromotions;
        return this;
    }

    public CommonProductOrderRequest setRelatedParties(ArrayList<RelatedParties> relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public CommonProductOrderRequest setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }


    public static final String TYPE_REDEEM_LINE = "REDEEM_LINE";
    public static final String TYPE_REDEEM_BAN = "REDEEM_BAN";
    public static final String TYPE_ACTIVATE_BAN = "ACTIVATE_BAN";
    public static final String TYPE_ACTIVATE_LINE = "ACTIVATE_LINE";
    public static final String TYPE_REACTIVATE_LINE = "REACTIVATE_LINE";
    public CommonProductOrderRequest setType(String type) {
        this.type = type;
        return this;
    }

    //Common Request Builder
    public void requestBuilderforProductOrder(ActivationRequestDataHolder activationRequestDataHolder) {
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
        orderItemsObj.setAction(actionType);

        ProductRequest productObj = new ProductRequest();
        if(activationRequestDataHolder.getActivationElectronicSerialNumber()!=null) {
            productObj.setProductSerialNumber(activationRequestDataHolder.getActivationElectronicSerialNumber());
            productObj.setProductCategory(ProductRequest.CATEGORY_HANDSET);
        }
        ProductSpecification productSpecificationObj = new ProductSpecification();
        productSpecificationObj.setBrand(GlobalLibraryValues.getBrand());
        productSpecificationObj.setId(activationRequestDataHolder.getSelectedPlan().getPlanPartClassNumber());

        productObj.setProductSpecification(productSpecificationObj);

        ArrayList<SupportingResources> supportingResourcesArrayList = new ArrayList<>();

        if(activationRequestDataHolder.getActivationSimCardSerialNumber()!=null) {
            SupportingResources supportingResourcesObj1 = new SupportingResources();
            supportingResourcesObj1.setSerialNumber(activationRequestDataHolder.getActivationSimCardSerialNumber());
            supportingResourcesObj1.setResourceType(SupportingResources.RESOURCE_TYPE_SIM_CARD);
            supportingResourcesArrayList.add(supportingResourcesObj1);
        }
        productObj.setSupportingResources(supportingResourcesArrayList);

        ProductOffering productOfferingObj = new ProductOffering();
        productOfferingObj.setId(activationRequestDataHolder.getSelectedPlan().getPlanPartNumber());
        productOfferingObj.setName(activationRequestDataHolder.getSelectedPlan().getPlanName());
        orderItemsObj.setProductOffering(productOfferingObj);

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


        BillingAccount billingAccount = new BillingAccount();

        PaymentPlan paymentPlan = new PaymentPlan();
        paymentPlan.setIsRecurring(autoRefillOrder);

        PaymentMean paymentMean = new PaymentMean();

        if (activationRequestDataHolder.getGuestCreditCard() == null) {
            //A saved CC is to be used for purchase
            paymentMean.setId(activationRequestDataHolder.getStoredCreditCard().getCcPaymentSourceId());
            CreditCard creditCard = new CreditCard();
            creditCard.setCvv(activationRequestDataHolder.getStoredCreditCardCVV());
            creditCard.setType(activationRequestDataHolder.getStoredCreditCard().getCcType());
            paymentMean.setCreditCard(creditCard);
            paymentMean.setPaymentType(PaymentMean.TYPE_CREDIT_CARD);
            paymentPlan.setPaymentMean(paymentMean);
        } else {
            //A guest CC is to used for purchase
            paymentPlan.setPaymentMean(activationRequestDataHolder.getGuestCreditCard());
        }

        billingAccount.setPaymentPlan(paymentPlan);

        orderItemsObj.setBillingAccount(billingAccount);


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
