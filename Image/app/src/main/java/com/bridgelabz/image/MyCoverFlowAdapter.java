package com.bridgelabz.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bridgeit007 on 17/8/16.
 */

public class MyCoverFlowAdapter extends CoverFlowAdapter  {
    private boolean dataChanged;

    public MyCoverFlowAdapter(Context context) {

        image.add( BitmapFactory.decodeResource(context.getResources(), R.drawable.background_img));
        image.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.images));
        image.add (BitmapFactory.decodeResource(context.getResources(),R.drawable.background));
        image.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.chat_background));
        image.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.delhi));
        image.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.abcd));

    }

    public void changeBitmap() {
        dataChanged = true;

        notifyDataSetChanged();
    }

    /*private Bitmap image[]= new Bitmap[6];*/

    ArrayList<Bitmap> image = new ArrayList<>();
    /*private Bitmap image1 = null;

    private Bitmap image2 = null;

    private Bitmap image3 =null;
*/
    @Override
    public int getCount() {
       // return dataChanged ? 3:8;
        return image.size();
    }

    @Override
    public Bitmap getImage(final int position) {
        //return (dataChanged && position == 0) ? image2 : image1;
        return  image.get(position);
    }
}
