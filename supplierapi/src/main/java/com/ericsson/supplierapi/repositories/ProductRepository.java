package com.ericsson.supplierapi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ericsson.supplierapi.models.Product;
import com.ericsson.supplierapi.models.Supplier;

public interface ProductRepository extends MongoRepository<Product,Long>{

	@Query("{productId : ?0}")
    List<Product> findByProductId(long productId);
}
