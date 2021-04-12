package com.example.final_check;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registerUser";
    public static final String TABLE_NAME_Second= "patientData";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registerUser (ID INTEGER PRIMARY KEY AUTOINCREMENT, fullName TEXT not null, email TEXT not Null, password TEXT not null, patients INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE patientData (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT not Null, name TEXT not Null, category TEXT not null,gender TEXT not Null,age TEXT not NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( " DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL( " DROP TABLE IF EXISTS " + TABLE_NAME_Second);

        onCreate(sqLiteDatabase);
    }

    public long addUser(String fullName, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullName", fullName);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("patients", 0);
        long res = db.insert("registerUser",null,contentValues);
        db.close();
        return res;
    }

    public void addPatient(String name, String category, String uname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("category",category);
        contentValues.put("username",uname);
        contentValues.put("gender","null");
        contentValues.put("age","null");
        Log.d("ADD Patient ","ADD Patient 1");

        db.insert("patientData",null,contentValues);
        db.close();
        Log.d("ADD Patient ","ADD Patient 2");


    }

    public boolean checkUser(String email, String pass){
        SQLiteDatabase db = getReadableDatabase();
        Log.d("Here ","CHECK");
        Cursor cursor = db.rawQuery(" SELECT * FROM registerUser WHERE email = '"+email+"' And password = '"+pass+"'",null);
        Log.d("Here ","CHECK2");
        int count = cursor.getCount();
        Log.d("COUNT ",Integer.toString(count));

        cursor.close();
        db.close();
        if(count>0){
            return true;
        }else{
            return false;
        }
    }



    public long checkPatient(String email){
        SQLiteDatabase db = getReadableDatabase();
        Log.d("Here Patient ","CHECK Patient 1");

        Cursor cursor = db.rawQuery(" SELECT * FROM patientData WHERE username = '"+email+"'",null);
        long countPatient = cursor.getCount();
        cursor.close();
        Log.d("Here Patient2 ","CHECK Patient 2");


        SQLiteDatabase db1 = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("patients", countPatient);
        db1.insert("registerUser",null,contentValues);
        db.close();
        db1.close();

        return countPatient;

    }

    public boolean checkPatient(String email, String patientName, String category)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM patientData WHERE username = '"+email+"' And name = '"+patientName+"' And category = '"+category+"'",null);
        Log.d("Here Patient Exists 1 ","CHECK Existing Patient 1");

        int count = cursor.getCount();
        if(count >0){
            return true;

        }else {
            return false;
        }
    }

    public List<patient_data> allPatients(String email)
    {
        List<patient_data> all_patient_data = new ArrayList<>();
        String query = "SELECT * FROM "+TABLE_NAME_Second+" WHERE username = '"+email+"'";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            do {
                patient_data allData = new patient_data();
                allData.setId(cursor.getString(0));
                allData.setName(cursor.getString(2));
                allData.setMental_health(cursor.getString(3));

                all_patient_data.add(allData);
            }while (cursor.moveToNext());
        }
        db.close();
        return all_patient_data;
    }

    public List<String> patientLabels(String email)
    {
        List<String> patLabels = new ArrayList<>();
        String query = "SELECT * FROM "+TABLE_NAME_Second+" WHERE username = '"+email+"'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                patLabels.add(cursor.getString(2));

            }while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return patLabels;

    }

    public String showUserName(String email)
    {
        String str = "Not found";
        String query = " SELECT * FROM registerUser WHERE email = '"+email+"'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()) {

            str = cursor.getString(1);}
//        if(cursor.getCount() > 0) {
//                do{;}while(cursor.moveToNext());
//
//            }
//        }
        return str;
    }

}
