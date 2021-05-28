package com.ericsson.supplierapi.services;

import java.time.LocalDate;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ericsson.supplierapi.models.Product;
import com.ericsson.supplierapi.repositories.ProductRepository;

import com.google.gson.Gson;




@Service
public class KafKaConsumerService 
{
	@Autowired
	private ProductRepository productRespository;
	private final Logger logger 
		= LoggerFactory.getLogger(KafKaConsumerService.class);
	
	@KafkaListener(topics = "${product.topic.name}", 
			groupId = "${product.topic.group.id}")
	public void consume(String message) {
		logger.info(String.format("Message recieved -> %s", message));
		String[] data=message.split(",");
		Product product=new Product();
		Gson gson=new Gson();
		//if(Integer.parseInt(data[0])>0)
	//	{
			product= gson.fromJson(message, Product.class);
		  
		productRespository.save( product);
		logger.info(String.format("Product Stored -> %s,%s", 
				product.getProductId(),product.getBufferLevel()));
		//}
		//else
		//{
			//logger.info(String.format("Invalid product Id -> %s", 
				//	data[0]));
		//}
		
	}

	
}
