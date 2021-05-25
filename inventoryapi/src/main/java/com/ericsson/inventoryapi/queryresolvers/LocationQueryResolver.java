package com.ericsson.inventoryapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ericsson.inventoryapi.models.Location;
import com.ericsson.inventoryapi.services.LocationService;
@Component
public class LocationQueryResolver implements GraphQLQueryResolver {
	@Autowired
	private LocationService LocationService;
	
	public List<Location> findAllLocations(){
		return this.LocationService.getAllLocations();
	}
	

	public Location findLocation(long locationId){
		return this.LocationService.getLocationById(locationId);
	}
}
