package com.aomao.fastdev;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private List<Bean> objects = new ArrayList<Bean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, List<Bean> datas) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        objects=datas;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Bean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_listview, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((Bean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(Bean object, ViewHolder holder) {
        //TODO implement
        holder.titleTv.setText(object.getTitle());
        holder.descTv.setText(object.getDesc());
        holder.timeTv.setText(object.getTime());
        holder.phoneTv.setText(object.getPhone());
    }

    protected class ViewHolder {
        private TextView titleTv;
    private TextView descTv;
    private TextView timeTv;
    private TextView phoneTv;

        public ViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.titleTv);
            descTv = (TextView) view.findViewById(R.id.descTv);
            timeTv = (TextView) view.findViewById(R.id.timeTv);
            phoneTv = (TextView) view.findViewById(R.id.phoneTv);
        }
    }
}
