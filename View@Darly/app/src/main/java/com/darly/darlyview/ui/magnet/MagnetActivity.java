package com.darly.darlyview.ui.magnet;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;

import com.darly.common.ToastApp;
import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.wedget.magnet.MagnetImageView;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

/**
 * @author Darly/张宇辉/2018/3/27 10:18
 * @version 1.0/com.darly.darlyview.ui.magnet
 */
@ContentBinder(R.layout.activity_magnet)
public class MagnetActivity extends BaseActivity implements OnClickListener{


    @ViewsBinder(R.id.id_magnet_title)
    TitleView id_magnet_title;

    @ViewsBinder(R.id.id_magnet_iv)
    MagnetImageView id_magnet_iv;

    @Override
    protected void initView(Bundle savedInstanceState) {
        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_magnet_title.setTitle(R.string.app_name);
        }else {
            id_magnet_title.setTitle(bean.getTitle());
        }
        id_magnet_title.removeBackground(R.drawable.ic_title_background);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        id_magnet_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
        id_magnet_iv.setOnClickIntent(new MagnetImageView.OnViewClick() {
            @Override
            public void onClick() {
                ToastApp.showToast("效果如何？");
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
}
