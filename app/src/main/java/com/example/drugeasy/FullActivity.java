package com.example.drugeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class FullActivity extends AppCompatActivity {

    TextView fnam, fgen, find, fside, fdose, fprice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indication);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        fnam = (TextView) findViewById(R.id.bbb);
       /* fgen=(TextView)findViewById(R.id.fullgenericname);
        find=(TextView)findViewById(R.id.fullindicattion);

        fside=(TextView)findViewById(R.id.fullsideeffectt);

        fdose=(TextView)findViewById(R.id.fulldose);
*/
        Intent data = getIntent();
        String n = data.getStringExtra("qu");
        System.out.println(n);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Drug");
        Query query = databaseReference.child("name").orderByChild("name").equalTo(n);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    String mm = data.child("name").getValue().toString();
                    String generic = data.child("genericName").getValue().toString();
                    String indication = data.child("indication").getValue().toString();
                    String side = data.child("sideEffect").getValue().toString();
                    String dose = data.child("does").getValue().toString();
                    // String nm=data.child("nma").getValue().toString();
                    Log.i("i",mm);
                    Log.i("**********",generic);

                    fnam.setText("oigrhufdiu");
                    fgen.setText(generic);
                    find.setText(indication);
                    fside.setText(side);
                    fdose.setText(dose);
                    //System.out.println("******************************************* " + generic + " " + indication);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Nothing to do");
            }
        });
    }

}