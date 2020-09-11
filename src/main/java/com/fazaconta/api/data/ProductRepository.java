package com.fazaconta.api.data;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fazaconta.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT * FROM Product WHERE name LIKE :name%")
	public Page<Product> findProductsByName(@Param("name") String name);
}
