package com.example.drugeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExpandActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ExpandModel> formulaList;
    TextView na, mmg, tab, gen, br,un;

    String after;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);
        Intent data = getIntent();
        String s = data.getExtras().getString("qu");
        System.out.println(s);
       after=s;

        recyclerView = findViewById(R.id.rec);
        na = (TextView) findViewById(R.id.finallname);
        mmg = (TextView) findViewById(R.id.finallmg);
        tab = (TextView) findViewById(R.id.textView5);
        gen = (TextView) findViewById(R.id.textView6);
        br = (TextView) findViewById(R.id.bbb);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = databaseReference.child("Drug").orderByChild("name").equalTo(s);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    String mm = data.child("name").getValue().toString();
                    String generic = data.child("genericName").getValue().toString();
                   String indication = data.child("indication").getValue().toString();
                    String side = data.child("sideEffect").getValue().toString();
                    String dose = data.child("does").getValue().toString();
                    String brr = data.child("brand").getValue().toString();
                    String d = data.child("does").getValue().toString();
                    String pr = data.child("price").getValue().toString();
                    String mg = data.child("mg").getValue().toString();
                    Log.i("Unknowwwww***********", indication);
                    na.setText("" + mm);
                    mmg.setText("" + mg);
                    gen.setText("" + generic);
                    br.setText("" + brr);
                    formulaList.add(new ExpandModel("Dose",
                            pr.toString()));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Nothing to do");
            }
        });
        initData();
        initRecyclerView();

        System.out.println(after + "Z*********************");


    }
    private void initRecyclerView() {
        ExpandAdapter formulaAdapter = new ExpandAdapter(this, formulaList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(formulaAdapter);
    }

    private void initData() {
        System.out.println("Working level INTDATA*****"+after+"*******");

        after="";

        formulaList = new ArrayList<>();
       // Uri path1 = Uri.parse("android.resource://com.trickuweb.expandcollapse/" + indication);
       /* Uri path2 = Uri.parse("android.resource://com.trickuweb.expandcollapse/" + R.drawable.evenoddformula);
        Uri path3 = Uri.parse("android.resource://com.trickuweb.expandcollapse/" + R.drawable.cosinerule);
        Uri path4 = Uri.parse("android.resource://com.trickuweb.expandcollapse/" + R.drawable.firstquadrant);
        Uri path5 = Uri.parse("android.resource://com.trickuweb.expandcollapse/" + R.drawable.firstquadrant);
        Uri path6 = Uri.parse("android.resource://com.trickuweb.expandcollapse/" + R.drawable.firstquadrant);
*/

/*
        formulaList.add(new FormulaModel("Dose",
                path2.toString()));
        formulaList.add(new FormulaModel("Side effect",
                path3.toString()));
        formulaList.add(new FormulaModel("Side effect",
                path4.toString()));
        formulaList.add(new FormulaModel("Price",
                path5.toString()));
        formulaList.add(new FormulaModel("Generic Name",
                path6.toString()));*/

    }
}
