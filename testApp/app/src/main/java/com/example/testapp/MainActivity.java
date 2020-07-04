package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.testapp.testActivity.testActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                startActivity(new Intent(MainActivity.this, testActivity.class));

                //通过Intent的ComponentName
//                ComponentName cn = new ComponentName(MainActivity.this,testActivity.class) ;
//                Intent intent = new Intent() ;
//                intent.setComponent(cn) ;
//                startActivity(intent) ;

                //初始化Intent时指定Activity
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, testActivity.class);
//                startActivity(intent);

                //隐式启动
                Intent intent = new Intent();
                intent.setAction("android.intent.action.TESTACTIVITY");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
            }
        });
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
