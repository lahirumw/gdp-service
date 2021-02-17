package com.rootcode.assesment.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rootcode.assesment.interceptor.AccessLogInterceptor;
import com.rootcode.assesment.interceptor.CorrelationIdInterceptor;

/**
 * API interceptor configuration
 * 
 * @author lahirua
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    
    @Autowired
    private AccessLogInterceptor accessLogInterceptor;
    
    @Autowired
    private CorrelationIdInterceptor correlationIdInterceptor;
    
    
    /**
     * Register the interceptors used. Only the specified Interceptors handle
     * requests which match with the given path params. Adding order is
     * important.
     * 
     * @param registry
     *                     : Interceptor registry object.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

	registry.addInterceptor(accessLogInterceptor);
	registry.addInterceptor(correlationIdInterceptor);
	
    }

}
