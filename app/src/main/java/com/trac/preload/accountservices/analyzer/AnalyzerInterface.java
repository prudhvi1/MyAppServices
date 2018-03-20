package com.trac.preload.accountservices.analyzer;

/**
 * Analyzer Interface
 * Created by com.tracfone.preload on 2/2/2018.
 */

public interface AnalyzerInterface {

    // Set Brand specific parameters here
    void setBrandParameters(String brand);

    // TODO : Andy will adress this API
    // Method to fetch MIN/ESN for the device
    String[] fetchSerialNumber();

    // Method to fetch PhoneBranding info
    void makePhoneBrandingRequest(String min, String esn, String sim);

    // Method to perform validate device
    void makeValidateDeviceRequest();

    // TODO : Andy will adress this API
    // Method to fetch phone status info
    void makePhoneStatusRequest();

    void initCacheManager();

}
