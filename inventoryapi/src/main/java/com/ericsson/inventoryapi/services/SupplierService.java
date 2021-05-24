package com.ericsson.inventoryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.inventoryapi.models.Product;
import com.ericsson.inventoryapi.models.Supplier;
import com.ericsson.inventoryapi.repositories.SupplierRepository;

@Service
public class SupplierService {
	 @Autowired
		private SupplierRepository SupplierRepository;
	 @Autowired   
	 private ProductService productService;
	    
	    //insert
	    public Supplier addSupplier(Supplier supplier,long productId) {
	    	
	    	Product product=this.productService.getProductById(productId);
	    	if(product!=null)
	    	{
	    	supplier.setProduct(product);
	    	this.SupplierRepository.save(supplier);
	    	
	    	}
	    	
	    	return supplier;
	    }
	    
	    
	    //find all
	    
	    public List<Supplier> getAllSuppliers(){
	    	return this.SupplierRepository.findAll();
	    }
	    
	    //find by id
	    public Supplier getSupplierById(long supplierId) {
	    	return this.SupplierRepository.findById(supplierId).orElse(null);
	    }
	    
	    //delete
	    
	    public boolean deleteSupplierById(long supplierId) {
	    	boolean status=false;
	    	this.SupplierRepository.deleteById(supplierId);
	    	if(this.getSupplierById(supplierId)==null)
	    		status=true;
	    	return status;
	    }
	    
	    
	    //update
	  
	    public Supplier updateSupplier(Supplier supplier) {
	    	return this.SupplierRepository.save(supplier);
	    }
}
