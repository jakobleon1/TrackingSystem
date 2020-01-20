package com.example.trackingsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(Context context){
        super(context, "TrackingDB.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Data (" +
                "ID INTEGER PRIMARY KEY," +
                "Longitude TEXT," +
                "Latitude TEXT," +
                "Date TEXT," +
                "Time TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Data");
        db.execSQL("CREATE TABLE Data (" +
                "ID INTEGER PRIMARY KEY," +
                "Longitude TEXT," +
                "Latitude TEXT," +
                "Date TEXT," +
                "Time TEXT)");
    }
}
