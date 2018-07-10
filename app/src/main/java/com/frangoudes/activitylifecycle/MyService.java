package com.frangoudes.activitylifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chris on 01-02-17.
 */

public class MyService extends Service {

    public static final String KEY1 = "KEY1 intent message";
    String msg = "Service log msg";

    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Service Bound", Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void onCreate(){
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(msg, "Service started");
        // Let it continue running until it is stopped.
        String key1Msg = intent.getStringExtra(KEY1);
        Toast.makeText(this, "Service Started with Intent Msg: "+key1Msg, Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

    /** Called when a client is binding to the service with bindService()*/
    @Override
    public void onRebind(Intent intent) {

    }
    @Override
    public void onDestroy() {
        Log.d(msg, "Service stopped");
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }
}