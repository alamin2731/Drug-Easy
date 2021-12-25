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
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class DrugClassActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    public void go(View view) {
        TextView aa = (TextView) findViewById(R.id.fname);
        String s = aa.getText().toString();
        Intent i = new Intent(DrugClassActivity.this, DrugEasyActivity.class);
        i.putExtra("qu", s);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_drug);
        Intent i = getIntent();
        String p = i.getExtras().getString("others");
        recyclerView = (RecyclerView) findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<MainStructure> options =
                new FirebaseRecyclerOptions.Builder<MainStructure>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Drug").orderByChild("genericName").startAt(p).endAt("\uf8ff"), MainStructure.class)
                        .build();
        mainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.startListening();
    }
}