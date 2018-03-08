package com.darly.darlyview.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.darly.darlyview.R;
import com.darly.dview.common.SCfg;
import com.darly.dview.widget.camera.util.ImageLoaderUtil;

import java.util.List;

/**
 * @author Darly/张宇辉/2018/3/5 9:07
 * @version 1.0/com.darly.darlyview.ui.adapter
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHocker> implements View.OnClickListener {
    private Context context;
    private List<RecyclerBean> list;
    private OnRecyclerItemClickListener listener;
    private RecyclerView recyclerView;


    public RecyclerViewAdapter(Context context, List<RecyclerBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @Override
    public ViewHocker onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main_recyclerview,parent,false);
        view.setOnClickListener(this);
        return new ViewHocker(view);
    }

    @Override
    public void onBindViewHolder(ViewHocker holder, int position) {
        RecyclerBean bean = list.get(position);
        if (bean!=null){
            holder.icon.setImageResource(bean.getIcon());
            holder.title.setText(bean.getTitle());
            holder.desc.setText(bean.getDesc());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (recyclerView != null && listener != null){
            int position = recyclerView.getChildAdapterPosition(v);
            listener.OnRecyclerItemClick(recyclerView,v,position,list.get(position));
        }
    }

    /**
     * 删除指定数据
     * @param position 数据位置
     */
    public void remove(int position){
        list.remove(position);
        notifyItemRemoved(position);//这样就只会删除这一条数据，而不会一直刷
    }

    /**
     * 插入数据
     * @param position 插入位置
     * @param data 插入的数据
     */
    public void insert(int position,RecyclerBean data){
        list.add(position,data);
        notifyItemInserted(position);
    }

    public void update(int position,RecyclerBean data){
        list.set(position,data);
        notifyItemChanged(position,data);
    }

    public class ViewHocker extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView desc;
        private ImageView icon;

        public ViewHocker(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.id_main_item_title);
            desc = (TextView) itemView.findViewById(R.id.id_main_item_desc);
            icon = (ImageView) itemView.findViewById(R.id.id_main_item_icon);
            icon.setLayoutParams(new RelativeLayout.LayoutParams(SCfg.getWidth(),SCfg.getWidth()/2));
        }
    }

    /**
     * 自定义RecyclerView的点击事件
     */
    public interface OnRecyclerItemClickListener{
        void OnRecyclerItemClick(RecyclerView parent,View view,int position,RecyclerBean data);
    }

}