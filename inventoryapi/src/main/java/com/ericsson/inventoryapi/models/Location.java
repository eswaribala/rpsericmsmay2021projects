package com.ericsson.inventoryapi.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Location")
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Location_Id")
	private long locationId;
	@Column(name="Location_Address")
	@Embedded
	private Address address;
	@Column(name="Contact_No")
	private long contactNo;

}
