package com.bridgelabz.imagecoverflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    protected static final String VIEW_LOG_TAG = "CoverFlowDemo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = LayoutInflater.from(this).inflate(R.layout.activity_main,
                null, false);
        setContentView(v);

        final CoverFlowView<MyCoverFlowAdapter> mCoverFlowView = (CoverFlowView<MyCoverFlowAdapter>) findViewById(R.id.coverflow);
       /* CoverFlowView<MyCoverFlowAdapter> mCoverFlowView =
                (CoverFlowView<MyCoverFlowAdapter>) findViewById(R.id.coverflow);*/

        mCoverFlowView.setCoverFlowGravity(CoverFlowView.CoverFlowGravity.CENTER_VERTICAL);
        mCoverFlowView.setCoverFlowLayoutMode(CoverFlowView.CoverFlowLayoutMode.WRAP_CONTENT);
      //  mCoverFlowView.enableReflection(true);
        mCoverFlowView.setReflectionHeight(30);
        mCoverFlowView.setReflectionGap(20);
        //mCoverFlowView.enableReflectionShader(true);
        mCoverFlowView.setVisibleImage(5);

        final MyCoverFlowAdapter adapter = new MyCoverFlowAdapter(this);
        mCoverFlowView.setAdapter(adapter);
        mCoverFlowView
                .setCoverFlowListener(new CoverFlowView.CoverFlowListener<MyCoverFlowAdapter>() {

                    @Override
                    public void imageOnTop(
                            CoverFlowView<MyCoverFlowAdapter> view,
                            int position, float left, float top, float right,
                            float bottom) {
                        Log.e(VIEW_LOG_TAG, position + " on top!");
                    }

                    @Override
                    public void topImageClicked(
                            CoverFlowView<MyCoverFlowAdapter> view, int position) {
                        Log.e(VIEW_LOG_TAG, position + " clicked!");
                    }

                    @Override
                    public void invalidationCompleted() {

                    }
                });

        mCoverFlowView
                .setTopImageLongClickListener(new CoverFlowView.TopImageLongClickListener() {

                    @Override
                    public void onLongClick(int position) {
                        Log.e(VIEW_LOG_TAG, "top image long clicked == >"
                                + position);
                    }
                });

        findViewById(R.id.change_bitmap_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeBitmap();
            }
        });
    }
}

