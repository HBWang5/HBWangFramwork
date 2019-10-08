package com.hbwang.api.permission.hal;


import android.content.Context;

import com.hbwang.api.permission.manager.IPermissionManager;
import com.hbwang.api.permission.manager.impl.PermissionManagerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/24-16:43
 */
public class PermissionHelper implements IPermissionHelper{
    private static PermissionHelper mPermissionHelper = null;
    private IPermissionManager mIPermissionManager;
    private List<String> list = new ArrayList();

    private PermissionHelper(){
        mIPermissionManager = new PermissionManagerImpl();
    }

    public static synchronized PermissionHelper getInstance(){
        if (mPermissionHelper == null) {
            mPermissionHelper = new PermissionHelper();

        }
        return mPermissionHelper;
    }


    @Override
    public IPermissionHelper jurisdictionApply( String Permission) {
        list.add(Permission);
        return getInstance();
    }

    @Override
    public void submit(Context context) {
        mIPermissionManager.jurisdictionApply(context,"",0,list.toArray(new String[list.size()]));
    }
}
