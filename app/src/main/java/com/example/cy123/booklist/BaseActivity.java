package com.example.cy123.booklist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.support.v7.widget.Toolbar;

/**
 * Created by cy123 on 2016/6/24.
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
