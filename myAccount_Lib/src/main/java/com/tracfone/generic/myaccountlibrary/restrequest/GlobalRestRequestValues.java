package com.tracfone.generic.myaccountlibrary.restrequest;

import android.app.Application;
import android.content.SharedPreferences;

import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;

/**
 * Created by psamdrala on 8/31/2016.
 */
public class GlobalRestRequestValues {
    private static  String SitUrl;
    public static final String SIT_URL="SIT_URL";
    private static SharedPreferences shared;
    public static final String PREFS_URL = "PREFS_REST";





    public static String getSitUrl() {
        SitUrl = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_URL, Application.MODE_PRIVATE).getString(SIT_URL,RestfulURL.SIT_URL_ROOT);
        return SitUrl;
    }

    public static String getProductionUrl() {
        String prodUrl = "apifull.tracfone.com";
        return prodUrl;
    }

    public static void setSitUrl(String sitUrl) {
        shared = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_URL, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(SIT_URL, sitUrl);
        editor.commit();
        SitUrl = sitUrl;


    }



}
