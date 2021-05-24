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

import com.ericsson.inventoryapi.models.Supplier;
import com.ericsson.inventoryapi.services.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;


	 @PostMapping({"/v1.0/{productId}", "/v1.1/{productId}"})
    public ResponseEntity<?> addSupplier(@RequestBody Supplier supplier,@PathVariable("productId") long productId){
       	
      Supplier SupplierObj=this.supplierService.addSupplier(supplier,productId);
      if(SupplierObj!=null) 
    	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(SupplierObj);
      
      else
    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Supplier Attributes are not matching");
      
	 
	 }
	 
	 
	 
/*
	 @PostMapping({"/v2.0", "/v2.1"})

	    public ResponseEntity<?> addSupplierv2(@RequestBody Supplier Supplier){
	    	
	    }
	    */
	 
	 
	 
	 //findall
	 @GetMapping({"/v1.0", "/v1.1"})
	 public List<Supplier> getAllSuppliers(){
		 return this.supplierService.getAllSuppliers();
	 }
	 
	 
	 
	 @GetMapping({"/v1.0/{supplierId}", "/v1.1/{supplierId}"})
	 public Supplier getSupplierById(@PathVariable("supplierId") long supplierId){
		 return this.supplierService.getSupplierById(supplierId);
	 }
	 
	 
	 @DeleteMapping({"/v1.0/{supplierId}", "/v1.1/{supplierId}"})
	 public ResponseEntity<?> deleteSupplierById(@PathVariable("supplierId") long supplierId){
		 
		 boolean status=this.supplierService.deleteSupplierById(supplierId);
		 if(status)
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Supplier "+supplierId+"deleted");
		 else
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier Not existing, could n't delete");
		 
		 
	 }
	 

}
