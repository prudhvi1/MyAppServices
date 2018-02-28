package com.tracfone.generic.myaccountlibrary.restserviceconnection.ssl;

import javax.net.ssl.X509TrustManager;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;

import java.security.cert.*;
import java.util.*;

/**
 * A custom X509TrustManager implementation that trusts a specified server certificate in addition
 * to those that are in the system TrustStore.
 * Also handles an out-of-order certificate chain, as is often produced by Apache's mod_ssl
 */
public class MyCustomTrustManager implements X509TrustManager {
	//
	//	private final X509TrustManager originalX509TrustManager;
	//	private final KeyStore trustStore;

//	private TracfoneLogger tfLogger = new TracfoneLogger(ReleaseFlavorConfig.LOG_FILE);
//	private String TAG = getClass().getName();
	private X509TrustManager parent; 


	//	SSLContext sslContext = SSLContext.getInstance("TLS");
	//
	//	/**
	//	 * @param trustStore A KeyStore containing the server certificate that should be trusted
	//	 * @throws NoSuchAlgorithmException
	//	 * @throws KeyStoreException
	//	 */
	//	public MyCustomTrustManager(KeyStore trustStore) throws NoSuchAlgorithmException, KeyStoreException {
	//		this.trustStore = trustStore;
	//
	//		TrustManagerFactory originalTrustManagerFactory = TrustManagerFactory.getInstance("X.509");
	//		originalTrustManagerFactory.init((KeyStore) null);
	//		// 
	//		TrustManager[] originalTrustManagers = originalTrustManagerFactory.getTrustManagers();
	//		originalX509TrustManager = (X509TrustManager) originalTrustManagers[0];
	//	}

	/**
	 * No-op. Never invoked by client, only used in server-side implementations
	 * @return
	 */
	public X509Certificate[] getAcceptedIssuers() {
		return (this.parent.getAcceptedIssuers());
	}

	/**
	 * No-op. Never invoked by client, only used in server-side implementations
	 * @return
	 */
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		this.parent.checkClientTrusted(chain, authType);

	}


	/**
	 * Given the partial or complete certificate chain provided by the peer,
	 * build a certificate path to a trusted root and return if it can be validated and is trusted
	 * for client SSL authentication based on the authentication type. The authentication type is
	 * determined by the actual certificate used. For instance, if RSAPublicKey is used, the authType should be "RSA".
	 * Checking is case-sensitive.
	 * Defers to the default trust manager first, checks the cert supplied in the ctor if that fails.
	 * @param chain the server's certificate chain
	 * @param authType the authentication type based on the client certificate
	 * @throws java.security.cert.CertificateException
	 */
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

		Locale locale1 = new Locale("en", "US");
		Locale.setDefault(locale1);

		if (chain == null)
		{
			//tfLogger.add(TAG, " checkServerTrusted: ", "chain is null " );
			throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
		}

		if (!(chain.length > 0)) 
		{
			//tfLogger.add(TAG, " checkServerTrusted: ", "chain length is not bigger than 0 " );
			throw new IllegalArgumentException("checkServerTrusted: X509Certificate is empty");
		}
		if (!(null != authType && authType.equalsIgnoreCase("RSA"))) 
		{
			//tfLogger.add(TAG, " checkServerTrusted: ", "authType is not equal RSA " );
			throw new CertificateException("checkServerTrusted: AuthType is not RSA");
		}
		if (chain != null)
		{	
			int count = 0;
			for(X509Certificate cert : chain)
			{
				if(cert != null)
				{
				    String subject = cert.getSubjectDN().getName().toLowerCase();
				    String issuer = cert.getIssuerDN().getName().toLowerCase();

				 /*   if ((!issuer.contains("=verisign")) && (!issuer.contains("=symantec"))){
					    throw new CertificateException();
				    }

				    if(ReleaseFlavorConfig.PRODUCTION)
					{
					    if ((!subject.contains("cn=api.tracfone.com")) && (!subject.contains("cn=verisign")) && (!subject.contains("cn=symantec"))) {
						throw new CertificateException();
					}
				}
				else
				{
					if(ReleaseFlavorConfig.SIT)
					{
						// This will check for the hostname being tracfone.com only.
						if ((!subject.contains("tracfone.com")) && (!subject.contains("cn=verisign")) && (!subject.contains("cn=symantec")))
						{
							throw new CertificateException();
						}
					}
				} */
				count++;
				}
			}
			
			if(count != 3){
				throw new CertificateException();
			}
		}

	}

	/**
	 * This method will search for a hostname match within the alternative names in the certificate
	 * @param hostname name of hostname to be matched
	 * @param cert  certificate to be searched for name match
	 * @return matchFound  true is issurer match found
	 */
	private boolean isAlternativeNameMatch(String hostname, X509Certificate cert)  throws CertificateException {
		boolean matchFound = false;
		if (cert != null) {
			Collection<List<?>> alternativeNames = cert.getSubjectAlternativeNames();
			if (alternativeNames != null) {
				Iterator it = alternativeNames.iterator();
				while (it.hasNext()) {
					List list = (List) it.next();
					int type = ((Integer) list.get(0)).intValue();
					// If type is 2, then we've got a dNSName
					if (type == 2) {
						String s = (String) list.get(1);
						s = s.toLowerCase();
						if (s.equals(hostname)) {
							matchFound = true;
							break;
						}
					}
				}
			}
		}
		return matchFound;
	}
}