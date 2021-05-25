package com.ericsson.supplierapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ericsson.supplierapi.models.Supplier;
import com.ericsson.supplierapi.services.SupplierService;
@Component
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
