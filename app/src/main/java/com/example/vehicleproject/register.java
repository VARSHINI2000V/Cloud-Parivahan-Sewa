package com.example.vehicleproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.vehicleproject.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    String ownerName, vehicleNumberplate, registeringAuthority,  vehicleClass, RCstatus, fuelType, vehicleAge, registrationDate, insuraceValidupto,secondowner,secondowneraadhaar,thirdowner,thirdowneraadhaar,owneraadhaar;
    FirebaseDatabase db;
    DatabaseReference reference;
    EditText registrationDate1;
    Spinner spinner;

    List<String> spin_name;
    Spinner spinner1;
    List<String> spin_name1;
    DatePickerDialog picker;
    EditText owneraad;
    EditText eText;
    EditText etext1;
    EditText entrytext;
    EditText entrytext1;
    EditText entrytext2;
    EditText entrytext3;

    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        spinner = findViewById(R.id.fuelType);
        String spinnerName="PETROL";
        String spinnername2="DIESEL";
        spin_name=new ArrayList<>();
        spin_name.add(spinnerName);
        spin_name.add(spinnername2);
        spinner1 = findViewById(R.id.RCstatus);
        String spinnerNames="ACTIVE";
        String spinnernames2="NON-ACTIVE";
        spin_name1=new ArrayList<>();
        spin_name1.add(spinnerNames);
        spin_name1.add(spinnernames2);
        entrytext=findViewById(R.id.secowneredit);
        entrytext1=findViewById(R.id.secownereditaadhaar);
        entrytext2=findViewById(R.id.thirdowneredit);
        entrytext3=findViewById(R.id.thirdownereditaadhaar);
        owneraad=findViewById(R.id.owneraadhaaredit);
        etext1=(EditText) findViewById(R.id.registerationupto);
        etext1.setInputType(InputType.TYPE_NULL);
        etext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(register.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etext1.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        eText=(EditText) findViewById(R.id.insuranceValidupto);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(register.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(register.this, android.R.layout.simple_spinner_item,spin_name);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(arrayAdapter);
        String summah=String.valueOf(spinner.getSelectedItem());

        ArrayAdapter<String> arrayAdapter1 =new ArrayAdapter<>(register.this, android.R.layout.simple_spinner_item,spin_name1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(arrayAdapter1);
        String summah1=String.valueOf(spinner1.getSelectedItem());



        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ownerName = binding.ownerName.getText().toString();
                vehicleNumberplate = binding.vehicleNumberplate.getText().toString();
                registeringAuthority = binding.registeringAuthority.getText().toString();
                vehicleClass = binding.vehicleClass.getText().toString();
                RCstatus = summah1;
                fuelType = summah;
                owneraadhaar=owneraad.getText().toString();
                secondowner=entrytext.getText().toString();
                secondowneraadhaar=entrytext1.getText().toString();
                thirdowner=entrytext2.getText().toString();
                thirdowneraadhaar=entrytext3.getText().toString();
                vehicleAge = binding.vehicleAge.getText().toString();
                registrationDate = etext1.getText().toString();
                insuraceValidupto = eText.getText().toString();
                if(ownerName.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter Owner Name",Toast.LENGTH_SHORT).show();
                }
                if(secondowner.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter Second Owner Name or please use '-' for NIL ",Toast.LENGTH_SHORT).show();
                }
                if(secondowneraadhaar.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter Second Owner Aadhaar Number or please use '-' for NIL ",Toast.LENGTH_SHORT).show();
                }
                if(thirdowner.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter Third Owner Name or please use '-' for NIL ",Toast.LENGTH_SHORT).show();
                }
                if(thirdowneraadhaar.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter Third Owner Aadhaar Number or please use '-' for NIL ",Toast.LENGTH_SHORT).show();
                }
                if(owneraadhaar.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter Owner Aadhaar Number or please use '-' for NIL ",Toast.LENGTH_SHORT).show();
                }

                if(vehicleNumberplate.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter a Valid Vehicle number plate ID",Toast.LENGTH_SHORT).show();
                }
                if(registeringAuthority.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter Registering authority",Toast.LENGTH_SHORT).show();
                }
                if(vehicleClass.isEmpty())
                {
                    Toast.makeText(register.this,"Please Vehicle class Name",Toast.LENGTH_SHORT).show();
                }
                if(vehicleAge.isEmpty())
                {
                    Toast.makeText(register.this,"Please Enter Vehicle Age",Toast.LENGTH_SHORT).show();
                }
                if (!ownerName.isEmpty() && !vehicleNumberplate.isEmpty() && !registeringAuthority.isEmpty() && !vehicleClass.isEmpty() && !RCstatus.isEmpty() && !fuelType.isEmpty() && !vehicleAge.isEmpty() && !registrationDate.isEmpty() && !insuraceValidupto.isEmpty()) {
                    Users users = new Users(ownerName, vehicleNumberplate, registeringAuthority, vehicleClass, RCstatus, fuelType, vehicleAge, registrationDate, insuraceValidupto,secondowner,secondowneraadhaar,thirdowner,thirdowneraadhaar,owneraadhaar);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");

                    reference.child(vehicleNumberplate).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.ownerName.setText("");
                            binding.vehicleNumberplate.setText("");
                            binding.registeringAuthority.setText("");
                            binding.vehicleClass.setText("");
                            binding.vehicleAge.setText("");
                            entrytext.setText("");
                            entrytext1.setText("");
                            entrytext2.setText("");
                            entrytext3.setText("");
                            eText.setText("");
                            etext1.setText("");
                            //  binding.registrationupto.setText("");
                            //  binding.insuraceValidupto.setText("");
                            Toast.makeText(register.this, "Registered Successfully!!!", Toast.LENGTH_SHORT).show();


                        }
                    });


                }

            }



        });
    }
}