package com.rootcode.assesment.gdp.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rootcode.assesment.gdp.data.Countries;

@Repository
public interface GdpRepository extends MongoRepository<Countries, UUID>{
    
    @Query(value = "{name: ?0, year: ?1 }")
    public Countries getCountryByCodeYear(String name, String year);

}
