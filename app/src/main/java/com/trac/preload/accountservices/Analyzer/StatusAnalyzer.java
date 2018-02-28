package com.trac.preload.accountservices.Analyzer;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.trac.preload.accountservices.BrandConstants;
import com.trac.preload.accountservices.GlobalValues;
import com.trac.preload.accountservices.Services.ValidateDeviceJobIntentService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.memory.LruCacheStringObjectPersister;
import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.LibraryConstants;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;
import com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.GlobalOauthValues;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseStatus;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseValidatedDevice;

import java.util.ArrayList;

/**
 * Created by com.tracfone.preload on 2/2/2018.
 */

public class StatusAnalyzer implements AnalyzerInterface, ValidateDeviceJobIntentService.ValidateDeviceResponseListner {
    protected TracfoneLogger tfLogger;
    boolean mRetry = false;
    private ArrayList<String> mBrandsList;
    private AnalyzerFragment mAnalyzerFragment;
    private String mSerialMin="", mSerialEsn="", mSerialSim="";
    private CacheManager mCacheManager;

    public StatusAnalyzer(AnalyzerFragment mAnalyzerFragment){
        this.mAnalyzerFragment = mAnalyzerFragment;
        this.mAnalyzerFragment.setStatusAnalyzer(this);
        initCacheManager();
    }

    @Override
    public void setBrandParameters(String brand) {
        tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
        Log.v("StatusAnalyzer", "setting Brand params");
        //Fetch current brand constants
        if(GlobalValues.getConstraintMap()==null) {
            Log.v("StatusAnalyzer", "Map null");
            return;
        }
        BrandConstants currBrandConstants = GlobalValues.getConstraintMap().get(brand);
        //Set up values of Oauth parameters
        GlobalOauthValues.setIsTLS12(true);
        GlobalOauthValues.setCLIENT_ID_RO(currBrandConstants.CLIENT_ID_RO1);
        GlobalOauthValues.setCCU_CLIENT_ID(currBrandConstants.CCU_CLIENT_ID);
        GlobalOauthValues.setCLIENT_SECRET_RO(currBrandConstants.CLIENT_SECRET_RO1);

        //Set up values of Oauth2 parameters
        GlobalOauthValues.setCLIENT_ID_RONS(currBrandConstants.CLIENT_ID_RO2);
        GlobalOauthValues.setCLIENT_SECRET_RONS(currBrandConstants.CLIENT_SECRET_RO2);

        //Set up values of Oauth2 parameters
        GlobalOauthValues.setCLIENT_ID_ROLIMITED(currBrandConstants.CLIENT_ID_RO_LIMITED);
        GlobalOauthValues.setCLIENT_SECRET_ROLIMITED(currBrandConstants.CLIENT_SECRET_RO_LIMITED);

        // Set up global library parameters
        GlobalLibraryValues.setClientAppName(currBrandConstants.CLIENT_APP_NAME);
        GlobalLibraryValues.setLibSubBrand(brand);
        // Set brand
        GlobalLibraryValues.setBrand(brand);

    }

    // TODO : Andy will adress this API
    @Override
    public String[] fetchSerialNumber() {
        int size = 2;
        // Please return two Strings { "MIN" ,"xxxxxxxxxx"} OR {"ESN", "xxxxxxxxxxxxx"} OR {"SIM", "xxxxxxxxxxxxxx"}
        return new String[size];
    }

    @Override
    public void makePhoneBrandingRequest(String min, String esn, String sim) {
        mSerialMin = min;
        mSerialEsn = esn;
        mSerialSim = sim;
        setBrandParameters(LibraryConstants.STRAIGHTTALK);
        mBrandsList = new ArrayList<>(GlobalValues.getConstraintMap().keySet());
        if(mBrandsList!=null && !mBrandsList.isEmpty()){
            makeValidateDeviceRequest();
        }
    }

