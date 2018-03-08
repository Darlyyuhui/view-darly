package com.darly.darlyview.ui.waveswiperefresh;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.wedget.waveswiperefresh.WaveSwipeRefreshLayout;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

import java.util.ArrayList;

/**水滴效果的下拉刷新，效果非常不错。
 * @author Darly/张宇辉/2018/3/8 8:31
 * @version 1.0/com.darly.darlyview.ui.waveswiperefresh
 */
@ContentBinder(R.layout.activity_waveswiperefresh)
public class WaveSwipeRefreshActivity extends BaseActivity implements WaveSwipeRefreshLayout.OnRefreshListener,OnClickListener{
    @ViewsBinder(R.id.id_waves_title)
    TitleView id_waves_title;
    @ViewsBinder(R.id.id_waves_list)
    ListView mListview;
    @ViewsBinder(R.id.id_waves_swipe)
    WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;
    @Override
    protected void initView(Bundle savedInstanceState) {
        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_waves_title.setTitle(R.string.app_name);
        }else {
            id_waves_title.setTitle(bean.getTitle());
        }
        id_waves_title.removeBackground(R.drawable.ic_title_background);

        mWaveSwipeRefreshLayout.setColorSchemeColors(Color.WHITE, Color.WHITE);
        mWaveSwipeRefreshLayout.setOnRefreshListener(this);
        mWaveSwipeRefreshLayout.setWaveColor(Color.argb(100,255,0,0));
    }

    @Override
    protected void loadData() {
        ArrayList<String> sampleArrayStr = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            sampleArrayStr.add("測試虛假數據"+i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, sampleArrayStr);
        mListview.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        id_waves_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_view_back_img:
                onBackPressed();
                break;
        }
    }

    @Override
    protected void onResume() {
        //mWaveSwipeRefreshLayout.setRefreshing(true);
        refresh();
        super.onResume();
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    private void refresh(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 更新が終了したらインジケータ非表示
                mWaveSwipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}
