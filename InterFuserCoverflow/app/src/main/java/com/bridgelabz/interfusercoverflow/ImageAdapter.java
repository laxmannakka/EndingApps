package com.bridgelabz.interfusercoverflow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by bridgeit007 on 10/9/16.
 */

public class ImageAdapter extends BaseAdapter {
    int mGalleryItemBackground;
    ArrayList<LIst> mData;
    private Context mContext;
    private FileInputStream fis;
    private Integer[] mImageIds = {
            R.drawable.appystore, R.drawable.appystore, R.drawable.appystore, R.drawable.appystore,
            R.drawable.images,
            R.drawable.images,
            R.drawable.images,
            R.drawable.images,
            R.drawable.images
    };

    private ImageView[] mImages;

    public ImageAdapter(Context context, ArrayList<LIst> mData) {

        this.mContext = context;
        this.mData = mData;
    }

   /* public ImageAdapter(Context c) {
        mContext = c;
        mImages = new ImageView[mImageIds.length];
    }*/


    public boolean createReflectedImages() {
        //The gap we want between the reflection and the original image
        final int reflectionGap = 4;


        int index = 0;
        for (int imageId : mImageIds) {
            Bitmap originalImage = BitmapFactory.decodeResource(Resources.getSystem(), imageId);
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();


            //This will not scale but will flip on the Y axis
            Matrix matrix = new Matrix();
            matrix.preScale(1, -1);

            //Create a Bitmap with the flip matrix applied to it.
            //We only want the bottom half of the image
            Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, height / 2, width, height / 2, matrix, false);


            //Create a new bitmap with same width but taller to fit reflection
            Bitmap bitmapWithReflection = Bitmap.createBitmap(width
                    , (height + height / 2), Bitmap.Config.ARGB_8888);

            //Create a new Canvas with the bitmap that's big enough for
            //the image plus gap plus reflection
            Canvas canvas = new Canvas(bitmapWithReflection);
            //Draw in the original image
            canvas.drawBitmap(originalImage, 0, 0, null);
            //Draw in the gap
            Paint deafaultPaint = new Paint();
            canvas.drawRect(0, height, width, height + reflectionGap, deafaultPaint);
            //Draw in the reflection
            canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

            //Create a shader that is a linear gradient that covers the reflection
            Paint paint = new Paint();
            LinearGradient shader = new LinearGradient(0, originalImage.getHeight(), 0,
                    bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff, 0x00ffffff,
                    Shader.TileMode.CLAMP);
            //Set the paint to use this shader (linear gradient)
            paint.setShader(shader);
            //Set the Transfer mode to be porter duff and destination in
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            //Draw a rectangle using the paint with our linear gradient
            canvas.drawRect(0, height, width,
                    bitmapWithReflection.getHeight() + reflectionGap, paint);

            ImageView imageView = new ImageView(mContext);
            imageView.setImageBitmap(bitmapWithReflection);
            imageView.setLayoutParams(new CoverFlow.LayoutParams(140, 200));
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            mImages[index++] = imageView;

        }
        return true;
    }

    public int getCount() {
        return mData.size();
        // return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      /*  //Use this code if you want to load from resources
        ImageView i = new ImageView(mContext);
        i.setImageResource(mImageIds[position]);
        i.setLayoutParams(new CoverFlow.LayoutParams(200, 200));
        i.setScaleType(ImageView.ScaleType.FIT_XY);

        //Make sure we set anti-aliasing otherwise we get jaggies
      *//*  BitmapDrawable drawable = (BitmapDrawable) i.getDrawable();
        drawable.setAntiAlias(true);*//*
        return i;
*/
        //return mImages[position];


        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.layout_bg, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) rowView.findViewById(R.id.imageview);
            viewHolder.text = (TextView) rowView.findViewById(R.id.textview);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

        holder.image.setImageResource(mData.get(position).getId());
        holder.text.setText(mData.get(position).getTitle());

        return rowView;
    }

    /**
     * Returns the size (0.0f to 1.0f) of the views
     * depending on the 'offset' to the center.
     */
    public float getScale(boolean focused, int offset) {
        /* Formula: 1 / (2 ^ offset) */
        return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
    }

    class ViewHolder {
        ImageView image;
        TextView text;
    }

}

