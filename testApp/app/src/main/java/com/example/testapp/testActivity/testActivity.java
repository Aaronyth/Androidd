package com.example.testapp.testActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.testapp.R;
import com.example.testapp.weight.TestDialog;

public class testActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "testActivity";
    TestDialog mTestDialog;

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
        backButton.setOnClickListener(this);
        dialogButton.setOnClickListener(this);

        mTestDialog = new TestDialog(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.dialog_button:
                showDialog();
                break;

            case R.id.back_button:
                finish();
                break;
        }
    }

    private void showDialog() {
        mTestDialog.show();
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
        Log.d(TAG, "onDestroy: ");
    }
}
