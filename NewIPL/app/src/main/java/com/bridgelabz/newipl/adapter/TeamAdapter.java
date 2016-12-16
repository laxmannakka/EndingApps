package com.bridgelabz.newipl.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgelabz.newipl.R;
import com.bridgelabz.newipl.utility.ImageDownloaderInterface;
import com.bridgelabz.newipl.utility.Imagedownload;
import com.bridgelabz.newipl.model.TeamsModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by bridgeit007 on 22/11/16.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    List<TeamsModel> listofTeams;
    Context mContext;

    public TeamAdapter(List<TeamsModel> listofTeams, Context mContext) {
        this.listofTeams = listofTeams;
        this.mContext = mContext;
    }

    @Override
    public TeamAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle, parent, false);
        return new MyViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(final TeamAdapter.MyViewHolder holder, int position) {
        TeamsModel model = listofTeams.get(position);
        holder.ownerName.setText(model.getOwner());
        holder.teamName.setText(model.getTeamname());

        Imagedownload.imageDownload(model.getUrl(), new ImageDownloaderInterface() {

            @Override
            public void imagaeDownloded(Uri uri) {
            //    Picasso.with(mContext).load(uri).placeholder(R.mipmap.ic_launcher).fit().into(holder.imageView);
                Glide
                        .with(mContext)
                        .load(uri)
                        .placeholder(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                         // can also be a drawable
                        .into(holder.imageView);
            }
        });
        if (position % 2 == 0) {
            Animation slideLtoR = AnimationUtils.loadAnimation(mContext, R.anim.sliderighttoleft1);
            holder.itemView.startAnimation(slideLtoR);
          //  setFadeAnimation(holder.itemView);

        } else {
            Animation slideLtoR = AnimationUtils.loadAnimation(mContext, R.anim.slidelefttoright);
            holder.itemView.startAnimation(slideLtoR);
          //  setFadeAnimation(holder.itemView);

        }
    }

    @Override
    public int getItemCount() {
        return listofTeams.size();
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(2000);
        view.startAnimation(anim);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ownerName, teamName;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ownerName = (TextView) itemView.findViewById(R.id.setownername);
            teamName = (TextView) itemView.findViewById(R.id.setteamname);
            imageView = (ImageView) itemView.findViewById(R.id.logoteam);
        }
    }
}