package com.rootcode.assesment.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rootcode.assesment.constant.HeaderParameters;

/**
 * 
 * @author lahirua
 *
 */
@Component
public class CorrelationIdInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CorrelationIdInterceptor.class);

    /**
     * Checks for a valid correlation ID. If no valid Id is found a new
     * correlation id is generated.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

	String correlationId = request.getHeader(HeaderParameters.CORRELATION_ID);

	if (correlationId == null) {
	    correlationId = UUID.randomUUID().toString();
	}

	LOGGER.info("Correlation ID for the request: {}", correlationId);

	response.setHeader(HeaderParameters.CORRELATION_ID, correlationId);

	return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	    ModelAndView modelAndView) {
	// Do nothing.
    }

    /**
     * Resets the Correlation Id container.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	    Exception ex) {

    }
}
