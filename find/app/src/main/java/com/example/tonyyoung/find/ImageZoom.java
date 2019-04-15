package com.example.tonyyoung.find;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ImageZoom extends android.support.v7.widget.AppCompatImageView implements View.OnTouchListener {

    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();

    // create different states to different gestures：
    private static final int NONE = 0; // when fingers off screen
    private static final int DRAG = 1; // when drag
    private static final int ZOOM = 2; //when zoom in and out
    private int currentMode = NONE; //initialise as NONE mode

    private PointF startPoint = new PointF(); //start point
    private PointF midPoint = new PointF();  //the mid point
    private float currentDistance = 1f; //current distance between fingers


    public ImageZoom(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public ImageZoom(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public ImageZoom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            // when fingers off screen
            case MotionEvent.ACTION_UP:
                currentMode = NONE;
                break;

            case MotionEvent.ACTION_POINTER_UP:
                currentMode = NONE;
                break;

            // when single finger is down
            case MotionEvent.ACTION_DOWN:
                matrix.set(view.getImageMatrix());
                savedMatrix.set(matrix);
                startPoint.set(event.getX(), event.getY());
                currentMode = DRAG;
                break;

            // when two fingers down
            case MotionEvent.ACTION_POINTER_DOWN:
                currentDistance = getDistance(event);
                if (currentDistance > 10f) {
                    savedMatrix.set(matrix);
                    midPoint = getMidpoint(event);
                    currentMode = ZOOM;
                }
                break;

            // drag mode
            case MotionEvent.ACTION_MOVE:
                if (currentMode == DRAG) {
                    // when drag with one finger
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - startPoint.x, event.getY() - startPoint.y);
                } else if (currentMode == ZOOM) {
                    float d = getDistance(event);
                    if (d > 10f) {
                        matrix.set(savedMatrix);
                        float scale = d / currentDistance;
                        matrix.postScale(scale, scale, midPoint.x, midPoint.y);
                    }
                }
                break;
        }
        view.setImageMatrix(matrix);
        return true;
    }

    //get distance of two fingers
    private float getDistance(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    //calculate the mid point of two fingers
    private PointF getMidpoint(MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        return new PointF(x / 2, y / 2);
    }
}
