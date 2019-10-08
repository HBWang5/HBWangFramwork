package com.hbwang.api.widget;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/7/27.
 */

public class HBWangEditText extends android.support.v7.widget.AppCompatEditText  {

    public HBWangEditText(Context context) {
        super(context);
        disableShowSoftInput(this);

    }

    public HBWangEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        disableShowSoftInput(this);
    }

    public HBWangEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        disableShowSoftInput(this);
    }


    public void disableShowSoftInput(EditText tvInputNumber) {
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            tvInputNumber.setInputType(InputType.TYPE_NULL);
        } else {
            Class<EditText> cls = EditText.class;
            Method method;
            try {
                method = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                method.setAccessible(true);
                method.invoke(tvInputNumber, false);
            } catch (Exception e) {
            }

//            try {
//                method = cls.getMethod("setSoftInputShownOnFocus", boolean.class);
//                method.setAccessible(true);
//                method.invoke(tvInputNumber, false);
//            } catch (Exception e) {
//            }
        }
    }
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == 1) {
            super.onKeyPreIme(keyCode, event);
//            onKeyBoardHideListener.onKeyHide(keyCode, event);
            return false;
        }
        return super.onKeyPreIme(keyCode, event);
    }


    /**
     *键盘监听接口
     */
    OnKeyBoardHideListener onKeyBoardHideListener;
    public void setOnKeyBoardHideListener(OnKeyBoardHideListener onKeyBoardHideListener) {
        this.onKeyBoardHideListener = onKeyBoardHideListener;
    }


    public interface OnKeyBoardHideListener{
        void onKeyHide(int keyCode, KeyEvent event);
    }
}
