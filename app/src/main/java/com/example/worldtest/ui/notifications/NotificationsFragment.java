package com.example.worldtest.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.worldtest.R;
import com.example.worldtest.loginActivity;
import com.example.worldtest.myinfo.SettingsByPreferenceActivity;
import com.example.worldtest.ui.home.find;

import static com.example.worldtest.ActivityCollectorUtil.finishAllActivity;

public class NotificationsFragment extends Fragment {

    private String name;
    private String password;
    private View root;

    public static NotificationsFragment newInstance() {
        Bundle args = new Bundle();
        NotificationsFragment fragment = new NotificationsFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

            root = inflater.inflate(R.layout.fragment_notifications, container, false);
            //final TextView tv_main_hello = root.findViewById(R.id.tv_main_hello);
            Intent intent = getActivity().getIntent();
            name = intent.getStringExtra("name");
            password = intent.getStringExtra("password");
            initView(root);
            return root;
    }
    private void initView(View root){

        if (name != null && password != null) {
            final TextView tv_main_hello = root.findViewById(R.id.tv_main_hello);
            tv_main_hello.setText("欢迎您，用户：" + name);
        } else {
            Intent intent2 = getActivity().getIntent();
            name = intent2.getStringExtra("username");
            String password2 = intent2.getStringExtra("password");
            final TextView tv_main_hello = root.findViewById(R.id.tv_main_hello);
            tv_main_hello.setText("欢迎您，用户：" + name);
        }
        final Button mBtMainLogout = root.findViewById(R.id.bt_main_logout);
        mBtMainLogout.setOnClickListener(v -> {
            finishAllActivity();
            Intent intent1 = new Intent(NotificationsFragment.this.getActivity(), loginActivity.class);
            startActivity(intent1);

        });
        final Button mBtMainInfo = root.findViewById(R.id.bt_main_info);
        mBtMainInfo.setOnClickListener(v -> {
            Intent intent12 = new Intent(NotificationsFragment.this.getActivity(), InfoActivity.class);
            intent12.putExtra("name", name);
            intent12.putExtra("password", password);
            startActivity(intent12);

        });
        final Button mBtMainSetting = root.findViewById(R.id.bt_main_setting);
        mBtMainSetting.setOnClickListener(view -> {
            Intent intent13 = new Intent(NotificationsFragment.this.getActivity(), SettingsByPreferenceActivity.class);
            startActivity(intent13);
        });

    }
}