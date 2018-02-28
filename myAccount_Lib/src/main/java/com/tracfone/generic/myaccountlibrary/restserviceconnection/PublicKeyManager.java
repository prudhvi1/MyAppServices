package com.tracfone.generic.myaccountlibrary.restserviceconnection;

import java.math.BigInteger;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;  

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager; 

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:
 * This Public key manager is used to Pin the device certificates for 
 * security purposes. 
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ****************************************************************************/

public final class PublicKeyManager implements X509TrustManager
{
	public static String keyExpirationDate = "2015-06-21";  //yyyy-MM-dd
	
	private static String PUB_KEY_CURRENT = " ";
	
	private static String PUB_KEY_NEXT = " ";
	
	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
	{
		if (chain == null) {
			throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
		}

		if (!(chain.length > 0)) {
			throw new IllegalArgumentException("checkServerTrusted: X509Certificate is empty");
		}

		if (!(null != authType && authType.equalsIgnoreCase("RSA"))) {
			throw new CertificateException("checkServerTrusted: AuthType is not RSA");
		}

		// Perform customary SSL/TLS checks
		try {
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
			tmf.init((KeyStore) null);

			for (TrustManager trustManager : tmf.getTrustManagers()) {
				((X509TrustManager) trustManager).checkServerTrusted(chain, authType);
			}
		} catch (Exception e) {
			throw new CertificateException(e);
		}

		// Hack ahead: BigInteger and toString(). We know a DER encoded Public Key begins
		// with 0x30 (ASN.1 SEQUENCE and CONSTRUCTED), so there is no leading 0x00 to drop.
		RSAPublicKey pubkey = (RSAPublicKey) chain[0].getPublicKey();
		String encoded = new BigInteger(1 /* positive */, pubkey.getEncoded()).toString(16);

		// Pin it!
		final boolean currentValid = PUB_KEY_CURRENT.equalsIgnoreCase(encoded);
		final boolean nextValid = PUB_KEY_NEXT.equalsIgnoreCase(encoded);
		if (!currentValid && !nextValid) {
			throw new CertificateException("Certificate Pinning Failure");
		}
	}

	@Override
	public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
			String authType) throws java.security.cert.CertificateException {
		// Unsupported
		
	} 

	@Override
	public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		// Unsupported
		return null;
	}
}