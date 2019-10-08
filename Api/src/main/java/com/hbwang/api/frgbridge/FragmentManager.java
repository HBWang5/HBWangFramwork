package com.hbwang.api.frgbridge;

import android.support.v4.app.FragmentActivity;

import com.hbwang.api.base.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2018/1/24.
 */
public abstract class FragmentManager {
    abstract void addFragment(BaseFragment fragment ,int id);
    abstract void remove(BaseFragment fragment ,int id);
    abstract void replace(BaseFragment fragment ,int id);
    abstract void hine(BaseFragment fragment ,int id);
    abstract void show(BaseFragment fragment ,int id);
    abstract FragmentManagerImpl init(FragmentActivity activity);

    public abstract void commit();
}
