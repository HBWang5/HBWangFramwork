package com.hbwang.api.adapter;

/**
 * Created by Administrator on 2018/3/13.
 */

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装ViewHolder ,子类可以直接使用
 */
public class BaseViewHolder extends  RecyclerView.ViewHolder{


    private Map<Integer, View> mViewMap;

    @SuppressLint("UseSparseArrays")
    BaseViewHolder(View itemView) {
        super(itemView);
        mViewMap = new HashMap<>();
    }

    /**
     * 获取设置的view
     */
    public View getView(int id) {
        View view = mViewMap.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            mViewMap.put(id, view);
        }
        return view;
    }
}
