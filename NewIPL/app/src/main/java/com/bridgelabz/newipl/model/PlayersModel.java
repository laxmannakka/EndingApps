package com.bridgelabz.newipl.model;

import android.widget.ImageView;

/**
 * Created by bridgeit007 on 23/11/16.
 */

public class PlayersModel {
    private String player_name;

    private String player_img_url;

    private String player_role;

    private String player_batting_style;

    private String player_bowling_style;

    private String player_nationality;

    private String player_dob;
    private ImageView image;

    public PlayersModel() {
    }

    public PlayersModel(String player_name, String player_img_url, String player_role, String player_batting_style, String player_bowling_style, String player_nationality, String player_dob) {
        this.player_name = player_name;
        this.player_img_url = player_img_url;
        this.player_role = player_role;
        this.player_batting_style = player_batting_style;
        this.player_bowling_style = player_bowling_style;
        this.player_nationality = player_nationality;
        this.player_dob = player_dob;
    }
    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_img_url() {
        return player_img_url;
    }

    public void setPlayer_img_url(String player_img_url) {
        this.player_img_url = player_img_url;
    }

    public String getPlayer_role() {
        return player_role;
    }

    public void setPlayer_role(String player_role) {
        this.player_role = player_role;
    }

    public String getPlayer_batting_style() {
        return player_batting_style;
    }

    public void setPlayer_batting_style(String player_batting_style) {
        this.player_batting_style = player_batting_style;
    }

    public String getPlayer_bowling_style() {
        return player_bowling_style;
    }

    public void setPlayer_bowling_style(String player_bowling_style) {
        this.player_bowling_style = player_bowling_style;
    }

    public String getPlayer_nationality() {
        return player_nationality;
    }

    public void setPlayer_nationality(String player_nationality) {
        this.player_nationality = player_nationality;
    }

    public String getPlayer_dob() {
        return player_dob;
    }

    public void setPlayer_dob(String player_dob) {
        this.player_dob = player_dob;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
