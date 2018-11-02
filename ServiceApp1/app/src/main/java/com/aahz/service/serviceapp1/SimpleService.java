package com.aahz.service.serviceapp1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class SimpleService extends Service {
    private final String LOG = getClass().getSimpleName();
    private int countFile = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG, "onStartCommand");
        Thread thread = new Thread(()->{
            for(int i = 0; i < 5; i++) {
                loadLimitation();
                countFile ++;
                Log.d(LOG, "count " + countFile);

            }
        });
        thread.start();

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LOG, "onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG, "onDestroy");

    }

    public void loadLimitation() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
