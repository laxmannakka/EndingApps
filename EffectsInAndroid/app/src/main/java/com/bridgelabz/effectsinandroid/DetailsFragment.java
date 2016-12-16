package com.bridgelabz.effectsinandroid;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by bridgeit007 on 21/11/16.
 */

public class DetailsFragment extends Fragment {
    View mView;
    Toolbar mToolbar;
    LinearLayout mLineralayout;
    Button mButtonBAck;
    boolean lax = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        mView = inflater.inflate(R.layout.hearttransition, container, false);
        mToolbar = (Toolbar) mView.findViewById(R.id.fragment);
        mLineralayout = (LinearLayout) mView.findViewById(R.id.transition);
        final ImageView image = (ImageView) mView.findViewById(R.id.imageview);
        ImageView back =(ImageView)mView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),HeartTransitionActivity.class);
                startActivity(intent);
            }
        });
        // setting the animation from utils
        Animation slideLtoR = AnimationUtils.loadAnimation(mView.getContext(), R.anim.sliderighttoleft1);
        mToolbar.startAnimation(slideLtoR);
        Animation imageLtoR = AnimationUtils.loadAnimation(mView.getContext(), R.anim.sliderighttoleft2);
        image.startAnimation(imageLtoR);
        return mView; // returning the view
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.listofoptions, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}

