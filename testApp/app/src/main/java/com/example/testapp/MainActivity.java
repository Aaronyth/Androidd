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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
