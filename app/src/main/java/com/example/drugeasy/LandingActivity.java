package com.example.drugeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

    Button search, generic, indication, aToZ, invoice, ab,ad,store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        search = (Button) findViewById(R.id.searchButton);
        generic = (Button) findViewById(R.id.genericButton);
        indication = (Button) findViewById(R.id.indicationButton);
        aToZ = (Button) findViewById(R.id.atozButton);
        invoice = (Button) findViewById(R.id.invoiceButton);
        ab = (Button) findViewById(R.id.about);
        ad=(Button)findViewById(R.id.addDrug);
        store=(Button)findViewById(R.id.drugStore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, StoreActivity.class));

            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, MainActivity.class));
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, SearchDrugActivity.class));
            }
        });
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, GenericActivity.class));

            }
        });
        indication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, IndicationActivity.class));

            }
        });
        aToZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, AllDrugActivity.class));

            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, AboutActivity.class));

            }
        });


    }
}