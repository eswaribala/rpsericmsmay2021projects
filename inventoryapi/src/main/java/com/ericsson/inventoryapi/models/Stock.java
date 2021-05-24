package com.ericsson.inventoryapi.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.ForeignKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Stock")
public class Stock {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Invoice_No")
	private long invoiceNo;
    @Column(name="Price")
	private long price;
    @Column(name="Qty")
    private long qty;
    @Column(name="DOP")
    @DateTimeFormat(iso = ISO.DATE)
	private LocalDate dop;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Product_Id"), name = "Product_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Product product;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
   	@JoinColumn(foreignKey = @ForeignKey(name = "Location_Id"), name = "Location_Id")
   	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Location location;
	
}
