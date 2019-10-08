package com.hbwang.api.base.model;

import android.content.Context;

import com.hbwang.api.mvp.model.IModel;


public abstract class BaseModel implements IModel {

    private Context context;

    public BaseModel(Context context){
        this.context = context;
    }

    public Context getContext() {
        return context;
    }


}
