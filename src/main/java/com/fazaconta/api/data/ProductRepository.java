package com.fazaconta.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fazaconta.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
