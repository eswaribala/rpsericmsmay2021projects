package com.ericsson.inventoryapi.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Supplier")
public class Supplier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Supplier_Id")
	private long supplierId;
	@Column(name="Supplier_Name")
	private String supplierName;
	@Embedded
	private Address address;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Product_Id"), name = "Product_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Product product;
	
}
