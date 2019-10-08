package com.hbwang.launcher.view.activity;


import com.hbwang.api.base.view.activity.BaseActivity;
import com.hbwang.api.base.view.fragment.BaseFragment;
import com.hbwang.hbwangframwork.R;
import com.hbwang.launcher.presenter.impl.NavigationPresenterActImpl;
import com.hbwang.launcher.ui.INavigationActivityUI;
import com.hbwang.viewbindlib.annotation.ContenView;

@ContenView(R.layout.activity_main)
public class NavigationActivity extends BaseActivity<INavigationActivityUI, NavigationPresenterActImpl> implements INavigationActivityUI {

    @Override
    public NavigationPresenterActImpl createPresenter() {
        return new NavigationPresenterActImpl(this);
    }


    @Override
    public void initView() {

    }


    @Override
    public BaseFragment initFragment() {
        return null;
    }

    @Override
    public int initFragmentId() {
        return 0;
    }

    @Override
    public void initOnClicked() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void initData() {

    }
}
