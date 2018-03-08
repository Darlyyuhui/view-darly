package com.darly.darlyview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.common.CacheData;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.ui.adapter.RecyclerViewAdapter;
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
public class MainActivity extends BaseActivity implements RecyclerViewAdapter.OnRecyclerItemClickListener{

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
        adapter = new RecyclerViewAdapter(this, CacheData.getRecyclerBeanData());
        id_main_recyclerview.setAdapter(adapter);
        //添加动画效果
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setRemoveDuration(2000);
        id_main_recyclerview.setItemAnimator(animator);
        //最后一个参数是反转布局一定是false,为true的时候为逆向显示，在聊天记录中可能会有使用
        //这个东西在显示后才会加载，不会像ScollView一样一次性加载导致内存溢出
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        GridLayoutManager manager = new GridLayoutManager(this,2);
        id_main_recyclerview.setLayoutManager(manager);
    }

    @Override
    protected void initListener() {
        adapter.setOnRecyclerItemClickListener(this);
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
}
