package com.darly.darlyview.ui.shapeloading;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.wedget.shapeloading.ShapeLoadingDialog;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

/**跳跃效果的加载动画，类似于58同城的加载效果。
 * @author Darly/张宇辉/2018/3/8 9:02
 * @version 1.0/com.darly.darlyview.ui.shapeloading
 */
@ContentBinder(R.layout.activity_shapeloading)
public class ShapeLoadingActivity extends BaseActivity implements OnClickListener{
    @ViewsBinder(R.id.id_shapeloading_title)
    TitleView id_shapeloading_title;

    private ShapeLoadingDialog shapeLoadingDialog;

    @Override
    protected void initView(Bundle savedInstanceState) {
        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_shapeloading_title.setTitle(R.string.app_name);
        }else {
            id_shapeloading_title.setTitle(bean.getTitle());
        }
        id_shapeloading_title.removeBackground(R.drawable.ic_title_background);

    }

    @Override
    protected void loadData() {
        shapeLoadingDialog = new ShapeLoadingDialog.Builder(this)
                .loadText("加载中...")
                .build();
    }

    @Override
    protected void initListener() {
        id_shapeloading_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
        id_shapeloading_title.setRightViewRightTextOneListener("弹框",this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_view_back_img:
                onBackPressed();
                break;
            case R.id.title_view_ok:
                shapeLoadingDialog.show();
                break;
        }
    }

}
