package com.osttra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.osttra.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
	@Query("SELECT p FROM Product p WHERE p.price < :maxPrice")
    List<Product> findProductsCheaperThan(@Param("maxPrice") double maxPrice);
	
	@Query("SELECT p FROM Product p WHERE p.price < :maxPrice and p.price > :minPrice")
    List<Product> findProductsInRange(@Param("maxPrice") double maxPrice, @Param("minPrice") double minPrice);

}
