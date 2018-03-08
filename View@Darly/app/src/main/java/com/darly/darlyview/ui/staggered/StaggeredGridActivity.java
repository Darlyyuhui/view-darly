package com.darly.darlyview.ui.staggered;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.common.CacheData;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.ui.adapter.RecyclerViewAdapter;
import com.darly.darlyview.ui.adapter.StaggerAdapter;
import com.darly.darlyview.wedget.pinterest.MultiColumnListView;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

/**注意跟StaggeredGridView区别，他的实现原理更类似于PinterestLikeAdapterView。AndroidStaggeredGrid的目的是为了满足Etsy app的需求（估计是作者自己开发的一个app）。有个很不错的特点是，当横竖屏切换时，改控件可以自己定位上次浏览的位置。和ListView一样，支持添加header 和 footer。个人觉得这个才是最好的。
 * @author Darly/张宇辉/2018/3/6 11:14
 * @version 1.0/com.darly.darlyview.ui.staggered
 */
@ContentBinder(R.layout.activity_staggeredgrid)
public class StaggeredGridActivity extends BaseActivity implements View.OnClickListener {
    @ViewsBinder(R.id.id_stagger_title)
    TitleView id_stagger_title;
    @ViewsBinder(R.id.id_stagger_recyclerview)
    MultiColumnListView id_stagger_recyclerview;

    StaggerAdapter adapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_stagger_title.setTitle(R.string.app_name);
        }else {
            id_stagger_title.setTitle(bean.getTitle());
        }
        id_stagger_title.removeBackground(R.drawable.ic_title_background);

    }

    @Override
    protected void loadData() {
        adapter = new StaggerAdapter(CacheData.getStaggerData(),R.layout.item_stagger_recyclerview,this);
        id_stagger_recyclerview.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        id_stagger_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
    }
    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.title_view_back_img:
                onBackPressed();
                break;
        }
    }

}
