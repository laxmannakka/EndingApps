package com.bridgelabz.casosal2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FancyCoverFlow fancyCoverFlow = (FancyCoverFlow) findViewById(R.id.coverflow);
        fancyCoverFlow.setAdapter(new ViewGroupExampleAdapter());
        fancyCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"position"+i,Toast.LENGTH_LONG).show();
            }
        });
    }

    // =============================================================================
    // Private classes
    // =============================================================================

    private static class ViewGroupExampleAdapter extends FancyCoverFlowAdapter {

        // =============================================================================
        // Private members
        // =============================================================================

        private int[] images = {R.drawable.appystore, R.drawable.background_img, R.drawable.bbbb, R.drawable.appystore, R.drawable.background_img, R.drawable.bbbb,R.drawable.song,R.drawable.appystore};

        // =============================================================================
        // Supertype overrides
        // =============================================================================

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Integer getItem(int i) {
            return images[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getCoverFlowItem(int i, View reuseableView, ViewGroup viewGroup) {
            CustomViewGroup customViewGroup = null;

            if (reuseableView != null) {
                customViewGroup = (CustomViewGroup) reuseableView;
            } else {
                customViewGroup = new CustomViewGroup(viewGroup.getContext());
                customViewGroup.setLayoutParams(new FancyCoverFlow.LayoutParams(500, 1000));
            }

            customViewGroup.getImageView().setImageResource(this.getItem(i));
            customViewGroup.getTextView().setText(String.format("Item %d", i));

            return customViewGroup;
        }


        private static class CustomViewGroup extends LinearLayout {

            // =============================================================================
            // Child views
            // =============================================================================

            private TextView textView;

            private ImageView imageView;

            private Button button;

            // =============================================================================
            // Constructor
            // =============================================================================

            private CustomViewGroup(Context context) {
                super(context);

                this.setOrientation(VERTICAL);

                this.textView = new TextView(context);
                this.imageView = new ImageView(context);
                this.button = new Button(context);

                LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                this.textView.setLayoutParams(layoutParams);
                this.imageView.setLayoutParams(layoutParams);
                this.button.setLayoutParams(layoutParams);

                this.textView.setGravity(Gravity.CENTER);

                this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                this.imageView.setAdjustViewBounds(true);

                this.button.setText("Goto GitHub");
                this.button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://davidschreiber.github.com/FancyCoverFlow"));
                        view.getContext().startActivity(i);
                    }
                });

                this.addView(this.textView);
                this.addView(this.imageView);
                this.addView(this.button);
            }

            // =============================================================================
            // Getters
            // =============================================================================

            private TextView getTextView() {
                return textView;
            }

            private ImageView getImageView() {
                return imageView;
            }
        }
    }
}

