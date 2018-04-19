package com.trac.preload.accountservices.subscriptionmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Broadcast recevier to listen boot complete event
 * Created by syennamani on 3/20/2018.
 */

public class OnBootupReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent != null) {
            String action = intent.getAction();
            if(action != null) {
                if(action.equals("android.intent.action.BOOT_COMPLETED")) {
                    // Start subscription service
                    SubscriptionService.enqueueWork(context,intent);
                }
            }
        }
    }
}
