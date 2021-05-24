package com.ericsson.inventoryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.inventoryapi.models.Location;
import com.ericsson.inventoryapi.models.Product;
import com.ericsson.inventoryapi.models.Stock;
import com.ericsson.inventoryapi.repositories.StockRepository;
@Service
public class StockService {
	@Autowired
	private StockRepository StockRepository;
 @Autowired   
 private ProductService productService;
 @Autowired
 private LocationService locationService;
    
    //insert
    public Stock addStock(Stock stock,long productId,long locationId) {
    	
    	Product product=this.productService.getProductById(productId);
    	Location location=this.locationService.getLocationById(locationId);
    	if((product!=null)&&(location!=null))
    	{
    	stock.setProduct(product);
    	stock.setLocation(location);
    	this.StockRepository.save(stock);    	
    	}
    	
    	return stock;
    }
    
    
    //find all
    
    public List<Stock> getAllStocks(){
    	return this.StockRepository.findAll();
    }
    
    //find by id
    public Stock getStockById(long stockId) {
    	return this.StockRepository.findById(stockId).orElse(null);
    }
    
    //delete
    
    public boolean deleteStockById(long stockId) {
    	boolean status=false;
    	this.StockRepository.deleteById(stockId);
    	if(this.getStockById(stockId)==null)
    		status=true;
    	return status;
    }
    
    
    //update
  
    public Stock updateStock(Stock stock) {
    	return this.StockRepository.save(stock);
    }
}
