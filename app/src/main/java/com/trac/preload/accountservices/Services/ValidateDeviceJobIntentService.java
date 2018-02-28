package com.trac.preload.accountservices.Services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.JobIntentService;
import android.util.Log;

import com.trac.preload.accountservices.GlobalValues;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.exception.CacheLoadingException;
import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will make Validate Device restful web service request.
 *
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 * Created by tjana on 1/18/2018.
 * ****************************************************************************/
public class ValidateDeviceJobIntentService extends JobIntentService {
    static final int JOB_ID = 100122;
    private static final String TAG = "ValidateDeviceService";
    protected TracfoneLogger tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
    private static ValidateDeviceResponseListner mListner;
    private static CacheManager mCacheManager;
    public static final String MIN = "min";
    public static final String ESN = "esn";
    public static final String SIM = "sim";
    private String mMin;
    private String mESN, mSim;
    private String cacheKey;
    private String result;

    public interface ValidateDeviceResponseListner {
        public void onRequestFailure(Exception spiceException, String cacheKey);

        public void onRequestSuccess(String result, String cacheKey);
    }

    public static void enqueueWork(Context context, Intent work, ValidateDeviceResponseListner listner, CacheManager cacheManager) {
        enqueueWork(context, ValidateDeviceJobIntentService.class, JOB_ID, work);
        mListner = listner;
        Log.d(TAG, "enqueueWork: "+mListner);
        if (mCacheManager == null) {
            mCacheManager = cacheManager;
        }
    }

    @Override
    protected void onHandleWork(Intent intent) {
        // We have received work to do.  The system or framework is already
        // holding a wake lock for us at this point, so we can just go.
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (extras.containsKey(MIN))
                    this.mMin = extras.getString(MIN);
                if (extras.containsKey(ESN))
                    this.mESN = extras.getString(ESN);
                if (extras.containsKey(SIM))
                    this.mSim = extras.getString(SIM);
                cacheKey = RestConstants.VALIDATE_DEVICE;
                if (!mESN.isEmpty()) {
                    cacheKey = cacheKey + mESN;
                } else if(!mMin.isEmpty()){
                    cacheKey = cacheKey + mMin;
                } else{
                    cacheKey = cacheKey + mSim;
                }
                ValidateDeviceSyncRequest request = new ValidateDeviceSyncRequest(mMin, mESN, mSim);
                if (GlobalValues.isValidatedDeviceValid()) {
                    try {
                        if (mCacheManager.isDataInCache(String.class, cacheKey, RestConstants.VALIDATED_DEVICE_CACHE_DURATION)) {
                            result = mCacheManager.loadDataFromCache(String.class, cacheKey, RestConstants.VALIDATED_DEVICE_CACHE_DURATION);
                            if(mListner!=null)
                                mListner.onRequestSuccess(result, cacheKey);
                        } else {
                            loadDataFromNetworkAndSaveInCache(request, true);
                        }
                    } catch (CacheLoadingException e) {
                        e.printStackTrace();
                        loadDataFromNetworkAndSaveInCache(request, true);
                    } catch (CacheCreationException e) {
                        e.printStackTrace();
                        loadDataFromNetworkAndSaveInCache(request, true);
                    }
                } else {
                    loadDataFromNetworkAndSaveInCache(request, false);
                }
            }
        }
    }

    private void loadDataFromNetworkAndSaveInCache(ValidateDeviceSyncRequest request, boolean shouldSaveInCache){
        try {
            result = request.loadDataFromNetwork();
            if (shouldSaveInCache)
                mCacheManager.saveDataToCacheAndReturnData( result, cacheKey);
            Log.d(TAG, "loadDataFromNetworkAndSaveInCache: "+mListner);
            if(mListner!=null)
                mListner.onRequestSuccess(result, cacheKey);
        } catch (final Exception e) {
            e.printStackTrace();
            Log.d(TAG, "loadDataFromNetworkAndSaveInCache:Exception "+mListner);
            if(mListner!=null)
                mListner.onRequestFailure(e, cacheKey);
            mCacheManager.removeDataFromCache(String.class, cacheKey);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //mListner = null;
    }
}