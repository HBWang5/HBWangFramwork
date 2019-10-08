package com.hbwang.api.bitmap.config;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/5/23-15:17
 */
public enum  ImageFormat {

    /**
     * JPEG :
     JPEG（发音为/jay-peg/）是一种广泛使用的有损压缩图片标准格式，
     它不支持透明和多帧动画，一般摄影类作品最终都是以JPEG格式展示。
     通过控制压缩比，可以调整图片的大小。
     * ======================================================================================================
     PNG :
     PNG是一种无损压缩图片格式，它支持完整的透明通道，
     从图像处理领域讲，JPEG只有RGB三个通道，而PNG有ARGB四个通道。
     由于是无损压缩，因此PNG图片占用空间一般比较大，会无形中添加最终APP的大小，
     在做APP瘦身时一般都要对PNG图片进行处理以减小其占用的体积。
     * ======================================================================================================
     GIF :
     GIF 是- 一种古老的图片格式，它诞生于1987 年，
     随着初代互联网流行开来。它的特点是支持多帧动画。大家对这种格式肯定不陌生，
     社交平台上面发送的各种动态表情，大部分都是基于GIF 来实现的。
     * ======================================================================================================
     WebP :
     相比前面几种图片格式,WebP (发音为/weppy/ )算是一一个初生儿了，由Google 在2010
     年发布，它支持有损和无损压缩、支持完整的透明通道、也支持多帧动画，是一种比较理想的图片格式。
     目前国内很多主流APP都已经应用了WebP,例如微信、微博.淘宝等。在既保证图片质量又要限制图片大小的需求下，WebP应该是首选。
     * ======================================================================================================
     */
    JPEG,
    PNG,
    GIF,
    BMP,
    WebP
}
