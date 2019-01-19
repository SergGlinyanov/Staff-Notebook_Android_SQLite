package com.example.android.staffnotbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "staff";

    public static final String TABLE_WORKER = "worker";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_LASTNAME = "lastname";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_YEAR = "year";
    public static final String KEY_MANAGER = "manager";

    public static final String TABLE_MANAGER = "manager";

    public static final String KEY_ID_M = "_id";
    public static final String KEY_NAME_M = "name";
    public static final String KEY_LASTNAME_M = "lastname";
    public static final String KEY_PHONE_M = "phone";
    public static final String KEY_YEAR_M = "year";
    public static final String KEY_DEPARTMENT = "department";

    public static final String TABLE_STAFF = "all_staff";

    public static final String KEY_ID_S = "_id";
    public static final String KEY_NAME_S = "name";
    public static final String KEY_LASTNAME_S = "lastname";
    public static final String KEY_PHONE_S = "phone";
    public static final String KEY_YEAR_S = "year";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_WORKER + "(" + KEY_ID + " String primary key," + KEY_NAME + " text," +
                              KEY_LASTNAME + " text," + KEY_PHONE + " text," + KEY_YEAR + " text," + KEY_MANAGER + " text" + ")" );
        db.execSQL("create table " + TABLE_MANAGER + "(" + KEY_ID_M + " String primary key," + KEY_NAME_M + " text," +
                KEY_LASTNAME_M + " text," + KEY_PHONE_M + " text," + KEY_YEAR_M + " text," + KEY_DEPARTMENT + " text" + ")" );
        db.execSQL("create table " + TABLE_STAFF +"(" + KEY_ID_S + " String primary key," + KEY_NAME_S + " text," +
                KEY_LASTNAME_S + " text," + KEY_PHONE_S + " text," + KEY_YEAR_S + " text" +  ")" );
        db.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                + " SELECT " + DBHelper.KEY_NAME + "," + DBHelper.KEY_LASTNAME + "," + DBHelper.KEY_PHONE +
                "," + DBHelper.KEY_YEAR + " FROM " + DBHelper.TABLE_WORKER + ";");
        db.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                + " SELECT " + DBHelper.KEY_NAME_M + "," + DBHelper.KEY_LASTNAME_M + "," + DBHelper.KEY_PHONE_M +
                "," + DBHelper.KEY_YEAR_M + " FROM " + DBHelper.TABLE_MANAGER + ";");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists " + TABLE_WORKER);
        db.execSQL("drop table if exists " + TABLE_MANAGER);
        db.execSQL("drop table if exists " + TABLE_STAFF);

        onCreate(db);

    }


}
