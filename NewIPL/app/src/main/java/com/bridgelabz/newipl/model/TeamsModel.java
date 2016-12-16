package com.bridgelabz.newipl.model;

import android.widget.ImageView;

/**
 * Created by bridgeit007 on 22/11/16.
 */

public class TeamsModel {
    String teamname;
    String owner;
    String url;
    ImageView logo;

    public TeamsModel(String teamname, String url, String ownername){
        this.teamname=teamname;
        this.url=url;
        this.owner=ownername;
    }

    public TeamsModel() {
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ImageView getLogo() {
        return logo;
    }

    public void setLogo(ImageView logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}