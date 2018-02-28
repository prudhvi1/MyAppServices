package com.tracfone.generic.myaccountlibrary.restserviceconnection;

import com.tracfone.generic.myaccountlibrary.CustomException;

/**
 * Created by psamdrala on 5/5/2017.
 */

public class UnexpectedException extends CustomException {


    public UnexpectedException(String msg){
        super(msg);
    }
}
