package com.hbwang.widget.shadowview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;


import com.hbwang.hbwangframwork.R;

import java.util.ArrayList;
import java.util.List;



/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/9/9-10:00
 */
public class ShadowView extends View {
    int lastX;
    int lastY;

    public float currentX = getWidth() / 2;
    public float currentY = getHeight() / 2;
    private Paint mOutCirclePaint;
    private Paint mCirclePaint;
    private Paint mIconPaint;
    private Path path;
    private Path mPath;

    private LineElement mCurrentLine = null;
    private List<LineElement> mLines = null;
    private float mLaserX = 0;
    private float mLaserY = 0;
    final Paint mPaint = new Paint();
    private int mWidth = 0;
    private int mHeight = 0;
    private long mElapsed = 10;
    private float mStrokeWidth = 20;
    private float mCircleRadius = 10;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            ShadowView.this.invalidate();
        }
    };

    private void initialize(Context context){
        mStrokeWidth = convertDipToPx(context, 22);
        mCircleRadius = convertDipToPx(context, 50);
        mPaint.setARGB(255, 255, 0, 0);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(0);
        mPaint.setColor(Color.TRANSPARENT);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    public static float convertDipToPx(Context context, float fDip) {
        float fPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, fDip,
                context.getResources().getDisplayMetrics());
        return fPx;
    }

    @Override
    protected void onSizeChanged (int w, int h, int oldw, int oldh){
        mWidth = w;
        mHeight = h;
        adjustLasterPosition();
    }

    private void adjustLasterPosition(){
        if(mLaserX - mCircleRadius < 0) mLaserX = mCircleRadius;
        else if(mLaserX + mCircleRadius > mWidth) mLaserX = mWidth - mCircleRadius;
        if(mLaserY - mCircleRadius < 0) mLaserY = mCircleRadius;
        else if(mLaserY + mCircleRadius > mHeight) mLaserY = mHeight - mCircleRadius;
    }
    private void updateLaserPosition(float x, float y){
        mLaserX = x;
        mLaserY = y;
        adjustLasterPosition();
    }

    public ShadowView(Context context) {
        super(context);
        initPaint();
        initialize(context);
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        initialize(context);
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        initialize(context);
    }


    private void initPaint() {
        //画外侧圆球边界画笔
        mOutCirclePaint = new Paint();
        //设置画笔粗细
        mOutCirclePaint.setStrokeWidth(150);
        //画笔属性是空心圆
        mOutCirclePaint.setStyle(Paint.Style.STROKE);

        mOutCirclePaint.setColor(this.getResources().getColor(R.color.mOutCirclePaint));

//        //画内侧圆球边界画笔
//        mInCirclePaint = new Paint();
//        //设置画笔粗细
//        mInCirclePaint.setStrokeWidth(8);
//        //画笔属性是空心圆
//        mInCirclePaint.setStyle(Paint.Style.STROKE);


        //画圆球画笔
        mCirclePaint = new Paint();


        //手势转动icon
        mIconPaint = new Paint();


        mPath = new Path();
        mPath.addCircle(getWidth() / 2, getHeight() / 2, 300, Path.Direction.CW);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawCircle(canvas);

        drawImg(canvas);
        initAnimation(canvas);

    }
    private boolean isValidLine(float x1, float y1, float x2, float y2){
        return Math.abs(x1 - x2) > 1 || Math.abs(y1 - y2) > 1;
    }

    private void initAnimation(Canvas canvas) {
        //canvas.drawText("ABCDE", 10, 16, mPaint);
        mElapsed = SystemClock.elapsedRealtime();

        if(mLines != null) {
            updatePaths();
            for (LineElement e : mLines) {
                if(e.mStartX < 0 || e.mEndY < 0 || e.mPath.isEmpty()) continue;
                //canvas.drawLine(e.mStartX, e.mStartY, e.mEndX, e.mEndY, e.mPaint);
                canvas.drawPath(e.mPath, e.mPaint);
            }
            compactPaths();
        }
        canvas.drawCircle(mLaserX, mLaserY, mCircleRadius, mPaint);
    }

    private void drawImg(Canvas canvas) {
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.park_icon_control_move, null)
                ,  currentX == 0 ?getWidth()/2 -50:currentX, currentY== 0 ?getHeight()/2-50:currentY, mCirclePaint);
    }

    private void drawCircle(Canvas canvas) {
        //参数分别是：圆心坐标，半径 ，所使用的画笔
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 300, mOutCirclePaint);
    }

    /**
     * 定义圆球运行轨迹
     */
    private void drawCirclePath() {


    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int viewIn = isViewIn(event);
        if (viewIn < 400 && viewIn > 200) {
            Log.d("CarParkingView", "viewIn:" + viewIn);
            this.currentX = event.getX()-50;
            this.currentY = event.getY()-50;
            //重绘小球
            this.invalidate();




        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();
        if(action == MotionEvent.ACTION_UP){// end one line after finger release
            if(isValidLine(mCurrentLine.mStartX, mCurrentLine.mStartY, x, y)){
                mCurrentLine.mEndX = x;
                mCurrentLine.mEndY = y;
                addToPaths(mCurrentLine);
            }
            //mCurrentLine.updatePathPoints();
            mCurrentLine = null;
            updateLaserPosition(x, y);
            invalidate();
            return true;
        }

        if(action == MotionEvent.ACTION_DOWN){
            mLines = null;
            mCurrentLine = new LineElement(mStrokeWidth);
            mCurrentLine.mStartX = x;
            mCurrentLine.mStartY = y;
            updateLaserPosition(x, y);
            return true;
        }

        if(action == MotionEvent.ACTION_MOVE) {
            if (mCurrentLine == null) {
                mLines = null;
                mCurrentLine = new LineElement(mStrokeWidth);
                mCurrentLine.mStartX = x;
                mCurrentLine.mStartY = y;
                updateLaserPosition(x, y);
                return true;
            }
            if(isValidLine(mCurrentLine.mStartX, mCurrentLine.mStartY, x, y)){
                mCurrentLine.mEndX = x;
                mCurrentLine.mEndY = y;
                addToPaths(mCurrentLine);

                mCurrentLine = new LineElement(mStrokeWidth);

                mCurrentLine.mStartX = x;
                mCurrentLine.mStartY = y;

                updateLaserPosition(x, y);
            }else{
                //do nothing, wait next point
            }
        }

        if(mHandler.hasMessages(1)){
            mHandler.removeMessages(1);
        }
        Message msg = new Message();
        msg.what = 1;
        mHandler.sendMessageDelayed(msg, 0);

        }

        return true;
    }
    private void addToPaths(LineElement element){
        if(mLines == null) {
            mLines = new ArrayList<LineElement>() ;
        }
        mLines.add(element);
    }

    private void updatePaths() {
        int size = mLines.size();
        if (size == 0) return;


        LineElement line = null;
        int j = 0;
        for (; j < size; j++) {
            line = mLines.get(j);
            if (line.updatePathPoints()) break;
        }

        if (j == size) {
            mLines.clear();
            return;
        } else {
            for (j--; j >= 0; j--) {
                mLines.remove(0);
            }
        }

        line.updatePath();
        size = mLines.size();

        LineElement lastLine = null;
        for (int i = 1; i < size; i++) {
            line = mLines.get(i);
            if (line.updatePathPoints()){
                if (lastLine == null) {
                    lastLine = mLines.get(i - 1);
                }
                line.updatePathWithStartPoints(lastLine.mPoints[3], lastLine.mPoints[2]);
                lastLine = null;
            }else{
                mLines.remove(i);
                size = mLines.size();
            }
        }
    }

    public void compactPaths(){

        int size = mLines.size();
        int index = size - 1;
        if(size == 0) return;
        int baseAlpha = 255 - LineElement.ALPHA_STEP;
        int itselfAlpha;
        LineElement line;
        for(; index >=0 ; index--, baseAlpha -= LineElement.ALPHA_STEP){
            line = mLines.get(index);
            itselfAlpha = line.mPaint.getAlpha();
            if(itselfAlpha == 255){
                if(baseAlpha <= 0 || line.mPathWidth < 1){
                    ++index;
                    break;
                }
                line.setAlpha(baseAlpha);
            }else{
                itselfAlpha -= LineElement.ALPHA_STEP;
                if(itselfAlpha <= 0 || line.mPathWidth < 1){
                    ++index;
                    break;
                }
                line.setAlpha(itselfAlpha);
            }
        }

        if(index >= size){
            // all sub-path should disappear
            mLines = null;
        }
        else if(index >= 0){
            //Log.i(TAG, "compactPaths from " + index + " to " + (size - 1));
            mLines = mLines.subList(index, size);
        }else{
            // no sub-path should disappear
        }

        long interval = 40 - SystemClock.elapsedRealtime() + mElapsed;
        if(interval < 0) interval = 0;
        Message msg = new Message();
        msg.what = 1;
        mHandler.sendMessageDelayed(msg, interval);
    }
    private int isViewIn(MotionEvent event) {
        lastX = (int) event.getX();
        lastY = (int) event.getY();
        //圆心坐标
        int vCenterX = getWidth()/2;
        int vCenterY = getHeight()/2;
        //点击位置x坐标与圆心的x坐标的距离
        int distanceX = Math.abs(vCenterX-lastX);
        //点击位置y坐标与圆心的y坐标的距离
        int distanceY = Math.abs(vCenterY-lastY);
        //点击位置与圆心的直线距离
        int distanceZ = (int) Math.sqrt(Math.pow(distanceX,2)+Math.pow(distanceY,2));
        return distanceZ;
    }
}
