package com.example.checklist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.checklist.CheckListApplication;
import com.example.checklist.Customize.KeyboardStateObserver;
import com.example.checklist.Customize.ScreenUtils;
import com.example.checklist.Customize.StatusBarUtils;
import com.example.checklist.R;

import java.util.Objects;

public class PopupTask extends BaseActicity {

    private Toolbar toolbar;
    private EditText editText;
    private LinearLayout layout;
    private RelativeLayout relativeLayout;
    private Context mContext = CheckListApplication.getContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Objects.requireNonNull(getWindow()).addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            Objects.requireNonNull(getWindow()).setStatusBarColor(getResources().getColor(R.color.white));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_task);
        iniView();
        setUpToolBar();
        KeyboardStateObserver.getKeyboardStateObserver(this)
                .setKeyboardVisibilityListener(new KeyboardStateObserver.OnKeyboardVisibilityListener() {
                    @Override
                    public void onKeyboardShow(int heightDifference) {
                        setEtQuickTodo(ScreenUtils.getScreenHeight() - StatusBarUtils.getStatusBarHeight(mContext) -
                                heightDifference - editText.getHeight());
                    }

                    @Override
                    public void onKeyboardHide() {
                        setEtQuickTodo(ScreenUtils.getScreenHeight() - StatusBarUtils.getStatusBarHeight(mContext) - layout.getHeight());
                    }
                });
    }

    @Override
    protected void iniView() {
        toolbar = findViewById(R.id.popup_task_toolbar);
        editText = findViewById(R.id.et_quick_todo);
        layout = findViewById(R.id.line_quick);
        relativeLayout = findViewById(R.id.relative_btn);
    }

    @Override
    protected void setUpToolBar() {
        toolbar.setNavigationOnClickListener((View v) -> {
            onBackPressed();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(layout,InputMethodManager.RESULT_SHOWN);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            out();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void out(){
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void setEtQuickTodo(int dpTop){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                layout.getHeight());
        layoutParams.setMargins(0, dpTop, 0, 0);
        layout.setLayoutParams(layoutParams);
    }
}