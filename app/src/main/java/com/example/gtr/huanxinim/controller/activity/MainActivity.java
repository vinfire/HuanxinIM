package com.example.gtr.huanxinim.controller.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.gtr.huanxinim.R;
import com.example.gtr.huanxinim.controller.fragment.ChatFragment;
import com.example.gtr.huanxinim.controller.fragment.ContactListFragment;
import com.example.gtr.huanxinim.controller.fragment.SettingFragment;

public class MainActivity extends FragmentActivity {

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
        initListener();
    }

    private void initView() {
        rgMain = (RadioGroup) findViewById(R.id.rg_main);
    }

    private void initData() {
        chatFragment = new ChatFragment();
        contactListFragment = new ContactListFragment();
        settingFragment = new SettingFragment();

        //默认选择会话列表页面
        rgMain.check(R.id.rb_main_chat);
    }

    private void initListener() {
        // RadioGroup的选择事件
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Fragment fragment = null;
                switch (checkedId){
                    //会话列表页面
                    case R.id.rb_main_chat:
                        fragment = chatFragment;
                        break;

                    //联系人列表页面
                    case R.id.rb_main_contact:
                        fragment = contactListFragment;
                        break;

                    //设置页面
                    case R.id.rb_main_setting:
                        fragment = settingFragment;
                        break;
                    default:
                        break;
                }

                //切换fragment
                switchFragment(fragment);
            }
        });
    }

    //切换fragment
    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_main, fragment).commit();
    }

}