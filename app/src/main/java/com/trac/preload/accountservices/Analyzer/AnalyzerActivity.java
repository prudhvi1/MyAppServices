package com.trac.preload.accountservices.Analyzer;

import android.Manifest;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;


import com.trac.preload.accountservices.R;
import com.trac.preload.accountservices.SubManager.SubscriptionService;
import com.tracfone.generic.myaccountlibrary.DebugConfig;

import java.security.Permission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AnalyzerActivity extends AppCompatActivity {
    private Context context;
    private StatusAnalyzer mStatusAnalyzer;
    private static final int PERMISSIONS_REQUEST = 1;
    List<String> permissionsQue = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        // satish. Check the Phone State permission here, just in case. This is throw away code for a preload.
        if ( ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);

        }
        AnalyzerFragment analyzerFragment =
                (AnalyzerFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (analyzerFragment == null) {
            // Create the fragment
            analyzerFragment = AnalyzerFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, analyzerFragment);
            transaction.commit();
        }

        mStatusAnalyzer = new StatusAnalyzer(analyzerFragment);
    }

    private void checkPermissionsAndInit() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(permissionsQue!=null)
                permissionsQue.clear();

            //Check if App has phone permission before initializing mdn and bandwidth x
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                permissionsQue.add(Manifest.permission.READ_PHONE_STATE);
            }

            if (permissionsQue.size() > 0) {
                startPermissionQueCheck( permissionsQue);

            } else {
                // Start subscription service
                Intent intent = new Intent();
                SubscriptionService.enqueueWork(this,intent);
            }
        } else {
            // Start subscription service
            Intent intent = new Intent();
            SubscriptionService.enqueueWork(this,intent);
        }
    }

    // This will be the final result of the permissions popups, here the place all the permissions granted or not granted can be checked.
    public void onRequestPermissionsResultFinal(){
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            // Start subscription service
            Intent intent = new Intent();
            SubscriptionService.enqueueWork(this,intent);
        }
    }

    public  void startPermissionQueCheck(List<String> permissionsQue) {
       String permission = permissionsQue.remove(0);
        ActivityCompat.requestPermissions(AnalyzerActivity.this,new String[]{permission}, PERMISSIONS_REQUEST);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSIONS_REQUEST: {

                if(grantResults[0]!=PackageManager.PERMISSION_GRANTED) {
                    permissionsQue.add(permissions[0]);
                }else{
                    callBackFromPermissionFromPopup();
                }
            }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    // intermediate call backs from thr permission fragment
    public void callBackFromPermissionFromPopup(){
        if(permissionsQue.size()>0) {
            startPermissionQueCheck(permissionsQue);
        }else{
            onRequestPermissionsResultFinal();
        }
    }
}
