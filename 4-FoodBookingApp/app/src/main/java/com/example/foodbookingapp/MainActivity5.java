package com.example.foodbookingapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("black"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Cart cart = new Cart();
        ImageButton clear = (ImageButton) findViewById(R.id.imageButton);
        ListView listView = (ListView) findViewById(R.id.list1);
        ListView listView2 = (ListView) findViewById(R.id.list2);
        TextView total = (TextView) findViewById(R.id.total);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart.clearCart();
                Intent i = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(MainActivity5.this, "Cart Cleared", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<String> cartItems = cart.getCartItems();
        ArrayList<Integer> cartPrices = cart.getCartPrices();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cartItems);
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,
                cartPrices);
        listView.setAdapter(adapter);
        listView2.setAdapter(adapter2);

        int totalCost = 0;
        for (int i = 0; i < cartPrices.size(); i++) {
            totalCost += cartPrices.get(i);
        }
        total.setText("Total: " + totalCost);

    }

}