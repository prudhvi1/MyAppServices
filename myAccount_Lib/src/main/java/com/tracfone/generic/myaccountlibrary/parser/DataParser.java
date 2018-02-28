package com.tracfone.generic.myaccountlibrary.parser;

import android.os.Handler;
import android.os.Looper;

import com.tracfone.generic.myaccountlibrary.DebugConfig;
import com.tracfone.generic.myaccountlibrary.TracfoneLogger;
import com.tracfone.generic.myaccountlibrary.Util;
import com.tracfone.generic.myaccountlibrary.responselistner.ResponseListener;


/**
 * Created by atatipally on 2/23/2016.
 */
public class DataParser {

    private ResponseListener mListener;
    private String mResponse;
    private String cacheKey;
    protected TracfoneLogger tfLogger;
    private Class<?> mResponseClassName;

    public DataParser(ResponseListener listener, String response, Class<?> type,String cacheKey) {
        this.mListener = listener;
        this.mResponse = response;
        this.mResponseClassName = type;
        this.cacheKey = cacheKey;
        tfLogger = new TracfoneLogger(DebugConfig.LOG_FILE);
        doParse();
    }

    public void doParse() {
        try {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    Object parsedObj = null;
                    if (mListener == null) {
                        return;
                    }
                    if (mResponse == null) {
                        sendCallback(parsedObj);
                    }
                    try {
                        parsedObj = Util.fromJson(mResponse, mResponseClassName);
                    } catch (Exception e) {
                        tfLogger.add(getClass().getName(), "doParse Thread", e.toString());
                    }finally {
                        tfLogger.close();
                    }
                    sendCallback(parsedObj);
                }
            });
            t.start();
        }catch (Exception e){
            tfLogger.add(getClass().getName(), "doParse", e.toString());
            tfLogger.close();
        }
        finally {
            tfLogger.close();
        }
    }

    private void sendCallback(final Object obj) {
        Handler h = new Handler(Looper.getMainLooper());
        h.post(new Runnable() {

            @Override
            public void run() {
                mListener.OnNetworkResponse(obj, (obj == null) ? false : true,cacheKey);
            }
        });
    }



}
