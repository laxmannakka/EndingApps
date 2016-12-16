package com.bridgelabz.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Martin Appl tried this
 * */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CoverFlowCarousel carousel = (CoverFlowCarousel)findViewById(R.id.mycoverflow);
        final MyAdapter adapter = new MyAdapter();
        carousel.setAdapter(adapter);
        carousel.setSelection(adapter.getCount()/2); //adapter.getCount()-1
        //carousel.setSlowDownCoefficient(1);
        carousel.setSpacing(0.5f);


    }


    private class MyAdapter extends BaseAdapter {
        private int[] mResourceIds = {R.drawable.appystore, R.drawable.background, R.drawable.bbbb, R.drawable.images,
                R.drawable.appystore};

        private int mCount = mResourceIds.length ;

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public Object getItem(int position) {
            return mResourceIds[position % mResourceIds.length];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            MyFrame v;
            if (convertView == null) {
                v = new MyFrame(MainActivity.this);
            } else {
                v = (MyFrame) convertView;
            }

            v.setImageResource(mResourceIds[position % mResourceIds.length]);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "clicked position:" + position, Toast.LENGTH_SHORT).show();
                }
            });


            return v;
        }

        public void addView() {
            mCount++;
            notifyDataSetChanged();
        }

    }


        public static class MyFrame extends FrameLayout {
            private ImageView mImageView;

            public void setImageResource(int resId){
                mImageView.setImageResource(resId);
            }

            public MyFrame(Context context) {
                super(context);

                mImageView = new ImageView(context);
                mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                addView(mImageView);

                setBackgroundColor(Color.WHITE);
                setSelected(false);
            }

            @Override
            public void setSelected(boolean selected) {
                super.setSelected(selected);

                if(selected) {
                    mImageView.setAlpha(1.0f);
                } else {
                    mImageView.setAlpha(0.5f);
                }
            }
        }
    }




