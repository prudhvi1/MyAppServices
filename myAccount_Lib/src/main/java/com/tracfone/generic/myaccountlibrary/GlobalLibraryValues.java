package com.tracfone.generic.myaccountlibrary;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class contains global values which determine the behavior of the 
* library.  These will normally be set by the application using the library.
* The library will get the values to determine application specific behavior. 
*
*
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2015,  All Rights Reserved
*
*  
* ****************************************************************************/

public class GlobalLibraryValues { 
	
	public static String ENGLISH = "ENG";
	public static String SPANISH = "SPA";

	private static Context appContext;
	 
	private static String libBrand = "";
	private static String libClientAppVersion = "";
	private static String libClientAppName = "";
	private static String libClientAppType = "";
	private static String libLanguage = "";
	private static String libChannelId = "";
	private static String libSubBrand = "";

	//holding Username temporary to populate in Username EditText
	private static String tempUsername = "";

	//MGage phone number flag
	private static String mGagePhoneNumber = null;
	
	//MGage Phone Number Setting
 	public static String getmGagePhoneNumber() {return mGagePhoneNumber;}
	public static void setmGagePhoneNumber(String mGagePhoneNumber) {GlobalLibraryValues.mGagePhoneNumber = mGagePhoneNumber;}

	// The getter and setter for username holder
	public static String getTempUsername() {return tempUsername;}
	public static void setTempUsername(String tempUsername) {GlobalLibraryValues.tempUsername = tempUsername;}

	public static Context getAppContext(){  return appContext; }
	public static void setAppContext(Context c) { appContext = c; }

	public static String getBrand() { return  libBrand; }  
	public static void setBrand(String brand){ libBrand = brand; }
	
	public static String getClientAppVersion() { return libClientAppVersion; }
	public static void setClientAppVersion(String clientAppVersion) { libClientAppVersion = clientAppVersion; }
	
	public static String getClientAppName() { return libClientAppName; }
	public static void setClientAppName(String clientAppName) { libClientAppName = clientAppName; }

	public static String getClientAppType() { return libClientAppType; }
	public static void setClientAppType(String clientAppType) { libClientAppType = clientAppType; }

	public static String getChannelId() { return libChannelId; }
	public static void setChannelId(String channelId) { libChannelId = channelId; }

	public static String getDeviceId() {
		String androidId = Settings.Secure.getString(getAppContext().getContentResolver(), Settings.Secure.ANDROID_ID);
		if (androidId == null  || androidId.isEmpty()) {
			WifiManager wifiManager = (WifiManager) getAppContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
			WifiInfo wInfo = wifiManager.getConnectionInfo();
			androidId = wInfo.getMacAddress();
		}
		return androidId;
	}

	//Check if brand is Straight Talk
	public static boolean isStraightTalk() {
		boolean isStraightTalk = false;
		if (getBrand().equals(LibraryConstants.STRAIGHTTALK)) {
			isStraightTalk = true;
		}
		return isStraightTalk;
	}

	public static String getLibSubBrand() {
		return libSubBrand;
	}

	public static void setLibSubBrand(String libSubBrand) {
		GlobalLibraryValues.libSubBrand = libSubBrand;
	}


	public static String getLanguage() {
		String locale = Locale.getDefault().getDisplayLanguage();
/*		if (locale.equals("es") && GlobalLibraryValues.getBrand().equals(LibraryConstants.TELCEL)) {
			return SPANISH;
		} else {
			return ENGLISH;
		}*/
		if (libLanguage.equals("")) {
			return ENGLISH;
		} else {
			return libLanguage;	
		}
	}
	public static void setLanguage(String language) {libLanguage = language; }
	
	public static String getDeviceModel() {
		String manufacturer = Build.MANUFACTURER;
		String model = Build.MODEL; 
		String manufacturerModel;
		if (model.startsWith(manufacturer)) {
			manufacturerModel = model;
		} else {
			manufacturerModel = manufacturer + "_" + model;
		} 
		//remove unsafe characters
		manufacturerModel = manufacturerModel.replace(" ","_");
		manufacturerModel = manufacturerModel.replace("?", "");
		manufacturerModel = manufacturerModel.replace("/", "");
		manufacturerModel = manufacturerModel.replace(":", "");
		manufacturerModel = manufacturerModel.replace("#", "");
		manufacturerModel = manufacturerModel.replace("&", "");
		manufacturerModel = manufacturerModel.replace("=", "");
		manufacturerModel = manufacturerModel.replace("+", ""); 
		manufacturerModel = manufacturerModel.replace("$", ""); 
		manufacturerModel = manufacturerModel.replace(",", "");
		manufacturerModel = manufacturerModel.replace("%", "");
		manufacturerModel = manufacturerModel.replace("<", "");
		manufacturerModel = manufacturerModel.replace(">", "");
		manufacturerModel = manufacturerModel.replace("/", ""); 
		manufacturerModel = manufacturerModel.replace("'", "");
		manufacturerModel = manufacturerModel.replace("[", "");
		manufacturerModel = manufacturerModel.replace("]", "");
		manufacturerModel = manufacturerModel.replace("(", "");
		manufacturerModel = manufacturerModel.replace(")", "");
		manufacturerModel = manufacturerModel.replace("{", "");
		manufacturerModel = manufacturerModel.replace("}", "");
		try {
			manufacturerModel = URLEncoder.encode(manufacturerModel, "UTF-8");
		} catch (UnsupportedEncodingException e) { 
			manufacturerModel = "unknown";
		}
		//Replace any %s with "" otherwise they will cause problems with string fromat
		manufacturerModel = manufacturerModel.replace("%", "");
		return manufacturerModel; 
	}
	
	public static String getOSVersion() { return "android_" + String.valueOf(android.os.Build.VERSION.SDK_INT); }


}
