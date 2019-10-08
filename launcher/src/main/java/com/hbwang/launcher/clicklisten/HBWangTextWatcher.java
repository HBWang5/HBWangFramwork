package com.hbwang.launcher.clicklisten;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;

import com.hbwang.launcher.view.fragment.launcher.LauncherFrgCallBack;


/**
 * Created by Administrator on 2017/7/21.
 */

public class HBWangTextWatcher implements TextWatcher {
    public LauncherFrgCallBack launcherFrgCallBack;
//    public String mCityIndex;

    public HBWangTextWatcher(LauncherFrgCallBack launcherFrgCallBack) {
        this.launcherFrgCallBack = launcherFrgCallBack;
    }
    TextView mTextView;
    public  void setTextView(TextView textView){
        this.mTextView = textView;
    }

    /**
     * 编辑框的内容发生改变之前的回调方法
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    /**
     * 编辑框的内容正在发生改变时的回调方法 >>用户正在输入
     * 我们可以在这里实时地 通过搜索匹配用户的输入
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    /**
     * 编辑框的内容改变以后,用户没有继续输入时 的回调方法
     */
    @Override
    public void afterTextChanged(Editable s) {
        String string = s.toString();
        if(!TextUtils.isEmpty(string)) {
        }
    }

}
