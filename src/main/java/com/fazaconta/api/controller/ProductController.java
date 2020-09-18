package com.fazaconta.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fazaconta.api.data.ProductRepository;
import com.fazaconta.api.error.ProductNotFoundException;
import com.fazaconta.api.model.Product;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class ProductController {
	
	private ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/product")
	public @ResponseBody List<Product> findProductsByName(@RequestParam(value="name", required = false) String name) {
		if(name != null && !name.equals("")) {
			return productRepository.findByNameStartsWith(name);
		}
		return productRepository.findAll();
	}
	
	@PostMapping("/product")
	public @ResponseBody Product newProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("/product/{id}")
	public @ResponseBody Product one(@PathVariable Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PutMapping("/product/{id}")
	public @ResponseBody Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		return productRepository.findById(id)
			.map(product -> {
				product.setName(newProduct.getName());
				product.setPrice(newProduct.getPrice());
				return productRepository.save(product);
			}).orElseGet(() -> {
				newProduct.setId(id);
				return productRepository.save(newProduct);
			});
	}
	
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable Long id) {
		productRepository.deleteById(id);
	}
}
