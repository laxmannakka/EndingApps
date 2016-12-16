package com.bridgelabz.layererdlist;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LayerDrawable layerDrawable;
    ImageView video, song, home, historyy, search;
    ImageView imageArray[] = new ImageView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        video = (ImageView) findViewById(R.id.video);
        song = (ImageView) findViewById(R.id.song);
        home = (ImageView) findViewById(R.id.home);
        historyy = (ImageView) findViewById(R.id.history);
        search = (ImageView) findViewById(R.id.search);
        //  song.setImageResource(R.drawable.ic_history_white_24dp);
        imageArray[0] = song;
        imageArray[1] = video;
        imageArray[2] = search;
        imageArray[3] = home;
        imageArray[4] = historyy;

        layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.demolayerlist);
        final Drawable history = (Drawable) getResources().getDrawable(R.drawable.ic_history_white_24dp);
        layerDrawable.setDrawableByLayerId(R.id.layerimage, history);
        historyy.setBackground(layerDrawable);

        layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.demolayerlist);
        final Drawable homee = (Drawable) getResources().getDrawable(R.drawable.ic_home_white_24dp);
        layerDrawable.setDrawableByLayerId(R.id.layerimage, homee);
        home.setBackground(layerDrawable);


        layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.demolayerlist);
        Drawable songicon = getResources().getDrawable(R.drawable.ic_music_note_white_24dp);
        layerDrawable.setDrawableByLayerId(R.id.layerimage, songicon);
        song.setBackground(layerDrawable);

        layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.demolayerlist);
        Drawable videoicon = getResources().getDrawable(R.drawable.ic_ondemand_video_white_24dp);
        layerDrawable.setDrawableByLayerId(R.id.layerimage, videoicon);
        video.setBackground(layerDrawable);




        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor();
                Toast.makeText(getApplicationContext(), "clciked Home", Toast.LENGTH_LONG).show();
                setColor(home);
            }
        });

        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor();
                setColor(song);

            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor();
                setColor(video);

            }
        });
        historyy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor();
                setColor(historyy);

            }
        });

 /*       search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor();
                setColor(search);

            }
        });*/

        search.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case  MotionEvent.ACTION_UP :
                        setColor(search);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        changeColor();
                        break;
                }
                return false;
            }
        });
    }


    public void changeColor() {

        for (int i = 0; i <= 4; i++) {
            LayerDrawable bgDrawable = (LayerDrawable) imageArray[i].getBackground();
            GradientDrawable gradientDrawable = (GradientDrawable) bgDrawable
                    .findDrawableByLayerId(R.id.layer3);
            gradientDrawable.setColor(ContextCompat.getColor(this,R.color.lightblack));
        }
    }

    public void setColor(ImageView imageView) {
        LayerDrawable bgDrawable = (LayerDrawable) imageView.getBackground();
        //  layerDrawable =(LayerDrawable)getResources().getDrawable(R.drawable.demolayerlist);
        GradientDrawable shape = (GradientDrawable) (bgDrawable.findDrawableByLayerId(R.id.layer3));
        // shape.setColor(getResources().getColor(android.R.color.holo_blue_bright));
       // shape.setColor(Color.RED);
        shape.setColor(ContextCompat.getColor(this, R.color.orange));
    }

}
