package com.bridgelabz.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String VIEW_LOG_TAG = "error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = LayoutInflater.from(this).inflate(R.layout.activity_main,
                null, false);
        setContentView(v);

        final TextView textView = (TextView) findViewById(R.id.text);

        final CoverFlowView<MyCoverFlowAdapter> mCoverFlowView = (CoverFlowView<MyCoverFlowAdapter>) findViewById(R.id.coverflow);

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
                        Toast.makeText(MainActivity.this,"Position"+position,Toast.LENGTH_SHORT).show();
                        textView.setText("laxlal"+position);
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

     /*   findViewById(R.id.change_bitmap_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeBitmap();
            }
        });*/
    }
}


