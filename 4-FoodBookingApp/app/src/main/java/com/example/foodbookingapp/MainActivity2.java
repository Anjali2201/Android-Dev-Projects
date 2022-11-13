package com.example.foodbookingapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        registerForContextMenu(image);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        registerForContextMenu(image2);
        ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        registerForContextMenu(image3);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle("Add Toppings");
        menu.add(0, v.getId(), 0, "Rs20: Olives");
        menu.add(0, v.getId(), 0, "Rs50: Pepperoni");
        menu.add(0, v.getId(), 0, "Rs70: Mushrooms");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
