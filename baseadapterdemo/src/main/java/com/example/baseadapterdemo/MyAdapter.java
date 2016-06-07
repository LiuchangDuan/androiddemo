package com.example.baseadapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baseadapterdemo.bean.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class MyAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Bean> mDatas;

    public MyAdapter(Context context, List<Bean> datas) {
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

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_listview, parent, false);
            holder = new ViewHolder();

            holder.mTitle = (TextView) convertView.findViewById(R.id.id_title);
            holder.mDescript = (TextView) convertView.findViewById(R.id.id_descript);
            holder.mTime = (TextView) convertView.findViewById(R.id.id_time);
            holder.mPhone = (TextView) convertView.findViewById(R.id.id_phone);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Bean bean = mDatas.get(position);
        //如果数据是int类型，记得转化为String类型
        //setText(int)中传的是资源文件的id
        holder.mTitle.setText(bean.getTitle());
        holder.mDescript.setText(bean.getDescript());
        holder.mTime.setText(bean.getTime());
        holder.mPhone.setText(bean.getPhone());

        return convertView;
    }

    private class ViewHolder {
        TextView mTitle;
        TextView mDescript;
        TextView mTime;
        TextView mPhone;
    }

}
