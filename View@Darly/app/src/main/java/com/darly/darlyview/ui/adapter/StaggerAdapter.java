package com.darly.darlyview.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.darly.common.ParentAdapter;
import com.darly.darlyview.R;

import java.util.List;

/**
 * @author Darly/张宇辉/2018/3/5 9:07
 * @version 1.0/com.darly.darlyview.ui.adapter
 */
public class StaggerAdapter extends ParentAdapter<RecyclerBean>{

    public StaggerAdapter(List<RecyclerBean> data, int resID, Context context) {
        super(data, resID, context);
    }

    @Override
    public View HockView(int position, View view, ViewGroup parent, int resID, Context context, RecyclerBean recyclerBean) {
        ViewHocker hocker = null;
        if (view ==null){
            view = LayoutInflater.from(context).inflate(resID,null);
            hocker = new ViewHocker();
            hocker.title = (TextView) view.findViewById(R.id.id_stagger_item_title);
            hocker.desc = (TextView) view.findViewById(R.id.id_stagger_item_desc);
            hocker.icon = (ImageView) view.findViewById(R.id.id_stagger_item_icon);
            view.setTag(hocker);
        }else {
            hocker = (ViewHocker) view.getTag();
        }
        hocker.title.setText(recyclerBean.getTitle());
        hocker.desc.setText(recyclerBean.getDesc());
        hocker.icon.setImageResource(recyclerBean.getIcon());
        return view;
    }

    class ViewHocker{
        TextView title;
        TextView desc;
        ImageView icon;
    }
}
