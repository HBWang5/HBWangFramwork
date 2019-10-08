package com.hbwang.widget.shadowview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;



/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/9/9-10:00
 */
public class ShadowLayout extends ShadowRelativeLayout {
    public ShadowLayout(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return true;
    }
}
