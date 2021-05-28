package com.ericsson.productapi.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProductStreams {
	
    String OUTPUT = "product-out";
   
    @Output(OUTPUT)
    MessageChannel outboundInventory();

}
