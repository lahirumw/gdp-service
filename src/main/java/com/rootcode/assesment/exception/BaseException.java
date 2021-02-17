package com.rootcode.assesment.exception;

import org.springframework.http.HttpStatus;

/**
 * This class is extended by other HTTP resource specific exceptions
 *
 * 
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -4128719035026198680L;


    private final HttpStatus httpStatus;

 BaseException() {
	httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * Constructor Method.
     * 
     * @param httpStatus
     *            : The Http status assigned to the exception.
     * 
     * @param message
     *            : Exception message to be set.
     */
    public BaseException(HttpStatus httpStatus, String message) {
	super(message);
	this.httpStatus = httpStatus;
    }

    /**
     * Constructor Method.
     * 
     * @param httpStatus
     * 
     * @param message
     * 
     * @param e
     */
    public BaseException(HttpStatus httpStatus, String message, Exception e) {
	super(message, e);
	this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
	return httpStatus;
    }

}
