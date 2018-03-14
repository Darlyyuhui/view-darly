package com.darly.darlyview.ui.mover;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.darly.common.DLog;
import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.ui.adapter.EffectAdapter;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.wedget.mover.Techniques;
import com.darly.darlyview.wedget.mover.YoYo;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

/**
 * @author Darly/张宇辉/2018/3/14 11:37
 * @version 1.0/com.darly.darlyview.ui.mover
 */
@ContentBinder(R.layout.activity_mover)
public class MoverActivity extends BaseActivity implements View.OnClickListener,OnItemClickListener{

    @ViewsBinder(R.id.id_mover_title)
    TitleView id_mover_title;

    @ViewsBinder(R.id.list_items)
    private ListView mListView;

    private EffectAdapter mAdapter;

    @ViewsBinder(R.id.hello_world)
    private View mTarget;

    private YoYo.YoYoString rope;


    @Override
    protected void initView(Bundle savedInstanceState) {
        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_mover_title.setTitle(R.string.app_name);
        }else {
            id_mover_title.setTitle(bean.getTitle());
        }
        id_mover_title.removeBackground(R.drawable.ic_title_background);
    }

    @Override
    protected void loadData() {
        mAdapter = new EffectAdapter(this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        id_mover_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
        id_mover_title.setRightViewRightTextOneListener("弹框",this);
        mListView.setOnItemClickListener(this);
        mTarget.setOnClickListener(this);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            rope = YoYo.with(Techniques.FadeIn).duration(1000).playOn(mTarget);// after start,just click mTarget view, rope is not init
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (rope != null) {
            rope.stop(true);
        }
        Techniques technique = (Techniques) view.getTag();
        rope = YoYo.with(technique)
                .duration(1200)
                .repeat(YoYo.INFINITE)
                .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                .interpolate(new AccelerateDecelerateInterpolator())
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        DLog.i("canceled previous animation");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .playOn(mTarget);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_view_back_img:
                onBackPressed();
                break;
            case R.id.title_view_ok:
                startActivity(new Intent(this, ExampleActivity.class));
                break;
            case R.id.hello_world:
                rope.stop(true);
                break;

        }
    }

}
