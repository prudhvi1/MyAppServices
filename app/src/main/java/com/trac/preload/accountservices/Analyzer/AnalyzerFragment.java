package com.trac.preload.accountservices.Analyzer;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trac.preload.accountservices.R;

/**
 * Created by com.tracfone.preload on 2/26/2018.
 */

public class AnalyzerFragment extends Fragment {

    private TextView brandName, status, end_date;
    private EditText serial1, serial2, serial3;
    private Button goBtn1,goBtn2,goBtn3;
    private StatusAnalyzer mStatusAnalyzer;
    public AnalyzerFragment(){

    }

    public static AnalyzerFragment newInstance() {
        return new AnalyzerFragment();
    }

    public void setStatusAnalyzer(StatusAnalyzer mStatusAnalyzer){
        this.mStatusAnalyzer = mStatusAnalyzer;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_analyzer, container, false);
        // Set up status quey views
        serial1 = root.findViewById(R.id.et_device);
        serial2 = root.findViewById(R.id.et_device_esn);
        serial3 = root.findViewById(R.id.et_device_sim);
        goBtn1 = root.findViewById(R.id.bt_get1);
        goBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(getActivity(),root);
                String min = serial1.getText().toString();
                if(min.isEmpty()){
                    setErrorToast("invalid");
                    return;
                }
                clearDeviceDetails();
                mStatusAnalyzer.makePhoneBrandingRequest(min,"","");
            }
        });

        goBtn2 = root.findViewById(R.id.bt_get2);
        goBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(getActivity(),root);
                String esn = serial2.getText().toString();
                if(esn.isEmpty()){
                    setErrorToast("invalid");
                    return;
                }
                clearDeviceDetails();
                mStatusAnalyzer.makePhoneBrandingRequest("",esn,"");
            }
        });

        goBtn3 = root.findViewById(R.id.bt_get3);
        goBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(getActivity(),root);
                String sim = serial3.getText().toString();
                if(sim.isEmpty()){
                    setErrorToast("invalid");
                    return;
                }
                clearDeviceDetails();
                mStatusAnalyzer.makePhoneBrandingRequest("","",sim);
            }
        });

        // Set up device status view

        brandName = (TextView) root.findViewById(R.id.tv_brand_name);
        status = (TextView) root.findViewById(R.id.tv_device_status);
        end_date = (TextView) root.findViewById(R.id.tv_device_end);

        return root;
    }

    public void setDeviceDetails(String bName, String dStatus, String endDate){
        brandName.setText(bName);
        status.setText(dStatus);
        end_date.setText(endDate);
    }

    public void clearDeviceDetails(){
        brandName.setText("");
        status.setText("");
        end_date.setText("");
    }

    public void setErrorToast(String msg){
        Toast.makeText(getActivity(),"This device serial number "+msg,Toast.LENGTH_SHORT).show();
    }

    public static void hideSoftKeyboard (Activity activity, View view)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }
}
