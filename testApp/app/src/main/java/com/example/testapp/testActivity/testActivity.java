package com.example.testapp.testActivity;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.testapp.R;
import com.example.testapp.constant.TestConstant;
import com.example.testapp.service.BindService;
import com.example.testapp.service.TestService;
import com.example.testapp.weight.TestDialog;

public class testActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "testActivity";
    private TestDialog mTestDialog;
    private ServiceConnection mSerConn;
    private BindService mBindService;

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

        setContentView(R.layout.test_activity);

        Button backButton = findViewById(R.id.back_button);
        Button dialogButton = findViewById(R.id.dialog_button);
        Button startServiceButton = findViewById(R.id.start_service_button);
        Button bindServiceButton = findViewById(R.id.bind_service_button);
        Button stopServiceButton = findViewById(R.id.stop_service_button);
        Button unbindServiceButton = findViewById(R.id.unbind_service_button);
        Button sendBroadcast = findViewById(R.id.send_broadcast);


        backButton.setOnClickListener(this);
        dialogButton.setOnClickListener(this);
        startServiceButton.setOnClickListener(this);
        bindServiceButton.setOnClickListener(this);
        stopServiceButton.setOnClickListener(this);
        unbindServiceButton.setOnClickListener(this);
        sendBroadcast.setOnClickListener(this);

        mTestDialog = new TestDialog(this);

        createSerConn();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.dialog_button:
                showDialog();
                break;

            case R.id.start_service_button:
                testStartService();
                break;

            case R.id.stop_service_button:
                testStopService();
                break;

            case R.id.bind_service_button:
                testBindService();
                break;

            case R.id.unbind_service_button:
                testUnBindService();
                break;

            case R.id.send_broadcast:
//                testSendBroadcast();
                testSendOrderBroadcast();
                break;

            case R.id.back_button:
                finish();
                break;

            default:
                break;
        }
    }

    private void showDialog() {
        mTestDialog.show();
    }

    private void testStartService() {
        Intent intent = new Intent(this, TestService.class);
        intent.putExtra(TestConstant.KEY_TEST_DATA,"data transfer");
        startService(intent);
    }

    private void testStopService() {
        Intent intent = new Intent(this, TestService.class);
        stopService(intent);
    }

    private void createSerConn() {
        mSerConn = new ServiceConnection() {
            /*
            与Service交互的接口方法
            获取绑定Service传递过来的IBinder对象
            通过这个IBinder对象，与Service进行交互
             */
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(TAG, "onServiceConnected:");
                mBindService = ((BindService.LocalBinder)service).getBindSer();
                String testString = mBindService.getTestString();
                Log.d(TAG, "onServiceConnected: " + "testString = " + testString);
            }

            /*
            异常情况下取消绑定时回调
             */
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(TAG, "onServiceDisconnected:");
            }
        };
    }

    private void testBindService() {
        Log.d(TAG, "testBindService: ");
        Intent intent = new Intent(this,BindService.class);
        bindService(intent,mSerConn,Service.BIND_AUTO_CREATE);
    }

    private void testUnBindService() {
        Log.d(TAG, "testUnBindService: ");
        if(mBindService != null) {
            mBindService = null;
            unbindService(mSerConn);
        }
    }

    private void testSendBroadcast() {
        Log.i(TAG, "testSendBroadcast: ");
        Intent intent = new Intent();
        intent.setAction(TestConstant.ACTION_TEST_BROADCAST);
        this.sendBroadcast(intent);
    }

    private void testSendOrderBroadcast() {
        Log.i(TAG, "testSendOrderBroadcast: ");
        Intent intent = new Intent();
        intent.setAction(TestConstant.ACTION_TEST_BROADCAST);
        intent.putExtra(TestConstant.KEY_TEST_BROADCAST_DATA,"send order broadcast.");
        this.sendOrderedBroadcast(intent, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBindService != null) {
            mBindService = null;
            unbindService(mSerConn);
        }
        Log.d(TAG, "onDestroy: ");
    }
}
