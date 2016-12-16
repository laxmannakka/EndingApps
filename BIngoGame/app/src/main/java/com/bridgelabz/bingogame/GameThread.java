package com.bridgelabz.bingogame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * Created by bridgeit007 on 16/11/16.
 */

public class GameThread extends Thread {
    Paint background;
    SurfaceHolder mSurfaceHolder;
    private int mCanvasWidth;
    private int mCanvasHeight;
    private boolean mRun = false;
    private boolean mTouched = false;
    private int mTouchX;
    private int mTouchY;
    private Blip[] mBlips;
    int numbers=0;
    private long mLastTime;
    private int mFrameCount;
    String TAG ="laxman";

    public GameThread(SurfaceHolder surfaceHolder) {
        background = new Paint();
        background.setColor(0xffeeeeec);
        mSurfaceHolder = surfaceHolder;

    }

    public void setSurfaceSize(int width, int height) {
        mCanvasWidth = width;
        mCanvasHeight = height;
    }

    public void doStart() {
        synchronized (mSurfaceHolder) {

            createBlips();

            mLastTime = System.currentTimeMillis();
            mFrameCount = 0;
            mRun = true;
        }
    }

    @Override
    public void run() {
        while(mRun) {
            long now = System.currentTimeMillis();

            Canvas c = null;
            try {
                c = mSurfaceHolder.lockCanvas();
                synchronized (mSurfaceHolder) {
                    updatePhysics();
                    updateScreen(c);
                }
            } finally {
                if (c != null) {
                    mSurfaceHolder.unlockCanvasAndPost(c);
                }
            }

            mFrameCount++;
            int delta = (int)(now - mLastTime);

            if (delta > 5000) {
                double deltaSeconds = delta / 1000.0;
                double fps = mFrameCount / deltaSeconds;
                Log.d(TAG, "FPS: " + fps + " average over " + deltaSeconds + " seconds.");

                mLastTime = System.currentTimeMillis();
                mFrameCount = 0;
            }
        }
    }

    public void createBlips() {
        // Switch to some type of list instead of array
        int num_blips = 50;
        mBlips = new Blip[num_blips + 1];

        for (int i = 0; i < mBlips.length - 1; i++) {
            mBlips[i] = new Blip(mCanvasWidth, mCanvasHeight);
        }
    }
    public void updatePhysics()
    {
        for (int i = 0; i < mBlips.length; i++) {
            if (mBlips[i] == null) continue; // Remove soon!
            mBlips[i].step(mBlips);
        }

    }

    public void updateScreen(Canvas canvas)
    {
        // Optimization: drawColor() ?
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(),
                background);

        for (int i = 0; i < mBlips.length; i++) {
            if (mBlips[i] == null) continue;

            // These paint objects should obviously be cached.
            Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
            foreground.setColor(mBlips[i].color);

            Path path = new Path();
            path.addCircle((int)mBlips[i].x, (int)mBlips[i].y, mBlips[i].radius, Path.Direction.CW);

            canvas.drawPath(path, foreground);
        }

        if (mTouched) {
            Log.d(TAG, "Drawing circle at " + mTouchX + "," + mTouchY);

            Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
            foreground.setColor(0x80729fcf);

            Paint stroke = new Paint(Paint.ANTI_ALIAS_FLAG);
            stroke.setColor(0x80204a87);
            stroke.setStyle(Paint.Style.STROKE);
            Log.d(TAG, "default stroke width: " + stroke.getStrokeWidth());
            stroke.setStrokeWidth(2);

            Path path = new Path();
            path.addCircle(mTouchX, mTouchY, 60, Path.Direction.CW);

           // canvas.drawPath(path, foreground);
         // canvas.drawPath(path, stroke);
        }
    }

    public void onTouch(int action, int x, int y)
    {
        synchronized (mSurfaceHolder) {

            if (action == MotionEvent.ACTION_UP) {
                Log.d(TAG, "ACTION_UP");
                Blip blip = new Blip();
                blip.x = x;
                blip.y = y;

                blip.explode();
                mBlips[mBlips.length-1] = blip;
                numbers++;

                mTouched = false; // Work-around to not show the touch circle
            } else if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE) {
                mTouched = true;
                mTouchX = x;
                mTouchY = y;
            }
        }
    }

}
