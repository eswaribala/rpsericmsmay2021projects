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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.inventoryapi.models.Stock;
import com.ericsson.inventoryapi.services.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.bohnman.squiggly.Squiggly;
//import com.github.bohnman.squiggly.util.SquigglyUtils;

@RestController
@RequestMapping("/stocks")
public class StockController {
	@Autowired
	private StockService stockService;


	 @PostMapping({"/v1.0/{productId}/{locationId}", "/v1.1/{productId}/{locationId}"})
    public ResponseEntity<?> addStock(@RequestBody Stock stock,@PathVariable("productId") long productId, @PathVariable("locationId") long locationId){
       	
      Stock StockObj=this.stockService.addStock(stock,productId,locationId);
      if(StockObj!=null) 
    	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(StockObj);
      
      else
    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stock Attributes are not matching");
      
	 
	 }
	 
	 
	 
/*
	 @PostMapping({"/v2.0", "/v2.1"})

	    public ResponseEntity<?> addStockv2(@RequestBody Stock Stock){
	    	
	    }
	    */
	 
	 
	 
	 //findall
	 @GetMapping({"/v1.0", "/v1.1"})
	 public List<Stock> getAllStocks(){
		 return this.stockService.getAllStocks();
	 }
	 
	 
	 
	 @GetMapping({"/v1.0/{stockId}", "/v1.1/{stockId}"})
	 public Stock getStockById(@PathVariable("stockId") long stockId){
		 return this.stockService.getStockById(stockId);
	 }
	 
	 
	 @DeleteMapping({"/v1.0/{stockId}", "/v1.1/{stockId}"})
	 public ResponseEntity<?> deleteStockById(@PathVariable("stockId") long stockId){
		 
		 boolean status=this.stockService.deleteStockById(stockId);
		 if(status)
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Stock "+stockId+"deleted");
		 else
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock Not existing, could n't delete");
		 
		 
	 }
	 
	 
	//http://localhost:7070/stocks/v1.0/filters?fields=invoiceNo,qty
	/*		
	 @GetMapping({"/v1.0/filters", "/v1.1/filters"})
		    public String getFilteredStock(@RequestParam(name = "fields", required = false) 
		    String fields) 
			{

				List<Stock> stockList = getAllStocks();
				ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);  
				return SquigglyUtils.stringify(mapper, stockList);
				
		    }
*/
	 
}
