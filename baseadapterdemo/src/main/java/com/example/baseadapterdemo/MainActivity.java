package com.example.baseadapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.baseadapterdemo.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<Bean> mDatas;
    private MyAdapter mAdapter;

    private MyAdapterWidthCommonViewHolder myAdapterWidthCommonViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();

        initView();

    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.id_listview);

//        if (mListView != null) {
//            mListView.setAdapter(mAdapter);
            mListView.setAdapter(myAdapterWidthCommonViewHolder);
//        }
    }

    private void initDatas() {

        mDatas = new ArrayList<>();

        Bean bean = new Bean("Android新技能Get 1",
                "Android打造万能的ListView和GridView适配器", "2016-6-6", "10086");
        mDatas.add(bean);

        bean = new Bean("Android新技能Get 2",
                "Android打造万能的ListView和GridView适配器", "2016-6-6", "10086");
        mDatas.add(bean);

        bean = new Bean("Android新技能Get 3",
                "Android打造万能的ListView和GridView适配器", "2016-6-6", "10086");
        mDatas.add(bean);

        bean = new Bean("Android新技能Get 4",
                "Android打造万能的ListView和GridView适配器", "2016-6-6", "10086");
        mDatas.add(bean);

        bean = new Bean("Android新技能Get 5",
                "Android打造万能的ListView和GridView适配器", "2016-6-6", "10086");
        mDatas.add(bean);

        mAdapter = new MyAdapter(this, mDatas);

        myAdapterWidthCommonViewHolder = new MyAdapterWidthCommonViewHolder(this, mDatas);

    }
}
