package com.omnirio.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByProductIdAndIsActive(long productId, int isActive);
	
	Product findByCategoryAndIsActive(long categoryId, int isActive);
	
}
