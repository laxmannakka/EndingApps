package com.bridgelabz.newipl.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bridgelabz.newipl.R;
import com.bridgelabz.newipl.adapter.PlayerAdapter;
import com.bridgelabz.newipl.model.PlayersModel;
import com.bridgelabz.newipl.utility.ClickListener;
import com.bridgelabz.newipl.utility.PlayerDetailFragment;
import com.bridgelabz.newipl.utility.RecyclerTouchListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class IplPlayersview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipl_playersview);
        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);

        Toast.makeText(getApplicationContext(), "im in another activity", Toast.LENGTH_LONG).show();
        Intent intent = getIntent();
        // Getting the key value
        int value = intent.getIntExtra("Key", 0);

        // Stroring the team Firebase database team referances in array
        String[] firebaseteamreferance = {"sunrisers", "Mubhai", "royalchalengers", "rising", "kingspunjab", "delhidaredevils", "gujaratlions", "kolkatata"};

        //Creating the fire database referance
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(firebaseteamreferance[value]);

        // Initializing the recycler view
        final RecyclerView playerrecycleview = (RecyclerView) findViewById(R.id.teamrecycleview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        playerrecycleview.setLayoutManager(mLayoutManager);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<List<PlayersModel>> t = new GenericTypeIndicator<List<PlayersModel>>() {
                };
                List<PlayersModel> firebaseData = dataSnapshot.getValue(t);
                PlayerAdapter adapter = new PlayerAdapter(IplPlayersview.this, firebaseData);
                playerrecycleview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        playerrecycleview.addOnItemTouchListener(new RecyclerTouchListener(IplPlayersview.this, playerrecycleview, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"mesage"+position,Toast.LENGTH_LONG).show();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                PlayerDetailFragment  fragment = new PlayerDetailFragment();
                ft.setCustomAnimations(R.animator.zoomin,R.animator.exit_anim);
                ft.replace(R.id.framelayout, fragment);
                ft.addToBackStack(null);
                ft.commit();
                /*
                Intent intent = new Intent(IplPlayersview.this,PlayerDeatailsActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(this, (View)ivProfile, "profile");
                startActivity(intent);*/
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

}

