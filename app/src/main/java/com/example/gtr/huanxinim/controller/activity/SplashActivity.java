package com.example.gtr.huanxinim.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.gtr.huanxinim.R;
import com.example.gtr.huanxinim.modle.Model;
import com.hyphenate.chat.EMClient;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        
        //发送延时消息
        handler.sendMessageDelayed(Message.obtain(), 1500);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //如果当前activity已经退出，那么就不处理handler中的消息
            if (isFinishing()){
                return;
            }
            //判断进入主页面还是登录页面
            toMainOrLogin();
        }
    };

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

                    //跳转到主页面
                    goToMain();
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
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
