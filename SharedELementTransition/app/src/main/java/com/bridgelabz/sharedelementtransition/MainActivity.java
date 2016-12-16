package com.bridgelabz.sharedelementtransition;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    View ivProfile;
    Button mButton;
    View textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivProfile = (ImageView) findViewById(R.id.ivprofile);
        mButton = (Button) findViewById(R.id.button);
        textview = findViewById(R.id.textview);



        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                Pair<View,String> pair1 =Pair.create(ivProfile,ivProfile.getTransitionName());
                Pair<View, String> pair2 = Pair.create(textview, textview.getTransitionName());

               /* ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, (View)ivProfile, ivProfile.getTransitionName());*/
                ActivityOptionsCompat options =ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,pair1,pair2);
                startActivity(intent, options.toBundle());
            }
        });


    }
}
