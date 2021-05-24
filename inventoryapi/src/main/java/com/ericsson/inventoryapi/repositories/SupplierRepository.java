package com.ericsson.inventoryapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.inventoryapi.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Long>{

}
