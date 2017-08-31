package com.kiven.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by SuperLi on 2017/8/29.
 */

public abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder {
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T model);
}
