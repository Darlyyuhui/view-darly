package com.darly.darlyview.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.darly.darlyview.R;
import com.darly.darlyview.wedget.focusresize.FocusResizeAdapter;
import com.darly.dview.common.SCfg;
import com.darly.dview.widget.camera.util.ImageLoaderUtil;

import java.util.List;

/**
 * @author Darly/张宇辉/2018/3/5 9:07
 * @version 1.0/com.darly.darlyview.ui.adapter
 */
public class RecyclerViewAdapter extends FocusResizeAdapter<RecyclerView.ViewHolder> implements OnClickListener{


    public static final int OFFSET_TEXT_SIZE = 4;
    public static final float OFFSET_TEXT_ALPHA = 100f;
    public static final float ALPHA_SUBTITLE = 0.81f;
    public static final float ALPHA_SUBTITLE_HIDE = 0f;
    private Context context;
    private List<RecyclerBean> list;

    private OnRecyclerItemClickListener listener;
    private RecyclerView recyclerView;

    public RecyclerViewAdapter(Context context, int height,List<RecyclerBean> list,RecyclerView recyclerView) {
        super(context, height);
        this.context = context;
        this.list = list;
        this.recyclerView = recyclerView;
    }

    public void setData(List<RecyclerBean> items) {
        this.list.addAll(items);
        notifyDataSetChanged();
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemBigResize(RecyclerView.ViewHolder viewHolder, int position, int dyAbs) {
//        if (((RecyclerViewHolder) viewHolder).title.getTextSize() + (dyAbs / OFFSET_TEXT_SIZE) >= context.getResources().getDimension(R.dimen.font_xxxlarge)) {
//            ((RecyclerViewHolder) viewHolder).title.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.font_xxxlarge));
//        } else {
//            ((RecyclerViewHolder) viewHolder).title.setTextSize(TypedValue.COMPLEX_UNIT_PX, ((RecyclerViewHolder) viewHolder).title.getTextSize() + (dyAbs / OFFSET_TEXT_SIZE));
//        }
//
//        float alpha = dyAbs / OFFSET_TEXT_ALPHA;
//        if (((RecyclerViewHolder) viewHolder).desc.getAlpha() + alpha >= ALPHA_SUBTITLE) {
//            ((RecyclerViewHolder) viewHolder).desc.setAlpha(ALPHA_SUBTITLE);
//        } else {
//            ((RecyclerViewHolder) viewHolder).desc.setAlpha(((RecyclerViewHolder) viewHolder).desc.getAlpha() + alpha);
//        }
    }

    @Override
    public void onItemBigResizeScrolled(RecyclerView.ViewHolder viewHolder, int position, int dyAbs) {
//        ((RecyclerViewHolder) viewHolder).title.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.font_xxxlarge));
//        ((RecyclerViewHolder) viewHolder).desc.setAlpha(ALPHA_SUBTITLE);
    }

    @Override
    public void onItemSmallResizeScrolled(RecyclerView.ViewHolder viewHolder, int position, int dyAbs) {
//        ((RecyclerViewHolder) viewHolder).title.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.font_medium));
//        ((RecyclerViewHolder) viewHolder).desc.setAlpha(ALPHA_SUBTITLE_HIDE);
    }

    @Override
    public void onItemSmallResize(RecyclerView.ViewHolder viewHolder, int position, int dyAbs) {
//        if (((RecyclerViewHolder) viewHolder).title.getTextSize() - (dyAbs / OFFSET_TEXT_SIZE) <= context.getResources().getDimension(R.dimen.font_medium)) {
//            ((RecyclerViewHolder) viewHolder).title.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.font_medium));
//        } else {
//            ((RecyclerViewHolder) viewHolder).title.setTextSize(TypedValue.COMPLEX_UNIT_PX, ((RecyclerViewHolder) viewHolder).title.getTextSize() - (dyAbs / OFFSET_TEXT_SIZE));
//        }
//
//        float alpha = dyAbs / OFFSET_TEXT_ALPHA;
//        if (((RecyclerViewHolder) viewHolder).desc.getAlpha() - alpha < ALPHA_SUBTITLE_HIDE) {
//            ((RecyclerViewHolder) viewHolder).desc.setAlpha(ALPHA_SUBTITLE_HIDE);
//        } else {
//            ((RecyclerViewHolder) viewHolder).desc.setAlpha(((RecyclerViewHolder) viewHolder).desc.getAlpha() - alpha);
//        }
    }

    @Override
    public void onItemInit(RecyclerView.ViewHolder viewHolder) {
//        ((RecyclerViewHolder) viewHolder).title.setTextSize(TypedValue.COMPLEX_UNIT_PX,
//                context.getResources().getDimensionPixelSize(R.dimen.font_xxxlarge));
//        ((RecyclerViewHolder) viewHolder).desc.setAlpha(ALPHA_SUBTITLE);
    }

    @Override
    public int getFooterItemCount() {
        return list ==null?0:list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recyclerview, parent, false);
        v.setOnClickListener(this);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerBean customObject = list.get(position);
        fill((RecyclerViewHolder) holder, customObject);
    }

    private void fill(RecyclerViewHolder holder, RecyclerBean bean) {
        if (bean!=null){
            holder.icon.setImageResource(bean.getIcon());
            holder.title.setText(bean.getId()+bean.getTitle());
            holder.desc.setText(bean.getDesc());
        }
    }

    @Override
    public void onClick(View v) {
        if (recyclerView != null && listener != null){
            int position = recyclerView.getChildAdapterPosition(v);
            listener.OnRecyclerItemClick(recyclerView,v,position,list.get(position));
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView desc;
        private ImageView icon;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.id_main_item_title);
            desc = (TextView) itemView.findViewById(R.id.id_main_item_desc);
            icon = (ImageView) itemView.findViewById(R.id.id_main_item_icon);
//            icon.setLayoutParams(new RelativeLayout.LayoutParams(SCfg.getWidth(),SCfg.getWidth()/2));
        }
    }



    /**
     * 自定义RecyclerView的点击事件
     */
    public interface OnRecyclerItemClickListener{
        void OnRecyclerItemClick(RecyclerView parent,View view,int position,RecyclerBean data);
    }

}
