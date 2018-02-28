package com.tracfone.generic.myaccountlibrary.oauth2serviceconnection;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;

import java.util.Calendar;


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

public class GlobalOauthValues {
    //Shared Preferences Constants
    private static final String PREFS_LIBRARY = "LIBRARY_PREFS";
    private static final String PREFS_KEY_AUTH_TOKEN_RONS = "AUTH_TOKEN_RONS";
    private static final String PREFS_KEY_REFRESH_TOKEN_RONS = "REFRESH_TOKEN_RONS";
    private static final String PREFS_KEY_EXPIRY_RONS = "EXPIRY_RONS";
    private static final String PREFS_KEY_ACCOUNT_ID = "ACCOUNT_ID";


    private static boolean libIsTLS12;
    private static String libAuthTokenCCU = "";
    private static long libExpiryCCU;
    private static String libAuthTokenFB = "";
    private static long libExpiryFB;
    private static String libAuthTokenROorCCP = "";
    private static String libRefreshTokenROorCCP = "";
    private static long libExpiryROorCCP;
    private static String libAuthTokenROLimited = "";
    private static String libRefreshTokenROLimited = "";
    private static long libExpiryROLimited;
    private static boolean libIsROLimitedLogin = false;

    //Oauth Parameters
    private static  String clientIdRO = "";
    private static  String clientIdCCU = "";
    private static  String clientSecretRO = "";
    private static  String clientIdRONS = "";
    private static  String clientSecretRONS = "";
    private static  String clientIdROLimted = "";
    private static  String clientSecretROLimited = "";

    //TLS 1.2 Oauth gateway getter and setter
    public static boolean getIsTLS12() {return libIsTLS12;}
    public static void setIsTLS12(boolean isTLS12) {libIsTLS12 = isTLS12;}

