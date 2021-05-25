package com.ericsson.inventoryapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ericsson.inventoryapi.models.Supplier;
import com.ericsson.inventoryapi.services.SupplierService;

public class SupplierQueryResolver implements GraphQLQueryResolver {
	@Autowired
	private SupplierService SupplierService;
	
	public List<Supplier> findAllSuppliers(){
		return this.SupplierService.getAllSuppliers();
	}
	

	public Supplier findSupplier(long supplierId){
		return this.SupplierService.getSupplierById(supplierId);
	}
}
