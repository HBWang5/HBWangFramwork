package com.hbwang.api.bitmap.compress;

import android.graphics.Bitmap;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/5/23-14:41
 */
public interface IImageCompress {

    /**
     * 压缩后图片获取
     */
    IImageCompress setImage();

    /**
     * 设置图片格式
     */
    IImageCompress setImageFormat();

    /**
     * 质量压缩:
     * 质量压缩并不会改变图片在内存中的大小，仅仅会减小图片所占用的磁盘空间的大小，
     * 因为质量压缩不会改变图片的分辨率，而图片在内存中的大小是根据width*height*
     * 一个像素的所占用的字节数计算的，宽高没变，在内存中占用的大小自然不会变，
     * 质量压缩的原理是通过改变图片的位深和透明度来减小图片占用的磁盘空间大小，
     * 所以不适合作为缩略图，可以用于想保持图片质量的同时减小图片所占用的磁盘空间大小。
     * 另外，由于png是无损压缩，所以设置quality无效.
     */
    IImageCompress imageQuality();

    /**
     * 采样率压缩:
     * 采样率压缩是通过设置BitmapFactory.Options.inSampleSize，来减小图片的分辨率，进而减小图片所占用的磁盘空间和内存大小。
     * 设置的inSampleSize会导致压缩的图片的宽高都为1/inSampleSize，整体大小变为原始图片的inSampleSize平方分之一，
     * 当然，这些有些注意点：
     * 1、inSampleSize小于等于1会按照1处理
     * 2、inSampleSize只能设置为2的平方，不是2的平方则最终会减小到最近的2的平方数，
     * 如设置7会按4进行压缩，设置15会按8进行压缩。 
     */
    IImageCompress imageSampling();

    /**
     * 缩放压缩
     * 放缩法压缩使用的是通过矩阵对图片进行裁剪，也是通过缩放图片尺寸，来达到压缩图片的效果，和采样率的原理一样。
     * 通过减少图片的像素来降低图片的磁盘空间大小和内存大小，可以用于缓存缩略图
     */
    IImageCompress imageZoom();


    /**
     * RGB_565压缩是通过改用内存占用更小的编码格式来达到压缩的效果。
     * Android默认的颜色模式为ARGB_8888，这个颜色模式色彩最细腻，显示质量最高。
     * 一般不建议使用ARGB_4444，因为画质不好，如果对透明度没有要求，
     * 建议可以改成RGB_565，相比ARGB_8888将节省一半的内存开销。
     * ALPHA_8  表示8位Alpha位图,即A=8,一个像素点占用1个字节,它没有颜色,只有透明度
     *    ARGB_4444  表示16位ARGB位图，即A=4,R=4,G=4,B=4,一个像素点占4+4+4+4=16位，2个字节
     *    ARGB_8888  表示32位ARGB位图，即A=8,R=8,G=8,B=8,一个像素点占8+8+8+8=32位，4个字节
     *    RGB_565  表示16位RGB位图,即R=5,G=6,B=5,它没有透明度,一个像素点占5+6+5=16位，2个字节
     *    我们在做压缩处理的时候，可以先通过改变Bitmap的图片编码格式，来达到压缩的效果，
     * 其实压缩最主要就是要么改变其宽高，要么就通过减少其单个像素占用的内存。
     */
    IImageCompress imageRGB_565();

    /**
     * 这里是将图片压缩成用户所期望的长度和宽度，
     * 如果用户期望的长度和宽度和原图长度宽度相差太多的话，图片会很不清晰。
     */
    IImageCompress createScaledBitmap();

    /**
     * 压缩后图片获取
     */
    Bitmap getImage();

    /**
     * 图片占用内存
     */
    Bitmap getImageMemory();

}
