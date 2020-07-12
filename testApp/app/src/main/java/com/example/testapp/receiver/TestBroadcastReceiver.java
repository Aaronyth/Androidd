package com.example.testapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.testapp.constant.TestConstant;

public class TestBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "TestBroadcastReceiver";

    public TestBroadcastReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //判断接收广播的名，TestConstant.ACTION_TEST_BROADCAST是自定义广播的字符串
        if(intent.getAction().equals(TestConstant.ACTION_TEST_BROADCAST)) {
            Bundle bundle  = getResultExtras(true);
            Log.i(TAG, "onReceive: " + bundle.getString(TestConstant.KEY_TEST_BROADCAST_DATA));
        }
    }
}