    //The getter and setting for logged in accountID
    public static  String getAccountId() {
        return GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getString(PREFS_KEY_ACCOUNT_ID, "");
   }
    public static void setAccountId(String accountId) {
        SharedPreferences.Editor editor;
        editor = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Context.MODE_PRIVATE).edit();
        editor.putString(PREFS_KEY_ACCOUNT_ID, accountId );
        editor.commit();
    }
    public static void clearAccountId() {
        SharedPreferences.Editor editor;
        editor = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Context.MODE_PRIVATE).edit();
        editor.putString(PREFS_KEY_ACCOUNT_ID, "" );
        editor.commit();
    }
    public static boolean isAccountIdPresent(){
        boolean present = true;
        String libAccountId = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getString(PREFS_KEY_ACCOUNT_ID, "");
        if  (libAccountId == null || libAccountId.isEmpty()) {
            return false;
        }
        return present;
    }

    public static boolean isLoggedIn(){
        return (GlobalOauthValues.isAccountIdPresent());
    }

    public static boolean isLoggedInLimited() {
        return (GlobalOauthValues.isAccountIdPresent() && getIsROLimitedLogin());
    }

    public static void logoff() {
        clearAccountId();
        clearTokenROorCCP();
        clearTokenRONS();
        clearTokenROLimited();
        setIsROLimitedLogin(false);
    }

    public static String getCCU_CLIENT_ID() {return clientIdCCU;}
    public static void setCCU_CLIENT_ID(String cCU_CLIENT_ID) {
        clientIdCCU = cCU_CLIENT_ID;}

    // The getter and setter of ClientID_RONS and ClientSecret_RONS for Oauth2
    public static String getCLIENT_ID_RONS() {return clientIdRONS;}
    public static void setCLIENT_ID_RONS(String cLIENT_ID_RONS) {
        clientIdRONS = cLIENT_ID_RONS;}

    public static String getCLIENT_SECRET_RONS() {return clientSecretRONS;}
    public static void setCLIENT_SECRET_RONS(String cLIENT_SECRET_RONS) {
        clientSecretRONS = cLIENT_SECRET_RONS;}

    // The getter and setter of ClientID_RO_LIMITED and ClientSecret_RO_LIMITED for Oauth2
    public static String getCLIENT_ID_ROLIMITED() {return clientIdROLimted;}
    public static void setCLIENT_ID_ROLIMITED(String cLIENT_ID_ROLIMITED) {clientIdROLimted = cLIENT_ID_ROLIMITED;}

    public static String getCLIENT_SECRET_ROLIMITED() {return clientSecretROLimited;}
    public static void setCLIENT_SECRET_ROLIMITED(String cLIENT_SECRET_ROLIMITED) {clientSecretROLimited = cLIENT_SECRET_ROLIMITED;}

    // The getter and setter of ClientID and ClientSecret for Oauth
    public static String getCLIENT_ID_RO() {return clientIdRO;}
    public static void setCLIENT_ID_RO(String cLIENT_ID) {
        clientIdRO = cLIENT_ID;}

    public static String getCLIENT_SECRET_RO() {return clientSecretRO;}
    public static void setCLIENT_SECRET_RO(String cLIENT_SECRET) {
        clientSecretRO = cLIENT_SECRET;}


    //The getter and setting for logged in OAUTH CCU authToken
    public static String getAuthTokenCCU() {
        if (libAuthTokenCCU == null) {
            return "";
        } else {
            return libAuthTokenCCU; }
    }
    public static void setAuthTokenCCU(String authToken) { libAuthTokenCCU = authToken; }

    public static long getExpiryCCU() { return libExpiryCCU; }
    public static void setExpiryCCU(int expiryInSeconds) {
        Calendar calendar = Calendar.getInstance();
        libExpiryCCU = calendar.getTimeInMillis() + expiryInSeconds*1000;
    }
    public static int remainingExpiryCCU() {
        Calendar calendar = Calendar.getInstance();
        long remainingMs  = libExpiryCCU - calendar.getTimeInMillis();
        int remainingSec = (int)remainingMs/1000;
        if(remainingSec < 0) remainingSec = 0;
        return remainingSec;
    }

    public static void clearTokenCCU() {
        setAuthTokenCCU("");
        Calendar calendar = Calendar.getInstance();
        libExpiryCCU = calendar.getTimeInMillis();
    }

    public static boolean isTokenValidCCU() {
        TracfoneLogger tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
        tfLogger.add("Global Values", "isTokenValidCCU", "CCU Remaining Expiry: " + remainingExpiryCCU() + " Token: " + libAuthTokenCCU);
        tfLogger.close();
        Calendar calendar = Calendar.getInstance();
        if (libAuthTokenCCU == null || libAuthTokenCCU.isEmpty()) {
            return false;
        } else {
            if (calendar.getTimeInMillis() < libExpiryCCU) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isCCUTokenPresent(){
        boolean present = true;
        if  (libAuthTokenCCU == null || libAuthTokenCCU.isEmpty()) {
            return false;
        }
        return present;
    }

    //The getter and setting for logged in OAUTH CCP authToken
    public static String getAuthTokenFB() {
        if (libAuthTokenFB == null) {
            return "";
        } else {
            return libAuthTokenFB; }
    }
    public static void setAuthTokenFB(String authToken) { libAuthTokenFB = authToken; }

    public static long getExpiryFB() {return libExpiryFB; }
    public static void setExpiryFB(int expiryInSeconds) {
        Calendar calendar = Calendar.getInstance();
        libExpiryFB = calendar.getTimeInMillis() + expiryInSeconds * 1000;
    }

    public static void clearTokenFB() {
        setAuthTokenFB("");
        Calendar calendar = Calendar.getInstance();
        libExpiryFB = calendar.getTimeInMillis();
    }

    public static boolean isTokenValidFB() {
        Calendar calendar = Calendar.getInstance();
        if (libAuthTokenFB == null || libAuthTokenFB.isEmpty()) {
            return false;
        } else {
            if (calendar.getTimeInMillis() < libExpiryFB) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isFBTokenPresent(){
        boolean present = true;
        if  (libAuthTokenFB == null || libAuthTokenFB.isEmpty()) {
            return false;
        }
        return present;
    }

    public int remainingExpiryFB() {
        Calendar calendar = Calendar.getInstance();
        long remainingMs  = GlobalOauthValues.libExpiryFB - calendar.getTimeInMillis();
        int remainingSec = (int)remainingMs/1000;
        if(remainingSec < 0) remainingSec = 0;
        return remainingSec;
    }

    //The getter and setting for logged in OAUTH RO or CCP authToken
    public static String getAuthTokenROorCCP() {
        if (libAuthTokenROorCCP == null) {
            return "";
        } else {
            return libAuthTokenROorCCP; }

        }
    public static void setAuthTokenROorCCP(String authToken) { libAuthTokenROorCCP = authToken; }

    public static String getRefreshTokenROorCCP() {
        if (libRefreshTokenROorCCP == null) {
        return "";
    } else {
        return libRefreshTokenROorCCP; }
    }
    public static void setRefreshTokenROorCCP(String refreshToken) {
        libRefreshTokenROorCCP = refreshToken;}

    public static long getExpiryROorCCP() { return libExpiryROorCCP; }
    public static void setExpiryROorCCP(int expiryInSeconds) {
        Calendar calendar = Calendar.getInstance();
        libExpiryROorCCP = calendar.getTimeInMillis() + expiryInSeconds * 1000;
    }
    public static int remainingExpiryROorCCP() {
        Calendar calendar = Calendar.getInstance();
        long remainingMs  = libExpiryROorCCP - calendar.getTimeInMillis();
        int remainingSec = (int)remainingMs/1000;
        if(remainingSec < 0) remainingSec = 0;
        return remainingSec;
    }

    public static void clearTokenROorCCP() {
        setAuthTokenROorCCP("");
        Calendar calendar = Calendar.getInstance();
        libExpiryROorCCP = calendar.getTimeInMillis();
    }

    public static boolean isTokenValidROorCCP() {
        TracfoneLogger tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
        tfLogger.add("Global Values", "isTokenValidROorCCP", "RO Remaining Expiry: " + remainingExpiryROorCCP() + " Token: " + libAuthTokenROorCCP);
        tfLogger.close();
        Calendar calendar = Calendar.getInstance();
        if (libAuthTokenROorCCP == null || libAuthTokenROorCCP.isEmpty()) {
            return false;
        } else {
            if (calendar.getTimeInMillis() < libExpiryROorCCP) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isTokenROorCCPPresent(){
        boolean present = true;
        if  (libAuthTokenROorCCP == null || libAuthTokenROorCCP.isEmpty()) {
            return false;
        }
        return present;
    }

    public static boolean isRefreshTokenROorCCPPresent(){
        boolean present = true;
        if  (libRefreshTokenROorCCP == null || libRefreshTokenROorCCP.isEmpty()) {
            return false;
        }
        return present;
    }

    //The getter and setting for logged in OAUTH RO Limited authToken
    public static String getAuthTokenROLimited() {
        if (libAuthTokenROLimited == null) {
            return "";
        } else {
            return libAuthTokenROLimited; }

    }
    public static void setAuthTokenROLimited(String authToken) { libAuthTokenROLimited = authToken; }

    public static String getRefreshTokenROLimited() {
        if (libRefreshTokenROLimited == null) {
            return "";
        } else {
            return libRefreshTokenROLimited; }
    }
    public static void setRefreshTokenROLimited(String refreshToken) {
        libRefreshTokenROLimited = refreshToken;}

    public static long getExpiryROLimited() { return libExpiryROLimited; }
    public static void setExpiryROLimited(int expiryInSeconds) {
        Calendar calendar = Calendar.getInstance();
        libExpiryROLimited = calendar.getTimeInMillis() + expiryInSeconds * 1000;
    }
    public static int remainingExpiryROLimited() {
        Calendar calendar = Calendar.getInstance();
        long remainingMs  = libExpiryROLimited - calendar.getTimeInMillis();
        int remainingSec = (int)remainingMs/1000;
        if(remainingSec < 0) remainingSec = 0;
        return remainingSec;
    }

    public static void clearTokenROLimited() {
        setAuthTokenROLimited("");
        Calendar calendar = Calendar.getInstance();
        libExpiryROLimited = calendar.getTimeInMillis();
    }

    public static boolean isTokenValidROLimited() {
        TracfoneLogger tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
        tfLogger.add("Global Values", "isTokenValidROLimited", "RO Remaining Expiry: " + remainingExpiryROLimited() + " Token: " + libAuthTokenROLimited);
        tfLogger.close();
        Calendar calendar = Calendar.getInstance();
        if (libAuthTokenROLimited == null || libAuthTokenROLimited.isEmpty()) {
            return false;
        } else {
            if (calendar.getTimeInMillis() < libExpiryROLimited) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isTokenROLimitedPresent(){
        boolean present = true;
        if  (libAuthTokenROLimited == null || libAuthTokenROLimited.isEmpty()) {
            return false;
        }
        return present;
    }

    public static boolean isRefreshTokenROLimitedPresent(){
        boolean present = true;
        if  (libRefreshTokenROLimited == null || libRefreshTokenROLimited.isEmpty()) {
            return false;
        }
        return present;
    }

    public static void setIsROLimitedLogin(boolean isLimitedLogin) {
        libIsROLimitedLogin = isLimitedLogin;
    }

    public static boolean getIsROLimitedLogin() {
        return libIsROLimitedLogin;
    }

    //The getter and setting for logged in OAUTH RONS authToken
    public static void setAuthTokenRONS(String authToken){
        SharedPreferences.Editor editor;
        editor = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Context.MODE_PRIVATE).edit();
        editor.putString(PREFS_KEY_AUTH_TOKEN_RONS, authToken);
        editor.commit();
    }
    public static String getAuthTokenRONS(){
        return GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getString(PREFS_KEY_AUTH_TOKEN_RONS, "");
  }

    public static void setRefreshTokenRONS(String refreshToken){
        SharedPreferences.Editor editor;
        editor = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Context.MODE_PRIVATE).edit();
        editor.putString(PREFS_KEY_REFRESH_TOKEN_RONS,refreshToken);
        editor.commit();
    }
    public static String getRefreshTokenRONS(){
        return GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getString(PREFS_KEY_REFRESH_TOKEN_RONS, "");
    }

    public static void setExpiryRONS(int expiryInSeconds){
        Calendar calendar = Calendar.getInstance();
        long libExpiryRONS= calendar.getTimeInMillis() + expiryInSeconds * 1000;
        SharedPreferences.Editor editor;
        editor = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Context.MODE_PRIVATE).edit();
        editor.putLong(PREFS_KEY_EXPIRY_RONS,libExpiryRONS);
        editor.commit();
    }
    public static long getExpiryRONS(){
        Calendar calendar = Calendar.getInstance();
        return GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getLong(PREFS_KEY_EXPIRY_RONS, calendar.getTimeInMillis());
   }

    public static int remainingExpiryRONS() {
        Calendar calendar = Calendar.getInstance();
        long  libExpiryRONS = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getLong(PREFS_KEY_EXPIRY_RONS, calendar.getTimeInMillis());
        long remainingMs  = libExpiryRONS - calendar.getTimeInMillis();
        int remainingSec = (int)remainingMs/1000;
        if(remainingSec < 0) remainingSec = 0;
        return remainingSec;
    }

    public static void clearTokenRONS() {
        setAuthTokenRONS("");
        SharedPreferences.Editor editor;
        editor = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).edit();
        Calendar calendar = Calendar.getInstance();
        long libExpiryRONS = calendar.getTimeInMillis();
        editor.putLong(PREFS_KEY_EXPIRY_RONS,libExpiryRONS);
        editor.commit();
    }

    public static boolean isTokenValidRONS() {
        String libAuthTokenRONS = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getString(PREFS_KEY_AUTH_TOKEN_RONS, "");
        Calendar calendar = Calendar.getInstance();
        long  libExpiryRONS = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getLong(PREFS_KEY_EXPIRY_RONS, calendar.getTimeInMillis());
        TracfoneLogger tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
        tfLogger.add("Global Values", "isTokenValidRONS", "RONS Remaining Expiry: " + remainingExpiryRONS() + " Token: " + libAuthTokenRONS);
        tfLogger.close();
        if (libAuthTokenRONS == null || libAuthTokenRONS.isEmpty()) {
            return false;
        } else {
            if (calendar.getTimeInMillis() < libExpiryRONS) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isTokenRONSPresent(){
        boolean present = true;
        String libAuthTokenRONS = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getString(PREFS_KEY_AUTH_TOKEN_RONS, "");
        if  (libAuthTokenRONS == null || libAuthTokenRONS.isEmpty()) {
            return false;
        }
        return present;
    }

    public static boolean isRefreshTokenRONSPresent(){
        boolean present = true;
        String libRefreshTokenRONS = GlobalLibraryValues.getAppContext().getSharedPreferences(PREFS_LIBRARY, Application.MODE_PRIVATE).getString(PREFS_KEY_REFRESH_TOKEN_RONS, "");
        if  (libRefreshTokenRONS == null || libRefreshTokenRONS.isEmpty()) {
            return false;
        }
        return present;
    }
}
