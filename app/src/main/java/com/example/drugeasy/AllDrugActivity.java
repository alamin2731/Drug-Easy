package com.example.drugeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AllDrugActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    public void go(View view){
        TextView aa=(TextView)findViewById(R.id.fname);
        String s=aa.getText().toString();
        Intent intent = new Intent(AllDrugActivity.this,DrugEasyActivity.class);
        intent.putExtra("qu", s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_drug);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
setTitle("A-Z Drugs");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<MainStructure> options =
                new FirebaseRecyclerOptions.Builder<MainStructure>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Drug"), MainStructure.class)
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