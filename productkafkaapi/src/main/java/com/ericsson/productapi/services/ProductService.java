package com.ericsson.productapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.productapi.models.Product;
import com.ericsson.productapi.repositories.ProductRepository;

@Service
public class ProductService {
	 @Autowired
		private ProductRepository ProductRepository;
	    
	    //insert
	    public Product addProduct(Product product) {
	    	return this.ProductRepository.save(product);
	    }
	    
	    
	    //find all
	    
	    public List<Product> getAllProducts(){
	    	return this.ProductRepository.findAll();
	    }
	    
	    //find by id
	    public Product getProductById(long productId) {
	    	return this.ProductRepository.findById(productId).orElse(null);
	    }
	    
	    //delete
	    
	    public boolean deleteProductById(long productId) {
	    	boolean status=false;
	    	this.ProductRepository.deleteById(productId);
	    	if(this.getProductById(productId)==null)
	    		status=true;
	    	return status;
	    }
	    
	    
	    //update
	  
	    public Product updateProduct(Product product) {
	    	return this.ProductRepository.save(product);
	    }
}
