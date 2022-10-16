package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent rate = getIntent();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.rating);
                String rating = name.getText().toString();
                rate.putExtra("MESSAGE", rating);
                int r = Integer.parseInt(rating);
                if (r == 1) {
                    name.setText("⭐");
                } else if (r == 2) {
                    name.setText("⭐⭐");
                } else if (r == 3) {
                    name.setText("⭐⭐⭐");
                } else if (r == 4) {
                    name.setText("⭐⭐⭐⭐");
                } else if (r == 5) {
                    name.setText("⭐⭐⭐⭐⭐");
                }

                setResult(2, rate);
                finish();
            }
        });

    }
}