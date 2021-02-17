package com.rootcode.assesment.gdp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rootcode.assesment.exception.BaseException;
import com.rootcode.assesment.exception.ExceptionMessages;
import com.rootcode.assesment.gdp.data.CountryCodes;
import com.rootcode.assesment.gdp.repository.CountryCodeRepository;
import com.rootcode.assesment.gdp.repository.GdpRepository;

/**
 * Service class for GDP
 * 
 * @author lahirua
 *
 */
@Service
public class GdpService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GdpService.class);
    
    private static final int ALPHA2 = 2;
    
    private static final int ALPHA3 = 3;
    
    @Autowired
    private GdpRepository gdpRepository;
    
    @Autowired
    private CountryCodeRepository countryCodeRepository;
    
    /**
     * Return GDP rate by using CountryCode and CountryRepository
     * 
     * @param code
     * @param year
     * @return
     */
    public String getGdpRate(String code, String year) {
	
	LOGGER.info("GdpService : getGdpRate");
	
	CountryCodes countryCode = null;
	
	if(code.length() == ALPHA2) {
	    
	    countryCode = countryCodeRepository.getCountryByAlpha2(code);
	}
	else if(code.length() == ALPHA3){
	    
	    countryCode = countryCodeRepository.getCountryByAlpha3(code);
	}
	
	if(countryCode != null) {
	    
	    return gdpRepository.getCountryByCodeYear(countryCode.getName(), year).getValue();
	    
	}else {
	    
	    throw new BaseException(HttpStatus.BAD_REQUEST, ExceptionMessages.BAD_REQUEST);
	}
	
    }
}
