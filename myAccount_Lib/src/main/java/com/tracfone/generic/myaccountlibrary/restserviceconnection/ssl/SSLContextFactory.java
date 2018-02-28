package com.tracfone.generic.myaccountlibrary.restserviceconnection.ssl;

import android.util.Base64;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.R;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;

import java.io.*;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * A factory for SSLContexts.
 * Builds an SSLContext with custom KeyStore and TrustStore, to work with a client cert signed by a self-signed CA cert.
 */
public class SSLContextFactory {

    private static SSLContextFactory theInstance = null;
    private TracfoneLogger tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
    private String TAG = getClass().getName();
    private static String TF_S = "techsupportemailid";
    private static String TF_B = "BKS";

    private SSLContextFactory() {
    }

    public static SSLContextFactory getInstance() {
        if(theInstance == null) {
            theInstance = new SSLContextFactory();
        }
        return theInstance;
    }

    /**
     * Creates an SSLContext with the client and server certificates
     * # @param clientCertFile A File containing the client certificate
     * # @param clientCertPassword Password for the client certificate
     * # @param caCertString A String containing the server certificate
     * # @return An initialized SSLContext
     * # @throws Exception
     */
    public SSLContext makeContext() throws Exception {
        final KeyStore keyStore = loadPKCS12KeyStore();
       // final KeyStore keyStore = KeyStore.getInstance(GlobalLibraryValues.getAppContext().getResources().getString(R.string.tf_b));
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("X.509");
        kmf.init(keyStore, TF_S.toCharArray());
        KeyManager[] keyManagers = kmf.getKeyManagers();

        final KeyStore trustStore = loadPEMTrustStore();
        TrustManager[] trustManagers = {new MyCustomTrustManager()};
        
      //  TrustManagerFactory tmf =  TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      //  tmf.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, trustManagers, null);
        tfLogger.add(TAG, "makeContext()", "makeContext - end");
        return sslContext;
    }

    /**
     * Produces a KeyStore from a String containing a PEM certificate (typically, the server's CA certificate)
     * # @param certificateString A String containing the PEM-encoded certificate
     * @return a KeyStore (to be used as a trust store) that contains the certificate
     * @throws Exception
     */
    private KeyStore loadPEMTrustStore() throws Exception {
    	InputStream inStream = null;
    	tfLogger.add(TAG, "loadPEMTrustStore()", "loadPEMTrustStore");
        inStream = GlobalLibraryValues.getAppContext().getResources().openRawResource(R.raw.verisignroot);
        
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(inStream);
        String alias = cert.getSubjectX500Principal().getName();

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null);
        trustStore.setCertificateEntry(alias, cert);
        tfLogger.add(TAG, "loadPEMTrustStore()", "loadPEMTrustStore - end");
        return trustStore;
    }

    /**
     * Produces a KeyStore from a PKCS12 (.p12) certificate file, typically the client certificate
     * # @param certificateFile A file containing the client certificate
     * # @param clientCertPassword Password for the certificate
     * @return A KeyStore containing the certificate from the certificateFile
     * @throws Exception
     */
    private KeyStore loadPKCS12KeyStore() throws Exception {
        KeyStore keyStore = null;
        InputStream fis = null;
        
        try {
            keyStore = KeyStore.getInstance(TF_B);
            fis = GlobalLibraryValues.getAppContext().getResources().openRawResource(R.raw.appkeystore);
            keyStore.load(fis, TF_B.toCharArray());
        } finally {
            try {
                if(fis != null) {
                    fis.close();
                }
            } catch(IOException ex) {
                // ignore
            }
        }
        return keyStore;
    }

    /**
     * Reads and decodes a base-64 encoded DER certificate (a .pem certificate), typically the server's CA cert.
     * @param certificateStream an InputStream from which to read the cert
     * @return a byte[] containing the decoded certificate
     * @throws IOException
     */
    byte[] loadPemCertificate(InputStream certificateStream) throws IOException {

        byte[] der = null;
        BufferedReader br = null;

        try {
            StringBuilder buf = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(certificateStream));

            String line = br.readLine();
            while(line != null) {
                if(!line.startsWith("--")){
                    buf.append(line);
                }
                line = br.readLine();
            }

            String pem = buf.toString();
            der = Base64.decode(pem, Base64.DEFAULT);

        } finally {
           if(br != null) {
               br.close();
           }
        }

        return der;
    }
}