package com.ericsson.inventoryapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.inventoryapi.models.Location;
import com.ericsson.inventoryapi.services.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private LocationService locationService;


	 @PostMapping({"/v1.0", "/v1.1"})
    public ResponseEntity<?> addLocation(@RequestBody Location location){
       	
      Location locationObj=this.locationService.addLocation(location);
      if(locationObj!=null) 
    	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(locationObj);
      
      else
    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Location Attributes are not matching");
      
	 
	 }
	 
	 
	 
/*
	 @PostMapping({"/v2.0", "/v2.1"})

	    public ResponseEntity<?> addLocationv2(@RequestBody Location Location){
	    	
	    }
	    */
	 
	 
	 
	 //findall
	 @GetMapping({"/v1.0", "/v1.1"})
	 public List<Location> getAllLocations(){
		 return this.locationService.getAllLocations();
	 }
	 
	 
	 
	 @GetMapping({"/v1.0/{locationId}", "/v1.1/{locationId}"})
	 public Location getLocationById(@PathVariable("locationId") long locationId){
		 return this.locationService.getLocationById(locationId);
	 }
	 
	 
	 @DeleteMapping({"/v1.0/{locationId}", "/v1.1/{locationId}"})
	 public ResponseEntity<?> deleteLocationById(@PathVariable("locationId") long locationId){
		 
		 boolean status=this.locationService.deleteLocationById(locationId);
		 if(status)
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Location "+locationId+"deleted");
		 else
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Location Not existing, could n't delete");
		 
		 
	 }
	 
}
