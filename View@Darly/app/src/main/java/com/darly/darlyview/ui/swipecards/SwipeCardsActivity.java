package com.darly.darlyview.ui.swipecards;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.ui.adapter.RecyclerBean;
import com.darly.darlyview.wedget.swipecards.SwipeFlingAdapterView;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

import java.util.ArrayList;

/**一个实现了可滑动卡片风格的开源项目，类似国外很火的交友软件Tinder中的卡片效果，图中的卡片可左右滑动飞出界面，分别表示喜欢和不喜欢。
 * @author Darly/张宇辉/2018/3/6 14:12
 * @version 1.0/com.darly.darlyview.ui.swipecards
 */

@ContentBinder(R.layout.activity_swipecards)
public class SwipeCardsActivity extends BaseActivity implements OnClickListener {
    @ViewsBinder(R.id.frame)
    SwipeFlingAdapterView flingContainer;
    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;
    @ViewsBinder(R.id.id_swipe_title)
    TitleView id_swipe_title;

    @Override
    protected void initView(Bundle savedInstanceState) {
        RecyclerBean bean = (RecyclerBean) getIntent().getSerializableExtra("RecyclerBean");
        if (bean == null) {
            id_swipe_title.setTitle(R.string.app_name);
        }else {
            id_swipe_title.setTitle(bean.getTitle());
        }
        id_swipe_title.removeBackground(R.drawable.ic_title_background);


        al = new ArrayList<>();
        al.add("php");
        al.add("c");
        al.add("python");
        al.add("java");
        al.add("html");
        al.add("c++");
        al.add("css");
        al.add("javascript");
    }

    @Override
    protected void loadData() {
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_swipecards, R.id.helloText, al );
        flingContainer.setAdapter(arrayAdapter);
    }

    @Override
    protected void initListener() {
        id_swipe_title.setLeftBackOneListener(R.mipmap.ic_title_back,this);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });
        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_view_back_img:
                onBackPressed();
                break;
//            case R.id.left:
//                flingContainer.getTopCardListener().selectLeft();
//                break;
//            case R.id.right:
//                flingContainer.getTopCardListener().selectRight();
//                break;
        }

    }
}
