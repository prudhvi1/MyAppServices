package com.tracfone.generic.myaccountlibrary.restrequest;

import com.octo.android.robospice.request.SpiceRequest;

/**
 * Created by skishore on 10/19/2016.
 */

public class AddressRequest extends SpiceRequest<String> {










    public AddressRequest(){
        super(String.class);

    }
    @Override
    public String loadDataFromNetwork() throws Exception {
        return null;
    }
}
