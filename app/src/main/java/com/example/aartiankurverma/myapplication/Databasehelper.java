package com.example.aartiankurverma.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aarti Ankur Verma on 2018-02-07.
 */

public class Databasehelper extends SQLiteOpenHelper{
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "PHONENUMBER";
    public static final String DATABASE_NAME = "name.db";
    public static final String TABLE_NAME = "STUDENT_NAME";

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,EMAIL TEXT, PHONENUMBER INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name, String email, String phonenumber){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, phonenumber);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (db.insert(TABLE_NAME, null, contentValues) == -1)
            return false;
        else
                return true;
}
}


