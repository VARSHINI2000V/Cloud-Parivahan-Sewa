package com.example.vehicleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rtopage extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtopage);
        b1=findViewById(R.id.registerbtn);
        b2=findViewById(R.id.updatebtn);
        b3=findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r=new Intent(rtopage.this,register.class);
                startActivity(r);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u=new Intent(rtopage.this,update.class);
                startActivity(u);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(rtopage.this,MainActivity.class);
                startActivity(k);
            }
        });
    }
}