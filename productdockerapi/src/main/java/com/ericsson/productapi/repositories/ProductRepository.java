package com.ericsson.productapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.productapi.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
