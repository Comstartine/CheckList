package com.example.checklist.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.example.checklist.CheckListApplication;
import com.example.checklist.R;
import com.example.checklist.logic.entity.Label;
import com.example.checklist.logic.entity.Lists;
import com.loper7.date_time_picker.DateTimeConfig;
import com.loper7.date_time_picker.dialog.CardDatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.gujun.android.taggroup.TagGroup;

public class AddTask extends BaseActicity {

    private static final String TAG = "AddTask";
    private Context context = this;

    private TextView at_selectTime;
    private TextView at_text;
    private EditText at_readyTodo;
    private ImageView at_tag,at_file,at_priority,at_image;
    private TagGroup at_tags;

    //数据
    private List<Lists> lists;
    private List<Label> labels;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        iniView();
        setUpToolBar();
        setSelectTime();

    }

    private void setSelectTime(){

        at_selectTime.setText(simpleDateFormat.format(System.currentTimeMillis()));
        at_selectTime.setOnClickListener((View v) -> {
            selectTime();
        });
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
        at_text = findViewById(R.id.at_text);
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