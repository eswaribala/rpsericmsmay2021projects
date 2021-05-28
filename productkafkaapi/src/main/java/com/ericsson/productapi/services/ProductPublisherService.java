package com.ericsson.productapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.ericsson.productapi.facades.ProductStreams;

@Service
public class ProductPublisherService {

	private final ProductStreams productStreams;
	   @Autowired
		private ProductService productService;
	public ProductPublisherService(ProductStreams productStreams)
	{
		this.productStreams=productStreams;
	}
	public boolean sendProductDetails(long productId)
	{
		//JPA code
		//skeleton
		//Notification
		MessageChannel messageChannel = productStreams.outboundInventory();
	       return  messageChannel.send(MessageBuilder
	                .withPayload(productService.getProductById(productId))
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());

		
	}
	

}
