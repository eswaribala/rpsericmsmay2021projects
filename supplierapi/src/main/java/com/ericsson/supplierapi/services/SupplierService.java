package com.ericsson.supplierapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.supplierapi.models.Product;
import com.ericsson.supplierapi.models.Supplier;
import com.ericsson.supplierapi.repositories.SupplierRepository;

@Service
public class SupplierService {
	 @Autowired
		private SupplierRepository SupplierRepository;
	
	    //insert
	    public Supplier addSupplier(Supplier supplier,long productId) {
	    	
	    	//inter service communication
	    	
	    	//supplier.setProduct(product);
	    	this.SupplierRepository.save(supplier);
	    	
	    	//}
	    	
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
