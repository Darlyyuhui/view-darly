package com.darly.darlyview.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;

import com.darly.common.ToastApp;
import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.common.CacheData;
import com.darly.darlyview.ui.adapter.CustomRecyclerAdapter;
import com.darly.darlyview.ui.adapter.CustomRecyclerAdapter.OnRecyclerItemClickListener;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.video.VideoActivity;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

/** 休闲娱乐入口，使用GridView进行数据展示。
 * @author Darly/张宇辉/2018/3/19 9:45
 * @version 1.0/com.darly.darlyview.ui
 */
@ContentBinder(R.layout.activity_little_rest)
public class LittleRestActivity extends BaseActivity implements OnClickListener,OnRecyclerItemClickListener{

    @ViewsBinder(R.id.id_little_rest_title)
    TitleView id_little_rest_title;
    @ViewsBinder(R.id.id_little_rest_grid)
    RecyclerView id_little_rest_grid;

    CustomRecyclerAdapter adapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        id_little_rest_title.setTitle("休闲娱乐");
        id_little_rest_title.removeBackground(R.drawable.ic_title_background);
    }

    @Override
    protected void loadData() {
        adapter  = new CustomRecyclerAdapter(this, CacheData.getLittleRestData(),3);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        id_little_rest_grid.setLayoutManager(manager);
        id_little_rest_grid.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        id_little_rest_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
        id_little_rest_title.setRightViewRightTextOneListener("视频",this);
        adapter.setOnRecyclerItemClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_view_back_img:
                onBackPressed();
                break;
            case R.id.title_view_ok:
                startActivity(new Intent(this, VideoActivity.class));
                break;
        }
    }

    @Override
    public void OnRecyclerItemClick(RecyclerView parent, View view, int position, RecyclerBean data) {
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
