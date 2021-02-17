package com.rootcode.assesment.validation;

import org.springframework.http.HttpStatus;

import com.rootcode.assesment.exception.BaseException;
import com.rootcode.assesment.exception.ExceptionMessages;

/**
 * Validation for the API
 * 
 * @author lahirua
 *
 */
public final class Validator {

    /**
     * Validate country code
     * 
     * @param code
     */

    public static void validateCountryCode(String code) {

	commonValidation(code);
    }
    
    
    /**
     * Validate year
     * 
     * @param code
     */

    public static void validateYear(String code) {

	commonValidation(code);
    }
    
    
    /**
     * Common validation methid for any String
     * 
     * @param code
     */

    private static void commonValidation(String code) {

	if (code == null || "".equals(code.trim())) {

	    throw new BaseException(HttpStatus.BAD_REQUEST, ExceptionMessages.BAD_REQUEST);
	}
    }
}
