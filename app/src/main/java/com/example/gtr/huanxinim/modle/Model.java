package com.example.gtr.huanxinim.modle;

import android.content.Context;

import com.example.gtr.huanxinim.modle.dao.UserAccountDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 数据模型层全局类
 */

public class Model {

    private Context mContext;
    private ExecutorService executors = Executors.newCachedThreadPool();
    private UserAccountDao userAccountDao;

    private static Model model = null;

    private Model(){

    }

    public static Model getInstance(){
        if (model==null){
            synchronized (Model.class){
                if (model==null){
                    model = new Model();
                }
            }
        }
        return model;
    }

    //初始化
    public void init(Context context){
        mContext = context;

        //创建用户帐号数据库的操作类对象
        userAccountDao = new UserAccountDao(context);
    }

    //获取全局线程池对象
    public ExecutorService getGlobalThreadPool(){
        return executors;
    }

    //用户登录成功后的处理方法
    public void loginSuccess() {

    }

    //获取用户帐号数据库的操作类对象
    public UserAccountDao getUserAccountDao(){
        return userAccountDao;
    }
}
