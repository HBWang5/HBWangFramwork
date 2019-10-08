package com.hbwang.messagebus.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.hbwang.messagebus.lifecycle.ILifecycle;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/2-10:38
 */
public class LiveDataFrag extends Fragment {
    private int activityCode;
    private ILifecycle mILifecycle;

    public void setILifecycle(ILifecycle mILifecycle) {
        this.mILifecycle = mILifecycle;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activityCode = context.hashCode();
        if (mILifecycle != null) {
            mILifecycle.onCreate(activityCode);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        if (mILifecycle != null) {
            mILifecycle.onStart(activityCode);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mILifecycle != null) {
            mILifecycle.onDestroy(activityCode);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mILifecycle != null) {
            mILifecycle.onPause(activityCode);
        }
    }

}
