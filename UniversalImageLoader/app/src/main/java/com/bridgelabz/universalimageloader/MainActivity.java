package com.bridgelabz.universalimageloader;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();
        ImageLoader.getInstance().init(config);

        String url = "http://st1.vchensubeswogfpjoq.netdna-cdn.com/wp-content/uploads/2014/05/UniversalImageLoader-620x405.png";
        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.bg)
                .showImageOnFail(R.drawable.bg)
                .showImageOnLoading(R.drawable.bg).build();




//initialize image view
        final ImageView imageView = (ImageView) findViewById(R.id.imageview);

//download and display image from url
       imageLoader.displayImage(url, imageView, options, new ImageLoadingListener() {
           @Override
           public void onLoadingStarted(String imageUri, View view) {

           }

           @Override
           public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

           }

           @Override
           public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
               Log.i("MainActivity.this", "onLoadingComplete: ..................");
           }

           @Override
           public void onLoadingCancelled(String imageUri, View view) {

           }
       });
/*imageLoader.loadImage(url,new SimpleImageLoadingListener(){
    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        super.onLoadingComplete(imageUri, view, loadedImage);
        imageView.setImageBitmap(loadedImage);
    }
});*/

    }
}
