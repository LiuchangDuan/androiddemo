package com.example.baseadapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baseadapterdemo.bean.Bean;
import com.example.baseadapterdemo.utils.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class MyAdapterWidthCommonViewHolder extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Bean> mDatas;
    private Context mContext;

    public MyAdapterWidthCommonViewHolder(Context context, List<Bean> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, R.layout.item_listview, position);

        Bean bean = mDatas.get(position);

        TextView title = holder.getView(R.id.id_title);
        title.setText(bean.getTitle());
        TextView desc = holder.getView(R.id.id_descript);
        desc.setText(bean.getDescript());
        ((TextView)holder.getView(R.id.id_time)).setText(bean.getTime());
        ((TextView)holder.getView(R.id.id_phone)).setText(bean.getPhone());

        return holder.getConvertView();
    }

}
