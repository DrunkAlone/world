package com.example.worldtest.ui.dashboard;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldtest.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.example.worldtest.ActivityCollectorUtil.addActivity;

public class DiscoverActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        addActivity(this);

      //  Bmob.initialize(this, "77494e1ab861a4159c7161d78fa33b53");

        /*增加一条数据
        Moment moment = new Moment();
        moment.setUser_name("Min");
        moment.setUser_avatar("Avatar");
        moment.setContent("This is content.");
        moment.setPicture("Picture");
        moment.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e!=null) {
                    Toast.makeText(DiscoverActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DiscoverActivity.this, "success", Toast.LENGTH_LONG).show();
                }
            }
        });*/

    }
}
