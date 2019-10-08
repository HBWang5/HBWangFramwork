package com.hbwang.api.frgbridge;


import android.support.v4.app.FragmentActivity;

import com.hbwang.api.base.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2018/1/24.
 */

public class FragmentBridgeImpl extends FragmentBridge{
    private BaseFragment fragment;
    private FragmentManager fragmentManager;
    private int id;
    public FragmentBridgeImpl(FragmentActivity fragmentActivity) {
        fragmentManager = new FragmentManagerImpl().init(fragmentActivity);//初始化Fragment管理器
    }

    @Override
    public FragmentBridgeImpl addFragment() {
        fragmentManager.addFragment(fragment,id);
        return this;
    }

    @Override
    public FragmentBridgeImpl remove() {
        fragmentManager.remove(fragment,id);
        return this;
    }

    @Override
    public FragmentBridgeImpl replace() {
        fragmentManager.replace(fragment,id);
        commit();
        return this;
    }

    @Override
    public FragmentBridgeImpl commit() {
        fragmentManager.commit();
        return this;
    }

    @Override
    public FragmentBridgeImpl hine(BaseFragment fragment) {
        fragmentManager.hine(fragment,id);
        return this;
    }

    @Override
    public FragmentBridgeImpl show(BaseFragment fragment) {
        fragmentManager.show(fragment,id);
        return this;
    }

    @Override
    public FragmentBridgeImpl init(BaseFragment fragment , int id) {
        this.id = id;
        this.fragment = fragment;
        return this;
    }
}
