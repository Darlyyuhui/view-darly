package com.darly.darlyview.ui.mover;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.wedget.mover.Techniques;
import com.darly.darlyview.wedget.mover.YoYo;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

/**
 * @author Darly/张宇辉/2018/3/14 14:41
 * @version 1.0/com.darly.darlyview.ui.mover
 */
@ContentBinder(R.layout.activity_example)
public class ExampleActivity extends BaseActivity implements View.OnClickListener {

    @ViewsBinder(R.id.id_example_title)
    TitleView id_example_title;
    @ViewsBinder(R.id.notice)
    TextView note;
    @ViewsBinder(R.id.submit)
    Button submit;
    @ViewsBinder(R.id.notice2)
    TextView note2;
    @ViewsBinder(R.id.submit2)
    Button submit2;


    @Override
    protected void initView(Bundle savedInstanceState) {
        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_example_title.setTitle(R.string.app_name);
        }else {
            id_example_title.setTitle(bean.getTitle());
        }
        id_example_title.removeBackground(R.drawable.ic_title_background);
    }

    @Override
    protected void loadData() {
        note.setText("Please input your Email and Password");
        note2.setText("Please input your Email and Password");
    }

    @Override
    protected void initListener() {
        id_example_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
        submit.setOnClickListener(this);
        submit2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_view_back_img:
                onBackPressed();
                break;
            case R.id.submit:
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .playOn(findViewById(R.id.edit_area));
                note.setText("Wrong password!");


                break;
            case R.id.submit2:
                YoYo.with(Techniques.Shake).playOn(findViewById(R.id.edit_area2));
                note2.setText("Wrong password!");
                break;
        }
    }
}
