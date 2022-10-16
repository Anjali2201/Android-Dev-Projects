package com.example.eventlistners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i1=getIntent();
        String name = i1.getStringExtra("Name");

        TextView r= findViewById(R.id.result);

        int age = i1.getIntExtra("Age",99);
        r.setText("Name:"+name);


        



    }
}