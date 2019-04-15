package com.example.tonyyoung.find;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;

public class ZoomDragLayout extends FrameLayout implements ScaleGestureDetector.OnScaleGestureListener {

    private static final String name = "ZoomLayout";

    //three modes for different gestures
    private enum Mode {
        NONE,
        DRAG,
        ZOOM
    }

    private static final float minZoom = 1.0f; //the minimum zoom
    private static final float maxZoom = 4.0f; //maximum can be 4x
    private Mode mode = Mode.NONE; //initialise as NONE mode
    private float scale = 1.0f;
    private float lastScaleFactor = 0f;
    // How much to translate the canvas
    private float dx = 0f;
    private float dy = 0f;
    private float prev_dx = 0f;
    private float prev_dy = 0f;
    // Where the finger first  touches the screen
    private float start_x = 0f;
    private float start_y = 0f;

    public ZoomDragLayout(Context context) {
        super(context);
        init(context);
    }

    public ZoomDragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ZoomDragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context){
        final ScaleGestureDetector scaleDetector = new ScaleGestureDetector(context, this);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        Log.i(name, "DOWN");
                        if (scale > minZoom) {
                            mode = Mode.DRAG;
                            start_x = motionEvent.getX() - prev_dx;
                            start_y = motionEvent.getY() - prev_dy;
                        }
                        break;
                    //drag movement
                    case MotionEvent.ACTION_MOVE:
                        if (mode == Mode.DRAG) {
                            dx = motionEvent.getX() - start_x;
                            dy = motionEvent.getY() - start_y;
                        }
                        break;

                    case MotionEvent.ACTION_POINTER_DOWN:
                        mode = Mode.ZOOM;
                        break;
                    //fingers off screen
                    case MotionEvent.ACTION_POINTER_UP:
                        mode = Mode.DRAG;
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.i(name, "UP");
                        mode = Mode.NONE;
                        prev_dx = dx;
                        prev_dy = dy;
                        break;
                }
                scaleDetector.onTouchEvent(motionEvent);

                if ((mode == Mode.DRAG && scale >= minZoom) || mode == Mode.ZOOM) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    float max_dx = ((child().getWidth() - (child().getWidth() / scale)) / 2) * scale;
                    float max_dy = ((child().getHeight() - (child().getHeight() / scale))/ 2) * scale;
                    dx = Math.min(Math.max(dx, -max_dx), max_dx);
                    dy = Math.min(Math.max(dy, -max_dy), max_dy);
                    Log.i(name, "Width: " + child().getWidth() + ", scale " + scale + ", dx " + dx
                            + ", max " + max_dx);
                    scale_and_translation();
                }
                return true;
            }
        });
    }


    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        float scaleFactor = detector.getScaleFactor();
        Log.i(name, "onScale" + scaleFactor);
        if (lastScaleFactor == 0 || (Math.signum(scaleFactor) == Math.signum(lastScaleFactor))) {
            scale *= scaleFactor;
            scale = Math.max(minZoom, Math.min(scale, maxZoom));
            lastScaleFactor = scaleFactor;
        } else {
            lastScaleFactor = 0;
        }
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Log.i(name, "onScaleBegin");
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        Log.i(name, "onScaleEnd");
    }

    private void scale_and_translation() {
        child().setScaleX(scale);
        child().setScaleY(scale);
        child().setTranslationX(dx);
        child().setTranslationY(dy);
    }

    private View child() {
        return getChildAt(0);
    }
}
