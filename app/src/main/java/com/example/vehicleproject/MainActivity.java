package com.example.vehicleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button rto;
    Button traffic;
    TextView txtMarquee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMarquee = (TextView) findViewById(R.id.marqueeText);

        // Now we will call setSelected() method
        // and pass boolean value as true
        txtMarquee.setSelected(true);
        //checkConnection();
        if(!isOnline())
        {
            Intent i=new Intent(MainActivity.this,nointernet.class);
            startActivity(i);

        }

        rto=findViewById(R.id.button);

        traffic=findViewById(R.id.button2);

        rto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, rtoActivity.class);
                startActivity(i);

            }
        });

        traffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, trafficActivity.class);
                startActivity(i2);
            }
        });
    }
    public boolean isOnline()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo==null||!networkInfo.isAvailable()||!networkInfo.isConnected())
        {
            return false;
        }
        return true;
    }

    /*
    public void checkConnection(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                Toast.makeText(this, "Wifi Enabled", Toast.LENGTH_SHORT).show();
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                Toast.makeText(this, "Mobile Data Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();

            }
        }
    }
    */


}
