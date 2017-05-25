package com.example.gtr.huanxinim.modle.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gtr.huanxinim.modle.dao.UserAccountTable;

/**
 * Created by GTR on 2017/4/22.
 */

public class UserAccountDBHelper extends SQLiteOpenHelper {

    public UserAccountDBHelper(Context context) {
        super(context, "account.db", null, 1);
    }

    //数据库创建的时候调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserAccountTable.CREATE_TAB);
    }

    //数据库更新的时候调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
