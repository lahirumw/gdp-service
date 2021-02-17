package com.rootcode.assesment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Health Controller
 * 
 * @author lahirua
 *
 */
@RestController("healthController")
@PropertySource(value = { "classpath:/application.properties" })
public class HealthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    @Value("${app.version}")
    private String version;

    /**
     * Health rout for application
     * 
     * @return String
     */
    @GetMapping(value = "/health")
    public String getHealth() {

	LOGGER.info("Health Controller: Health Route ");

	return version;
    }

}