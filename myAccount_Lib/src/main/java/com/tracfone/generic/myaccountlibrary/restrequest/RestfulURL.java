package com.tracfone.generic.myaccountlibrary.restrequest;

import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;

/**
 * ************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * The class will specifies the URLS to be used for each of the restful
 * services.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ***************************************************************************
 */

public class RestfulURL {

    //Web Service List
    public static final int VALIDATE_DEVICE = 1;
    public static final int ACCOUNT_DETAILS = 2;
    public static final int PASSWORD_RESET = 3;
    public static final int CREATE_NEW_ACCOUNT = 4;
    public static final int SECURITY_QUESTIONS = 5;
    public static final int CARDS_IN_RESERVE = 7;
    public static final int CARD_TO_TOP = 8;
    public static final int REDEEM_CARD_FROM_RESERVE = 9;
    public static final int AVAILABLE_PLANS = 10;
    public static final int CONFIRM_PURCHASE = 11;
    public static final int ACCOUNT_PROFILE = 12;
    public static final int UPDATE_PROFILE_CONTACT = 13;
    public static final int UPDATE_PROFILE_LOGIN = 14;
    public static final int PAYMENT_SOURCES = 15;
    public static final int ADD_PAYMENT_SOURCE = 16;
    public static final int UPDATE_PAYMENT_SOURCE = 17;
    public static final int DELETE_PAYMENT_SOURCE = 18;
    public static final int TRANSACTION_HISTORY = 19;
    public static final int UPDATE_DEVICE_NICKNAME = 20;
    public static final int UPDATE_GROUP_NICKNAME = 200;
    public static final int DELETE_DEVICE = 21;
    public static final int ENROLL_AUTO_REFILL = 22;
    public static final int SCRIPTS = 24;
    public static final int RETAILERS = 25;
    public static final int DATA_USAGE = 26;
    public static final int UNUSED = 27;
    public static final int CALCULATE_TOTAL_AUTO_REFILL = 271;
    public static final int APP_SUPPORT_VERSION = 28;
    public static final int ADD_DEVICE_TO_ACCOUNT = 29;
    public static final int ACCOUNT_RECOVERY_ACCOUNT_STATUS = 300;
    public static final int ACCOUNT_RECOVERY_CHECK_POINTS = 301;
    public static final int ACCOUNT_RECOVERY_VALIDATE = 302;
    public static final int VALIDATE_PROMOTIONS = 31;
    public static final int CHECK_FACEBOOK_TF_LINK_STATUS = 33;
    public static final int LINK_FACEBOOK_TF_ACCOUNT = 34;
    public static final int GET_BALANCE_INQUIRY = 35;
    public static final int FETCH_BALANCE_INQUIRY = 36;
    public static final int TICKETS_HISTORY = 40;
    public static final int RETENTION_MATRIX = 41;
    public static final int GET_APN_OPERATING_SYSTEMS_SETTINGS_INSTRUCTIONS = 42;
    public static final int GET_VAS_SERVICES= 43;
    public static final int GET_VAS_COUNTER = 44;
    public static final int VAS_COUNTER_INCREMENT = 45;
    public static final int OTA_PENDING = 46;
    public static final int REWARD_DETAILS = 47;
    public static final int VOUCHER_TOKEN = 48;
    public static final int CURRENT_ENROLLMENT_PLAN = 49;
    public static final int DE_ENROLL_PLAN = 50;
    public static final int DIS_ENROLLMENT_REASONS = 51;
    public static final int MARK_DEFAULT_DEVICE = 52;
    public static final int DELETE_DEVICE_GROUPID = 53;
    public static final int SET_PUSH_PREF = 55;
    public static final int SET_PUSH_MESSAGE_STATUS = 56;
    public static final int VALIDATE_ADDRESS = 57;
    public static final int SERVICE_ORDER =58;
    public static final int SERVICE_ORDER_V2 =580;
    public static final int PRODUCT_ORDER =59;
    public static final int PRODUCT_ORDER_V2 =590;
    public static final int SERVICE_QUALIFICATION =60;
    public static final int SERVICE_QUALIFICATION_BYOP =61;
    public static final int SERVICE_PROVIDER_CONFIG =62;
    public static final int PORT_CARRIER_LIST =63;
    public static final int PORT_CARRIER_CONFIG =64;
    public static final int PHONE_REGISTER =65;
    public static final int PHONE_BRANDING =66;
    public static final int BYOP_COVERAGE =67;
    public static final int HANDSET_PROTECTION_AVAILABLE_PROGRAMS = 68;
    public static final int MANUFACTURERS_AND_MODELS = 69;
    public static final int HANDSET_PROTECTION_ENROLLED_PROGRAM = 70;
    public static final int TRANSACTION_HISTORY_V2 = 71;
    public static final int PAYMENT_HISTORY = 72;
    public static final int GUEST_PURCHASE = 73;
    public static final int DELETE_DEVICE_ACTIVATION = 74;
    public static final int RENEWAL_ENQUIRY = 75;
    public static final int PRODUCT_ORDER_ESTIMATE =76;
    public static final int CHECK_POINTS = 77;
    public static final int VERIFICATION_CODE = 78;
    public static final int REWARD_TOKEN_RETRIEVAL = 79;
    public static final int ILD_DATA_BALANCE = 80;
    public static final int SERVICE_DETAILS = 81;


