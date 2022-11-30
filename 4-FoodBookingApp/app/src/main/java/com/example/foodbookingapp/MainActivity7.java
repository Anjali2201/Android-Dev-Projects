package com.example.foodbookingapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("black"));
        actionBar.setBackgroundDrawable(colorDrawable);
        LocalDateTime dateTime = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dateTime = LocalDateTime.now().plusMinutes(20);
        }

        TextView time = (TextView) findViewById(R.id.textView4);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            time.setText(
                    "Your order will be delivered at " + dateTime.getHour() + ":" + dateTime.getMinute() + " on "
                            + dateTime.getDayOfMonth() + "/" + dateTime.getMonthValue() + "/" + dateTime.getYear());
        }

    }
}