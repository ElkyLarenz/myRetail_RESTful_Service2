package com.myretail.rest.classes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<PriceData, String> {
    
}
