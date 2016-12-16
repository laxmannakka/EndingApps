package com.bridgelabz.bingogame;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play = (Button) findViewById(R.id.button);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        Canvas canvas = new Canvas();
        paint.setColor(Color.RED);
        paint.setTextSize(20);
        canvas.drawPaint(paint);
        canvas.drawText("Some Text", 10, 25, paint);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  play = new Intent (MainActivity.this, GameActivity.class);
                startActivity(play);
            }
        });


    }
}
