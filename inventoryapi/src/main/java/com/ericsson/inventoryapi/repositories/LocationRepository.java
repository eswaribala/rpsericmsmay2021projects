package com.ericsson.inventoryapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.inventoryapi.models.Location;

public interface LocationRepository extends JpaRepository<Location,Long>{

}
