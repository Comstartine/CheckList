package com.example.checklist.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.checklist.R;
import com.example.checklist.activity.AboutVersion;
import com.example.checklist.activity.AccountSetting;

public class SetFragment extends Fragment {

    private View view;
    private TextView account,general_settings,concern,abnormal_feedback;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.setting_fragment,container,false);
        init();
        setOperationalLogic();
        return view;
    }

    private void setOperationalLogic() {
        account.setOnClickListener((View v) -> {
            startActivity(new Intent(getContext(), AccountSetting.class));
        });
        concern.setOnClickListener((View v) -> {
            startActivity(new Intent(getContext(), AboutVersion.class));
        });
        general_settings.setOnClickListener((View v) -> {
            Toast.makeText(getContext(), "后续更新", Toast.LENGTH_SHORT).show();
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pup_general_settings,
                null,false);
        builder.setView(view);
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.yes).setOnClickListener((View v1) -> {
            Toast.makeText(getContext(), "确认提交", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();
        });
        view.findViewById(R.id.no).setOnClickListener((View v2) -> {
            Toast.makeText(getContext(), "取消提交", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();
        });
        abnormal_feedback.setOnClickListener((View v) -> {
            alertDialog.show();
        });
    }

    private void init() {
        account = view.findViewById(R.id.accout);
        general_settings = view.findViewById(R.id.general_settings);
        concern = view.findViewById(R.id.concern);
        abnormal_feedback = view.findViewById(R.id.abnormal_feedback);
    }
}
