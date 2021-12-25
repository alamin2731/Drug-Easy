package com.example.drugeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DrugEasyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movie> movieList;
    TextView na, mmg, tab, gen, br, un, t;
    String others;

    public void others(View view) {
        t = findViewById(R.id.gggg);
        others = t.getText().toString();
        Intent i = new Intent(DrugEasyActivity.this, DrugClassActivity.class);
        i.putExtra("others", others);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_drug_easy);
        recyclerView = findViewById(R.id.recyclerView);

        na = findViewById(R.id.nnn);
        mmg = findViewById(R.id.mmmg);
        tab = findViewById(R.id.tttt);
        gen = findViewById(R.id.gggg);
        br = findViewById(R.id.bbb2);

        Intent data = getIntent();
        String s = data.getExtras().getString("qu");
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
                    String ty = data.child("type").getValue().toString();
                    Log.i("Unknowwwww***********", indication);
                    na.setText(mm);
                    mmg.setText(mg);
                    tab.setText(ty);
                    gen.setText(generic);
                    br.setText(brr);


                    khan(indication, dose, side, pr);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Nothing to do");
            }
        });


    }


    private void initRecyclerView() {
        MovieAdapter movieAdapter = new MovieAdapter(movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieAdapter);
    }

    private void initData() {
        movieList = new ArrayList<>();
    }

    public void khan(String i, String j, String k, String l) {
        initData();
        initRecyclerView();
        movieList.add(new Movie("Indication", i));
        movieList.add(new Movie("Dose", j));
        movieList.add(new Movie("Side Effect", k));
        movieList.add(new Movie("Price", l));
    }

}