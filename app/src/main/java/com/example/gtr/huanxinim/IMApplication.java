package com.example.gtr.huanxinim;

import android.app.Application;

import com.example.gtr.huanxinim.modle.Model;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;


/**
 * Created by GTR on 2017/4/22.
 */

public class IMApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化环信的EaseUI
        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);  // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAutoAcceptGroupInvitation(false);  // 默认接受群邀请，是不需要验证的，改成需要验证
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);

        //初始化数据模型层类
        Model.getInstance().init(this);
    }
}
