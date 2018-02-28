package com.tracfone.generic.myaccountlibrary.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;

public class CustomSQLiteHelper extends SQLiteOpenHelper{

    public static final String TABLE_NOTIFICATIONS= GlobalLibraryValues.getBrand()+"NOTIFICATIONS";
    public static final String COLUMN_NOTIFICATION_ID="NOTIFICATION_ID";
    public static final String COLUMN_NOTIFICATION_DESCRIPTION="NOTIFICATION_DESCRIPTION";
    public static final String DATABASE_NAME=GlobalLibraryValues.getBrand()+"NOTIFICATIONS.db";
    public static final int DATABASE_VERSION=1;

    private static final String TABLE_CREATE="create table "+TABLE_NOTIFICATIONS+"("+COLUMN_NOTIFICATION_ID+" text ,"+COLUMN_NOTIFICATION_DESCRIPTION+" text );";

    public CustomSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
