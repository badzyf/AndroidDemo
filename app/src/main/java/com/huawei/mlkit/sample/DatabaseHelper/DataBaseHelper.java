package com.huawei.mlkit.sample.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * 修改时间: 2022/1/30
 * 编写人:  Asus
 * 功能描述: 创建SQLite数据库，将训练数据存储到数据库中
 * 备注: 测试
 */
class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="drill.db";
    private static final int VERSION =1;

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table drill (clench int, " +
                "waizhan int, houshen int, qianqu int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
