package com.kiven.recyclerviewdemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SuperLi on 2017/8/29.
 */

public class TyepTwoViewHolder extends TypeAbstractViewHolder {
    public ImageView avatar;

    public TextView name;

    public TextView content;

    public TyepTwoViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);

    }

    @Override
    public void bindHolder(DataModel model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
    }
}
