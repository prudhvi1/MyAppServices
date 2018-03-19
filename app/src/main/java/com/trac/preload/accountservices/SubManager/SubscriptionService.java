package com.trac.preload.accountservices.SubManager;

import android.content.Context;
import android.content.Intent;
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
    static SubscriptionManager mSubscriptionManager = null;
    static final int JOB_ID = 100126;
    private static List<SubscriptionInfo> mSubInfoList = null;

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, SubscriptionService.class, JOB_ID, work);
        Log.d(TAG, "enqueueWork: ");
        if(mSubscriptionManager == null) {
            mSubscriptionManager = SubscriptionManager.from(context);
            mSubscriptionManager.addOnSubscriptionsChangedListener(mOnSubscriptionsChangeListener);
        }
    }

    private static final SubscriptionManager.OnSubscriptionsChangedListener mOnSubscriptionsChangeListener
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
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
        mSubscriptionManager.removeOnSubscriptionsChangedListener(mOnSubscriptionsChangeListener);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        printSubscriptionDetails();
    }

    private static void printSubscriptionDetails(){
        mSubInfoList = mSubscriptionManager.getActiveSubscriptionInfoList();
        for(SubscriptionInfo info: mSubInfoList){
            Log.v(TAG, ""+info.getSubscriptionId()+ "\n"+ info.getNumber()+"\n"+info.getDisplayName()+"\n"+info.getCarrierName());
        }
    }
}
