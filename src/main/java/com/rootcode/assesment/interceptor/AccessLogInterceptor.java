package com.rootcode.assesment.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Intercepter for Logging purposes and calculates
 * the time taken for a request to be completed.
 * 
 * @author lahirua
 *
 */
@Component
public class AccessLogInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessLogInterceptor.class);

    /**
     * PreHandle: Records the time the request was sent
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
	long startTime = System.currentTimeMillis();
	request.setAttribute("startTime", startTime);

	return true;
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
    {
	// Nothing to do here

    }

    /**
     * AfterCompletion: Records the time take for the response to be returned
     * and calculates the total time taken. 
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	    Exception exception) {

	long startTime = (Long) request.getAttribute("startTime");
	long endTime = System.currentTimeMillis();
	long executeTime = endTime - startTime;

	LOGGER.info("Execute time : {} ms", executeTime);

    }

}
