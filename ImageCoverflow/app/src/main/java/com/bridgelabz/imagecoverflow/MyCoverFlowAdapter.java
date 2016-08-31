package com.bridgelabz.imagecoverflow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class MyCoverFlowAdapter extends CoverFlowAdapter {

    private boolean dataChanged;

    public MyCoverFlowAdapter(Context context) {

        image1 = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.background_img);

        image2 = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ic_no_internet);
    }

    public void changeBitmap() {
        dataChanged = true;

        notifyDataSetChanged();
    }

    private Bitmap image1 = null;

    private Bitmap image2 = null;

    @Override
    public int getCount() {
        return dataChanged ? 3 : 8;
    }

    @Override
    public Bitmap getImage(final int position) {
        return (dataChanged && position == 0) ? image2 : image1;
    }
}
