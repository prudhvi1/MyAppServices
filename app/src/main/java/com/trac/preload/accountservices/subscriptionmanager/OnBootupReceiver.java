package com.trac.preload.accountservices.subscriptionmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Broadcast recevier to listen boot complete event
 * Created by syennamani on 3/20/2018.
 */

public class OnBootupReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent != null) {
            Log.d("broadcast 1", "onReceive: ");
            String action = intent.getAction();
            Log.d("broadcast 3 ", action);
            if(action != null) {
                if(action.equals("android.intent.action.BOOT_COMPLETED")) {
                    Log.d("broadcast 2", "onReceive: ");

                    // Start subscription service
                    SubscriptionService.enqueueWork(context,intent);
                }
            }
        }
    }
}
