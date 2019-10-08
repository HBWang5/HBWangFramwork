package com.hbwang.api.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2018/3/13.
 */

public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {
    // 数据源
    private List<T> datas;
    private OnItemClickListener mItemClickListener;

    // 构造方法，传入
    public BaseRecycleAdapter(List<T> datas) {
        this.datas = datas;
    }

    abstract int getLayoutId();


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        view.setOnClickListener(this);
        return new BaseViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        // 子类实现数据绑定
        holder.itemView.setTag(position);
        bindData(holder, position);
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick((Integer) v.getTag());
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    /**
     * 刷新数据
     */
    public void refresh(List<T> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }


    /**
     * 添加数据
     */
    public void addData(List<T> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 删除数据
     */
    public void remove(int position) {
        datas.remove(position);
        notifyDataSetChanged();
    }



    /**
     * 绑定数据
     *
     * @param holder   具体的viewHolder
     * @param position 对应的索引
     */
    protected abstract void bindData(BaseViewHolder holder, int position);

    /**
     * 绑定的数据
     *
     * @param holder 具体的ViewHolder
     * @param data   具体的数据
     */
    protected abstract void bindData(BaseViewHolder holder, T data);

    /**
     *
     */

    public abstract Object getData(int position);


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
