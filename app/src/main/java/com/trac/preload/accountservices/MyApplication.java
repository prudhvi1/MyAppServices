package com.trac.preload.accountservices;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import com.octo.android.robospice.SpiceManager;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.LibraryConstants;
import com.tracfone.generic.myaccountlibrary.restcommon.CachedSpiceService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by com.tracfone.preload on 2/2/2018.
 */

public class MyApplication extends Application {

    private static final int BRAND_COUNT = 6;
    private static MyApplication mInstance;
    private SpiceManager spiceManager = new SpiceManager(CachedSpiceService.class);

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        BrandConstants[] brandConstants = new BrandConstants[BRAND_COUNT];
        brandConstants[0] = new BrandConstants(Parameters.StraighTalk.CLIENT_APP_NAME, Parameters.StraighTalk.CLIENT_ID_RO1,Parameters.StraighTalk.CCU_CLIENT_ID, Parameters.StraighTalk.CCP_CLIENT_ID,Parameters.StraighTalk.CLIENT_SECRET_RO1,Parameters.StraighTalk.CLIENT_ID_RO2,Parameters.StraighTalk.CLIENT_SECRET_RO2,Parameters.StraighTalk.CLIENT_ID_RO_LIMITED,Parameters.StraighTalk.CLIENT_SECRET_RO_LIMITED);
        brandConstants[1] = new BrandConstants(Parameters.Net10.CLIENT_APP_NAME, Parameters.Net10.CLIENT_ID_RO1,Parameters.Net10.CCU_CLIENT_ID, Parameters.Net10.CCP_CLIENT_ID,Parameters.Net10.CLIENT_SECRET_RO1,Parameters.Net10.CLIENT_ID_RO2,Parameters.Net10.CLIENT_SECRET_RO2,Parameters.Net10.CLIENT_ID_RO_LIMITED,Parameters.Net10.CLIENT_SECRET_RO_LIMITED);
        brandConstants[2] = new BrandConstants(Parameters.GoSmart.CLIENT_APP_NAME, Parameters.GoSmart.CLIENT_ID_RO1,Parameters.GoSmart.CCU_CLIENT_ID, Parameters.GoSmart.CCP_CLIENT_ID,Parameters.GoSmart.CLIENT_SECRET_RO1,Parameters.GoSmart.CLIENT_ID_RO2,Parameters.GoSmart.CLIENT_SECRET_RO2,Parameters.GoSmart.CLIENT_ID_RO_LIMITED,Parameters.GoSmart.CLIENT_SECRET_RO_LIMITED);
        brandConstants[3] = new BrandConstants(Parameters.Tracfone.CLIENT_APP_NAME, Parameters.Tracfone.CLIENT_ID_RO1,Parameters.Tracfone.CCU_CLIENT_ID, Parameters.Tracfone.CCP_CLIENT_ID,Parameters.Tracfone.CLIENT_SECRET_RO1,Parameters.Tracfone.CLIENT_ID_RO2,Parameters.Tracfone.CLIENT_SECRET_RO2,Parameters.Tracfone.CLIENT_ID_RO_LIMITED,Parameters.Tracfone.CLIENT_SECRET_RO_LIMITED);
        brandConstants[4] = new BrandConstants(Parameters.TotalWireless.CLIENT_APP_NAME, Parameters.TotalWireless.CLIENT_ID_RO1,Parameters.TotalWireless.CCU_CLIENT_ID, Parameters.TotalWireless.CCP_CLIENT_ID,Parameters.TotalWireless.CLIENT_SECRET_RO1,Parameters.TotalWireless.CLIENT_ID_RO2,Parameters.TotalWireless.CLIENT_SECRET_RO2,Parameters.TotalWireless.CLIENT_ID_RO_LIMITED,Parameters.TotalWireless.CLIENT_SECRET_RO_LIMITED);
        brandConstants[5] = new BrandConstants(Parameters.SimpleMobile.CLIENT_APP_NAME, Parameters.SimpleMobile.CLIENT_ID_RO1,Parameters.SimpleMobile.CCU_CLIENT_ID, Parameters.SimpleMobile.CCP_CLIENT_ID,Parameters.SimpleMobile.CLIENT_SECRET_RO1,Parameters.SimpleMobile.CLIENT_ID_RO2,Parameters.SimpleMobile.CLIENT_SECRET_RO2,Parameters.SimpleMobile.CLIENT_ID_RO_LIMITED,Parameters.SimpleMobile.CLIENT_SECRET_RO_LIMITED);
        // Data Structure to store brand params
        Map<String, BrandConstants> constantsMap = new HashMap<>();
        constantsMap.put(LibraryConstants.STRAIGHTTALK,brandConstants[0]);
        constantsMap.put(LibraryConstants.NET10, brandConstants[1]);
        constantsMap.put(LibraryConstants.GO_SMART,brandConstants[2]);
        constantsMap.put(LibraryConstants.TRACFONE,brandConstants[3]);
        constantsMap.put(LibraryConstants.TOTAL,brandConstants[4]);
        constantsMap.put(LibraryConstants.SIMPLE,brandConstants[5]);
        GlobalValues.setConstraintMap(constantsMap);
        Log.v("MyApplication","Set map");
        if(spiceManager == null)
            Log.v("MyApplication","spicemanager null");
        //set version code
        try {
            GlobalLibraryValues.setClientAppVersion(String.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            GlobalLibraryValues.setClientAppVersion("unknown");
        }
        // Set application context
        GlobalLibraryValues.setAppContext(this);
        // set as Full version
        GlobalLibraryValues.setClientAppType(LibraryConstants.CLIENTAPP_TYPE_FULL);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        spiceManager.shouldStop();
    }

    public void startSpiceManager() {
        if (!spiceManager.isStarted())  spiceManager.start(getApplicationContext());
    }

    public SpiceManager getSpiceManager() {
        return spiceManager;
    }

}
