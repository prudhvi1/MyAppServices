package com.tracfone.generic.myaccountlibrary;
/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class can be used to create custom exceptions
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/


public class MyAccountServiceException extends Exception {

    public static final String EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION = "My Account Exception: SERVER RESPONSE FAILED VALIDATION";

    public MyAccountServiceException() {
    }

    public MyAccountServiceException(String message ) {
        super(message);

    }

    public MyAccountServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
