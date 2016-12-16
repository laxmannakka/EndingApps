package com.bridgelabz.newipl.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.View;

import com.bridgelabz.newipl.R;
import com.bridgelabz.newipl.adapter.TeamAdapter;
import com.bridgelabz.newipl.utility.ClickListener;
import com.bridgelabz.newipl.utility.DataBaseHandler;
import com.bridgelabz.newipl.utility.RecyclerTouchListener;
import com.bridgelabz.newipl.model.TeamsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DataBaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHandler(MainActivity.this);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        List<TeamsModel> messages = db.getAllStoredData();
        if(messages.size()==0) {


            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("ipl");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<List<TeamsModel>> t = new GenericTypeIndicator<List<TeamsModel>>() {
                    };
                    List<TeamsModel> messages = dataSnapshot.getValue(t);
                    for (int i = 0; i < messages.size(); i++) {
                        TeamsModel model = messages.get(i);
                        String teamname = model.getTeamname();
                        String url = model.getUrl();
                        String ownername = model.getOwner();
                        db.addStoreDataToDataBase(new TeamsModel(teamname, url, ownername));
                    }
                    TeamAdapter adapter = new TeamAdapter(messages, MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else{
            TeamAdapter adapter = new TeamAdapter(messages, MainActivity.this);
            recyclerView.setAdapter(adapter);
        }

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MainActivity.this, recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Intent displyteaminfo;
                displyteaminfo = new Intent(MainActivity.this, IplPlayersview.class);
                displyteaminfo.putExtra("Key", position);
                startActivity(displyteaminfo);
            }


            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}