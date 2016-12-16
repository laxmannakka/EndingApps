package com.bridgelabz.effectsinandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PlaceHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_holder);
        ListView listView = (ListView) findViewById(R.id.listview);
        String urlArray[] = {"http://www.planwallpaper.com/static/images/125146_nature-flowers-1600x1200-wallpaper.jpg",
                "http://www.planwallpaper.com/static/images/7033124-nature-flowers.jpg",
                "http://www.planwallpaper.com/static/images/s7.jpg",
                "http://www.planwallpaper.com/static/images/nature-flowers_00273585.jpg"};
            PlaceHolderAdapter adapter = new PlaceHolderAdapter(PlaceHolderActivity.this,urlArray);
        listView.setAdapter(adapter);

    }

}

