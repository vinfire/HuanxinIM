package com.example.gtr.huanxinim.modle.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gtr.huanxinim.modle.dao.ContactTable;

/**
 * Created by GTR on 2017/5/14.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //创建联系人的表
        db.execSQL(ContactTable.CREATE_TAB);
        //创建邀请信息的表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
