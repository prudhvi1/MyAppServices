package com.tracfone.generic.myaccountlibrary.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class NotificationDataSource {

    private SQLiteDatabase database;
    private CustomSQLiteHelper customSQLiteHelper;
    private String[] allColumns={CustomSQLiteHelper.COLUMN_NOTIFICATION_ID,CustomSQLiteHelper.COLUMN_NOTIFICATION_DESCRIPTION};

    public NotificationDataSource(Context context)
    {
        customSQLiteHelper=new CustomSQLiteHelper(context);
    }

    private void openDatabaseInReadMode()
    {
        database=customSQLiteHelper.getReadableDatabase();
    }
    private void openDatabaseInWriteMode()
    {
        database=customSQLiteHelper.getWritableDatabase();
    }
    private void close()
    {
        customSQLiteHelper.close();
    }
    public void insertNotification(String notificationId, String notificationDesc)
    {
        openDatabaseInWriteMode();
        ContentValues newNotification=new ContentValues();
        newNotification.put(CustomSQLiteHelper.COLUMN_NOTIFICATION_ID,notificationId);
        newNotification.put(CustomSQLiteHelper.COLUMN_NOTIFICATION_DESCRIPTION,notificationDesc);
        database.insert(CustomSQLiteHelper.TABLE_NOTIFICATIONS, null, newNotification);
        close();
    }

    public List<Notification> getAllNotifications()
    {
        List<Notification> notificationList=new ArrayList<>();
        openDatabaseInReadMode();
        Cursor cursor=database.query(CustomSQLiteHelper.TABLE_NOTIFICATIONS,allColumns,null,null,null,null,null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            Notification notification=new Notification();
            notification.setNotificationID(cursor.getString(0));
            notification.setNotificationDescription(cursor.getString(1));
            notificationList.add(notification);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return notificationList;
    }
}
