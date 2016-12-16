package com.bridgelabz.effectsinandroid;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.RippleDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mButton,mButton2,mButton3;
    Toolbar mToolbar;
    private RippleDrawable mRippleDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.placeholder);
        mButton2=(Button)findViewById(R.id.heart);
        mButton3 =(Button)findViewById(R.id.collapsingtoolbar);
        mToolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");





        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent placeholer = new Intent (MainActivity.this,PlaceHolderActivity.class);
                startActivity(placeholer);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent heartTransition = new Intent(MainActivity.this,HeartTransitionActivity.class);
                startActivity(heartTransition);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item:
                Search obj = new Search();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.activity_main, obj);
                ft.addToBackStack(null);//add the transaction to the back stack so the user can navigate back
                ft.commit();
        }

        return super.onOptionsItemSelected(item);
    }
}
