package com.ericsson.inventoryapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.inventoryapi.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
