package com.rootcode.assesment.gdp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootcode.assesment.gdp.service.GdpService;
import com.rootcode.assesment.validation.Validator;


/**
 * Controller Class for Login
 * 
 * @author lahirua
 *
 */
@RestController
@RequestMapping("/v1/gdp")
public class GdpController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GdpController.class);
    
    @Autowired
    private GdpService gdpService;

    @GetMapping(value = "/{countryCode}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getGdpRate(@PathVariable("countryCode") String countryCode, @PathVariable("year") String year) {
	
	LOGGER.info("GdpController : getGdpRate");
	
	Validator.validateCountryCode(countryCode);
	Validator.validateYear(year);
	
	//TO DO : implement proper responce object
	return gdpService.getGdpRate(countryCode, year);
    }
}
