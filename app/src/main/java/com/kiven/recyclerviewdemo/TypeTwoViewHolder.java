package com.kiven.recyclerviewdemo;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SuperLi on 2017/8/29.
 */

public class TypeTwoViewHolder extends TypeAbstractViewHolder<DataModelTwo> {
    public ImageView avatar;

    public TextView name;

    public TextView content;

    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void bindHolder(DataModelTwo model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
    }
}
