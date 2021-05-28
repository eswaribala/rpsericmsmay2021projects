package com.ericsson.supplierapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ericsson.supplierapi.models.Product;
import com.ericsson.supplierapi.models.Supplier;

public interface ProductRepository extends MongoRepository<Product,Long>{

}
