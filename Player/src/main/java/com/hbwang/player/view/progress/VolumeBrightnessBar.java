package com.hbwang.player.view.progress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hbwang.player.R;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/19-11:22
 */
public class VolumeBrightnessBar extends View {


    private Paint mRoundRectPaint;               //圆角矩形边界画笔
    private Paint mPaintBitmap;         //图片
    private int style;
    private Paint mRoundRectFillPaint;
    private int percent = 50;
    private Paint mRoundRectBorderPaint;

    public VolumeBrightnessBar(Context context) {
        super(context);
        initBar();
    }

    public VolumeBrightnessBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initBar();
    }


    public VolumeBrightnessBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBar();
    }

    private void initBar() {
        mRoundRectPaint = new Paint();               //圆角矩形画笔
        mRoundRectPaint.setColor(getResources().getColor(R.color.colorProFull));       //设置画笔颜色
        mRoundRectPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mRoundRectPaint.setStrokeWidth(3f);         //设置画笔宽度为10px
        mRoundRectPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        mRoundRectPaint.setAntiAlias(true);

        mRoundRectBorderPaint = new Paint();            //圆角矩形边界画笔
        mRoundRectBorderPaint.setColor(getResources().getColor(R.color.colorProBorder));       //设置画笔颜色
        mRoundRectBorderPaint.setStyle(Paint.Style.STROKE);  //设置画笔模式为填充
        mRoundRectBorderPaint.setStrokeWidth(3f);         //设置画笔宽度为10px
        mRoundRectBorderPaint.setAntiAlias(true);

        mRoundRectFillPaint = new Paint();          //矩形填充画笔
        mRoundRectFillPaint.setColor(getResources().getColor(R.color.colorPro));       //设置画笔颜色
        mRoundRectFillPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mRoundRectFillPaint.setStrokeWidth(3f);         //设置画笔宽度为10px
        mRoundRectFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        mRoundRectFillPaint.setAntiAlias(true);

        mPaintBitmap = new Paint();        //图标画笔


    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF(10, 5, 80, 300);
        canvas.drawRoundRect(rectF, 30, 30, mRoundRectPaint);


        Rect rect = new Rect(10, 5, 80, 300 - (percent * 3));
        canvas.drawRect(rect, mRoundRectFillPaint);

        RectF rectF1 = new RectF(10, 5, 80, 300);
        canvas.drawRoundRect(rectF1, 30, 30, mRoundRectBorderPaint);


        Bitmap bitmap = style == 0 ? BitmapFactory.decodeResource(getResources(), R.drawable.volume_tag) : BitmapFactory.decodeResource(getResources(), R.drawable.brightnss_tag);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 40, 40, true);
        canvas.drawBitmap(scaledBitmap, 25, 250, mPaintBitmap);


        PaintFlagsDrawFilter mDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        canvas.setDrawFilter(mDrawFilter);                   // 从canvas层面去除绘制时锯齿
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 0声音
     * 1亮度
     */
    public VolumeBrightnessBar setStyle(int style) {
        this.style = style;
        return this;
    }

    public void setPercent(int percent){
        this.percent = percent;
        invalidate();
    }
}
