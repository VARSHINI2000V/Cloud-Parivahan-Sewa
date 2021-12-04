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

public class rtoActivity extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://vehicleproject-49d9a-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto);
        final EditText id=findViewById(R.id.rtoid);
        final EditText password=findViewById(R.id.rtopassword);
        final Button rtobtn=findViewById(R.id.rtologin);
        rtobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String idTxt=id.getText().toString();
                final String passwordTxt=password.getText().toString();
                if(idTxt.isEmpty() || passwordTxt.isEmpty())
                {
                    Toast.makeText(rtoActivity.this,"Please enter your id or password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("officers").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(idTxt)) {
                                final String getPassword = snapshot.child(idTxt).child("password").getValue(String.class);
                                if (getPassword.equals(passwordTxt)) {
                                    Toast.makeText(rtoActivity.this, "Successfully Logged In..", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(rtoActivity.this,rtopage.class));
                                    finish();
                                } else {
                                    Toast.makeText(rtoActivity.this, "wrong password..", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(rtoActivity.this, "Enter correct User ID..", Toast.LENGTH_SHORT).show();

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