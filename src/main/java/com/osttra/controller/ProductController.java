package com.osttra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.entity.Product;
import com.osttra.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/add")
	public Product addUser(@RequestBody Product product) {

		Product newproduct = productRepository.save(product);

		return newproduct;

	}
	
	@GetMapping("/products/cheaper")
    public List<Product> findProductsCheaper(@RequestParam("maxPrice") double maxPrice) {
		
        return productRepository.findProductsCheaperThan(maxPrice);
        
    }
	
	@GetMapping("/products/range")
    public List<Product> findProductsInRange(@RequestParam("maxPrice") double maxPrice, @RequestParam("minPrice") double minPrice) {
		
        return productRepository.findProductsInRange(maxPrice,minPrice);
        
    }
	
}
