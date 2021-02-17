package com.rootcode.assesment.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Controller Advice to Handle Exceptions thrown by the Controllers.
 * 
 * @author lahirua
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String EXCEPTION_TRACE = "Exception Trace:";

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * Method to handle Resource Exceptions thrown by Controllers
     * 
     * @param e
     *                     : The base exception object.
     * @param request
     *                     : The Http request object.
     * @param response
     *                     : The Http response object.
     * @return {@link ResponseEntity}
     * @throws IOException
     *                         : Input/output exception.
     */
    @ExceptionHandler({ BaseException.class })
    public ResponseEntity<String> handleResourceException(BaseException e, HttpServletRequest request,
	    HttpServletResponse response) {

	LOGGER.error(EXCEPTION_TRACE, e);

	HttpHeaders responseHeaders = new HttpHeaders();

	responseHeaders.setContentType(MediaType.APPLICATION_JSON);

	BaseExceptionResponseDto exceptionDto = new BaseExceptionResponseDto(e);

	return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, e.getHttpStatus());
    }

    

}
