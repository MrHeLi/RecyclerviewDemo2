package com.kiven.recyclerview.practice_one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.kiven.recyclerview.practice_one.divider.HorizontalDividerItemDecoration;
import com.kiven.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SuperLi on 2017/11/12.
 */

public class PracticeOneActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyBaseAdapter adapter;
    private List<String> data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        LinearLayoutManager llmanager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llmanager);
        adapter = new MyBaseAdapter(this, data);
        recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this).build());
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0 ; i < 20; i++) {
            data.add("item " + i );
            Log.i("TAG", "item " + 1);
        }
    }

    private void initView() {
        recyclerView = (RecyclerView) this.findViewById(R.id.id_recyclerview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.m_lv:
                LinearLayoutManager lvmanager = new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(lvmanager);
                break;
            case R.id.m_gv:
                GridLayoutManager gvmanager = new GridLayoutManager(this,3);
                recyclerView.setLayoutManager(gvmanager);
                break;
            case R.id.mh_lv:
                break;
            case R.id.mh_gv:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
