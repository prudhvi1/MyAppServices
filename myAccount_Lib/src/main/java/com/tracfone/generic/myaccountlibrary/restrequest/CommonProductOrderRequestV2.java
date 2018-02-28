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
import com.tracfone.generic.myaccountlibrary.restpojos.RequestProductOrderV2;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseCurrentEnrollmentPlan;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponsePlanList;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAccount;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.BillingAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.CharacteristicSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.CharacteristicSpecification2;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.CreditCard;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Individual;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.LocationEstimate;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.OrderItemsRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PaymentMean;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PaymentPlan;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductOffering;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductPromotions;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductRequest;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ProductSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedOrderItem;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedServices;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by skishore on 10/19/2016.
 */

public class CommonProductOrderRequestV2 extends SpiceRequest<String> {

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
    private boolean isModifyEnrollment;

    public CommonProductOrderRequestV2(String actionType, boolean isModifyEnrollment) {
        super(String.class);
        this.actionType = actionType;
        this.isModifyEnrollment = isModifyEnrollment;
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
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(requestProductOrder);

        String url;
        url = RestfulURL.getUrl(RestfulURL.PRODUCT_ORDER_V2, GlobalLibraryValues.getBrand());
        if (ReleaseFlavorConfig.TEST_MOCKABLE) url = String.format(url, actionType);

        SetupHttpURLConnection execConnection;
        if (isModifyEnrollment) {
            execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "PUT", jsonString, getClass().toString());
        } else {
            execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        }
        String result = execConnection.executeRequest();
        return result;
    }

    public static final String EXTERNAL_ID = "12345667890";

    public CommonProductOrderRequestV2 setExternalID(String externalID) {
        this.externalID = externalID;
        return this;
    }

    public CommonProductOrderRequestV2 setLocation(ArrayList<LocationEstimate> locationEstimateArrayList) {
        this.locationEstimateArrayList = locationEstimateArrayList;
        return this;
    }

    public CommonProductOrderRequestV2 setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
        return this;
    }

    public CommonProductOrderRequestV2 setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public CommonProductOrderRequestV2 setOrderItems(ArrayList<OrderItemsRequest> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public CommonProductOrderRequestV2 setProductPromotions(ArrayList<ProductPromotions> productPromotions) {
        this.productPromotions = productPromotions;
        return this;
    }

    public CommonProductOrderRequestV2 setRelatedParties(ArrayList<RelatedParties> relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public CommonProductOrderRequestV2 setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }


    public static final String TYPE_REDEEM_LINE = "REDEEM_LINE";
    public static final String TYPE_REDEEM_BAN = "REDEEM_BAN";
    public static final String TYPE_ACTIVATE_BAN = "ACTIVATE_BAN";
    public static final String TYPE_ACTIVATE_LINE = "ACTIVATE_LINE";
    public static final String TYPE_REACTIVATE_LINE = "REACTIVATE_LINE";
    public CommonProductOrderRequestV2 setType(String type) {
        this.type = type;
        return this;
    }

    //Common redemption product order Request Builder
    public void requestBuilderforProductOrderRedemption(RedemptionRequestDataHolder redemptionRequestDataHolder) {
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

        BillingAccount billingAccount = new BillingAccount();
        if (redemptionRequestDataHolder.isMultiLineAccount() && !redemptionRequestDataHolder.getBillingAccountId().isEmpty()) {
            billingAccount.setId(redemptionRequestDataHolder.getBillingAccountId());
        }
        PaymentPlan paymentPlan = new PaymentPlan();
        if (actionType.equals(OrderItemsRequest.ACTION_ENROLLMENT)) paymentPlan.setIsRecurring(true);
        PaymentMean paymentMean = new PaymentMean();
        if (redemptionRequestDataHolder.getIsRewardPointsPayment()) {
            // Rewards points to be used for purchase
            paymentMean.setPaymentType(PaymentMean.TYPE_LOYALTYPOINTS);
            paymentPlan.setPaymentMean(paymentMean);
        } else if (redemptionRequestDataHolder.getGuestCreditCard() == null) {
            //A saved CC is to be used for purchase
            paymentMean.setId(redemptionRequestDataHolder.getStoredCreditCard().getCcPaymentSourceId());
            CreditCard creditCard = new CreditCard();
            creditCard.setCvv(redemptionRequestDataHolder.getStoredCreditCardCVV());
            creditCard.setType(redemptionRequestDataHolder.getStoredCreditCard().getCcType());
            paymentMean.setCreditCard(creditCard);
            BillingAddress billingAddress = new BillingAddress();
            billingAddress.setzipcode(redemptionRequestDataHolder.getStoredCreditCard().getCcBillingZipCode());
            paymentMean.setBillingAddress(billingAddress);
            paymentMean.setPaymentType(PaymentMean.TYPE_CREDIT_CARD);
            paymentPlan.setPaymentMean(paymentMean);
        } else {
            //A guest CC is to used for purchase
            paymentPlan.setPaymentMean(redemptionRequestDataHolder.getGuestCreditCard());
        }
        billingAccount.setPaymentPlan(paymentPlan);
        setBillingAccount(billingAccount);

        if (redemptionRequestDataHolder.isMultiLineAccount()) {
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
    }

    public ArrayList<OrderItemsRequest> buildOrderItemsRedemption(RedemptionRequestDataHolder redemptionRequestDataHolder) {
        final int planId = 1;
        final int addOnId = 2;
        ArrayList<OrderItemsRequest> orderItemsArrayList = new ArrayList<>();
        //Please note this method will only work with a single device with one plan and an optional ILD add on.  Other combinations will require
        //additional logic.
        ResponseCurrentEnrollmentPlan.CurrentEnrollmentPlan.ServicePlan enrolledPlan = null;
        Integer relatedOrderItemNumber = null;
        if (redemptionRequestDataHolder.getCurrentEnrollmentPlan() != null) enrolledPlan = redemptionRequestDataHolder.getCurrentEnrollmentPlan().getPlan();
        if(redemptionRequestDataHolder.getSelectedVasPlansList() != null && redemptionRequestDataHolder.getSelectedVasPlansList().get(0) != null) {
            relatedOrderItemNumber = addOnId;
        }
        OrderItemsRequest orderItemsObj = populateOrderItem(planId, redemptionRequestDataHolder, redemptionRequestDataHolder.getSelectedPlan(), enrolledPlan, relatedOrderItemNumber);
        orderItemsArrayList.add(orderItemsObj);
        //Add vas plan is present
        if(redemptionRequestDataHolder.getSelectedVasPlansList() != null && redemptionRequestDataHolder.getSelectedVasPlansList().get(0) != null) {
            OrderItemsRequest orderItemsObj2 = populateOrderItem(addOnId, redemptionRequestDataHolder, redemptionRequestDataHolder.getSelectedVasPlansList().get(0), null, null);
            orderItemsArrayList.add(orderItemsObj2);
        }
        return orderItemsArrayList;
    }

    public ArrayList<OrderItemsRequest> buildOrderItemsMultiLineRedemption(RedemptionRequestDataHolder redemptionRequestDataHolder) {
        ArrayList<OrderItemsRequest> orderItemsArrayList = new ArrayList<>();
        //Please note this method will only work with a multiple devices with NO add ons.  Other combinations will require
        //additional logic.
        for (int orderItemId = 1; orderItemId <= redemptionRequestDataHolder.getOrderItems().size(); orderItemId++) {
            OrderItemsRequest orderItemsObj = populateOrderItem(orderItemId, redemptionRequestDataHolder, redemptionRequestDataHolder.getOrderItems().get(orderItemId-1).getPlan(), null, null);
            orderItemsArrayList.add(orderItemsObj);
        }
        return orderItemsArrayList;
    }

    private OrderItemsRequest populateOrderItem(int id, RedemptionRequestDataHolder redemptionRequestDataHolder, ResponsePlanList.PlanList.Plan plan, ResponseCurrentEnrollmentPlan.CurrentEnrollmentPlan.ServicePlan enrolledPlan, Integer relatedOrderItem) {
        OrderItemsRequest orderItemsObj = new OrderItemsRequest();

        if (redemptionRequestDataHolder.getOrderItems().get(0).getDevice().getDeviceStatus().equals(Device.DEVICE_ACTIVE)) {
            orderItemsObj.setAction(actionType);
        } else {
            orderItemsObj.setAction(OrderItemsRequest.ACTION_REACTIVATION);
        }

        ProductOffering productOfferingObj = new ProductOffering();
        if (plan != null) {
            productOfferingObj.setId(plan.getPlanPartNumber());
            productOfferingObj.setName(plan.getPlanName());
        } else {
            productOfferingObj.setId(enrolledPlan.getPlanPartNumber());
            productOfferingObj.setName(enrolledPlan.getPlanName());
        }
        orderItemsObj.setProductOffering(productOfferingObj);

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
        if (actionType.equals(OrderItemsRequest.ACTION_ENROLLMENT)) {
            characteristicSpecification.setName(CharacteristicSpecification.NAME_RELATED_PROGRAM);
            if (plan != null) {
                characteristicSpecification.setValue(plan.getPlanProgramId());
            } else {
                characteristicSpecification.setValue(enrolledPlan.getPlanProgramId());
            }
        }
        characteristicSpecificationArrayList.add(characteristicSpecification);
        relatedServicesObj.setCharacteristicSpecification(characteristicSpecificationArrayList);
        if (actionType.equals(OrderItemsRequest.ACTION_REDEMPTION)) {
            relatedServicesObj.setIsRedeemNow(redemptionRequestDataHolder.isRedeemNow());
        }
        if (actionType.equals(OrderItemsRequest.ACTION_ENROLLMENT)) {
            relatedServicesObj.setIsEnrollNow(redemptionRequestDataHolder.isEnrollNow());
        }
        if (actionType.equals(OrderItemsRequest.ACTION_ENROLLMENT)) relatedServicesObj.setIsRecurring(true);
        relatedServicesArrayList.add(relatedServicesObj);

        productObj.setRelatedServices(relatedServicesArrayList);
        orderItemsObj.setProduct(productObj);

        if (relatedOrderItem != null) {
            RelatedOrderItem relatedOrderItemObj = new RelatedOrderItem();
            relatedOrderItemObj.setRelationshipType(RelatedOrderItem.RELATIONSHIP_TYPE_RELATEDTO);
            ArrayList<CharacteristicSpecification2> characteristicSpecificationArrayList2 = new ArrayList<>();
            CharacteristicSpecification2 characteristicSpecification2 = new CharacteristicSpecification2();
            characteristicSpecification2.setName(CharacteristicSpecification2.NAME_ORDER_ITEM_ID);
            characteristicSpecification2.setValue(relatedOrderItem);
            characteristicSpecificationArrayList2.add(characteristicSpecification2);
            relatedOrderItemObj.setCharacteristicSpecification(characteristicSpecificationArrayList2);
            orderItemsObj.setRelatedOrderItem(relatedOrderItemObj);
        }

        orderItemsObj.setId(Integer.toString(id));
        orderItemsObj.setQuantity("1");

        return orderItemsObj;
    }

}
