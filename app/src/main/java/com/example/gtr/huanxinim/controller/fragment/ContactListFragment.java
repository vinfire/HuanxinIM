package com.example.gtr.huanxinim.controller.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.gtr.huanxinim.R;
import com.example.gtr.huanxinim.controller.activity.AddContactActivity;
import com.hyphenate.easeui.ui.EaseContactListFragment;

/**
 * 联系人列表页面
 */

public class ContactListFragment extends EaseContactListFragment {

    @Override
    protected void initView() {
        super.initView();
        //布局显示加号
        titleBar.setRightImageResource(R.drawable.em_add);
        //添加头布局
        View headerView = View.inflate(getActivity(), R.layout.header_fragment_contact, null);
        listView.addHeaderView(headerView);
    }

    @Override
    protected void setUpView() {
        super.setUpView();

        //对添加好友按钮的点击事件处理
        titleBar.setRightLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
