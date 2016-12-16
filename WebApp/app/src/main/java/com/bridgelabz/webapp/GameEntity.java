package com.bridgelabz.webapp;

/**
 * Created by bridgeit007 on 7/9/16.
 */

public class GameEntity {

    public String url;
    public String titleResId;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitleResId() {
        return titleResId;
    }

    public void setTitleResId(String titleResId) {
        this.titleResId = titleResId;
    }

    public GameEntity(String url, String titleResId) {
        this.url = url;
        this.titleResId = titleResId;
    }
}
