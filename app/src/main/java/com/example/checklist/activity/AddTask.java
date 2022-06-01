package com.example.checklist.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.checklist.CheckListApplication;
import com.example.checklist.Customize.LogUtils;
import com.example.checklist.R;
import com.example.checklist.logic.AppDatabase;
import com.example.checklist.logic.entity.Files;
import com.example.checklist.logic.entity.Label;
import com.example.checklist.logic.entity.Lists;
import com.loper7.date_time_picker.DateTimeConfig;
import com.loper7.date_time_picker.dialog.CardDatePickerDialog;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.gujun.android.taggroup.TagGroup;

public class AddTask extends BaseActicity {
    private static final String TAG = "AddTask";
    private Context context = this;

    private TextView at_selectTime;
    private EditText at_edits;
    private EditText at_readyTodo;
    private ImageView at_tag,at_file,at_priority,at_image;
    private TagGroup at_tags;

    //数据
    private List<Lists> lists;
    private List<Label> labels;
    private List<Files> files;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
    //private AppDatabase db = AppDatabase.getInstance(context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        iniView();//绑定控件
        setUpToolBar();//设置toolbar
        setSelectTime();//选择时间
        selectLabel();//选择标签
        getEditText();
    }

    private void getEditText(){
        at_edits.getText();
        //数据库操作
    }

    private void setImage(){

    }

    private void setSelectTime(){
        at_selectTime.setText(simpleDateFormat.format(System.currentTimeMillis()));
        at_selectTime.setOnClickListener((View v) -> {
            selectTime();
        });
    }

    private void selectLabel(){
        AlertDialog alertDialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialog_label = LayoutInflater.from(context).inflate(R.layout.addtask_labels_dialog,
                null,false);
        builder.setView(dialog_label);
        builder.setCancelable(false);
        alertDialog = builder.create();
        AlertDialog finalAlertDialog = alertDialog;
        dialog_label.findViewById(R.id.dialog_cancel).setOnClickListener((View v) ->{
            finalAlertDialog.dismiss();
        });
        at_tag.setOnClickListener((View v) ->{
            finalAlertDialog.show();
        });
        List<String> select_tags = setTags(dialog_label);
        dialog_label.findViewById(R.id.dialog_submit_normal).setOnClickListener((View v) ->{
            at_tags.setTags(select_tags);
            finalAlertDialog.dismiss();
        });
    }

    @NonNull
    private List<String> setTags(View dialog_label){
        TagGroup tagGroup_normal = dialog_label.findViewById(R.id.dialog_labels_normal);
        TagGroup tagGroup_add = dialog_label.findViewById(R.id.dialog_labels_add);
        TextView add = dialog_label.findViewById(R.id.dialog_add);
        TextView submit_normal = dialog_label.findViewById(R.id.dialog_submit_normal);
        TextView submit_add = dialog_label.findViewById(R.id.dialog_submit_add);
        TextView cancel = dialog_label.findViewById(R.id.dialog_cancel);
        //获取数据库中的数据
        List<String> tags = new ArrayList<>();
        if(tags.size() == 0){
            dialog_label.findViewById(R.id.dialog_no_tag).setVisibility(View.VISIBLE);
        }else {
            tagGroup_normal.setTags(tags);
            tagGroup_add.setTags(tags);
        }
        add.setOnClickListener((View v) ->{
            tagGroup_add.setVisibility(View.VISIBLE);
            tagGroup_normal.setVisibility(View.INVISIBLE);
            cancel.setVisibility(View.INVISIBLE);
            add.setVisibility(View.INVISIBLE);
            submit_add.setVisibility(View.VISIBLE);
            submit_normal.setVisibility(View.INVISIBLE);
            dialog_label.findViewById(R.id.dialog_no_tag).setVisibility(View.INVISIBLE);
            submit_add.setOnClickListener((View v2) ->{
                tagGroup_add.setVisibility(View.INVISIBLE);
                tagGroup_normal.setVisibility(View.VISIBLE);
                cancel.setVisibility(View.VISIBLE);
                add.setVisibility(View.VISIBLE);
                submit_add.setVisibility(View.INVISIBLE);
                submit_normal.setVisibility(View.VISIBLE);
                tagGroup_normal.setTags(tagGroup_add.getTags());
                //数据库操作,更新标签数据

            });
        });
        List<String> select_tags = new ArrayList<>();
        tagGroup_normal.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                Toast.makeText(AddTask.this, "你点击了" + tag, Toast.LENGTH_SHORT).show();
//                tagGroup_normal.getTag
                //更新数据库
//                new Thread(() -> {
//                    select_tags.add(tag);
//                }).run();
                if(!select_tags.contains(tag))
                    select_tags.add(tag);
            }
        });
        return select_tags;
    }


    private void selectTime(){
        new CardDatePickerDialog.Builder(context)
                .setTitle("请选择日程日期和时间")
                .showFocusDateInfo(true)
                .setWrapSelectorWheel(false)
                .setDisplayType(DateTimeConfig.YEAR,DateTimeConfig.MONTH,DateTimeConfig.DAY,DateTimeConfig.HOUR,DateTimeConfig.MIN)
                .showBackNow(false)
                .setBackGroundModel(CardDatePickerDialog.CARD)
                .showFocusDateInfo(true)
                .setBackGroundModel(CardDatePickerDialog.STACK)
                .setOnChoose("确定", (Long aLong) -> {
                    at_selectTime.setText(simpleDateFormat.format(aLong));
                    return null;
                }).build().show();
    }

    @Override
    protected void iniView() {
        at_selectTime = findViewById(R.id.at_selectTime);
        at_edits = findViewById(R.id.at_edit);
        at_readyTodo = findViewById(R.id.at_ReadyTodo);
        at_tag = findViewById(R.id.at_tag);
        at_file = findViewById(R.id.at_file);
        at_priority = findViewById(R.id.at_priority);
        at_image = findViewById(R.id.at_image);
        at_tags = findViewById(R.id.at_tags);
    }

    @Override
    protected void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.at_toolbar);
        Spinner spinner = findViewById(R.id.at_spinner);

        toolbar.setNavigationOnClickListener((View v) -> {
            onBackPressed();
        });
    }
}