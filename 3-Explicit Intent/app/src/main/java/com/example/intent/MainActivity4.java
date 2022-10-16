package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent fb = getIntent();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            EditText name = findViewById(R.id.feedback);
            String feedback = name.getText().toString();
            fb.putExtra("MESSAGE", feedback);
            setResult(2, fb);
            finish();
        });

    }
}