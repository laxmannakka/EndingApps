package com.bridgelabz.interfusercoverflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<LIst> mData = new ArrayList<>();
    int image_array[] ={R.drawable.images,R.drawable.appystore,R.drawable.images,R.drawable.appystore,R.drawable.appystore};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        mData.add(new LIst(image_array[0],"laxman"));
        mData.add(new LIst(image_array[1],"laxman"));
        mData.add(new LIst(image_array[2],"laxman"));
        mData.add(new LIst(image_array[2],"laxman"));
        mData.add(new LIst(image_array[2],"laxman"));


        CoverFlow coverFlow;
        coverFlow = new CoverFlow(this);
        coverFlow = (CoverFlow) findViewById(R.id.coverflow);
        // coverFlow.setAdapter(new ImageAdapter(this));
     //   ImageAdapter coverImageAdapter = new ImageAdapter(this);
        //coverImageAdapter.createReflectedImages();

       ImageAdapter coverImageAdapter = new ImageAdapter(this,mData);
        coverFlow.setAdapter(coverImageAdapter);
        coverFlow.setSpacing(-25);
        coverFlow.setSelection(4, true);
        coverFlow.setAnimationDuration(1000);
      //  setContentView(coverFlow);
    }
}

