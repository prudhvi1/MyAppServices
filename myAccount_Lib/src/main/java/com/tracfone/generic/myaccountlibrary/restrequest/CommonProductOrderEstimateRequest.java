package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restpojos.ActivationRequestDataHolder;
import com.tracfone.generic.myaccountlibrary.restpojos.Device;
import com.tracfone.generic.myaccountlibrary.restpojos.RedemptionRequestDataHolder;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestProductOrderV2;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseCurrentEnrollmentPlan;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponsePlanList;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.CharacteristicSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Individual;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.LocationEstimate;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PostalAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductOffering;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductPromotions;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by skishore on 10/19/2016.
 */

public class CommonProductOrderEstimateRequest extends SpiceRequest<String> {

    private String externalID;
    private String orderDate;
    private ArrayList<RelatedParties> relatedParties;
    private ArrayList<ProductPromotions> productPromotions;
    private ArrayList<OrderItemsRequest> orderItems;
    private String quantity;
    private BillingAccount billingAccount;
    private ArrayList<LocationEstimate> locationEstimateArrayList;
    private HashMap<String, String> orderItemsMap;
    private String type;
    private String actionType;
    private boolean isEnrollment;

    public CommonProductOrderEstimateRequest(String actionType, boolean isEnrollment) {
        super(String.class);
        this.actionType = actionType;
        this.isEnrollment = isEnrollment;
    }


    @Override
    public String loadDataFromNetwork() throws Exception {
        RequestProductOrderV2 requestProductOrder =  new RequestProductOrderV2();
        RequestProductOrderV2.ProductOrderRequest productOrderRequest = new RequestProductOrderV2.ProductOrderRequest();
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
        if(locationEstimateArrayList !=null)
            productOrderRequest.setLocationEstimate(locationEstimateArrayList);
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
        url = RestfulURL.getUrl(RestfulURL.PRODUCT_ORDER_ESTIMATE, GlobalLibraryValues.getBrand());
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
    public CommonProductOrderEstimateRequest setExternalID(String externalID) {
        this.externalID = externalID;
        return this;
    }

    public CommonProductOrderEstimateRequest setLocation(ArrayList<LocationEstimate> locationEstimateArrayList) {
        this.locationEstimateArrayList = locationEstimateArrayList;
        return this;
    }

    public CommonProductOrderEstimateRequest setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
        return this;
    }

