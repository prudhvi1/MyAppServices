package com.tracfone.generic.myaccountlibrary.oauth2serviceconnection.exception;

import com.tracfone.generic.myaccountlibrary.CustomException;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * Thrown when the refresh token is not available or invalid
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

public class InvalidTokenTypeException extends CustomException {


    public static final String INVALID_REFRESH_TOKEN = "Invalid Refresh Token Type";
    public static final String NO_RO_CCP_AUTH_TOKEN = "No RO CCP Auth Token";
    public static final String NO_RONS_AUTH_TOKEN = "No RONS Token Available";
    public static final String NO_R0LIMTIED_AUTH_TOKEN = "No RO Limited Token Available";
    public static final String NO_RO_CCP_REFRESH_TOKEN = "No RO Refresh Token Available";
    public static final String NO_RONS_REFRESH_TOKEN = "No RONS Refresh Token Available";
    public static final String NO_ROLIMITED_REFRESH_TOKEN = "No RO Limited Refresh Token Available";

    /**
	 * The serialVersionUID is a universal version identifier for a Serializable class.
	 * Deserialization uses this number to ensure that a loaded class corresponds exactly
	 * to a serialized object. If no match is found, then an InvalidClassException is thrown.
	 */
	private static final long serialVersionUID = 2895410489493376381L;

	/**
     * Creates a new instance of <code>InvalidTokenTypeException</code> without detail message.
     */
    public InvalidTokenTypeException(){
    }

    /**
     * Constructs an instance of <code>InvalidTokenTypeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InvalidTokenTypeException(String msg){
        super(msg);
    }
}
