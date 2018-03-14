package com.darly.darlyview.ui.lottie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;

/**各种交互动画
 * @author Darly/张宇辉/2018/3/14 9:25
 * @version 1.0/com.darly.darlyview.ui.lottie
 */
public class LottieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        initView();
        loadData();
        initListener();
    }

    protected void initView() {

    }

    protected void loadData() {

    }

    protected void initListener() {

    }

}