    @Override
    public void makeValidateDeviceRequest() {
        //"7542101794"
        tfLogger.add("ValidateDevice", "performValidateDeviceRequest", "min: " + mSerialMin + " esn: "+ mSerialEsn+ " sim: "+mSerialSim);
        Intent intent = new Intent();
        intent.putExtra(ValidateDeviceJobIntentService.MIN, mSerialMin);
        intent.putExtra(ValidateDeviceJobIntentService.ESN, mSerialEsn);
        intent.putExtra(ValidateDeviceJobIntentService.SIM, mSerialSim);
        ValidateDeviceJobIntentService.enqueueWork(mAnalyzerFragment.getContext(), intent, this, mCacheManager);

    }

    @Override
    public void onRequestFailure(final Exception spiceException, String cacheKey) {
        final Handler mHandler = new Handler(Looper.getMainLooper());
        Log.d("StatusAnalyzer", "onRequestFailure: ");
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                GlobalValues.setValidatedDeviceValid(false);
                tfLogger.add("ValidateDevice", "onRequestFailure", spiceException.toString());
                mAnalyzerFragment.clearDeviceDetails();
                mAnalyzerFragment.setErrorToast("INVALID");
            }
        });
    }

    @Override
    public void onRequestSuccess(final String result, final String cacheKey) {
        Log.d("StatusAnalyzer", "onRequestSucces: ");
        final Handler mHandler = new Handler(Looper.getMainLooper());
        mHandler.post(new Runnable() {
            @Override public void run() {
                onResposeSuccess(result, cacheKey);
            }
        });
    }

    public void onResposeSuccess(String result, String cacheKey) {
            if (result == null) {
                tfLogger.add("ValidateDevice", " performValidateDeviceRequest: onRequestSuccess", "result = null");
                GlobalValues.setValidatedDeviceValid(false);
                return;
            }
            tfLogger.add("ValidateDevice", " performValidateDeviceRequest: onRequestSuccess", "Result = " + result);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            try {
                ResponseValidatedDevice validatedDeviceResponse = mapper.readValue(result, ResponseValidatedDevice.class);
                Log.v("ValidateDevice","Response:::"+ result);
                if (validatedDeviceResponse.getCommon().getResponseType().equals(ResponseStatus.SUCCESS)) {
                    validatedDeviceResponse.validateValidatedDevice();
                    GlobalValues.setValidatedDeviceValid(true);
                    //Save Validated Device
                    GlobalValues.setBrand(validatedDeviceResponse.getResponse().getBrand());
                    Log.v("ValidateDevice","Brand::"+GlobalValues.getBrand());
                    // Set values in activity
                    mAnalyzerFragment.setDeviceDetails(GlobalValues.getBrand(),validatedDeviceResponse.getResponse().getDeviceStatus(), validatedDeviceResponse.getResponse().getLastDayService());
                } else {
                    mBrandsList.remove(0);
                    GlobalValues.setValidatedDeviceValid(false);
                    mCacheManager.removeDataFromCache(String.class, cacheKey);
                    tfLogger.add("ValidateDevice", " performValidateDeviceRequest: onRequestSuccess", "Response Type: " + validatedDeviceResponse.getCommon().getResponseType());
                    if(!mBrandsList.isEmpty()) {
                        setBrandParameters(mBrandsList.get(0));
                        makeValidateDeviceRequest();
                    }else{
                        // Set Error message on activity
                        mAnalyzerFragment.clearDeviceDetails();
                        mAnalyzerFragment.setErrorToast("Not Found");
                    }
                }

            } catch (Exception e) {
                // Do Nothing
                mCacheManager.removeDataFromCache(String.class, cacheKey);
                Log.e("ValidateDevice", e.toString());
                mAnalyzerFragment.clearDeviceDetails();
                mAnalyzerFragment.setErrorToast("INVALID");
            }
    }

    @Override
    public void makePhoneStatusRequest() {

    }

    @Override
    public void initCacheManager() {
        if (mCacheManager == null) {
            mCacheManager = new CacheManager();
            LruCacheStringObjectPersister memoryPersister = new LruCacheStringObjectPersister(500000);
            mCacheManager.addPersister(memoryPersister);
        }
    }
}
