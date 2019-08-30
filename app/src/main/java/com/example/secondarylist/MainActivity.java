package com.example.secondarylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GroupRecyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<RecycleBean> childList;
    private FragmentBean fragmentBean;
    private LinkedHashMap<String, ArrayList<RecycleBean>> groupMap =
            new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_itemtype);

        // 测试数据，模拟
        fragmentBean = new FragmentBean();
        fragmentBean.setObject(new FragmentBean.ObjectBean());
        FragmentBean.ObjectBean.OneBean one = new FragmentBean.ObjectBean.OneBean();
        one.setStrOne("1");
        fragmentBean.getObject().setOneBean(one);
        List<FragmentBean.ObjectBean.OtherBean> mm = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            FragmentBean.ObjectBean.OtherBean other = new FragmentBean.ObjectBean.OtherBean();
            other.setStrOther("2");
            mm.add(other);
        }
        fragmentBean.getObject().setOtherBeanList(mm);

        myRecyclerViewDataType();
    }

    private void myRecyclerViewDataType() {

        final GridLayoutManager manager = new GridLayoutManager(this, 1, OrientationHelper.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItemViewType(position) == GroupRecyAdapter.GROUP_ITEM_TYPE ? manager.getSpanCount() : 1;
            }
        });
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new GroupRecyAdapter(this);

        initRecycleViewData();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mAdapter.setList(groupMap);
    }

    private void initRecycleViewData() {
        Gson gson = new Gson();

        // type 1
        childList = new ArrayList<>();
        RecycleBean recycleBean = new RecycleBean(false);
        String str = gson.toJson(fragmentBean.getObject().getOneBean());
        recycleBean.setIsType("1");
        recycleBean.setOneBean(gson.fromJson(str, RecycleBean.OneBean.class));
        childList.add(recycleBean);
        groupMap.put("1", childList);

        // type 2
        childList = new ArrayList<>();
        for (int i=0;i<fragmentBean.getObject().getOtherBeanList().size();i++){
            String strUser1 = gson.toJson(fragmentBean.getObject().getOtherBeanList().get(i));
            RecycleBean recycleBean2 = new RecycleBean(false);
            recycleBean2.setIsType("2");
            recycleBean2.setOtherBeanList(gson.fromJson(strUser1, RecycleBean.OtherBean.class));       ;
            childList.add(recycleBean2);
        }
        groupMap.put("2", childList);

        // type 3
        childList = new ArrayList<>();
        for (int y=0;y<fragmentBean.getObject().getOtherBeanList().size();y++){
            String strUser1 = gson.toJson(fragmentBean.getObject().getOtherBeanList().get(y));
            RecycleBean recycleBean3 = new RecycleBean(false);
            recycleBean3.setIsType("3");
            recycleBean3.setOtherBeanList(gson.fromJson(strUser1, RecycleBean.OtherBean.class));       ;
            childList.add(recycleBean3);
        }
        groupMap.put("3", childList);
    }

}
