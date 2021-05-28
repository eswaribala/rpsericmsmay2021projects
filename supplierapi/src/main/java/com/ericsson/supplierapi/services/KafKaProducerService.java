package com.ericsson.supplierapi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.ericsson.supplierapi.models.Product;
import com.ericsson.supplierapi.models.Supplier;
import com.ericsson.supplierapi.repositories.ProductRepository;
import com.ericsson.supplierapi.repositories.SupplierRepository;



@Service
public class KafKaProducerService 
{
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SupplierService supplierService;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(KafKaProducerService.class);
	
	//1. General topic with string payload
	
	@Value(value = "${supplier.topic.name}")
    private String supplierTopicName;
	
	@Autowired
    private KafkaTemplate<String, Supplier> kafkaTemplate;
	
	public void sendMessage(Supplier supplier, long productId) 
	{
		Supplier supplierObj=supplier;
		Product productObj=this.productRepository.findById(productId).orElse(null);
		if(productObj!=null)
		{
			supplierObj.setProductId(productId);
			this.supplierService.addSupplier(supplierObj, productId);
		}
		//for demo purpose 
		
		ListenableFuture<SendResult<String, Supplier>> future 
			= this.kafkaTemplate.send(supplierTopicName, supplierObj);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, Supplier>>() {
            @Override
            public void onSuccess(SendResult<String, Supplier> result) {
            	
            	logger.info("Sent message: " + supplierObj.getSupplierName()
            			+ " with offset: " + result.getRecordMetadata().offset());
            	System.out.println("Sent message: " + supplierObj.getSupplierName()
    			+ " with offset: " + result.getRecordMetadata().offset());
            }
            

            @Override
            public void onFailure(Throwable ex) {
            	logger.error("Unable to send Supplier Data : ", ex);
            }
       });
	}
	
	
}
