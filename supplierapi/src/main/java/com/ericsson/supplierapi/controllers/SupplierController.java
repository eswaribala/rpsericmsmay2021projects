package com.ericsson.supplierapi.controllers;

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

import com.ericsson.supplierapi.models.Supplier;
import com.ericsson.supplierapi.services.KafKaProducerService;
import com.ericsson.supplierapi.services.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	private KafKaProducerService kafkaProducerService;


	 @PostMapping({"/v1.0/{productId}", "/v1.1/{productId}"})
    public void addSupplier(@RequestBody Supplier supplier,@PathVariable("productId") long productId){
       	
      this.kafkaProducerService.sendMessage(supplier, productId);
      
	 
	 }
	 
	 
	 


}
