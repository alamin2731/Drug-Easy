package com.example.drugeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Medicine medicine;
    EditText nameEditTexta, genericNameEditTexta, branda,mga;
    public Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);setTitle("Add Drug");
        nameEditTexta = findViewById(R.id.editTextMedicineNamea);
        genericNameEditTexta = findViewById(R.id.editTextGenericNamea);
        branda = findViewById(R.id.editTextBranda);
mga=findViewById(R.id.editTextMga);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Request");
        medicine = new Medicine();
        save = findViewById(R.id.buttona);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditTexta.getText().toString();
                String genericName = genericNameEditTexta.getText().toString();
                String BRand = branda.getText().toString();
                String m=mga.getText().toString();
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(genericName) && TextUtils.isEmpty(BRand)&& TextUtils.isEmpty(m)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(MainActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    addMedicineFirebase(name, genericName, BRand,m);
                }


            }
        });

    }


    //Medicine m = new Medicine(name,genericName,indication,does,sideEffect,price);

    // FirebaseDatabase.getInstance().getReference().push().setValue(m);
    public void addMedicineFirebase(String name, String genericName, String BRand,String m) {
        medicine.setName(name);
        medicine.setGenericName(genericName);
        medicine.setBrand(BRand);
        medicine.setMg(m);
        databaseReference.addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                        // databaseReference.setValue(medicine);
                                                        FirebaseDatabase.getInstance().getReference().child("Requsting").push().setValue(medicine);
                                                        nameEditTexta.getText().clear();
                                                        genericNameEditTexta.getText().clear();
                                                        branda.getText().clear();
                                                        mga.getText().clear();
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError error) {

                                                    }
                                                }

        );
    }
}