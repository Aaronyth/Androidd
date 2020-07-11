package com.example.testapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.testapp.constant.TestConstant;

public class TestBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "TestBroadcastReceiver";

    public TestBroadcastReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(TestConstant.ACTION_TEST_BROADCAST)) {
            Log.i(TAG, "received broadcast in TestBroadcastReceiver");
        }
    }
}
