package com.darly.darlyview.ui.rebound;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.wedget.rebound.BaseSpringSystem;
import com.darly.darlyview.wedget.rebound.Spring;
import com.darly.darlyview.wedget.rebound.SpringListener;
import com.darly.darlyview.wedget.rebound.SpringSystem;
import com.darly.darlyview.wedget.rebound.SpringUtil;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

/**图片图标点击波动效果
 * @author Darly/张宇辉/2018/3/14 9:04
 * @version 1.0/com.darly.darlyview.ui.rebound
 */
@ContentBinder(R.layout.activity_rebound)
public class ReboundActivity extends BaseActivity implements SpringListener,View.OnClickListener {
    private final BaseSpringSystem mSpringSystem = SpringSystem.create();

    @ViewsBinder(R.id.id_rebound_title)
    TitleView id_rebound_title;

    @ViewsBinder(R.id.root_view)
    private FrameLayout mRootView;
    private Spring mScaleSpring;
    private View mImageView;


    @Override
    protected void initView(Bundle savedInstanceState) {
        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_rebound_title.setTitle(R.string.app_name);
        }else {
            id_rebound_title.setTitle(bean.getTitle());
        }
        id_rebound_title.removeBackground(R.drawable.ic_title_background);
    }

    @Override
    protected void loadData() {
        mImageView = mRootView.findViewById(R.id.image_view);
        // Create the animation spring.
        mScaleSpring = mSpringSystem.createSpring();
    }

    @Override
    protected void initListener() {
        id_rebound_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
        // Add an OnTouchListener to the root view.
        mRootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // When pressed start solving the spring to 1.
                        mScaleSpring.setEndValue(1);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // When released start solving the spring to 0.
                        mScaleSpring.setEndValue(0);
                        break;
                }
                return true;
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        // Add a listener to the spring when the Activity resumes.
        mScaleSpring.addListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Remove the listener to the spring when the Activity pauses.
        mScaleSpring.removeListener(this);
    }

    @Override
    public void onSpringUpdate(Spring spring) {
    // On each update of the spring value, we adjust the scale of the image view to match the
        // springs new value. We use the SpringUtil linear interpolation function mapValueFromRangeToRange
        // to translate the spring's 0 to 1 scale to a 100% to 50% scale range and apply that to the View
        // with setScaleX/Y. Note that rendering is an implementation detail of the application and not
        // Rebound itself. If you need Gingerbread compatibility consider using NineOldAndroids to update
        // your view properties in a backwards compatible manner.
        float mappedValue = (float) SpringUtil.mapValueFromRangeToRange(spring.getCurrentValue(), 0, 1, 1, 0.5);
        mImageView.setScaleX(mappedValue);
        mImageView.setScaleY(mappedValue);
    }

    @Override
    public void onSpringAtRest(Spring spring) {

    }

    @Override
    public void onSpringActivate(Spring spring) {

    }

    @Override
    public void onSpringEndStateChange(Spring spring) {

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
