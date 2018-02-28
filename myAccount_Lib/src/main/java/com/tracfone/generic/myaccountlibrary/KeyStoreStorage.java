package com.tracfone.generic.myaccountlibrary;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.x500.X500Principal;

/**
 * Created by atatipally on 4/5/2016.
 */
public class KeyStoreStorage {
    private  static String aliasKey = "MyACCOUNT_STORAGE_KEY";
    private static  KeyStore keyStore;
    protected static TracfoneLogger tfLogger;

    /**
     * Creates a symmetric key in the Android Key Store which can be used to store or retrive data
     * @param context Activity context
     */
    public static void createKeyforStorage(Context context){
        try{
            tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            // Create the keys if necessary
            if (!keyStore.containsAlias(aliasKey)) {
                if(android.os.Build.VERSION.SDK_INT >= 23) {
                    KeyGenParameterSpec spec =  new KeyGenParameterSpec.Builder(
                            aliasKey,
                            KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                            .setCertificateSubject(new X500Principal("CN=test"))
                            .setCertificateSerialNumber(BigInteger.ONE)
                            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)

                            .build();

                    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    generator.initialize(spec);
                    KeyPair keyPair = generator.generateKeyPair();

                }
            }

        } catch (NoSuchAlgorithmException e) {
            tfLogger.add("KeyStoreStorage", "NoSuchAlgorithmException", e.toString());
        } catch (NoSuchProviderException e) {
            tfLogger.add("KeyStoreStorage", "NoSuchProviderException", e.toString());
        } catch (InvalidAlgorithmParameterException e) {
            tfLogger.add("KeyStoreStorage", "InvalidAlgorithmParameterException", e.toString());
        } catch (KeyStoreException e) {
            tfLogger.add("KeyStoreStorage", "KeyStoreException", e.toString());
        } catch (CertificateException e) {
            tfLogger.add("KeyStoreStorage", "CertificateException", e.toString());
        } catch (IOException e) {
            tfLogger.add("KeyStoreStorage", "IOException", e.toString());
        }  catch (UnsupportedOperationException e) {
            tfLogger.add("KeyStoreStorage", "UnsupportedOperationException", e.toString());
        }finally {
            tfLogger.close();
        }
    }

    /**
     *encrypts the data and stores it with the keystore key
     * @param context Activity context
     * @param textToencrypt value to encrypt
     */
    public static void storeData(Context context,String textToencrypt){

        try{
            tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(aliasKey, null);
            RSAPublicKey publicKey = (RSAPublicKey) privateKeyEntry.getCertificate().getPublicKey();
            String filesDirectory = context.getFilesDir().getAbsolutePath();
            String encryptedDataFilePath = filesDirectory + File.separator + "my_account_secrets";

            Cipher inCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
            inCipher.init(Cipher.ENCRYPT_MODE, publicKey);

            CipherOutputStream cipherOutputStream =
                    new CipherOutputStream(
                            new FileOutputStream(encryptedDataFilePath), inCipher);
            cipherOutputStream.write(textToencrypt.getBytes("UTF-8"));
            cipherOutputStream.close();

        } catch (NoSuchAlgorithmException e) {
            tfLogger.add("KeyStoreStorage", "NoSuchAlgorithmException", e.toString());
        } catch (NoSuchProviderException e) {
            tfLogger.add("KeyStoreStorage", "NoSuchProviderException", e.toString());
        }  catch (KeyStoreException e) {
            tfLogger.add("KeyStoreStorage", "KeyStoreException", e.toString());
        }catch (IOException e) {
            tfLogger.add("KeyStoreStorage", "IOException", e.toString());
        } catch (UnrecoverableEntryException e) {
            tfLogger.add("KeyStoreStorage", "UnrecoverableEntryException", e.toString());
        } catch (NoSuchPaddingException e) {
            tfLogger.add("KeyStoreStorage", "NoSuchPaddingException", e.toString());
        } catch (InvalidKeyException e) {
            tfLogger.add("KeyStoreStorage", "InvalidKeyException", e.toString());
        } catch (UnsupportedOperationException e) {
            tfLogger.add("KeyStoreStorage", "UnsupportedOperationException", e.toString());
        }catch (CertificateException e) {
            tfLogger.add("KeyStoreStorage", "CertificateException", e.toString());
        }finally {
            tfLogger.close();
        }
    }

    /**
     * decrypts the data with the keystore key and returns the decrypted string
     * @param context Activity context
     * @return  decrypted string
     */
    public static String retrieveData(Context context){
        try {
            tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(aliasKey, null);
            Cipher outCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            outCipher.init(Cipher.DECRYPT_MODE, privateKeyEntry.getPrivateKey());

            String filesDirectory = context.getFilesDir().getAbsolutePath();
            String encryptedDataFilePath = filesDirectory + File.separator + "my_account_secrets";

            CipherInputStream cipherInputStream =
                    new CipherInputStream(new FileInputStream(encryptedDataFilePath),
                            outCipher);
            byte[] roundTrippedBytes = new byte[1000];

            int index = 0;
            int nextByte;
            while ((nextByte = cipherInputStream.read()) != -1) {
                roundTrippedBytes[index] = (byte) nextByte;
                index++;
            }
            String decryptedstring = new String(roundTrippedBytes, 0, index, "UTF-8");
            cipherInputStream.close();

            return decryptedstring;

        }  catch (NoSuchAlgorithmException e) {
            tfLogger.add("KeyStoreStorage", "NoSuchAlgorithmException", e.toString());
        } catch (KeyStoreException e) {
            tfLogger.add("KeyStoreStorage", "KeyStoreException", e.toString());
        }  catch (UnrecoverableEntryException e) {
            tfLogger.add("KeyStoreStorage", "UnrecoverableEntryException", e.toString());
        } catch (NoSuchPaddingException e) {
            tfLogger.add("KeyStoreStorage", "NoSuchPaddingException", e.toString());
        } catch (InvalidKeyException e) {
            tfLogger.add("KeyStoreStorage", "InvalidKeyException", e.toString());
        } catch (UnsupportedOperationException e) {
            tfLogger.add("KeyStoreStorage", "UnsupportedOperationException", e.toString());
        }catch (IOException e) {
            tfLogger.add("KeyStoreStorage", "IOException", e.toString());
        }catch (CertificateException e) {
            tfLogger.add("KeyStoreStorage", "CertificateException", e.toString());
        }finally {
            tfLogger.close();
        }
        return null;
    }

}