    public static final int OAUTH_TOKEN_RESOURCE_OWNER = 100;
    public static final int OAUTH_TOKEN_CLIENT_CREDENTIALS_UNPROTECTED = 101;


    //Common Key names
    public static final String BRANDNAME = "brandName";
    public static final String CLIENTAPPNAME = "clientAppName";
    public static final String CLIENTAPPVERSION = "clientAppVersion";
    public static final String CLIENTAPPTYPE = "clientAppType";
    public static final String DEVICEMODEL = "deviceModel";
    public static final String OSVERSION = "OSVersion";
    public static final String LANGUAGE = "language";
    public static final String SOURCESYSTEM = "sourceSystem";
    public static final String CHANNELID = "channelId";
    public static final String DEVICEID = "deviceId";
    public static final String SUBBRANDNAME = "subBrandName";

    //Web Service URLs
    public static final String SIT_URL_ROOT = "sitciapifull.tracfone.com";
    private static final String SIT_SYSTEM_URL = "https://%s";
    private static final String PRODUCTION_SYSTEM_URL = "https://api.tracfone.com";
    private static final String PRODUCTION_SYSTEM_TLS12_URL = "https://apifull.tracfone.com";
    private static final String TEST_URL = "https://demo1784988.mockable.io";
    private static final String TEST_URL2 = "https://tracfone.mockable.io";
    private static final String TEST_URL3 = "https://activation.tracfone.mockable.io";
    private static final String TEST_URL4 = "https://usagebalance.tracfone.mockable.io";

