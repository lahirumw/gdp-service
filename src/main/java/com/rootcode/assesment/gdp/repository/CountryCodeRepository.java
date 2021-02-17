package com.rootcode.assesment.gdp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rootcode.assesment.gdp.data.CountryCodes;

/**
 * 
 * @author lahirua
 *
 */
@Repository
public interface CountryCodeRepository extends MongoRepository<CountryCodes, String>{

    @Query(value = "{alpha3: ?0}")
    public CountryCodes getCountryByAlpha3(String alpha3);
    
    @Query(value = "{alpha2: ?0}")
    public CountryCodes getCountryByAlpha2(String alpha2);
}
