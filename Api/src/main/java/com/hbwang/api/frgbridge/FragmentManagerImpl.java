package com.hbwang.api.frgbridge;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.hbwang.api.base.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2018/1/24.
 */

public class FragmentManagerImpl extends FragmentManager {

    private FragmentTransaction fragmentTransaction;



    @Override
    void addFragment(BaseFragment fragment ,int id) {
        fragmentTransaction.add(id, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
        ;

    }

    @Override
    void remove(BaseFragment fragment ,int id) {
        fragmentTransaction.remove(fragment).disallowAddToBackStack();
    }

    @Override
    void replace(BaseFragment fragment ,int id) {
        fragmentTransaction .replace(id, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
        ;
    }

    @Override
    void hine(BaseFragment fragment ,int id) {
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
    }

    @Override
    void show(BaseFragment fragment ,int id) {
        if (fragment != null) {
            fragmentTransaction.show(fragment);
        }
    }


    @SuppressLint("CommitTransaction")
    @Override
    FragmentManagerImpl init(FragmentActivity activity) {
        fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        return this;
    }

    @Override
    public void commit() {
        fragmentTransaction.commitAllowingStateLoss();
    }
}
