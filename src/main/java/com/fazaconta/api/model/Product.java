package com.fazaconta.api.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
@SequenceGenerator(name = "sq_product", sequenceName = "sq_product")
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private BigDecimal price;
	
	Product() {}
	
	public Product(Long id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Product{");
		sb.append("id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", price=").append(price);
		sb.append("}");
		return sb.toString();
	}
}
