package com.ericsson.productapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.productapi.models.Product;
import com.ericsson.productapi.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
	private ProductService productService;


	 @PostMapping({"/v1.0", "/v1.1"})
    public ResponseEntity<?> addProduct(@RequestBody Product product){
       	
      Product productObj=this.productService.addProduct(product);
      if(productObj!=null) 
    	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(productObj);
      
      else
    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Attributes are not matching");
      
	 
	 }
	 
	 
	 
/*
	 @PostMapping({"/v2.0", "/v2.1"})

	    public ResponseEntity<?> addProductv2(@RequestBody Product product){
	    	
	    }
	    */
	 
	 
	 
	 //findall
	 @GetMapping({"/v1.0", "/v1.1"})
	 public List<Product> getAllProducts(){
		 return this.productService.getAllProducts();
	 }
	 
	 
	 
	 @GetMapping({"/v1.0/{productId}", "/v1.1/{productId}"})
	 public Product getProductById(@PathVariable("productId") long productId){
		 return this.productService.getProductById(productId);
	 }
	 
	 
	 @DeleteMapping({"/v1.0/{productId}", "/v1.1/{productId}"})
	 public ResponseEntity<?> deleteProductById(@PathVariable("productId") long productId){
		 
		 boolean status=this.productService.deleteProductById(productId);
		 if(status)
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product "+productId+"deleted");
		 else
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not existing, could n't delete");
		 
		 
	 }
	 
	 
	 

}
