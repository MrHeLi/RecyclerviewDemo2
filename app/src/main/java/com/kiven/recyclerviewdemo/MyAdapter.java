package com.kiven.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SuperLi on 2017/8/29.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<DataModel> modelList = new ArrayList<>();
    public MyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModel> list) {
        modelList.addAll(list);
    }

    @Override
    public int getItemViewType(int position) {
        return modelList.get(position).type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new TyepOneViewHolder(inflater.inflate(R.layout.item_type_one,
                        parent, false));
            case DataModel.TYPE_TWO:
                return new TyepTwoViewHolder(inflater.inflate(R.layout.item_type_two,
                        parent, false));
            case DataModel.TYPE_THREE:
                return new TyepThreeViewHolder(inflater.inflate(R.layout.item_type_three,
                        parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TypeAbstractViewHolder) holder).bindHolder(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
