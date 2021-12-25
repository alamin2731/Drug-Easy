package com.example.drugeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddMainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Medicine medicine;
    EditText nameEditText, genericNameEditText, indicationEditText, doseEditText, sideEffectEditText, priceEditText, mg, brand;
    public Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_main);
        nameEditText = findViewById(R.id.editTextMedicineName);
        genericNameEditText = findViewById(R.id.editTextGenericName);
        indicationEditText = findViewById(R.id.editTextIndication);
        doseEditText = findViewById(R.id.editTextDose);
        sideEffectEditText = findViewById(R.id.editTextSideEffect);
        priceEditText = findViewById(R.id.editTextPrice);
        mg = findViewById(R.id.editTextMg);
        brand = findViewById(R.id.editTextBrand);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Medicine");
        medicine = new Medicine();
        save = findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString();
                String genericName = genericNameEditText.getText().toString();
                String indication = indicationEditText.getText().toString();
                String does = doseEditText.getText().toString();
                String sideEffect = sideEffectEditText.getText().toString();
                String price = priceEditText.getText().toString();
                String MG = mg.getText().toString();
                String BRand = brand.getText().toString();
                String url = "https://ibb.co/7vzRnNR";
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(genericName) && TextUtils.isEmpty(indication) && TextUtils.isEmpty(sideEffect) && TextUtils.isEmpty(does)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(AddMainActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    addMedicineFirebase(name, genericName, indication, does, sideEffect, price, url, MG, BRand);
                }


            }
        });

    }


    //Medicine m = new Medicine(name,genericName,indication,does,sideEffect,price);

    // FirebaseDatabase.getInstance().getReference().push().setValue(m);
    public void addMedicineFirebase(String name, String genericName, String indication, String dose, String sideEffect, String price, String url, String MG, String BRand) {
        medicine.setName(name);
        medicine.setGenericName(genericName);
        medicine.setIndication(indication);
        medicine.setSideEffect(sideEffect);
        medicine.setPrice(price);
        medicine.setDose(dose);
        medicine.setBrand(BRand);
        medicine.setMg(MG);
        databaseReference.addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                        // databaseReference.setValue(medicine);
                                                        FirebaseDatabase.getInstance().getReference().child("Drug").push().setValue(medicine);
                                                        nameEditText.getText().clear();
                                                        genericNameEditText.getText().clear();
                                                        indicationEditText.getText().clear();
                                                        doseEditText.getText().clear();
                                                        sideEffectEditText.getText().clear();
                                                        priceEditText.getText().clear();
                                                        mg.getText().clear();
                                                        brand.getText().clear();


                                                    }


                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError error) {

                                                    }
                                                }

        );
    }
}