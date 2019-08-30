package com.example.secondarylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;


public class GroupRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int GROUP_ITEM_TYPE = 0;
    public static final int CHILD_ITEM_TYPE_ONE = 1;
    public static final int CHILD_ITEM_TYPE_TWO = 2;
    public static final int CHILD_ITEM_TYPE_THREE =3;
    private List<RecycleBean> mList = new ArrayList<>();
    private LayoutInflater inflater;
    private Context mContext;

    public GroupRecyAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }


    public void setList(LinkedHashMap<String, ArrayList<RecycleBean>> map) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            if (map.get(key).size() > 0) {
                RecycleBean recycleBean=new RecycleBean(true);
                recycleBean.setIsType(key);
                mList.add(recycleBean);
            }
            mList.addAll(map.get(key));
        }
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        if (viewType == GROUP_ITEM_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
            holder = new GroupViewHolder(view);
        } else if (viewType == CHILD_ITEM_TYPE_ONE) {
            // type 1
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type1, parent, false);
            holder = new ChildViewOneHolder(view);
        }else if (viewType == CHILD_ITEM_TYPE_TWO) {
            // type 2
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type2, parent, false);
            holder = new ChildViewTwoHolder(view);
        }else if (viewType == CHILD_ITEM_TYPE_THREE) {
            // type 3
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type3, parent, false);
            holder = new ChildViewThreeHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final RecycleBean bean = mList.get(position);
        int type = holder.getItemViewType();
        if (type == GROUP_ITEM_TYPE) {
            GroupViewHolder holder1 = (GroupViewHolder) holder;
            if ("1".equals(bean.getIsType()) ){
                holder1.tvTitle.setText("Type 1");
                holder1.tvClick.setVisibility(View.GONE);
            }else if ("2".equals(bean.getIsType())){
                holder1.tvTitle.setText("Type 2");
                holder1.tvClick.setText("Click");
                holder1.tvClick.setVisibility(View.VISIBLE);
                holder1.tvClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"click",Toast.LENGTH_SHORT).show();
                    }
                });
            }else if ("3".equals(bean.getIsType())){
                holder1.tvTitle.setText("Type 3");
                holder1.tvClick.setVisibility(View.GONE);
            }
        } else  if (type == CHILD_ITEM_TYPE_ONE){
            ChildViewOneHolder holder1 = (ChildViewOneHolder) holder;
           holder1.tvChild.setText(String.valueOf(position));
        }else  if (type == CHILD_ITEM_TYPE_TWO){
            ChildViewTwoHolder holder1 = (ChildViewTwoHolder) holder;
            holder1.tvChild.setText(String.valueOf(position));
        }else  if (type == CHILD_ITEM_TYPE_THREE){
            ChildViewThreeHolder holder1 = (ChildViewThreeHolder) holder;
            holder1.tvChild.setText(String.valueOf(position));
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).isGroup()){
            return GROUP_ITEM_TYPE;
        }else {
            if ("1".equals(mList.get(position).getIsType())) {
                return CHILD_ITEM_TYPE_ONE;
            } else if ("2".equals(mList.get(position).getIsType())) {
                return CHILD_ITEM_TYPE_TWO;
            } else if ("3".equals(mList.get(position).getIsType())) {
                return CHILD_ITEM_TYPE_THREE;
            }
        }

        return -1;
    }

    /**
     * group
     */
    class GroupViewHolder extends RecyclerView.ViewHolder {
        // 分组名称，查看更多
        TextView tvTitle,tvClick;
        public GroupViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvClick = (TextView) itemView.findViewById(R.id.tv_click);
        }
    }

    /**
     * type 1
     */
    class ChildViewOneHolder extends RecyclerView.ViewHolder {
       TextView tvChild;
        public ChildViewOneHolder(View itemView) {
            super(itemView);
            tvChild = (TextView) itemView.findViewById(R.id.tv_child);
        }
    }
    /**
     * type 2
     */
    class ChildViewTwoHolder extends RecyclerView.ViewHolder {
        TextView tvChild;
        public ChildViewTwoHolder(View itemView) {
            super(itemView);
            tvChild = (TextView) itemView.findViewById(R.id.tv_child);
        }
    }

    /**
     * type 3
     */
    class ChildViewThreeHolder extends RecyclerView.ViewHolder {
        TextView tvChild;
        public ChildViewThreeHolder(View itemView) {
            super(itemView);
            tvChild = (TextView) itemView.findViewById(R.id.tv_child);
        }
    }
}
