package com.ericsson.supplierapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.supplierapi.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Long>{

}
