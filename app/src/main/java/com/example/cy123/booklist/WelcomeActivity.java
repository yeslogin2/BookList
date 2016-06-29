package com.example.cy123.booklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by cy123 on 2016/6/25.
 */
public class WelcomeActivity extends BaseActivity {

    private final long SPLASH_LENTH = 3000;

    Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_LENTH);
    }
}
