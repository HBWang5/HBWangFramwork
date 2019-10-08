package com.hbwang.player.decryptor;

import java.nio.ByteBuffer;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/12-10:10
 * 播放解密器
 */
public interface IHBWangMediaDecryptor {

    /**
     * @param byteBuffer 流数据ByteBuffer对象
     * @param offset     byteBuffer起始数据对应的整个播放流的偏移位置
     * @param size       byteBuffer的大小
     */
    void decrypt(ByteBuffer byteBuffer, long offset, long size);

    /**
     * @param buffer 流数据字节数组
     * @param offset buffer起始数据对应的整个播放流的偏移位置
     * @param size   buffer的大小
     */
    void decrypt(byte[] buffer, long offset, long size);
}
