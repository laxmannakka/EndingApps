package com.bridgelabz.effectsinandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * Created by bridgeit007 on 21/11/16.
 */

public class PlaceHolderAdapter extends BaseAdapter {

    Context mContext;
   String [] mUrlList = new String [4];
    LayoutInflater inflater;


    public PlaceHolderAdapter(Context mContext, String[] mUrlList) {
        this.mContext = mContext;
        this.mUrlList = mUrlList;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mUrlList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.placeholderitem,viewGroup,false);
        ImageView imageView;
        imageView = (ImageView) view.findViewById(R.id.image);
        Picasso.with(mContext).load(mUrlList[i]).placeholder(R.mipmap.ic_launcher).centerCrop()
                .fit().into(imageView);
    /*    Glide.with(mContext)
                .load(mUrlList[i])
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .into(imageView);*/

        return view;
    }
}
