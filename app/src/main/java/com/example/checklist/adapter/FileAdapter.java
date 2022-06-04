package com.example.checklist.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.checklist.Customize.ImageConstant;
import com.example.checklist.Customize.LogUtils;
import com.example.checklist.Customize.Tasks;
import com.example.checklist.R;
import com.example.checklist.logic.entity.Files;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.ViewHolder> {

    private Context context;
    private List<String> mList;
    private RecyclerView recyclerView;

    private OnItemClickListener listener;

    public FileAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.add_image_view);
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_add_image,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position < mList.size()) {
            //代表+号之前的需要正常显示图片
            String picUrl = mList.get(position); //图片路径
            Glide.with(context).load(picUrl).into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.add_image);//最后一个显示加号图片
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null && v!= null && recyclerView != null) {
                    int position = holder.getBindingAdapterPosition();
                    listener.OnItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        int cout = mList == null ? 1 : mList.size() + 1;
        if(cout > ImageConstant.MAX_SELECT_PIC_NUM){
            return mList.size();
        }else{
            return cout;
        }
    }
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