    public static String getUrl(int serviceNumber, String Brand) {

        String url = "";

        String serverURL = "";
        String oauthServerURL = "";
        if (ReleaseFlavorConfig.PRODUCTION) {
            if (GlobalOauthValues.getIsTLS12()) {
                serverURL = PRODUCTION_SYSTEM_TLS12_URL + "/pep";
                oauthServerURL = PRODUCTION_SYSTEM_TLS12_URL;
            } else {
                serverURL = PRODUCTION_SYSTEM_URL  + "/pep";
                oauthServerURL = PRODUCTION_SYSTEM_URL;
            }
        } else {
            if (ReleaseFlavorConfig.SIT) {
                serverURL = String.format(SIT_SYSTEM_URL, GlobalRestRequestValues.getSitUrl()) + "/pep";
                oauthServerURL = String.format(SIT_SYSTEM_URL, GlobalRestRequestValues.getSitUrl());
            }
        }

        boolean testURLs;
        if (ReleaseFlavorConfig.TEST_MOCKABLE) {
            testURLs = true;
        } else {
            testURLs = false;
        }

        switch (serviceNumber) {
            case VALIDATE_DEVICE:
                if (testURLs) {
                    url = TEST_URL2 + "/validateUserDevice/v2/%s";
                } else {
                    url = serverURL + "/validateUserDevice/v2/%s?" + getCommonPairs();
                }
                break;
            case ACCOUNT_DETAILS:
                if (testURLs) {
                    url = TEST_URL + "/getAccountDetails/v2/%s";
                } else {
                    url = serverURL + "/getAccountDetails/v2/%s?" + getCommonPairs();
                }
                break;
            case PASSWORD_RESET:
                if (testURLs) {
                    url = TEST_URL + "/forgotPassword/";
                } else {
                    url = serverURL + "/forgotPassword/%s";
                }
                break;
            case CREATE_NEW_ACCOUNT:
                if (testURLs) {
                    url = TEST_URL + "/createNewAccount/%s";
                } else {
                    url = serverURL + "/createNewAccount/%s";
                }
                break;
            case SECURITY_QUESTIONS:
                if (testURLs) {
                    url = TEST_URL + "/getSecurityQuestions/";
                } else {
                    url = serverURL + "/getSecurityQuestions/?" + getCommonPairs();
                }
                break;
            case CARDS_IN_RESERVE:
                if (testURLs) {
                    url = TEST_URL + "/managePINCardReserve/%s";
                } else {
                    url = serverURL + "/managePINCardReserve/%s?" + getCommonPairs();
                }
                break;
            case CARD_TO_TOP:
                if (testURLs) {
                    url = TEST_URL + "/moveReservedPIN/%s/pinCardReserve/%s";
                } else {
                    url = serverURL + "/moveReservedPIN/%s/pinCardReserve/%s";
                }
                break;
            case REDEEM_CARD_FROM_RESERVE:
                if (testURLs) {
                    url = TEST_URL + "/redeemPINCardReserve/v2/%s";
                } else {
                    url = serverURL + "/redeemPINCardReserve/v2/%s";
                }
                break;
            case AVAILABLE_PLANS:
                if (testURLs) {
                    url = TEST_URL2 + "/servicePlanSelector/v2/%s";
                } else {
                    url = serverURL + "/servicePlanSelector/v2/%s?" + getCommonPairs();
                }
                break;
            case CONFIRM_PURCHASE:
                if (testURLs) {
                    url = TEST_URL2 + "/confirmPurchase/v2/partNumber/%s";
                } else {
                    url = serverURL + "/confirmPurchase/v2/partNumber/%s";
                }
                break;
            case ACCOUNT_PROFILE:
                if (testURLs) {
                    url = TEST_URL + "/getAccountProfile/%s";
                } else {
                    url = serverURL + "/getAccountProfile/%s?" + getCommonPairs();
                }
                break;
            case UPDATE_PROFILE_CONTACT:
                if (testURLs) {
                    url = TEST_URL + "/updateAccount/%s/profile/";
                } else {
                    url = serverURL + "/updateAccount/%s/profile/";
                }
                break;
            case UPDATE_PROFILE_LOGIN:
                if (testURLs) {
                    url = TEST_URL + "/updateLoginInformation/%s/profile/";
                } else {
                    url = serverURL + "/updateLoginInformation/%s/profile/";
                }
                break;
            case PAYMENT_SOURCES:
                if (testURLs) {
                    url = TEST_URL + "/getPaymentSource/%s";
                } else {
                    url = serverURL + "/getPaymentSource/%s?" + getCommonPairs();
                }
                break;
            case ADD_PAYMENT_SOURCE:
                if (testURLs) {
                    url = TEST_URL + "/addPaymentSource/%s";
                } else {
                    url = serverURL + "/addPaymentSource/%s";
                }
                break;
            case UPDATE_PAYMENT_SOURCE:
                if (testURLs) {
                    url = TEST_URL + "/updatePaymentSource/%s";
                } else {
                    url = serverURL + "/updatePaymentSource/%s";
                }
                break;
            case DELETE_PAYMENT_SOURCE:
                if (testURLs) {
                    url = TEST_URL + "/deletePaymentSource/%s/paymentSource/%s";
                } else {
                    url = serverURL + "/deletePaymentSource/%s/paymentSource/%s?" + getCommonPairs();
                }
                break;
            case TRANSACTION_HISTORY:
                if (testURLs) {
                    url = TEST_URL + "/getTransactionHistory/%s?offset=50&limit=25";
                } else {
                    url = serverURL + "/getTransactionHistory/%s?offset=0&limit=50&" + getCommonPairs();
                }
                break;
            case TICKETS_HISTORY:
                if (testURLs) {
                    url = TEST_URL + "/getTickets/%s";
                } else {
                    url = serverURL + "/getTickets/%s?" + getCommonPairs();
                }
                break;
            case REWARD_DETAILS:
                if (testURLs) {
                    url = TEST_URL + "/getRewards/min/%s";
                } else {
                    url = serverURL + "/getRewards/min/%s?" + getCommonPairs();
                }
                break;
            case VOUCHER_TOKEN:
                if (testURLs) {
                    url = TEST_URL + "/vouchers/accessToken/";
                } else {
                    url = serverURL + "/vouchers/accessToken/?" + getCommonPairs();
                }
                break;
            case UPDATE_DEVICE_NICKNAME:
                if (testURLs) {
                    url = TEST_URL + "/updateNickName/%s";
                } else {
                    url = serverURL + "/updateNickName/%s";
                }
                break;
            case UPDATE_GROUP_NICKNAME:
                if (testURLs) {
                    url = TEST_URL + "/updateNickName/groupId/%s";
                } else {
                    url = serverURL + "/updateNickName/groupId/%s";
                }
                break;
            case DELETE_DEVICE:
                if (testURLs) {
                    url = TEST_URL + "/customer-mgmt/v1/customeraccount/%s/esn/%s";
                } else {

                    url = serverURL + "/customer-mgmt/v1/customeraccount/%s/esn/%s?" + getCommonPairs();
                }
                break;
            case DELETE_DEVICE_GROUPID:
                if (testURLs) {
                    url = TEST_URL + "/customer-mgmt/v1/customeraccount/%s/group/esn/%s";
                } else {
                    url = serverURL + "/customer-mgmt/v1/customeraccount/%s/group/esn/%s?" + getCommonPairs();
                }
                break;
            case ENROLL_AUTO_REFILL:
                if (testURLs) {
                    url = TEST_URL2 + "/enrollIntoPlan/v2/%s/autoRefill/servicePlan/%s";
                } else {
                    url = serverURL + "/enrollIntoPlan/v2/%s/autoRefill/servicePlan/%s";
                }
                break;
            case SCRIPTS:
                if (testURLs) {
                    url = TEST_URL + "/getScripts/scripts/%s";
                } else {
                    url = serverURL + "/getScripts/scripts/%s?" + getCommonPairs();
                }
                break;
            case RETAILERS:
                if (testURLs) {
                    url = TEST_URL + "/retailer/?searchRadius=5.0&limit=30&origin=";
                } else {
                    url = serverURL + "/retailer/?" + getCommonPairs() + "&radius=5.0&maxMatches=30&origin=";
                }
                break;
            case DATA_USAGE:
                if (testURLs) {
                    url = TEST_URL4 + "/getDataUsage/v2/%s";
                } else {
                    url = serverURL + "/getDataUsage/v2/%s?" + getCommonPairs();
                }
                break;
            case CALCULATE_TOTAL_AUTO_REFILL:
                if (testURLs) {
                    url = TEST_URL + "/calculateEnrollTax/";
                } else {
                    url = serverURL + "/calculateEnrollTax/";
                }
                break;
            case APP_SUPPORT_VERSION:
                if (testURLs) {

                    url = TEST_URL + "/version/";
                } else {
                    url = serverURL + "/version/";
                }
                break;
            case ADD_DEVICE_TO_ACCOUNT:
                if (testURLs) {
                    url = TEST_URL + "/addDeviceToAccount/account/%s";
                } else {
                    url = serverURL + "/addDeviceToAccount/account/%s";
                }
                break;
            case ACCOUNT_RECOVERY_ACCOUNT_STATUS:
                if (testURLs) {
                    url = TEST_URL + "/accountRecovery/accountStatus/%s";
                } else {
                    url = serverURL + "/accountRecovery/accountStatus/%s?" + getCommonPairs();
                }
                break;
            case ACCOUNT_RECOVERY_CHECK_POINTS:
                if (testURLs) {
                    url = TEST_URL + "/accountRecovery/checkpoints/%s";
                } else {
                    url = serverURL + "/accountRecovery/checkpoints/%s";
                }
                break;
            case ACCOUNT_RECOVERY_VALIDATE:
                if (testURLs) {
                    url = TEST_URL + "/accountRecovery/validate/%s";
                } else {
                    url = serverURL + "/accountRecovery/validate/%s";
                }
                break;
            case VALIDATE_PROMOTIONS:
                if (testURLs) {
                    url = TEST_URL + "/validatePromotion/v2/";
                } else {
                    url = serverURL + "/validatePromotion/v2/";
                }
                break;
            case CHECK_FACEBOOK_TF_LINK_STATUS:
                if (testURLs) {
                    url = TEST_URL + "/checkLinkingStatus";
                } else {
                    url = serverURL + "/checkLinkingStatus/?" + getCommonPairs();
                }
                break;
            case LINK_FACEBOOK_TF_ACCOUNT:
                if (testURLs) {
                    url = TEST_URL + "/linkAccount";
                } else {
                    url = serverURL + "/linkAccount/%s?" + getCommonPairs();
                }
                break;
            case GET_BALANCE_INQUIRY:
                if (testURLs) {
                    url = TEST_URL4 + "/getBalanceInquiry/%s";
                } else {
                    url = serverURL + "/getBalanceInquiry/%s?" + getCommonPairs();
                }
                break;
            case FETCH_BALANCE_INQUIRY:
                if (testURLs) {
                    url = TEST_URL4 + "/requestBenefitsBalance/%s/transactionId/%s";
                } else {
                    url = serverURL + "/requestBenefitsBalance/v2/%s/transactionId/%s?" + getCommonPairs();
                }
                break;
            case RETENTION_MATRIX:
                if (testURLs) {
                    url = TEST_URL2 + "/retentionMatrix/%s";
                } else {
                    url = serverURL + "/retentionMatrix/%s";
                }
                break;
            case GET_APN_OPERATING_SYSTEMS_SETTINGS_INSTRUCTIONS:
                if (testURLs) {
                    url = TEST_URL + "/apnSettings/device/%s";
                } else {
                    url = serverURL + "/apnSettings/device/%s";
                }
                break;
            case GET_VAS_SERVICES:
                if (testURLs) {
                    url = TEST_URL + "/getAvailableVasServices/%s";
                } else {
                    url = serverURL + "/getAvailableVasServices/%s?" + getCommonPairs();
                }
                break;
            case GET_VAS_COUNTER:
                if (testURLs) {
                    url = TEST_URL2 + "/getCounterByEvent/%s/event/%s";
                } else {
                    url = serverURL + "/getCounterByEvent/%s/event/%s?" + getCommonPairs();
                }
                break;
            case VAS_COUNTER_INCREMENT:
                if (testURLs) {
                    url = TEST_URL2 + "/incrementCounter/%s";
                } else {
                    url = serverURL + "/incrementCounter/%s";
                }
                break;
            case OTA_PENDING:
                if (testURLs) {
                    url = TEST_URL + "/clearOTA/%s";
                } else {
                    url = serverURL + "/clearOTA/%s?" + getCommonPairs();
                }
                break;
            case CURRENT_ENROLLMENT_PLAN:
                if (testURLs) {
                    url = TEST_URL + "/getEnrolledPlan/%s";
                } else {
                    url = serverURL + "/getEnrolledPlan/%s?" + getCommonPairs();
                }
                break;
            case DE_ENROLL_PLAN:
                if (testURLs) {
                    url = TEST_URL + "/deEnrollFromPlan/%s/program/%s";
                } else {
                    url = serverURL + "/deEnrollFromPlan/%s/program/%s";
                }
                break;
            case DIS_ENROLLMENT_REASONS:
                if (testURLs) {
                    url = TEST_URL + "/disenrollmentReason/";
                } else {
                    url = serverURL + "/disenrollmentReason/?" + getCommonPairs();
                }
                break;

            case HANDSET_PROTECTION_AVAILABLE_PROGRAMS:
                if (testURLs) {
                    url = TEST_URL2 + "/getHandsetProtectionPrograms/min/%s";
                } else {
                    url = serverURL + "/getHandsetProtectionPrograms/min/%s?" + getCommonPairs();
                }
                break;

            case MANUFACTURERS_AND_MODELS:
                if (testURLs) {
                    url = TEST_URL2 + "/getManufacturerModel";
                } else {
                    url = serverURL + "/getManufacturerModel/?" + getCommonPairs();
                }
                break;

            case HANDSET_PROTECTION_ENROLLED_PROGRAM:
                if(testURLs) {
                    url = TEST_URL2 + "/getHPEnrolledProgram/%s";
                } else {
                    url = serverURL + "/getHPEnrolledProgram/%s?" + getCommonPairs();
                }
                break;

            case TRANSACTION_HISTORY_V2:
                if (testURLs) {
                    url = TEST_URL2 + "/getTransactionHistory/v2/esn/%s?offset=50&limit=25";
                } else {
                    url = serverURL + "/getTransactionHistory/v2/esn/%s?offset=50&limit=25&" + getCommonPairs();
                }
                break;

            case PAYMENT_HISTORY:
                if (testURLs) {
                    url = TEST_URL2 + "/getPaymentHistory/account/%s/device/%s?offset=50&limit=25";
                } else {
                    url = serverURL + "/getPaymentHistory/account/%s/device/%s?offset=50&limit=25&" + getCommonPairs();
                }
                break;
            case MARK_DEFAULT_DEVICE:
                if(testURLs){
                    url = TEST_URL3 +"/customer/preferences/defaultdevice/%s";
                }else{
                    url = serverURL +"/customer/preferences/defaultdevice/%s";
                }
                break;
            case SET_PUSH_PREF:
                if(testURLs){
                    url = TEST_URL3 +"/customer/preferences/notification";
                }else{
                    url = serverURL +"/customer/preferences/notification";
                }
                break;
            case SET_PUSH_MESSAGE_STATUS:
                if(testURLs){
                    url = TEST_URL3 +"/customer/notification/status";
                }else{
                    url = serverURL +"/customer/notification/status";
                }
                break;
            case VALIDATE_ADDRESS:
                if(testURLs){
                    url = TEST_URL3 +"/address-mgmt/v1/address/validate";
                }else{
                    url = serverURL +"/address-mgmt/v1/address/validate";
                }
                break;

            case SERVICE_ORDER:
                if(testURLs){
                    url = TEST_URL3 +"/order-mgmt/v1/serviceorder%s";
                }else{
                    url = serverURL +"/order-mgmt/v1/serviceorder";
                }
                break;
            case SERVICE_ORDER_V2:
                if(testURLs){
                    url = TEST_URL3 +"/order-mgmt/v2/serviceorder%s";
                }else{
                    url = serverURL +"/order-mgmt/v2/serviceorder";
                }
                break;
            case PRODUCT_ORDER:
                if(testURLs){
                    url = TEST_URL3 +"/order-mgmt/v1/productorder%s";
                }else{
                    url = serverURL +"/order-mgmt/v1/productorder";
                }
                break;
            case PRODUCT_ORDER_V2:
                if(testURLs){
                    url = TEST_URL3 +"/order-mgmt/v2/productorder%s";
                }else{
                    url = serverURL +"/order-mgmt/v2/productorder";
                }
                break;
            case SERVICE_QUALIFICATION:
                if(testURLs){
                    url = TEST_URL3 +"/service-qualification-mgmt/v1/service-qualification%s";
                }else{
                    url = serverURL +"/service-qualification-mgmt/v1/service-qualification";
                }
                break;
            case SERVICE_QUALIFICATION_BYOP:
                if(testURLs){
                    url = TEST_URL3 +"/service-qualification-mgmt/v1/service-qualification/productSerialNumber/%s%s/carrier/%s";
                }else{
                    url = serverURL +"/service-qualification-mgmt/v1/service-qualification/productSerialNumber/%s%s/carrier/%s?" + getCommonPairs();
                }
                break;
            case SERVICE_PROVIDER_CONFIG:
                if(testURLs){
                    url = TEST_URL3 +"/config-mgmt/v1/config/category/SERVICE_PROVIDERS";
                }else{
                    url = serverURL +"/config-mgmt/v1/config/category/SERVICE_PROVIDERS?" + getCommonPairs();
                }
                break;
            case PORT_CARRIER_LIST:
                if(testURLs){
                    url = TEST_URL3 +"/config-mgmt/v1/config/category/PORT_CARRIERS";
                }else{
                    url = serverURL +"/config-mgmt/v1/config/category/PORT_CARRIERS?" + getCommonPairs();
                }
                break;
            case PORT_CARRIER_CONFIG:
                if(testURLs){
                    url = TEST_URL3 +"/config-mgmt/v1/config/category/PORT_CARRIERS/name/carrier/value/%s/type/%s";
                }else{
                    url = serverURL +"/config-mgmt/v1/config/category/PORT_CARRIERS/name/carrier/value/%s/type/%s?" + getCommonPairs();
                }
                break;
            case PHONE_REGISTER:
                if(testURLs){
                    url = TEST_URL3 +"/inventory-mgmt/v1/resource-inventory/resource";
                }else{
                    url = serverURL +"/inventory-mgmt/v1/resource-inventory/resource";
                }
                break;
            case PHONE_BRANDING:
                if(testURLs){
                    url = TEST_URL3 +"/inventory-mgmt/v1/resource-inventory/resource";
                }else{
                    url = serverURL +"/inventory-mgmt/v1/resource-inventory/resource";
                }
                break;
            case BYOP_COVERAGE:
                if(testURLs){
                    url = TEST_URL3 +"/order-mgmt/v1/serviceorder/service-availibility/zipcode/%s/deviceType/%s/%s";
                }else{
                    url = serverURL +"/order-mgmt/v1/serviceorder/service-availibility/zipcode/%s/deviceType/%s/%s?" + getCommonPairs();
                }
                break;

            case OAUTH_TOKEN_RESOURCE_OWNER:
                if (testURLs) {
                    url = TEST_URL2 + "/oauth/ro";
                } else {
                    url = oauthServerURL + "/oauth/ro";
                }

                break;

            case OAUTH_TOKEN_CLIENT_CREDENTIALS_UNPROTECTED:
                if (testURLs) {
                    url = TEST_URL2 + "/oauth/cc";
                } else {
                    url = oauthServerURL + "/oauth/cc";
                }
                break;

            case GUEST_PURCHASE:
                if(testURLs) {
                    url = TEST_URL3 + "/order-mgmt/v1/productorder/esn/%s";
                }else{
                    url = serverURL + "/order-mgmt/v1/productorder/esn/%s";
                }
                break;

            case DELETE_DEVICE_ACTIVATION:
                if (testURLs) {
                    url = TEST_URL3 + "/customer-mgmt/v2/customeraccount/%s/esn/%s";
                } else {

                    url = serverURL + "/customer-mgmt/v2/customeraccount/%s/esn/%s?" + getCommonPairs();
                }
                break;

            case RENEWAL_ENQUIRY:
                if(testURLs){
                    url = TEST_URL3 +"/billing-mgmt/v1/billing-account/balance?";
                }else{
                    url = serverURL +"/billing-mgmt/v1/billing-account/balance?" + getCommonPairs();
                }
                break;
            case PRODUCT_ORDER_ESTIMATE:
                if(testURLs){
                    url = TEST_URL3 +"/order-mgmt/v1/productorder/estimate%s";
                }else{
                    url = serverURL +"/order-mgmt/v1/productorder/estimate";
                }
                break;
            case CHECK_POINTS:
                if (testURLs) {
                    url = TEST_URL2 +"/resource-mgmt/v1/resource/checkpoints?resourceCategory=LINE&serialNumber=%s";
                }else{
                    url = serverURL +"/resource-mgmt/v1/resource/checkpoints?resourceCategory=LINE&serialNumber=%s&" + getCommonPairs();
                }
                break;
            case VERIFICATION_CODE:
                if (testURLs) {
                    url = TEST_URL2 +"/resource-mgmt/v1/resource/verification-code%s";
                }else{
                    url = serverURL +"/resource-mgmt/v1/resource/verification-code%s?";
                }
                break;
            case REWARD_TOKEN_RETRIEVAL:
                if(testURLs) {
                    url = TEST_URL2 +"/token?brandName=STRAIGHT_TALK&customerID=%s&language=ENG&partner=AUGEO&sourceSystem=APP&token_type=oauth";
                } else {
                    url = serverURL +"/token?brandName=STRAIGHT_TALK&customerID=%s&language=ENG&partner=AUGEO&sourceSystem=APP&token_type=oauth";
                }
                break;
            case ILD_DATA_BALANCE:
                if(testURLs) {
                    url = TEST_URL4 +"/getDataUsage/v2/%s?type=ILD";
                } else {
                    url = serverURL +"/getDataUsage/v2/%s?type=ILD&" + getCommonPairs();;
                }
                break;
            case SERVICE_DETAILS:
                if(testURLs) {
                    url = TEST_URL2 +"/service-mgmt/v1/services?productSerialNumber=%s&productCategory=%s";
                } else {
                    url = serverURL +"/service-mgmt/v1/services?productSerialNumber=%s&productCategory=%s&" + getCommonPairs();
                }
                break;
        }

        return url;
    }

