package com.hbwang.launcher.clicklisten;


import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.hbwang.api.click.ILuancherClick;


/**
 * Created by Administrator on 2018/3/13.
 */

public class HBWangLuancherClick implements ILuancherClick, View.OnClickListener, View.OnTouchListener {
    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public boolean isBack() {
        return false;
    }
}
