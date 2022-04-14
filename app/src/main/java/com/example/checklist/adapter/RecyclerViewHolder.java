package com.example.checklist.adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.checklist.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    private Context context;

    public RecyclerViewHolder(@NonNull View itemView,Context context) {
        super(itemView);
        this.context = context;
        this.views = new SparseArray<>();
    }
    /**
     * 取得一个RecyclerHolder对象
     *
     * @param context 上下文
     * @param itemView 子项
     * @return 返回一个RecyclerHolder对象
     */
    public static RecyclerViewHolder getRecyclerViewHolder(Context context, View itemView){
        return new RecyclerViewHolder(itemView,context);
    }

    public SparseArray<View> getViews(){
        return this.views;
    }
    /**
     * 通过view的id获取对应的控件，如果没有则加入views中
     *
     * @param viewId 控件的id
     * @return 返回一个控件
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId){
        View view = views.get(viewId);
        if(view == null){
            view = itemView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (T)view;
    }

    /**
     * 设置字符串
     */
    public RecyclerViewHolder setText(int viewId,String text){
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }
    /**
     * 设置图片资源
     */
    public RecyclerViewHolder setImageResource(int viewId,int imageId){
        Glide.with(context).load(imageId).into((ImageView) getView(viewId));
        return this;
    }
    //Uri地址的图片资源
    public RecyclerViewHolder setImageResource(int viewId, Uri uri){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(R.mipmap.ic_launcher);
        requestOptions.placeholder(R.mipmap.ic_launcher);
        Glide.with(context).load(uri).apply(requestOptions).into((ImageView) getView(viewId));
        return this;
    }
    //Bitmap资源
    public RecyclerViewHolder setImageResource(int viewId, Bitmap bitmapId){
        Glide.with(context).load(bitmapId).into((ImageView) getView(viewId));
        return this;
    }
    //Drawable资源
    public RecyclerViewHolder setImageResource(int viewId, Drawable drawableId){
        Glide.with(context).load(drawableId).into((ImageView) getView(viewId));
        return this;
    }

}
