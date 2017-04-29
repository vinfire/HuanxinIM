package com.example.gtr.huanxinim;

import android.app.Application;

import com.example.gtr.huanxinim.modle.Model;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;


/**
 * Created by GTR on 2017/4/22.
 */

public class IMApplication extends Application {

    //各个平台的配置，建议放在全局Application或者程序入口
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

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

        //初始化友盟
        UMShareAPI.get(this);
    }
}
