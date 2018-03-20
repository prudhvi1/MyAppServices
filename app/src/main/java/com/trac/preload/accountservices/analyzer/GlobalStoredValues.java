package com.trac.preload.accountservices.analyzer;

/**
 * Created by sramprasad on 3/1/2018.
 *  This is the place where all the shared preferences used in the app are declared.
 *  If these need to be migrated to secure preferences, this would be place to accomplish it.
 */
import android.app.Application;
import android.content.SharedPreferences;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;


public class GlobalStoredValues {

    private static SharedPreferences appwidePrefs;

    private static String simMdn = "";
    private static String simSerialNumber ="";
    private static String simGid="";
    private static String esnFromDevice="";
    private static String subBrandName="";
    private static String serviceEndDate="";
    private static String esnFromSub="";
    private static String simFromSub="";
    private static String mdnFromSub="";
    private static String statusFromSub="";
    private static String carrierFromSub="";

    //SharedPreferences constants
    private static final String PREFS_NAME = "SUBSIDY_PRELOAD_PREFS";
    private static final String SIM_MDN = "SIM_MDN";
    private static final String SIM_SERIAL_NUMBER = "SIM_SERIAL_NUMBER";
    private static final String SIM_GID = "SIM_SERIAL_NUMBER_GID";
    private static final String DEVICE_ESN = "DEVICE_ESN_NUMBER";

    private static final String ESN_FROM_SUB = "SUB_ESN";
    private static final String MDN_FROM_SUB = "SUB_MDN";
    private static final String SIM_FROM_SUB = "SUB_SIM";

    private static final String SERVICE_END_DATE = "SERVICE_END_DATE";
    private static final String SUB_BRAND_NAME = "SUB_BRAND_NAME";
    private static final String SUB_MDN = "SUB_MDN";
    private static final String SUB_ESN = "SUB_ESN";
    private static final String SUB_ICCID = "SUB_SIM";
    private static final String STATUS_FROM_SUB = "SUB_STATUS";
    private static final String CARRIER_FROM_SUB = "SUB_CARRIER";

    //Getter and setter for the MDN of the physical device
    public static String getSimMdn() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        simMdn = appwidePrefs.getString(SIM_MDN,"");
        return simMdn;
    }
    public static void setSimMdn(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(SIM_MDN, deviceID);
        editor.commit();
        simMdn = deviceID;
    }

    //Getter and setter for the SIM Serial Number of the physical device
    public static String getSimSerialNumber() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        simSerialNumber = appwidePrefs.getString(SIM_SERIAL_NUMBER,"");
        return simSerialNumber;
    }
    public static void setSimSerialNumber(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(SIM_SERIAL_NUMBER, deviceID);
        editor.commit();
        simSerialNumber = deviceID;
    }

    //Getter and setter for the SIM GID of the physical device
    public static String getSimGid() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        simGid = appwidePrefs.getString(SIM_GID,"");
        return simGid;
    }
    public static void setSimGid(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(SIM_GID, deviceID);
        editor.commit();
        simGid = deviceID;
    }


    //Getter and setter for the DEVICE_ESN of the physical device
    public static String getDeviceEsn() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        esnFromDevice = appwidePrefs.getString(DEVICE_ESN,"");
        return esnFromDevice;
    }
    public static void setDeviceEsn(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(DEVICE_ESN, deviceID);
        editor.commit();
        esnFromDevice = deviceID;
    }

    //Getter and setter for the Brand Name of the Subscription.
    public static String getSubBrandName() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        subBrandName = appwidePrefs.getString(SUB_BRAND_NAME,"");
        return subBrandName;
    }
    public static void setSubBrandName(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(SUB_BRAND_NAME, deviceID);
        editor.commit();
        subBrandName = deviceID;
    }

    //Getter and setter for the Service End Date of the Subscription.
    public static String getServiceEndDate() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        serviceEndDate = appwidePrefs.getString(SERVICE_END_DATE,"");
        return serviceEndDate;
    }
    public static void setServiceEndDate(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(SERVICE_END_DATE, deviceID);
        editor.commit();
        serviceEndDate = deviceID;
    }

    //Getter and setter for the ESN of the Subscription.
    public static String getEsnFromSub() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        esnFromSub = appwidePrefs.getString(ESN_FROM_SUB,"");
        return esnFromSub;
    }
    public static void setEsnFromSub(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(ESN_FROM_SUB, deviceID);
        editor.commit();
        esnFromSub = deviceID;
    }

    //Getter and setter for the SIM of the Subscription.
    public static String getSimFromSub() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        simFromSub = appwidePrefs.getString(SIM_FROM_SUB,"");
        return simFromSub;
    }
    public static void setSimFromSub(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(SIM_FROM_SUB, deviceID);
        editor.commit();
        simFromSub = deviceID;
    }

    //Getter and setter for the SIM of the Subscription.
    public static String getMdnFromSub() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        mdnFromSub = appwidePrefs.getString(MDN_FROM_SUB,"");
        return mdnFromSub;
    }
    public static void setMdnFromSub(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(MDN_FROM_SUB, deviceID);
        editor.commit();
        mdnFromSub = deviceID;
    }

    //Getter and setter for the SIM of the Subscription.
    public static String getStatusFromSub() {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        statusFromSub = appwidePrefs.getString(STATUS_FROM_SUB,"");
        return statusFromSub;
    }
    public static void setStatusFromSub(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(STATUS_FROM_SUB, deviceID);
        editor.commit();
        statusFromSub = deviceID;
    }
// carrierFromSub
//Getter and setter for the Carrier of the Subscription.
    public static String getCarrierFromSub() {
    appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
    carrierFromSub = appwidePrefs.getString(CARRIER_FROM_SUB,"");
    return carrierFromSub;
}
    public static void setCarrierFromSub(String deviceID ) {
        appwidePrefs = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_NAME, Application.MODE_PRIVATE);
        SharedPreferences.Editor editor = appwidePrefs.edit();
        editor.putString(CARRIER_FROM_SUB, deviceID);
        editor.commit();
        carrierFromSub = deviceID;
    }

 }
