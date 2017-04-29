package com.example.gtr.huanxinim.controller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.gtr.huanxinim.R;
import com.example.gtr.huanxinim.controller.fragment.ChatFragment;
import com.example.gtr.huanxinim.controller.fragment.ContactListFragment;
import com.example.gtr.huanxinim.controller.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgMain;
    private ChatFragment chatFragment;
    private ContactListFragment contactListFragment;
    private SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        chatFragment = new ChatFragment();
        contactListFragment = new ContactListFragment();
        settingFragment = new SettingFragment();
    }

    private void initView() {
        rgMain = (RadioGroup) findViewById(R.id.rg_main);
    }
}