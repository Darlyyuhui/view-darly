package com.darly.darlyview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.common.CacheData;
import com.darly.darlyview.games.LittleRestActivity;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.ui.adapter.RecyclerViewAdapter;
import com.darly.darlyview.ui.mover.ExampleActivity;
import com.darly.darlyview.wedget.focusresize.FocusResizeScrollListener;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

/**
 * 整体开工页面，使用一个ListView界面展示所有界面环境
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2018/3/5 8:55
 * @version  1.0/com.darly.darlyview.ui
 */

@ContentBinder(R.layout.activity_main)
public class MainActivity extends BaseActivity implements RecyclerViewAdapter.OnRecyclerItemClickListener,OnClickListener{

    @ViewsBinder(R.id.id_main_title)
    TitleView id_main_title;
    @ViewsBinder(R.id.id_main_recyclerview)
    RecyclerView id_main_recyclerview;

    private RecyclerViewAdapter adapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        id_main_title.setTitle(R.string.app_name);
        id_main_title.removeBackground(R.drawable.ic_title_background);
    }

    @Override
    protected void loadData() {
        adapter = new RecyclerViewAdapter(this,(int) getResources().getDimension(R.dimen.custom_item_height), CacheData.getRecyclerBeanData(),id_main_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        if (id_main_recyclerview != null) {
            id_main_recyclerview.setLayoutManager(linearLayoutManager);
            id_main_recyclerview.setHasFixedSize(true);
            id_main_recyclerview.setAdapter(adapter);
            id_main_recyclerview.addOnScrollListener(new FocusResizeScrollListener<>(adapter, linearLayoutManager));
        }

    }

    @Override
    protected void initListener() {
        adapter.setOnRecyclerItemClickListener(this);
        id_main_title.setRightViewRightTextOneListener("休息",this);
    }

    @Override
    public void OnRecyclerItemClick(RecyclerView parent, View view, int position, RecyclerBean data) {
//        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
//        adapter.remove(position);
//        adapter.insert(position,"去他大爷的网络");
//        adapter.update(position,"去他大爷的网络");
        try {
            Intent intent = new Intent();
            intent.setClass(this,Class.forName(data.getClazz()));
            intent.putExtra("RecyclerBean",data);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_view_ok:
                startActivity(new Intent(this, LittleRestActivity.class));
                break;
        }
    }
}
