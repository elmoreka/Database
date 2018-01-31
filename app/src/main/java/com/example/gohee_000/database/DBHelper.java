package com.example.gohee_000.database;

/**
 * Created by Karl Elmore on 12/10/2017.
 * This class will create a SQLite database with 3 fields, id (primary key), name and phone number
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "STUDENT";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "STUDENT TABLE";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_PHONE_NUM = "PHONE_NUM";
    SQLiteDatabase mSqLiteDatabase;

    public DBHelper(Context context) { super(context, DB_NAME, null, DB_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY," + COL_NAME + " TEXT," + COL_PHONE_NUM + "TEXT);";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertStudent(String name, String phone_num) {
        mSqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_PHONE_NUM, phone_num);
        mSqLiteDatabase.insert(TABLE_NAME,null,values);
        mSqLiteDatabase.close();
    }

    public void getAllStudents() {
        mSqLiteDatabase = this.getReadableDatabase();
        String selectAll = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = mSqLiteDatabase.rawQuery(selectAll, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String phone_num = cursor.getString(2);

                Log.e("ID", String.valueOf(id));
                Log.e("NAME", String.valueOf(name));
                Log.e("PHONE_NUM", String.valueOf(phone_num));
    } while (cursor.moveToNext());
        }
        mSqLiteDatabase.close();
}
}