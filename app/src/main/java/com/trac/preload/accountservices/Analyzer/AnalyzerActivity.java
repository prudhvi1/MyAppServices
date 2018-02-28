package com.trac.preload.accountservices.Analyzer;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.trac.preload.accountservices.R;

public class AnalyzerActivity extends AppCompatActivity {

    private StatusAnalyzer mStatusAnalyzer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
