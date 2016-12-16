package com.bridgelabz.effectsinandroid;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HeartTransitionActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_transition);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle("");
        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.listofoptions, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:

                Toast.makeText(getApplicationContext(), "meassage" + item, Toast.LENGTH_LONG).show();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                //ft.setCustomAnimations(R.anim.slidelefttoright, R.anim.sliderighttoleft1);

                DetailsFragment fragment = new DetailsFragment();
                ft.replace(R.id.activity_heart_transition, fragment);

                ft.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
