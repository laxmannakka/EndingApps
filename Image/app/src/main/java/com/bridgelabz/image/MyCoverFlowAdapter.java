package com.bridgelabz.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bridgeit007 on 17/8/16.
 */

public class MyCoverFlowAdapter extends CoverFlowAdapter  {
    private boolean dataChanged;
    LayoutInflater inflater;

    Context context;
    public MyCoverFlowAdapter(Context context) {
        this.context=context;
        inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.custom_layout,null);

        image.add(getScreenViewBitmap(view,R.drawable.images));
        image.add(getScreenViewBitmap(view,R.drawable.background));
        image.add(getScreenViewBitmap(view,R.drawable.chat_background));
        image.add(getScreenViewBitmap(view,R.drawable.delhi));
        image.add(getScreenViewBitmap(view,R.drawable.abcd));

    }

    public  Bitmap getScreenViewBitmap(final View view,int drawable) {
        view.setDrawingCacheEnabled(true);

        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);

        imageView.setImageDrawable(context.getResources().getDrawable(drawable));
        view.buildDrawingCache(true);
        Bitmap b = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false); // clear drawing cache

        return b;
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
