package com.kiven.recyclerview.practice_one;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiven.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by SuperLi on 2017/11/12.
 */

public class MyBaseAdapter extends RecyclerView.Adapter<ViewHolder>{

    private LayoutInflater inflater;
    private List<String> data;

    public MyBaseAdapter(Context context, List<String> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_prac_one, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public ViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv);
    }
}
