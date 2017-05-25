package com.example.gtr.huanxinim.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.gtr.huanxinim.R;
import com.example.gtr.huanxinim.modle.Model;
import com.example.gtr.huanxinim.modle.bean.UserInfo;
import com.hyphenate.chat.EMClient;

import java.lang.ref.WeakReference;

public class SplashActivity extends Activity {

    private static final String TAG = "SplashActivity";
    private Handler mHandler = new InnerHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        
        //发送延时消息
        mHandler.sendMessageDelayed(Message.obtain(), 3000);
    }

    /**
     * 声明一个静态的 Handler 内部类，并持有外部类的弱引用
     */
    private static class InnerHandler extends Handler{

        private WeakReference<SplashActivity> mActivity;

        public InnerHandler(SplashActivity activity){
            mActivity = new WeakReference<SplashActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            SplashActivity activity = mActivity.get();
            if (activity != null){
                //如果当前activity已经退出，那么就不处理handler中的消息
                if (activity.isFinishing()){
                    return;
                }
                //判断进入主页面还是登录页面
                activity.toMainOrLogin();
            }
        }

    }

    private void toMainOrLogin() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();

        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //判断当前帐号是否已经登录过
                if (EMClient.getInstance().isLoggedInBefore()){  //登录过
                    //获取到当前登录用户的信息
                    UserInfo account = Model.getInstance().getUserAccountDao().getAccountByHxId(EMClient.getInstance().getCurrentUser());
                    if (account == null){
                        //跳转到登录页面
                        goToLogin();
                    }else {
                        //跳转到主页面
                        goToMain();
                    }
                }else {  //未登录过
                    //跳转到登录页面
                    goToLogin();
                }
            }
        });
    }

    private void goToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        //移除Handler的所有消息
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
