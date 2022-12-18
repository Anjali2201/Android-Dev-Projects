package com.example.foodbookingapp;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    AlertDialog dialog;
    AlertDialog.Builder builder;
    String[] options = { "Home Delivery-30 mins", "Store Pickup-20 mins" };

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
        Button btn = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = builder.create();
                dialog.show();
            }
        });
        // registerForContextMenu(btn);

        final NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        createChannel(mgr);

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

        builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an option");
        builder.setItems(options, (dialog, which) -> {
            Toast.makeText(this, "Selected Item: " + options[which], Toast.LENGTH_SHORT).show();
            if (options[which] == "Home Delivery-30 mins") {
                Intent i = new Intent(MainActivity5.this, MainActivity6.class);
                i.putExtra("Message", "Your order has been placed Successfully!");
                PendingIntent pi = PendingIntent.getActivity(MainActivity5.this, 0, i, 0);
                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(MainActivity5.this,
                        "mychannels.Apps");
                Notification n = nBuilder
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("Ordered Successfully!")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pi)
                        .build();
                mgr.notify(0, n);
                Intent i2 = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(i2);
            } else if (options[which] == "Store Pickup-20 mins") {
                Intent i = new Intent(MainActivity5.this, MainActivity6.class);
                i.putExtra("Message", "Your order has been placed Successfully!");
                PendingIntent pi = PendingIntent.getActivity(MainActivity5.this, 0, i, 0);
                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(MainActivity5.this,
                        "mychannels.Apps");
                Notification n = nBuilder
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("Ordered Successfully!")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pi)
                        .build();
                mgr.notify(0, n);
                Intent i2 = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(i2);
            }
        });

    }

    protected void createChannel(NotificationManager mgr) {
        NotificationChannel appsChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            appsChannel = new NotificationChannel("mychannels.Apps", "Apps", NotificationManager.IMPORTANCE_DEFAULT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            appsChannel.setLightColor(Color.BLUE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mgr.createNotificationChannel(appsChannel);
        }
    }

    // @Override
    // public void onCreateContextMenu(ContextMenu menu, View v,
    // ContextMenu.ContextMenuInfo menuInfo) {
    // super.onCreateContextMenu(menu, v, menuInfo);
    // MenuInflater inflater = getMenuInflater();
    // menu.setHeaderTitle("Choose an option");
    // menu.add(0, v.getId(), 0, "Home Delivery-30 mins");
    // menu.add(0, v.getId(), 0, "Store Pickup-20 mins");
    //
    // }

    // @Override
    // public boolean onContextItemSelected(MenuItem item) {
    // Toast.makeText(this, "Selected Item: " + item.getTitle(),
    // Toast.LENGTH_SHORT).show();
    // final NotificationManager mgr = (NotificationManager)
    // getSystemService(Context.NOTIFICATION_SERVICE);
    // createChannel(mgr);
    // if (item.getTitle() == "Home Delivery-30 mins") {
    // Intent i = new Intent(MainActivity5.this, MainActivity6.class);
    // i.putExtra("Message", "Your order has been placed Successfully!");
    // PendingIntent pi = PendingIntent.getActivity(MainActivity5.this, 0, i, 0);
    // NotificationCompat.Builder nBuilder = new
    // NotificationCompat.Builder(MainActivity5.this,
    // "mychannels.Apps");
    // Notification n = nBuilder
    // .setSmallIcon(R.drawable.icon)
    // .setContentTitle("Ordered Successfully!")
    // .setWhen(System.currentTimeMillis())
    // .setContentIntent(pi)
    // .build();
    // mgr.notify(11, n);
    //
    // } else if (item.getTitle() == "Store Pickup-20 mins") {
    // Intent i = new Intent(MainActivity5.this, MainActivity7.class);
    // i.putExtra("Message", "Your order has been placed Successfully!");
    // PendingIntent pi = PendingIntent.getActivity(MainActivity5.this, 0, i, 0);
    //
    // // CREATION OF NOTIFICATION
    // NotificationCompat.Builder nBuilder = new
    // NotificationCompat.Builder(MainActivity5.this,
    // "mychannels.Apps");
    // Notification n = nBuilder
    // .setSmallIcon(R.drawable.icon)
    // .setContentTitle("Ordered Successfully!")
    // .setWhen(System.currentTimeMillis())
    // .setContentIntent(pi)
    // .build();
    // mgr.notify(11, n);
    // }
    // return true;
    // }

}