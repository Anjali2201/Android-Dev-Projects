package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraintlayout);
//        WindowManager wm = (WindowManager) getSystemService(Activity.WINDOW_SERVICE);
//
//        Display d = wm.getDefaultDisplay();
//
//        if (d.getWidth() > d.getHeight()) {
////---landscape mode--
//
//        } else {
////---portrait mode--
//            setContentView(R.layout.landscape);
//        }
    }
}