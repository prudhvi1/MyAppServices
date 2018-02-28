package com.tracfone.generic.myaccountlibrary;

public class ReleaseFlavorConfig {

	// These flags will switch the between the mockable, SIT development, TST development and Production service URLs.
	// Mockable URLs      - SIT = false   PRODUCTION = false  TEST_MOCKABLE = true
	// SIT URLs           - SIT = true    PRODUCTION = false  TEST_MOCKABLE = false
	// PRODUCTION URLS    - SIT = dnc     PRODUCTION = true   TEST_MOCKABLE = dnc
	public static final boolean TEST_MOCKABLE = false;
	public static final boolean SIT = false;
	public static final boolean PRODUCTION = true;

	// This flag will switch the between insecure server connection and a secure connection.
	// This flag should be TRUE for released versions. 
	public static final boolean PRODUCTION_SSL = true;

	// This flag when TRUE, would imply it is being signed for the PLAY store, and it has PRODUCTION_SSL, and no logging enabled.
	// Default value is to be set as false.
	// This flag should be TRUE for fielded release versions.
	public static final boolean RELEASE_BUILD = true;

}
