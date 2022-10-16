package com.example.eventlistners;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        EditText dob = findViewById(R.id.txtDate);
        Button btnSubmit = findViewById(R.id.btnSend);
        TextView result = findViewById(R.id.resultView);
        RadioGroup gender = findViewById(R.id.radioGroup);
        EditText phone = findViewById(R.id.txtPhone);
        CheckBox terms = findViewById(R.id.checkbox);
        Spinner frequency = findViewById(R.id.spinner1);
        RadioButton gen = findViewById(gender.getCheckedRadioButtonId());
        Button Date;
        TextView date;


        String[] items = new String[]{"Daily", "Weekly", "Monthly", "Yearly"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        frequency.setAdapter(adapter);
        String fre = frequency.getSelectedItem().toString();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
                                         @RequiresApi(api = Build.VERSION_CODES.O)
                                         @Override
                                         public void onClick(View v) {

                                             String nm = name.getText().toString();
                                             String mail = email.getText().toString();
                                             String bday = dob.getText().toString();
                                             String phonenm = phone.getText().toString();
//

                                             gender.setOnClickListener(new View.OnClickListener() {
                                                                           public void onClick(View v1) {
                                                                               boolean checked = ((RadioButton) v1).isChecked();
                                                                               String g;
                                                                               switch (v1.getId()) {
                                                                                   case R.id.female:
                                                                                       if (checked)
                                                                                           break;

                                                                                   case R.id.male:
                                                                                       if (checked)
                                                                                           break;
                                                                               }
                                                                           }
                                                                       }
                                             );

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


                                             if (nm.isEmpty() || mail.isEmpty() || bday.isEmpty() || phonenm.isEmpty() || gender.getCheckedRadioButtonId() == -1 || !terms.isChecked() || frequency.getSelectedItem().toString().isEmpty()) {
                                                 Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_LONG).show();
                                             } else {
                                                 String regex = "^(.+)@(.+)$";
                                                 String regex2 = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";


//                                             Toast.makeText(getApplicationContext(), "Logged In Successfully", Toast.LENGTH_LONG).show();
//                                              Intent i = new Intent();


//                                              i.putExtra("Name",nm);
//                                              i.putExtra("Email",mail);
//                                              i.putExtra("DOB",bday);
//                                              i.putExtra("Phone",phonenm);
// //                                             i.putExtra("Gender",g);
// //                                             i.putExtra("Frequency",fre);
//                                              i.setAction("android.intent.action.A2");
//                                              startActivity(i);

                                             
                                             if (nm.length() < 25) {
                                                 if (mail.matches(regex)) {
                                                     if (phone.length() == 10) {
                                                         if (bday.matches(regex2)) {
                                                             LocalDate today = LocalDate.now();
                                                             LocalDate birthday = LocalDate.of(Integer.parseInt(bday.substring(6)), Integer.parseInt(bday.substring(3, 5)), Integer.parseInt(bday.substring(0, 2)));
                                                             Period p = Period.between(birthday, today);
                                                             int age = p.getYears();
                                                             result.setText("Name: " + nm + "\nEmail: " + mail + "\nAge: " + age + "\nPhone: " + phonenm + "\nFrequency:" + fre);
                                                         } else {
                                                             Toast.makeText(getApplicationContext(), "Please enter date in dd/mm/yyyy format", Toast.LENGTH_LONG).show();
                                                         }
                                                     } else {
                                                         Toast.makeText(getApplicationContext(), "Please enter a valid phone number", Toast.LENGTH_LONG).show();
                                                     }
                                                 } else {
                                                     Toast.makeText(getApplicationContext(), "Please enter a valid email", Toast.LENGTH_LONG).show();
                                                 }
                                             } 
                                             else {
                                                 Toast.makeText(getApplicationContext(), "Name should be less than 25 characters", Toast.LENGTH_LONG).show();
                                             }
                                            }
                                         }

                                     }
        );
    }
                                    }


