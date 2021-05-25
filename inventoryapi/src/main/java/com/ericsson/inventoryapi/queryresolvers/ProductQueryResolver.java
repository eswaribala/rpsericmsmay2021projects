package com.ericsson.inventoryapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ericsson.inventoryapi.models.Product;
import com.ericsson.inventoryapi.services.ProductService;

public class ProductQueryResolver implements GraphQLQueryResolver {
	@Autowired
	private ProductService productService;
	
	public List<Product> findAllProducts(){
		return this.productService.getAllProducts();
	}
	

	public Product findProduct(long productId){
		return this.productService.getProductById(productId);
	}
}
