package com.trac.preload.accountservices.Analyzer;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;


import com.trac.preload.accountservices.R;

public class AnalyzerActivity extends AppCompatActivity {

    private StatusAnalyzer mStatusAnalyzer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


}
