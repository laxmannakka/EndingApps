package com.bridgelabz.appystore.viewmodel;

import android.graphics.Bitmap;

/**
 * Created by bridgeit007 on 19/8/16.
 */

public class CategoryViewmodel {
    String title;
    Bitmap image;

    public CategoryViewmodel(String title, Bitmap image) {
        this.title=title;
        this.image=image;
    }
}
