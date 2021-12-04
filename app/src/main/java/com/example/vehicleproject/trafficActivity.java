package com.example.vehicleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class trafficActivity extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://vehicleproject-49d9a-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);
        final EditText id=findViewById(R.id.trafficid);
        final EditText password=findViewById(R.id.trafficpassword);
        final Button trafficbtn=findViewById(R.id.trafficbtn);
        trafficbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String idTxt=id.getText().toString();
                final String passwordTxt=password.getText().toString();
                if(idTxt.isEmpty() || passwordTxt.isEmpty())
                {
                    Toast.makeText(trafficActivity.this,"Please enter your id or password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("officers").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(idTxt)) {
                                final String getPassword = snapshot.child(idTxt).child("password").getValue(String.class);
                                if (getPassword.equals(passwordTxt)) {
                                    Toast.makeText(trafficActivity.this, "Successfully Logged In..", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(trafficActivity.this,trafficpage.class));
                                    finish();
                                } else {
                                    Toast.makeText(trafficActivity.this, "wrong password..", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(trafficActivity.this, "Enter correct User ID..", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

    }
}