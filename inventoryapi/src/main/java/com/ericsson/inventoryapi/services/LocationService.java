package com.ericsson.inventoryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.inventoryapi.models.Location;
import com.ericsson.inventoryapi.repositories.LocationRepository;

@Service
public class LocationService {
    @Autowired
	private LocationRepository locationRepository;
    
    //insert
    public Location addLocation(Location location) {
    	return this.locationRepository.save(location);
    }
    
    
    //find all
    
    public List<Location> getAllLocations(){
    	return this.locationRepository.findAll();
    }
    
    //find by id
    public Location getLocationById(long locationId) {
    	return this.locationRepository.findById(locationId).orElse(null);
    }
    
    //delete
    
    public boolean deleteLocationById(long locationId) {
    	boolean status=false;
    	this.locationRepository.deleteById(locationId);
    	if(this.getLocationById(locationId)==null)
    		status=true;
    	return status;
    }
    
    
    //update
  
    public Location updateLocation(Location location) {
    	return this.locationRepository.save(location);
    }
    
    
}
