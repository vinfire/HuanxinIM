package com.example.gtr.huanxinim.modle;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 数据模型层全局类
 */

public class Model {

    private Context mContext;
    private ExecutorService executors = Executors.newCachedThreadPool();

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
    }

    //获取全局线程池对象
    public ExecutorService getGlobalThreadPool(){
        return executors;
    }
}
