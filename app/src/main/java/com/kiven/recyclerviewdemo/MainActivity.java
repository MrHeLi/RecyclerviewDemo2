package com.kiven.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int type = (int) (Math.random() * 3 + 1);
            DataModel model = new DataModel();
            model.type = type;
            model.avatarColor = colors[type - 1];
            model.name = "name : " + i;
            model.content = "content : " + i;
            model.contentColor = colors[(type + 1) % 3];
            list.add(model);
        }

        adapter.addList(list);
        adapter.notifyDataSetChanged();
    }

}



