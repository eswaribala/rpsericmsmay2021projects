package com.ericsson.circuitbreaker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.circuitbreaker.handlers.CBHandler;


@RestController
public class CBController {
    @Autowired
	private CBHandler cbHandler;
	@GetMapping("/gateways/{userName}/{password}")
	public ResponseEntity<?> invokeAPIGeteway(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		
		return this.cbHandler.requestHandler(userName,password);
		
	}
}
