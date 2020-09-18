package com.fazaconta.api.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fazaconta.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByNameStartsWith(String name);
}
