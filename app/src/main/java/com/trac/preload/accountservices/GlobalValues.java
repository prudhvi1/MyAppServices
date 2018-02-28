package com.trac.preload.accountservices;

import android.util.Log;

import java.util.Map;

/**
 * Created by com.tracfone.preload on 2/2/2018.
 */

public class GlobalValues {

    private static boolean validatedDeviceValid;
    private static String brand;

    private static String versionCode;

    private static Map<String, BrandConstants> constraintMap;


    public static boolean isValidatedDeviceValid() {
        return validatedDeviceValid;
    }

    public static void setValidatedDeviceValid(boolean validatedDeviceValid) {
        GlobalValues.validatedDeviceValid = validatedDeviceValid;
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        GlobalValues.brand = brand;
    }

    public static Map<String, BrandConstants> getConstraintMap() {
        return constraintMap;
    }

    public static void setConstraintMap(Map<String, BrandConstants> constraintMap) {
        if(constraintMap!=null){
            Log.v("GLOBAL VALUES","Setting map");
        }
        GlobalValues.constraintMap = constraintMap;
    }


    public static String getVersionCode() {
        return versionCode;
    }

    public static void setVersionCode(String versionCode) {
        GlobalValues.versionCode = versionCode;
    }

}
