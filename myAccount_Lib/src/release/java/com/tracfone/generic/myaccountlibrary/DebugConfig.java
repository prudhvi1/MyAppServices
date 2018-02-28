package com.tracfone.generic.myaccountlibrary;

public class DebugConfig {

    //DEBUG Enable.  Primarily used enable general purpose logging
    // This flag should be FALSE for released versions.
    public static final boolean DEBUG = false;

    //DEBUG Enable_LOGGER.  Primarily used to enable TFLOGGER logging
    // This flag should be FALSE for released versions.
    public static final boolean DEBUG_LOGGER = false;

    //DEBUG Enable.  Primarily used to enable Robospice logging
    // This flag should be FALSE for released versions.
    public static final boolean DEBUG_ROBOSPICE = false;

    //Used to enable Tealeaf logging
    // For TeaLeaf to be enabled, turn the following flag to be true.
    // If TeaLeaf needs to be disabled, turn the following flag to be false.
    public static final boolean TEALEAF_LOGGER = false;

    //Used to enable a check for presence of play services on launch
    // This flag should be TRUE for released versions.
    // To run on an emulator set to FALSE (you may experience crashes if service calls are attempted)
    public static final boolean CHECK_PLAY_SERVICES = true;

    public static final boolean CRASHLYTICS = true;


    public static final String LOG_FILE = "MyAccount.txt";
}
