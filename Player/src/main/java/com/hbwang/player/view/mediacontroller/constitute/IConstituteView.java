package com.hbwang.player.view.mediacontroller.constitute;

import android.view.ViewGroup;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/13-17:51
 * 控制层组件整合
 */
public interface IConstituteView {
    /**
     * （控制View添加）
     * 添加下栏目（进度/全屏。。。。）
     */
    IConstituteView addBelowColumnView();

    /**
     * 添加上栏目（标题）
     */
    IConstituteView addTopColumnView();

    /**
     * 添加左栏目（亮度）
     */
    IConstituteView addLeftColumnView();

    /**
     * 添加右栏目（声音）
     */

    IConstituteView addRightColumnView();

    /**
     * ================================================================================================================
     *
     * 添加加载View（动画）
     */
    IConstituteView addLodingView();

    /**
     * ================================================================================================================
     *（各种插件）
     * 添加弹幕View
     */
    IConstituteView addBarrageView();

    /**
     * 添加广告View
     */
    IConstituteView addAdvertisingView();

    /**
     * 添加导航View
     */
    IConstituteView addNavigationView();

    /**
     *  ================================================================================================================
     * 初始化
     */
    IConstituteView init(ViewGroup viewGroup);

}
