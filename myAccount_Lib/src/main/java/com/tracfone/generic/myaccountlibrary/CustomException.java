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
public class CustomException   extends Exception{

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable class.
	 * Deserialization uses this number to ensure that a loaded class corresponds exactly
	 * to a serialized object. If no match is found, then an InvalidClassException is thrown.
	 */
	private static final long serialVersionUID = 1784765264331364582L;

	/**
     * Short description or name of the occurred error. (REQUIRED)
     */
    private String error;

    /**
     * Human readable description returned by the server to be shown to the user. (OPTIONAL)
     */
    private String errorDescription;


    /**
     * Returns the errors designation as a string. The value must be given by the server
     * when the error occurs.
     * @return String value of the errors designation / name
     *
     */
    public String getError(){
        return error;
    }

    /**
     * Sets the name or designation of the occurred error. The designation is given by the server
     * and can be passed to the exception by this method.
     * @param error string value of the errors designation / name
     */
    public void setError(String error){
        this.error = error;
    }

    /**
     * Returns the description to this error, if one was given by the server.
     *
     * @return string containing the description of the error
     */
    public String getErrorDescription(){
        return errorDescription;
    }

    /**
     * Sets the description for this error, if one was given by the server.
     *
     * @param errorDescription string containing the description of the error
     */

    public void setErrorDescription(String errorDescription){
        this.errorDescription = errorDescription;
    } 

    /**
     * Creates a new instance of <code>OAuthException</code> without detail message.
     */
    public CustomException(){
    }

    /**
     * Constructs an instance of <code>OAuthException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CustomException(String msg){
        super(msg);
    }
}
