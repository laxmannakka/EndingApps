package com.bridgelabz.bingogame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

/**
 * Created by bridgeit007 on 16/11/16.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread thread;

    public GameView(Context context) {
        super(context);


    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);

    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d("Bingogame", "Surface created Success fully");
        thread = new GameThread(surfaceHolder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
        Log.d("Bingogame", "Surface changeddddddddddd Success fully");
        thread.setSurfaceSize(width, height);
        thread.doStart();
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.i("Bingogame", "Surface Destroyed Success fully");
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        int x = (int) event.getX();
        int y = (int) event.getY();
        thread.onTouch(event.getAction(), x, y);
        return true;
    }

}
