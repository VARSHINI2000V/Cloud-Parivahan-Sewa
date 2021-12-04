package com.example.vehicleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.vehicleproject.databinding.ActivityPreviousBinding;
import com.example.vehicleproject.databinding.ActivityTrafficpageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class previous extends AppCompatActivity {
    ActivityPreviousBinding binding;
    DatabaseReference reference;
    String st1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPreviousBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        st1=getIntent().getExtras().getString("Value");
        readData(st1);
    }

    private void readData(String st1) {
        reference= FirebaseDatabase.getInstance().getReference("Users");
        reference.child(st1).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        Toast.makeText(previous.this,"Sucessfully Retrived",Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot= task.getResult();
                        String ownerName2=String.valueOf(dataSnapshot.child("secondowner").getValue());
                        String ownerName3=String.valueOf(dataSnapshot.child("thirdowner").getValue());
                        String ownerNum2=String.valueOf(dataSnapshot.child("secondowneraadhaar").getValue());
                        String ownerNum3=String.valueOf(dataSnapshot.child("thirdowneraadhaar").getValue());
                        binding.tvownerName.setText(ownerName2);
                        binding.tvregisterAuthority.setText(ownerNum2);
                        binding.tvownerName1.setText(ownerName3);
                        binding.tvregisterAuthority1.setText(ownerNum3);
                    }
                }
            }
        });

    }
}