package com.ericsson.inventoryapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ericsson.inventoryapi.models.Stock;
import com.ericsson.inventoryapi.services.StockService;
@Component
public class StockQueryResolver implements GraphQLQueryResolver {
	@Autowired
	private StockService StockService;
	
	public List<Stock> findAllStocks(){
		return this.StockService.getAllStocks();
	}
	

	public Stock findStock(long invoiceNo){
		return this.StockService.getStockById(invoiceNo);
	}
}
