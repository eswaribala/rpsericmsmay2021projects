package com.ericsson.inventoryapi.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {

	@Column(name="Door_No",nullable = false)
	private String doorNo;
	@Column(name="Street_Name",nullable = false)
	private String streetName;
	@Column(name="City",nullable = false)
	private String city;
	@Column(name="State",nullable = false)
	private String state;
	@Column(name="PinCode",nullable = false)
	private String pinCode;
}
