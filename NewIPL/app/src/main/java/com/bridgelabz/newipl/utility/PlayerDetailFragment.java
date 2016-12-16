package com.bridgelabz.newipl.utility;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridgelabz.newipl.R;

/**
 * Created by bridgeit007 on 1/12/16.
 */

public class PlayerDetailFragment extends Fragment{

    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.zoomintransition, container, false);
        return mView;
    }
}
