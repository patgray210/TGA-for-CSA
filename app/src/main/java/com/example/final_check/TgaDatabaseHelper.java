package com.example.final_check;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TgaDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_Name = "tgaDb";
    private static final int DB_VERSION = 1;


    public TgaDatabaseHelper(@Nullable Context context) {
        super(context, DB_Name,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table login (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "USERS TEXT," +
                "PASSWORD TEXT);");
        insertLogin(sqLiteDatabase,"camilla","test1");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    private static void insertLogin(SQLiteDatabase sqLiteDatabase, String user, String password)
    {
        ContentValues loginCred = new ContentValues();
        loginCred.put("USERS",user);
        loginCred.put("PASSWORD",password);
        sqLiteDatabase.insert("login",null,loginCred);
    }

}