    public CommonProductOrderEstimateRequest setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public CommonProductOrderEstimateRequest setOrderItems(ArrayList<OrderItemsRequest> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public CommonProductOrderEstimateRequest setProductPromotions(ArrayList<ProductPromotions> productPromotions) {
        this.productPromotions = productPromotions;
        return this;
    }

    public CommonProductOrderEstimateRequest setRelatedParties(ArrayList<RelatedParties> relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public CommonProductOrderEstimateRequest setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public static final String TYPE_REDEEM_LINE = "REDEEM_LINE";
    public static final String TYPE_REDEEM_BAN = "REDEEM_BAN";
    public static final String TYPE_ACTIVATE_BAN = "ACTIVATE_BAN";
    public static final String TYPE_ACTIVATE_LINE = "ACTIVATE_LINE";
    public static final String TYPE_REACTIVATE_LINE = "REACTIVATE_LINE";
    public CommonProductOrderEstimateRequest setType(String type) {
        this.type = type;
        return this;
    }

    //Common redemption product order Request Builder
    public void requestBuilderforProductOrderEstimate(ActivationRequestDataHolder activationRequestDataHolder) {
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
        relatedPartiesObj1.setRoleType(Party.PARTY_ROLE_TYPE_INTERNAL);
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

        ArrayList<LocationEstimate> locationEstimateArrayListObj = new ArrayList<LocationEstimate>();
        LocationEstimate locationEstimateObj = new LocationEstimate();
        locationEstimateObj.setAddressType(LocationEstimate.ADDRESS_TYPE_BILLING);
        PostalAddress postalAddressObj = new PostalAddress();
        if (activationRequestDataHolder.getGuestCreditCard() == null) {
            postalAddressObj.setZipcode(activationRequestDataHolder.getStoredCreditCard().getCcBillingZipCode());
        } else {
            //A guest CC is to used for purchase
            postalAddressObj.setZipcode(activationRequestDataHolder.getGuestCreditCard().getBillingAddress().getzipcode());
        }
        locationEstimateObj.setPostalAddress(postalAddressObj);
        locationEstimateArrayListObj.add(locationEstimateObj);
        setLocation(locationEstimateArrayListObj);

    }

    //Common redemption product order Request Builder
    public void requestBuilderforProductOrderEstimate(RedemptionRequestDataHolder redemptionRequestDataHolder) {
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
            if (!redemptionRequestDataHolder.getBillingAccountId().isEmpty()) {
                //Billing Account
                BillingAccount billingAccountObj = new BillingAccount();
                billingAccountObj.setId(redemptionRequestDataHolder.getBillingAccountId());
                setBillingAccount(billingAccountObj);
            }
            //Redemption Type
            if (redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceStatus().equals(Device.DEVICE_ACTIVE)) {
                setType(TYPE_REDEEM_BAN);
            } else {
                setType(TYPE_REACTIVATE_LINE);
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

        ArrayList<LocationEstimate> locationEstimateArrayListObj = new ArrayList<LocationEstimate>();
        LocationEstimate locationEstimateObj = new LocationEstimate();
        locationEstimateObj.setAddressType(LocationEstimate.ADDRESS_TYPE_BILLING);
        PostalAddress postalAddressObj = new PostalAddress();
        if (redemptionRequestDataHolder.getGuestCreditCard() == null) {
            postalAddressObj.setZipcode(redemptionRequestDataHolder.getStoredCreditCard().getCcBillingZipCode());
        } else {
            //A guest CC is to used for purchase
            postalAddressObj.setZipcode(redemptionRequestDataHolder.getGuestCreditCard().getBillingAddress().getzipcode());
        }
        locationEstimateObj.setPostalAddress(postalAddressObj);
        locationEstimateArrayListObj.add(locationEstimateObj);
        setLocation(locationEstimateArrayListObj);

    }




    public ArrayList<OrderItemsRequest> buildOrderItemsEstimate(RedemptionRequestDataHolder redemptionRequestDataHolder) {
        ArrayList<OrderItemsRequest> orderItemsArrayList = new ArrayList<>();
        //orderItemsObj Building
        ResponseCurrentEnrollmentPlan.CurrentEnrollmentPlan.ServicePlan enrolledPlan = null;
        if (redemptionRequestDataHolder.getCurrentEnrollmentPlan() != null) enrolledPlan = redemptionRequestDataHolder.getCurrentEnrollmentPlan().getPlan();
        OrderItemsRequest orderItemsObj = populateOrderItem(1, redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceMin(), redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceEsn(), redemptionRequestDataHolder.getSelectedPlan(), enrolledPlan);
        orderItemsArrayList.add(orderItemsObj);
        //Add vas plan is present
        if(redemptionRequestDataHolder.getSelectedVasPlansList() != null && redemptionRequestDataHolder.getSelectedVasPlansList().get(0) != null) {
            OrderItemsRequest orderItemsObj2 = populateOrderItem(2, redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceMin(), redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceEsn(), redemptionRequestDataHolder.getSelectedVasPlansList().get(0), null);
            orderItemsArrayList.add(orderItemsObj2);
        }
        return orderItemsArrayList;
    }


    public ArrayList<OrderItemsRequest> buildOrderItemsMultiLineEstimate(RedemptionRequestDataHolder redemptionRequestDataHolder) {
        ArrayList<OrderItemsRequest> orderItemsArrayList = new ArrayList<>();
        //Please note this method will only work with a multiple devices with NO add ons.  Other combinations will require
        //additional logic.
        for (int orderItemId = 1; orderItemId <= redemptionRequestDataHolder.getOrderItems().size(); orderItemId++) {
            OrderItemsRequest orderItemsObj = populateOrderItem(orderItemId, redemptionRequestDataHolder.getOrderItems().get(orderItemId-1).getDevice().getDeviceEsn(), redemptionRequestDataHolder.getOrderItems().get(orderItemId-1).getDevice().getDeviceEsn(), redemptionRequestDataHolder.getOrderItems().get(orderItemId-1).getPlan(), null);
            orderItemsArrayList.add(orderItemsObj);
        }
        return orderItemsArrayList;
    }

    public ArrayList<OrderItemsRequest> buildOrderItemsEstimate(ActivationRequestDataHolder activationRequestDataHolder) {
        ArrayList<OrderItemsRequest> orderItemsArrayList = new ArrayList<>();
        String esn;
        String min;
        if (activationRequestDataHolder.getFlowActionType().equals(OrderItemsRequest.ACTION_REACTIVATION)) {
            min = activationRequestDataHolder.getValidatedESN().getDeviceMin();
            esn = activationRequestDataHolder.getActivationElectronicSerialNumber();
        } else {
            min = null;
            esn = activationRequestDataHolder.getActivationElectronicSerialNumber();
        }
        //orderItemsObj Building
        OrderItemsRequest orderItemsObj = populateOrderItem(1, min, esn, activationRequestDataHolder.getSelectedPlan(), null);
        orderItemsArrayList.add(orderItemsObj);
        return orderItemsArrayList;
    }

    private OrderItemsRequest populateOrderItem(int id, String min, String esn, ResponsePlanList.PlanList.Plan plan, ResponseCurrentEnrollmentPlan.CurrentEnrollmentPlan.ServicePlan enrolledPlan) {
        OrderItemsRequest orderItemsObj = new OrderItemsRequest();

        orderItemsObj.setAction(actionType);

        ProductOffering productOfferingObj = new ProductOffering();
        if (plan != null) {
            productOfferingObj.setId(plan.getPlanPartNumber());
            productOfferingObj.setName(plan.getPlanName());
        } else {
            productOfferingObj.setId(enrolledPlan.getPlanPartNumber());
            productOfferingObj.setName(enrolledPlan.getPlanName());
        }

        ProductSpecification productSpecificationObj1 = new ProductSpecification();
        productSpecificationObj1.setBrand(GlobalLibraryValues.getBrand());
        if (plan != null) {
            productSpecificationObj1.setId(plan.getPlanPartClassNumber());
        } else {
            //TODO
            //productSpecificationObj1.setId(enrolledPlan.getPlanPartClassNumber());
        }
        productOfferingObj.setProductSpecification(productSpecificationObj1);

        orderItemsObj.setProductOffering(productOfferingObj);

        ProductRequest productObj = new ProductRequest();
        if(min != null && !min.isEmpty()) {
            productObj.setProductSerialNumber(min);
            productObj.setProductCategory(ProductRequest.CATEGORY_LINE);
        } else if(esn !=null) {
            productObj.setProductSerialNumber(esn);
            productObj.setProductCategory(ProductRequest.CATEGORY_HANDSET);
        }

        ProductSpecification productSpecificationObj = new ProductSpecification();
        productSpecificationObj.setBrand(GlobalLibraryValues.getBrand());
        if (plan != null) {
            productSpecificationObj.setId(plan.getPlanPartClassNumber());
        } else {
            //TODO
            //productSpecificationObj.setId(enrolledPlan.getPlanPartClassNumber());
        }
        productObj.setProductSpecification(productSpecificationObj);

        ArrayList<RelatedServices> relatedServicesArrayList = new ArrayList<>();
        RelatedServices relatedServicesObj = new RelatedServices();
        if (plan != null) {
            relatedServicesObj.setId(plan.getPlanId());
            if (plan.isIldVasFlag()) {
                relatedServicesObj.setCategory(RelatedServices.CATEGORY_ILD_ADDON);
            } else {
                relatedServicesObj.setCategory(RelatedServices.CATEGORY_SERVICE_PLAN);
            }
        } else {
            relatedServicesObj.setId(enrolledPlan.getPlanId());
            relatedServicesObj.setCategory(RelatedServices.CATEGORY_SERVICE_PLAN);
        }

        ArrayList<CharacteristicSpecification> characteristicSpecificationArrayList = new ArrayList<>();
        CharacteristicSpecification characteristicSpecification = new CharacteristicSpecification();
        if (isEnrollment) {
            characteristicSpecification.setName(CharacteristicSpecification.NAME_RELATED_PROGRAM);
            if (plan != null) {
                characteristicSpecification.setValue(plan.getPlanProgramId());
            } else {
                characteristicSpecification.setValue(enrolledPlan.getPlanProgramId());
            }
        }
        characteristicSpecificationArrayList.add(characteristicSpecification);
        relatedServicesObj.setCharacteristicSpecification(characteristicSpecificationArrayList);

        relatedServicesObj.setIsRecurring(isEnrollment);
        relatedServicesArrayList.add(relatedServicesObj);


        productObj.setRelatedServices(relatedServicesArrayList);
        orderItemsObj.setProduct(productObj);

        orderItemsObj.setId(Integer.toString(id));
        orderItemsObj.setQuantity("1");

        return orderItemsObj;
    }

}
