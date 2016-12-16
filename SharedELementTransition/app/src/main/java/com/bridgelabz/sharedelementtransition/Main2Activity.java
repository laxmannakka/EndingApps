package com.bridgelabz.sharedelementtransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView image = (ImageView) findViewById(R.id.ivprofile);
        image.setImageDrawable(getResources().getDrawable(R.drawable.ll));
    }
}
