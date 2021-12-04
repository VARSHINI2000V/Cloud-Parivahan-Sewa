package com.example.vehicleproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vehicleproject.databinding.ActivityTrafficpageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class trafficpage extends AppCompatActivity {
    ActivityTrafficpageBinding binding;
    DatabaseReference reference;
    Button b1;
    Button prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTrafficpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        b1=findViewById(R.id.button5);
        prev=findViewById(R.id.button4);

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vehicleNumberplate=binding. editTextTextPersonName.getText().toString();
                if(!vehicleNumberplate.isEmpty())
                {
                    readData(vehicleNumberplate);}
                else{
                    Toast.makeText(trafficpage.this,"Please Enter Vechile Number Plate Id",Toast.LENGTH_SHORT).show();

                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(trafficpage.this,previous.class);
                String st1=binding.editTextTextPersonName.getText().toString();
                j.putExtra("Value",st1);
                startActivity(j);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(trafficpage.this,MainActivity.class);
                startActivity(j);
            }
        });
    }

    private void readData(String vehicleNumberplate) {
        reference= FirebaseDatabase.getInstance().getReference("Users");
        reference.child(vehicleNumberplate).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if (task.getResult().exists()) {
                        Toast.makeText(trafficpage.this,"Sucessfully Retrived",Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot= task.getResult();
                        String ownerName=String.valueOf(dataSnapshot.child("ownerName").getValue());
                        String registeringAuthority=String.valueOf(dataSnapshot.child("registeringAuthority").getValue());
                        String vehicleClass=String.valueOf(dataSnapshot.child("vehicleClass").getValue());
                        String RCstatus=String.valueOf(dataSnapshot.child("rcstatus").getValue());
                        String fuelType=String.valueOf(dataSnapshot.child("fuelType").getValue());
                        String vehicleAge=String.valueOf(dataSnapshot.child("vehicleAge").getValue());
                        String registrationDate=String.valueOf(dataSnapshot.child("registrationDate").getValue());
                        String insuraceValidupto=String.valueOf(dataSnapshot.child("insuraceValidupto").getValue());
                        binding.tvownerName.setText(ownerName);
                        binding.tvregisterAuthority.setText(registeringAuthority);
                        binding.tvvehicleClass.setText(vehicleClass);
                        binding.tvRCstatus.setText(RCstatus);
                        // binding.tvfuelType.setText(fuelType);
                        binding.tvvehicleAge.setText(vehicleAge);
                        binding.tvregistrationDate.setText(registrationDate);
                        binding.tvinsuranceValidupto.setText(insuraceValidupto);
                    }
                    else{
                        Toast.makeText(trafficpage.this,"User Doesn't Exist",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(trafficpage.this,"Failed To Retreive",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}