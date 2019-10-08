package com.hbwang.launcher.view.activity;





import com.hbwang.api.base.view.activity.BaseActivity;
import com.hbwang.api.base.view.fragment.BaseFragment;
import com.hbwang.hbwangframwork.R;
import com.hbwang.launcher.presenter.impl.LauncherPresenterActImpl;
import com.hbwang.launcher.ui.ILauncherActivityUI;
import com.hbwang.launcher.view.fragment.launcher.WZLauncherFragment;
import com.hbwang.viewbindlib.annotation.ContenView;

@ContenView(R.layout.activity_main)
public class LauncherActivity extends BaseActivity<ILauncherActivityUI, LauncherPresenterActImpl> implements ILauncherActivityUI {


    @Override
    public LauncherPresenterActImpl createPresenter() {
        return new LauncherPresenterActImpl(this); //初始化控制器
    }


    @Override
    public void initView() {
//        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
//        intent.setData(Uri.parse("package:" + getPackageName()));
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivityForResult(intent, 0);
    }

    /**
     * 初始化（获取/添加）fragment
     */
    @Override
    public BaseFragment initFragment() {
        return new WZLauncherFragment();//创建Launcher fragment
    }

    /**
     * 初始化（添加）fragment ID
     */
    @Override
    public int initFragmentId() {
        return R.id.fragment_layout;
    }

    /**
     * 控件监听
     */
    @Override
    public void initOnClicked() {
    }

    @Override
    public void initData() {
    }

    /**
     * activity ID
     */
//    @Override
//    public int bindLayoutId() {
//        return R.layout.activity_main;
//    }


}
