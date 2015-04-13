package com.disydes.cateringboa;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;

import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Parse.initialize(this, "YaENmIdTTcZwrzFcwRpVmTSOeE3rJs8p073TbFFO", "gy5Ix1PU4ABryATpeArjG3fYzrlMB9Sagb42K7qH");

        Runnable runnable3secs = new Runnable() {
            @Override
            public void run() {
                nextActivity();
                finish();
            }
        };

        android.os.Handler myHandler = new android.os.Handler();
        myHandler.postDelayed(runnable3secs,3000);




    }



    public void nextActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }
}
