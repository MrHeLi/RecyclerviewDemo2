package com.kiven.recyclerviewdemo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private int colors[] = {android.R.color.holo_red_dark,
                            android.R.color.holo_blue_dark,
                            android.R.color.holo_orange_dark};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                int type = recyclerView.getAdapter().getItemViewType(position);
                if (type == DataModel.TYPE_THREE) {
                    return gridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
                    if (spanIndex == 1) {
                        outRect.left = 10;
                    } else {
                        outRect.right = 10;
                    }
                }

            }
        });
        adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            int type;
            if (i < 5 || (i > 15 && i < 20)) {
                type = 1;
            } else if (i < 10 || i > 26) {
                type = 2;
            } else {
                type = 3;
            }

            DataModel model = new DataModel();
            model.type = type;
            model.avatarColor = colors[type - 1];
            model.name = "type : " + type;
            model.content = "content : " + i;
            model.contentColor = colors[(type + 1) % 3];
            list.add(model);
        }

        List<DataModelOne> list1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DataModelOne model = new DataModelOne();
            model.avatarColor = colors[0];
            model.name = "name : " + i;
            list1.add(model);
        }

        List<DataModelTwo> list2 = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            DataModelTwo model = new DataModelTwo();
            model.avatarColor = colors[1];
            model.name = "name : " + i;
            model.content = "content : " + i;
            list2.add(model);
        }

        List<DataModelThree> list3 = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            DataModelThree model = new DataModelThree();
            model.avatarColor = colors[2];
            model.name = "name : " + i;
            model.content = "content : " + i;
            model.contentColor = colors[1];
            list3.add(model);
        }

        adapter.addList(list1,list2,list3);
        adapter.notifyDataSetChanged();
    }

}



