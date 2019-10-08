package com.hbwang.api.base.presenter;

import android.content.Context;

import com.hbwang.api.base.model.BaseModel;
import com.hbwang.api.mvp.presenter.impl.PresenterCenter;
import com.hbwang.api.mvp.view.IUIFrame;

public abstract class BasePresenter<M extends BaseModel,V extends IUIFrame> extends PresenterCenter<V> {

    private Context context;

    private M model;

    public BasePresenter(Context context){
        this.context = context;
        getModel();
    }

    public Context getContext() {
        return context;
    }

    public M getModel(){
        if (this.model == null){
            this.model = bindModel();
        }
        return this.model;
    }

    public abstract M bindModel();

}
