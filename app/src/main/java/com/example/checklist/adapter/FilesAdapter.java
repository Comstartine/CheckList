package com.example.checklist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.checklist.Customize.ImageConstant;
import com.example.checklist.R;

import java.util.List;

public class FilesAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;
    private LayoutInflater inflater;

    public FilesAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        int cout = mList == null ? 1 : mList.size() + 1;
        if(cout > ImageConstant.MAX_SELECT_PIC_NUM){
            return mList.size();
        }else{
            return cout;
        }
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_add_image, parent,false);
        ImageView iv = (ImageView) convertView.findViewById(R.id.add_image_view);
        if (position < mList.size()) {
            //代表+号之前的需要正常显示图片
            String picUrl = mList.get(position); //图片路径
            Glide.with(mContext).load(picUrl).into(iv);
        } else {
            iv.setImageResource(R.drawable.add_image);//最后一个显示加号图片
        }
        return convertView;
    }

}
