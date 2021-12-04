package com.example.vehicleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.vehicleproject.databinding.ActivityUpdateBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class update extends AppCompatActivity {
    ActivityUpdateBinding binding;
    DatabaseReference databaseReference;
    EditText numberplates;
    TextView readonly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vehicleNumberplate=binding.numberplate.getText().toString();
                readData(vehicleNumberplate);
            }
        });
        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ownerName, vehicleNumberplate, RCstatus, vehicleAge, insuraceValidupto,ownername2,owner2number,owner3number;

                owner2number=binding.uownernum2.getText().toString();
                owner3number=binding.uownernum3.getText().toString();
                ownerName=binding.uownerName2.getText().toString();
                ownername2=binding.uownerName3.getText().toString();
                vehicleNumberplate=binding. numberplate.getText().toString();
                RCstatus =binding. uRCstatus.getText().toString();
                vehicleAge =binding. uvehicleAge.getText().toString();
                insuraceValidupto =binding. uinsuranceValidupto.getText().toString();
                updateData(ownerName, vehicleNumberplate, RCstatus, vehicleAge, insuraceValidupto,ownername2,owner2number,owner3number);

            }
        });
    }

    private void updateData(String ownerName, String vehicleNumberplate, String rCstatus, String vehicleAge, String insuraceValidupto,String ownername2,String ownernum2,String ownernum3) {
        HashMap User= new HashMap();
        User.put("secondowner",ownerName);
        User.put("RCstatus",rCstatus);
        User.put("vehicleAge",vehicleAge);
        User.put("thirdowner",ownername2);
        User.put("insuraceValidupto", insuraceValidupto);
        User.put("thirdowneraadhaar",ownernum3);
        User.put("secondowneraadhaar", ownernum2);
        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(vehicleNumberplate).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful())
                {

                    binding. uownerName2.setText("");
                    binding. numberplate.setText("");
                    binding. uRCstatus.setText("");
                    binding. uvehicleAge.setText("");
                    binding. uinsuranceValidupto.setText("");
                    binding. uownerName3.setText("");
                    binding. uownernum2.setText("");
                    binding. uownernum3.setText("");
                    Toast.makeText(update.this,"Sucessfully Updated",Toast.LENGTH_SHORT).show();


                }
                else {
                    Toast.makeText(update.this, "Failed to Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void readData(String vehicleNumberplate) {
        readonly = findViewById(R.id.ownerread);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(vehicleNumberplate).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        DataSnapshot dataSnapshot = task.getResult();
                        String ownerName = String.valueOf(dataSnapshot.child("ownerName").getValue());
                        readonly.setText(ownerName);
                    }
                }
            }
        });
    }
}