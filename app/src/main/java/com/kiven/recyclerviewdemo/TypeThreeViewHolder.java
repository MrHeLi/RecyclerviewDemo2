package com.kiven.recyclerviewdemo;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SuperLi on 2017/8/29.
 */

public class TypeThreeViewHolder extends TypeAbstractViewHolder<DataModelThree> {
    public ImageView avatar;

    public TextView name;

    public TextView content;

    public ImageView contentImage;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
        contentImage = (ImageView) itemView.findViewById(R.id.contentImage);
        itemView.setBackgroundColor(Color.RED);

    }

    @Override
    public void bindHolder(DataModelThree model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
        contentImage.setBackgroundResource(model.contentColor);
    }
}
