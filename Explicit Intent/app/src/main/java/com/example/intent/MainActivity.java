package com.example.intent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.txtName);
        EditText email = findViewById(R.id.txtEmail);
        EditText phone = findViewById(R.id.txtPhone);
        CheckBox terms = findViewById(R.id.checkbox);
        Button btnSubmit = findViewById(R.id.btnSend);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override

            public void onClick(View v) {
                String nm = name.getText().toString();
                String mail = email.getText().toString();
                String phonenm = phone.getText().toString();


                terms.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v2) {
                        boolean checked = ((CheckBox) v2).isChecked();
                        if (terms.isChecked()) {
                            Toast.makeText(MainActivity.this, "Terms and Conditions Accepted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Accept Terms and Conditions", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                if (nm.isEmpty() || mail.isEmpty() || phonenm.isEmpty() || !terms.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_LONG).show();
                } else {
                    String regex = "^(.+)@(.+)$";
                    if (nm.length() < 25) {
                        if (mail.matches(regex)) {
                            if (phone.length() == 10) {
                                Toast.makeText(getApplicationContext(), "Logged In Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent();


                                i.putExtra("Name", nm);
                                i.putExtra("Email", mail);
                                i.putExtra("Phone", phonenm);

                                i.setAction("android.intent.action.A2");
                                startActivity(i);



                            } else {
                                Toast.makeText(getApplicationContext(), "Please enter a valid phone number", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Please enter a valid email", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Name should be less than 25 characters", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
