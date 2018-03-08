package com.darly.darlyview.ui.pannal;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.darly.common.DLog;
import com.darly.common.ToastApp;
import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.common.CacheData;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.ui.adapter.RecyclerViewAdapter;
import com.darly.darlyview.wedget.slidinguppanel.SlidingUpPanelLayout;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

import java.util.Arrays;
import java.util.List;

/**一个能够向上滑动的时候往上飞出一个显示区域的控件，类似于play music中的效果。该控件在主界面中有一个底部触发区域，该区域点击的时候被隐藏在下方的内容将网上漂移到顶部，直到被隐藏的内容完全挡住原来的布局。当被隐藏区域完全显示，这时再次点击触发区域（或者是通过下滑的手势）将恢复到最初的状态。
 * @author Darly/张宇辉/2018/3/6 9:41
 * @version 1.0/com.darly.darlyview.ui.pannal
 */
@ContentBinder(R.layout.activity_slidinguppanel)
public class SlidingUpPanelActivity extends BaseActivity implements View.OnClickListener {

    @ViewsBinder(R.id.sliding_layout)
    SlidingUpPanelLayout mLayout;

    @ViewsBinder(R.id.id_panel_title)
    TitleView id_panel_title;

    @ViewsBinder(R.id.id_panel_recyclerview)
    RecyclerView id_panel_recyclerview;

    RecyclerViewAdapter adapter;

    @ViewsBinder(R.id.list)
    RecyclerView lv;
    RecyclerViewAdapter lvadapter;
    @ViewsBinder(R.id.name)
    TextView t;

    @Override
    protected void initView(Bundle savedInstanceState) {

        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_panel_title.setTitle(R.string.app_name);
        }else {
            id_panel_title.setTitle(bean.getTitle());
        }
        id_panel_title.removeBackground(R.drawable.ic_title_background);
    }

    @Override
    protected void loadData() {
        adapter = new RecyclerViewAdapter(this, CacheData.getRecyclerBeanData());
        id_panel_recyclerview.setAdapter(adapter);
        //添加动画效果
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setRemoveDuration(2000);
        id_panel_recyclerview.setItemAnimator(animator);
        //最后一个参数是反转布局一定是false,为true的时候为逆向显示，在聊天记录中可能会有使用
        //这个东西在显示后才会加载，不会像ScollView一样一次性加载导致内存溢出
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        GridLayoutManager manager = new GridLayoutManager(this,2);
        id_panel_recyclerview.setLayoutManager(manager);

        lvadapter = new RecyclerViewAdapter(this, CacheData.getRecyclerBeanData());
        lv.setAdapter(lvadapter);
        LinearLayoutManager lvmanager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lv.setLayoutManager(lvmanager);
        t.setText(Html.fromHtml(getString(R.string.hello)));
    }

    @Override
    protected void initListener() {
        id_panel_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);

        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                DLog.i( "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                DLog.i( "onPanelStateChanged " + newState);
            }
        });
        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });

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
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }

}
