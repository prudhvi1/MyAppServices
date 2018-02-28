package com.tracfone.generic.myaccountlibrary.restcommon;

public class RestConstants { 

    //Cache Durations 
	
    public static final Integer VALIDATED_DEVICE_CACHE_DURATION = 600000;   //10 minute
    public static final Integer ACCOUNT_DETAILS_CACHE_DURATION = 600000;   //10 minute
    public static final Integer PAYMENT_SOURCES_CACHE_DURATION = 600000;   //10 minute
    public static final Integer DATA_USAGE_CACHE_DURATION = 1800000;   //1/2 hours
	public static final Integer ILD_BALANCE_CACHE_DURATION = 1800000;   //1/2 hours
	public static final Integer SECURITY_QUESTION_CACHE_DURATION = 3600000;   //1 hours
	public static final Integer BALANCE_INQUIRY_CACHE_DURATION = 900000;   //15 minutes
	public static final Integer PLANS_CACHE_DURATION = 3600000;   //1 hour
	public static final Integer PROTECTION_PLANS_CACHE_DURATION = 3600000; //1 hour
	public static final Integer MANUFACTURER_MODELS_DURATION = 3600000; //1 hour
	public static final Integer DE_ENROLL_REASONS_CACHE_DURATION = 3600000; //1 hour
	public static final Integer OTA_CACHE_DURATION = 900000;   //15 minute
		
	//Cache Keys 
	public static final String VALIDATE_DEVICE = "VALIDATE_DEVICE";
	public static final String ACCOUNT_DETAILS = "ACCOUNT_DETAILS";
	public static final String PAYMENT_SOURCES = "PAYMENT_SOURCES";
	public static final String DATA_USAGE = "DATA_USAGE";
	public static final String ILD_DATA_BALANCE = "ILD_DATA_BALANCE";
	public static final String AVAILABLE_PLANS = "AVAILABLE_PLANS";
	public static final String SECURITY_QUESTIONS = "SECURITY_QUESTIONS";
	public static final String BALANCE_INQUIRY = "BALANCE_INQUIRY";
	public static final String FETCH_BALANCE_INQUIRY = "FETCH_BALANCE_INQUIRY";
	public static final String VAS_PLANS = "VAS_PLANS";
	public static final String PROTECTION_PLANS="PROTECTION_PLANS";
	public static final String MANUFACTURER_MODELS = "MANUFACTURER_MODELS";
	public static final String DE_ENROLL_REASONS= "DE_ENROLL_REASONS";
	public static final String OTA_REQUEST = "OTA_REQUEST";
	
	//Record Limits
	public static final int DEVICE_LIMIT = 200;
	public static final int SECURITY_QUESTION_LIMIT = 5; 
	public static final int TRANSACTION_HISTORY_LIMIT = 100;
	
	//Retry Policy
	public static final boolean NO_RETRY_POLICY = true;

	//Source System for restful services
	public static final String SERVICE_SOURCESYSTEM = "APP";
}
