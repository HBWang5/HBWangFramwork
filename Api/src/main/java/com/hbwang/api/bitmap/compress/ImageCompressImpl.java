package com.hbwang.api.bitmap.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;


import java.io.ByteArrayOutputStream;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/5/23-14:48
 */
public class ImageCompressImpl implements IImageCompress {
    private Bitmap mBitmap;



    @Override
    public IImageCompress setImage() {
        return this;
    }

    @Override
    public IImageCompress setImageFormat() {
        return this;
    }

    @Override
    public IImageCompress imageQuality() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        //quality调节压缩的比例
        Log.i("wechat", "压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M宽度为" + bm.getWidth() + "高度为" + bm.getHeight()
                + "bytes.length=  " + (bytes.length / 1024) + "KB"
                + "quality=" + 60);
        return this;
    }

    @Override
    public IImageCompress imageSampling() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bm = BitmapFactory.decodeFile(Environment
                .getExternalStorageDirectory().getAbsolutePath()
                + "/Camera/test.jpg", options);

        Log.i("wechat", "压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M宽度为" + bm.getWidth() + "高度为" + bm.getHeight());
        return this;
    }

    @Override
    public IImageCompress imageZoom() {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        Bitmap bm = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(),
                mBitmap.getHeight(), matrix, true);

        Log.i("wechat", "压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M宽度为" + bm.getWidth() + "高度为" + bm.getHeight());
        return this;
    }

    @Override
    public IImageCompress imageRGB_565() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        Bitmap bitmap = BitmapFactory.decodeFile(Environment
                .getExternalStorageDirectory().getAbsolutePath()
                + "/Camera/test.jpg", options);

        Log.i("wechat", "压缩后图片的大小" + (bitmap.getByteCount() / 1024 / 1024)
                + "M宽度为" + bitmap.getWidth() + "高度为" + bitmap.getHeight());
        return null;
    }

    @Override
    public IImageCompress createScaledBitmap() {
        Bitmap bitmap = Bitmap.createScaledBitmap(mBitmap, 150, 150, true);

        Log.i("wechat", "压缩后图片的大小" + (bitmap.getByteCount() / 1024) + "KB宽度为"
                + bitmap.getWidth() + "高度为" + bitmap.getHeight());
        return null;
    }

    @Override
    public Bitmap getImage() {
        return null;
    }

    @Override
    public Bitmap getImageMemory() {
        return null;
    }
}
