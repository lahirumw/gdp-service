package com.rootcode.assesment.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The base exception wrapper for error responses.
 * 
 * @author lahirua
 */
public class BaseExceptionResponseDto implements Serializable {

    private static final long serialVersionUID = 6544747915886659085L;

    @JsonProperty("code")
    private int code;

    @JsonProperty("description")
    private String description;

    /**
     * Constructor Method.
     * 
     * @param e
     *              : Base exception.
     */
    public BaseExceptionResponseDto(BaseException e) {
	this.code = e.getHttpStatus().value();
	this.description = e.getMessage();
    }

    /**
     * Constructor Method.
     * 
     * @param code
     *                        : The code of the error.
     * @param description
     *                        : The description of the error.
     */
    public BaseExceptionResponseDto(int code, String description) {
	this.code = code;
	this.description = description;
    }

    public int getCode() {
	return code;
    }

    public String getDescription() {
	return description;
    }

}
