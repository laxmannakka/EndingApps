package com.bridgelabz.effectsinandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by bridgeit007 on 22/11/16.
 */

public class Search extends Fragment {
    View mView;
    Toolbar mToolbar;
    ImageView mImageview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.hearttransition, container, false);
        mToolbar = (Toolbar) mView.findViewById(R.id.fragment);
        mImageview = (ImageView) mView.findViewById(R.id.imageview);
        mToolbar.setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Animation slideLtoR = AnimationUtils.loadAnimation(mView.getContext(), R.anim.sliderighttoleft1);
                mToolbar.startAnimation(slideLtoR);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation topTtoB = AnimationUtils.loadAnimation(mView.getContext(), R.anim.slideintop);
                mToolbar.startAnimation(topTtoB);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return mView;
    }
}
