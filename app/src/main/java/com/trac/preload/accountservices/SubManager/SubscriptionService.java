package com.trac.preload.accountservices.SubManager;


import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.HandlerThread;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.telephony.SubscriptionManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by syennamani on 3/19/2018.
 */

public class SubscriptionService extends Service {

    SubscriptionManager mSubscriptionManager = null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @Override
    public void onCreate() {

        mSubscriptionManager = SubscriptionManager.from(this);
        mSubscriptionManager.addOnSubscriptionsChangedListener(mOnSubscriptionsChangeListener);

    }

    private final SubscriptionManager.OnSubscriptionsChangedListener mOnSubscriptionsChangeListener
            = new SubscriptionManager.OnSubscriptionsChangedListener() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
        @Override
        public void onSubscriptionsChanged() {
            // Handle state change here
            Log.v("Subscription Changed", ""+mSubscriptionManager.getActiveSubscriptionInfoCount());
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
        mSubscriptionManager.removeOnSubscriptionsChangedListener(mOnSubscriptionsChangeListener);
    }
}
