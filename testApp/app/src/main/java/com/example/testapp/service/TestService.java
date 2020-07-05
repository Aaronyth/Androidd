package com.example.testapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.testapp.constant.TestConstant;

public class TestService extends Service {

    private static final String TAG = "TestService";

    public TestService() {
        super();
        Log.d(TAG, "TestService: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        String testTransfer = intent.getStringExtra(TestConstant.KEY_TEST_DATA);
        Log.d(TAG, "onStartCommand: " + "intent: " + intent.getAction());
        Log.d(TAG, "onStartCommand: " + "testTransfer: " + testTransfer);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

}
