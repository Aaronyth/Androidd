package com.example.testapp.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.example.testapp.constant.TestConstant;

public class TestService extends Service {

    private static final String TAG = "TestService";
    private BroadcastReceiver receiver;

    public TestService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        receiver = new Receiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TestConstant.ACTION_TEST_BROADCAST);
        registerReceiver(receiver,intentFilter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        String testTransfer = intent.getStringExtra(TestConstant.KEY_TEST_DATA);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(TestConstant.ACTION_TEST_BROADCAST)) {
                Log.i(TAG, "received broadcast in service.");
            }
        }
    }

}
