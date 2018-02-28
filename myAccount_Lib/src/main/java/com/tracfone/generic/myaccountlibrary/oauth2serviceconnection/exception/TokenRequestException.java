package com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.exception;

import com.tracfone.generic.myaccountlibrary.CustomException;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * Thrown when refresh token request failurs occurs
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

public class TokenRequestException extends CustomException {


    public static final int REFRESH_TOKEN_EXPIRED_SERVICE_FAILURE_CODE = 5000;

    //Token Request Exception
    public static final String CCU_TOKEN_REQUEST_FAILED = "CCU Token Request Failed";
    public static final String RONS_TOKEN_REQUEST_FAILED = "RONS Token Request Failed";
    public static final String RO_TOKEN_REQUEST_FAILED = "RO Token Request Failed";
    public static final String ROLIMITED_TOKEN_REQUEST_FAILED = "ROLimited Token Request Failed";

    // Refresh Token Exceptions
    public static final String RO_CCP_REFRESH_TOKEN_EXPIRED = "R0 Refresh Token Expired-Failure 5000";
    public static final String RONS_REFRESH_TOKEN_EXPIRED = "RONS Refresh Token Expired-Failure 5000";
    public static final String ROLIMITED_REFRESH_TOKEN_EXPIRED = "ROLimited Refresh Token Expired-Failure 5000";
    public static final String RO_CCP_REFRESH_FAILURE = "RO Refresh Token Expired-Failure ";
    public static final String RONS_REFRESH_FAILURE = "RONS Refresh Token Expired-Failure ";
    public static final String ROLIMITED_REFRESH_FAILURE = "ROLimited Refresh Token Expired-Failure ";
    public static final String RO_CCP_UNKNOWN_REFRESH_FAILURE = "R0 Unknown Refresh Request Failure";
    public static final String ROLIMITED_UNKNOWN_REFRESH_FAILURE = "R0Limited Unknown Refresh Request Failure";


	/**
     * Creates a new instance of <code>InvalidTokenTypeException</code> without detail message.
     */
    public TokenRequestException(){
    }

    /**
     * Constructs an instance of <code>InvalidTokenTypeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TokenRequestException(String msg){
        super(msg);
    }
}
