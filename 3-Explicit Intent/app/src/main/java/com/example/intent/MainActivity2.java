package com.example.intent;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity2 extends AppCompatActivity {
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i1 = getIntent();
        String name = i1.getStringExtra("Name");
        String email = i1.getStringExtra("Email");
        String phone = i1.getStringExtra("Phone");

        TextView r = findViewById(R.id.heading);
        r.setText("Welcome " + name + "🧑🏽‍💻");

        TextView r1 = findViewById(R.id.textView);
        r1.setText(" \uD83D\uDCE8 : " + email);

        TextView r2 = findViewById(R.id.textView2);
        r2.setText("☎ : " + phone);

        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(v -> {
            Intent i2 = new Intent(Intent.ACTION_VIEW);
            i2.setData(Uri.parse("https://anjali2201.github.io/portfolio-web/"));
            startActivity(i2);
        });

        Button b2 = findViewById(R.id.button1);
        b2.setOnClickListener(v -> {
            Intent i3 = new Intent(Intent.ACTION_DIAL);
            i3.setData(Uri.parse("tel:9766016320"));
            startActivity(i3);
        });

        Button b3 = findViewById(R.id.button2);
        b3.setOnClickListener(v -> {
            Intent i4 = new Intent(Intent.ACTION_VIEW);
            i4.setData(Uri.parse(
                    "https://www.google.co.in/maps/place/Shri+Ramdeobaba+College+of+Engineering+and+Management/@21.1766214,79.0594336,17z/data=!3m1!4b1!4m5!3m4!1s0x3bd4c1a8970c08e9:0xfe4a9c97e7e671cb!8m2!3d21.1766214!4d79.0616223"));
            startActivity(i4);
        });

        Button b4 = findViewById(R.id.button3);
        b4.setOnClickListener(v -> {
            Intent i5 = new Intent(Intent.ACTION_SENDTO);
            i5.setData(Uri.parse("mailto:anjalikushwaha031@gmail.com"));
            i5.putExtra(Intent.EXTRA_SUBJECT, "Query regarding the app");
            i5.putExtra(Intent.EXTRA_TEXT, "Hi Anjali, I have a query regarding the app");
            startActivity(i5);
        });

        Button b5 = findViewById(R.id.button4);
        b5.setOnClickListener(v -> {
            Intent i6 = new Intent(MainActivity2.this, MainActivity3.class);
            startActivityForResult(i6, 2);
        });

        Button b6 = findViewById(R.id.button5);
        b6.setOnClickListener(v -> {
            Intent i7 = new Intent(MainActivity2.this, MainActivity4.class);
            startActivityForResult(i7, 3);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed here it is 2
        if (requestCode == 2) {
            Toast.makeText(getApplicationContext(), "Thank you for Rating! ⭐ ", Toast.LENGTH_LONG)
                    .show();
            String message = data.getStringExtra("MESSAGE");
            int rate = Integer.parseInt(message);
            Button b5 = findViewById(R.id.button4);
            b5.setBackgroundColor(getResources().getColor(R.color.instagram));
            if (rate == 1) {
                b5.setText("⭐");
            } else if (rate == 2) {
                b5.setText("⭐⭐");
            } else if (rate == 3) {
                b5.setText("⭐⭐⭐");
            } else if (rate == 4) {
                b5.setText("⭐⭐⭐⭐");
            } else if (rate == 5) {
                b5.setText("⭐⭐⭐⭐⭐");
            }

        }

        if (requestCode == 3) {
            Toast.makeText(getApplicationContext(), "Thank you for your valuable Feedback 🙂", Toast.LENGTH_LONG)
                    .show();
            String message = data.getStringExtra("MESSAGE");
            Button b6 = findViewById(R.id.button5);
            b6.setText(message);
            b6.setBackgroundColor(getResources().getColor(R.color.instagram));
            b6.setTextColor(getResources().getColor(R.color.white));

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}