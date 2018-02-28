package com.tracfone.generic.myaccountlibrary.restcommon;
  
import roboguice.util.temp.Ln;
import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.memory.LruCacheStringObjectPersister;
import com.tracfone.generic.myaccountlibrary.DebugConfig;

public class CachedSpiceService extends SpiceService {
	
	@Override
    public void onCreate() {
        super.onCreate();
        if (!DebugConfig.DEBUG_ROBOSPICE) {
        	// Logging really causes the app to chug with this many requests
        	Ln.getConfig().setLoggingLevel(Log.ERROR);
        }
    }


    @Override
    public CacheManager createCacheManager(Application application) {
        CacheManager manager = new CacheManager();

        LruCacheStringObjectPersister memoryPersister = new LruCacheStringObjectPersister(500000);
        manager.addPersister(memoryPersister);

        return manager;

    }

    /**
     * Overrides the number of threads that will be used to make requests.
     */
    @Override
    public int getThreadCount() {
        return 2;
    }
}