    public static String getCommonPairs() {
        String commonPairs = BRANDNAME + "=" + GlobalLibraryValues.getBrand();
        commonPairs = commonPairs + "&" + CLIENTAPPNAME + "=" + GlobalLibraryValues.getClientAppName();
        commonPairs = commonPairs + "&" + CLIENTAPPVERSION + "=" + GlobalLibraryValues.getClientAppVersion();
        commonPairs = commonPairs + "&" + CLIENTAPPTYPE + "=" + GlobalLibraryValues.getClientAppType();
        commonPairs = commonPairs + "&" + DEVICEMODEL + "=" + GlobalLibraryValues.getDeviceModel();
        commonPairs = commonPairs + "&" + OSVERSION + "=" + GlobalLibraryValues.getOSVersion();
        commonPairs = commonPairs + "&" + LANGUAGE + "=" + GlobalLibraryValues.getLanguage();
        commonPairs = commonPairs + "&" + SOURCESYSTEM + "=" + RestConstants.SERVICE_SOURCESYSTEM;
        commonPairs = commonPairs + "&" + CHANNELID + "=" + GlobalLibraryValues.getChannelId();
        commonPairs = commonPairs + "&" + DEVICEID + "=" + GlobalLibraryValues.getDeviceId();
        commonPairs = commonPairs + "&" + SUBBRANDNAME + "=" + GlobalLibraryValues.getLibSubBrand();
        return commonPairs;
    }
}
