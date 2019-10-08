package com.hbwang.widget.shadowview;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Log;

import com.hbwang.api.base.app.ApiApplication;
import com.hbwang.hbwangframwork.R;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/9/9-16:18
 */
class LineElement {
    final static String TAG = "LineElement";
    static final public int ALPHA_STEP = 4;

    public LineElement(float pathWidth) {
        mPaint = new Paint();
        mPaint.setARGB(255, 255, 0, 0);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(0);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mPaint.setColor(ApiApplication.getApplication().getResources().getColor(R.color.path));
        mPaint.setStyle(Paint.Style.FILL);
        mPath = new Path();
        mPathWidth = pathWidth;
        for (int i = 0; i < mPoints.length; i++) {
            mPoints[i] = new PointF();
        }
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
    }

    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
        mPathWidth = (alpha * mPathWidth) / 255;
    }

    private boolean caculatePoints(float k, float b, float x1, float y1, float distance, PointF pt1, PointF pt2) {
        //point-k formula
        //  y= kx + b
        //distance formula of two points
        //  distance*distance = Math.pow((x - x1), 2) + Math.pow((y - y1), 2)
        //    |
        //    V
        //  ax*x + bx + c = 0;
        //    |
        //    V
        //  x = (-b +/- Math.sqrt( b*b - 4*a*c ) ) / (2*a)
        double a1 = Math.pow(k, 2) + 1;
        double b1 = 2 * k * (b - y1) - 2 * x1;
        double c1 = Math.pow(x1, 2) + Math.pow(b - y1, 2) - Math.pow(distance, 2);
        double criterion = Math.pow(b1, 2) - 4 * a1 * c1;
        if (criterion > 0) {
            criterion = Math.sqrt(criterion);
            pt1.x = (float) ((-b1 + criterion) / (2 * a1));
            pt1.y = k * pt1.x + b;
            pt2.x = (float) ((-b1 - criterion) / (2 * a1));
            pt2.y = k * pt2.x + b;
            return true;
        }
        return false;
    }

    private void swapPoint(PointF pt1, PointF pt2) {
        float t = pt1.x;
        pt1.x = pt2.x;
        pt2.x = t;
        t = pt1.y;
        pt1.y = pt2.y;
        pt2.y = t;
    }

    public boolean updatePathPoints() {
        float distance = mPathWidth / 2;
        if (Math.abs(mEndX - mStartX) < 1) {
            mPoints[0].x = mStartX + distance;
            mPoints[0].y = mStartY - distance;
            mPoints[1].x = mStartX - distance;
            mPoints[1].y = mPoints[0].y;
            mPoints[2].x = mPoints[1].x;
            mPoints[2].y = mEndY + distance;
            mPoints[3].x = mPoints[0].x;
            mPoints[3].y = mPoints[2].y;
        } else if (Math.abs(mEndY - mStartY) < 1) {
            mPoints[0].x = mStartX - distance;
            mPoints[0].y = mStartY - distance;
            mPoints[1].x = mPoints[0].x;
            mPoints[1].y = mStartY + distance;
            mPoints[2].x = mEndX + distance;
            mPoints[2].y = mPoints[1].y;
            mPoints[3].x = mPoints[2].x;
            mPoints[3].y = mPoints[0].y;
        } else {
            //point-k formula
            //y= kx + b
            float kLine = (mEndY - mStartY) / (mEndX - mStartX);
            float kVertLine = -1 / kLine;
            float b = mStartY - (kVertLine * mStartX);
            if (!caculatePoints(kVertLine, b, mStartX, mStartY, distance, mPoints[0], mPoints[1])) {
                String info = String.format(TAG, "startPt, criterion < 0, (%.2f, %.2f)-->(%.2f, %.2f), kLine - %.2f, kVertLine - %.2f, b - %.2f",
                        mStartX, mStartY, mEndX, mEndY, kLine, kVertLine, b);
                Log.i(TAG, info);
                return false;
            }
            b = mEndY - (kVertLine * mEndX);
            if (!caculatePoints(kVertLine, b, mEndX, mEndY, distance, mPoints[2], mPoints[3])) {
                String info = String.format(TAG, "endPt, criterion < 0, (%.2f, %.2f)-->(%.2f, %.2f), kLine - %.2f, kVertLine - %.2f, b - %.2f",
                        mStartX, mStartY, mEndX, mEndY, kLine, kVertLine, b);
                Log.i(TAG, info);
                return false;
            }
            //reorder points to unti-clockwise
            if (mStartX < mEndX) {
                if (mStartY < mEndY) {
                    if (mPoints[0].x < mPoints[1].x) {
                        swapPoint(mPoints[0], mPoints[1]);
                    }
                    if (mPoints[2].x > mPoints[3].x) {
                        swapPoint(mPoints[2], mPoints[3]);
                    }
                } else {
                    if (mPoints[0].x > mPoints[1].x) {
                        swapPoint(mPoints[0], mPoints[1]);
                    }
                    if (mPoints[2].x < mPoints[3].x) {
                        swapPoint(mPoints[2], mPoints[3]);
                    }
                }
            } else {
                if (mStartY < mEndY) {
                    if (mPoints[0].x < mPoints[1].x) {
                        swapPoint(mPoints[0], mPoints[1]);
                    }
                    if (mPoints[2].x > mPoints[3].x) {
                        swapPoint(mPoints[2], mPoints[3]);
                    }
                } else {
                    if (mPoints[0].x > mPoints[1].x) {
                        swapPoint(mPoints[0], mPoints[1]);
                    }
                    if (mPoints[2].x < mPoints[3].x) {
                        swapPoint(mPoints[2], mPoints[3]);
                    }
                }
            }
        }

        return true;
    }

    // for the first line
    public void updatePath() {
        //update path
        mPath.reset();
        mPath.moveTo(mPoints[0].x, mPoints[0].y);
        mPath.lineTo(mPoints[1].x, mPoints[1].y);
        mPath.lineTo(mPoints[2].x, mPoints[2].y);
        mPath.lineTo(mPoints[3].x, mPoints[3].y);
        mPath.close();
    }

    // for middle line
    public void updatePathWithStartPoints(PointF pt1, PointF pt2) {
        mPath.reset();
        mPath.moveTo(pt1.x, pt1.y);
        mPath.lineTo(pt2.x, pt2.y);
        mPath.lineTo(mPoints[2].x, mPoints[2].y);
        mPath.lineTo(mPoints[3].x, mPoints[3].y);
        mPath.close();
    }

    public float mStartX = -1;
    public float mStartY = -1;
    public float mEndX = -1;
    public float mEndY = -1;
    public Paint mPaint;
    public Path mPath;
    public PointF[] mPoints = new PointF[4]; //path's vertex
    float mPathWidth;
}

