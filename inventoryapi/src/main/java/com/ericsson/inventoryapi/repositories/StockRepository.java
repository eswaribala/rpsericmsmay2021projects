package com.ericsson.inventoryapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.inventoryapi.models.Stock;

public interface StockRepository extends JpaRepository<Stock,Long>{

}
