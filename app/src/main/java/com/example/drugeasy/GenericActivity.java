package com.example.drugeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class GenericActivity extends AppCompatActivity {

    RecyclerView recview;
    myadapter adapter;
    String s;
    TextView t;
    String y;
    public void VVV(View view) {
        t = findViewById(R.id.nametext);
        s = t.getText().toString();
        Intent i = new Intent(GenericActivity.this, DrugEasyActivity.class);
        i.putExtra("qu", s);
        startActivity(i);
        System.out.println(s + "*****************************************************");
        //startActivity(new Intent(GenericActivity.this, SearchDrugActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indication);
        recview = (RecyclerView) findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
setTitle("Search");
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Drug").child("genericName"), model.class)
                        .build();

        adapter = new myadapter(options);
        recview.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem item = menu.findItem(R.id.searchf);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s) {
        String sl=s.toLowerCase();
        String su=s.toUpperCase();
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Drug").orderByChild("genericName").startAt(su).endAt(sl + "\uf8ff"), model.class)
                        .build();

        adapter = new myadapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}