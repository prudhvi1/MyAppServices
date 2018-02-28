package com.tracfone.generic.myaccountlibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class will save an exception log to a file
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

public class ExceptionLog {

    private static final String EXCEPTION_EMAIL = "dsalihi@tracfone.com";
    private Context context;

    public ExceptionLog(Context context) {
        this.context = context;
    }

    public void writeStackTraceToFile(final Throwable e){

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                String crashLog = sw.toString();
                extractLogToFile(crashLog);
            }
        }).start();


    }

    public void extractLogToFile(String crashLog) {
        PackageManager manager = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        String model = Build.MODEL;
        if (!model.startsWith(Build.MANUFACTURER))
            model = Build.MANUFACTURER + " " + model;
        // Make file name - file must be saved to external storage or it wont be readable by
        // the email app.
        String exceptionPathName = Environment.getExternalStorageDirectory().toString() + File.separator + "TF_Logging" + File.separator + GlobalLibraryValues.getBrand() + "MyAccountCRASH.txt";

        // Extract to file.
        File file = new File(exceptionPathName);
        // InputStreamReader reader = null;
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write("Android version: " + Build.VERSION.SDK_INT + "\n");
            writer.write("Device: " + model + "\n");
            writer.write("App version: " + (info == null ? "(null)" : info.versionCode) + "\n");
            writer.write("App name: " + (info == null ? "(null)" : info.versionName) + "\n");
            writer.write("Time of crash logged: " + new Date().toString()+ "\n");
            writer.write(crashLog);
            writer.close();
        } catch (IOException e) {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e1) {
                }
        }
    }
}
