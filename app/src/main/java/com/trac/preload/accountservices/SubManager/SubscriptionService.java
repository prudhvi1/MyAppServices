package com.trac.preload.accountservices.SubManager;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


/**
 * Created by syennamani on 3/19/2018.
 */

public class SubscriptionService extends JobIntentService {
    private static final String TAG = "SubscriptionService";
    SubscriptionManager mSubscriptionManager = null;
    static final int JOB_ID = 100126;
    private static Context mContext;
    private List<SubscriptionInfo> mSubInfoList = null;
    private static Handler mHandler;

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, SubscriptionService.class, JOB_ID, work);
        Log.d(TAG, "enqueueWork: ");
        mContext = context;
        mHandler = new Handler();
    }

    private final SubscriptionManager.OnSubscriptionsChangedListener mOnSubscriptionsChangeListener
            = new SubscriptionManager.OnSubscriptionsChangedListener() {
        @Override
        public void onSubscriptionsChanged() {
            Log.v(TAG,"Subscription Changed");
            // Handle state change here
            printSubscriptionDetails();
        }
    };

    @Override
    public void onDestroy() {
        Log.d(TAG, "Service destroyed");
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        if(mSubscriptionManager == null) {
            mSubscriptionManager = SubscriptionManager.from(mContext);
        }
        printSubscriptionDetails();
        mSubscriptionManager.addOnSubscriptionsChangedListener(mOnSubscriptionsChangeListener);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.v(TAG, "Serviec is running");
            }
        }, 2000);

    }

    private void printSubscriptionDetails(){
        mSubInfoList = mSubscriptionManager.getActiveSubscriptionInfoList();
        for(SubscriptionInfo info: mSubInfoList){
            Log.v(TAG, ""+info.getSubscriptionId()+ "\n"+ info.getNumber()+"\n"+info.getDisplayName()+"\n"+info.getCarrierName());
        }
    }
}
