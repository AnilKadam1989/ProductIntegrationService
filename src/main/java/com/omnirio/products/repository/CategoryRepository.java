package com.omnirio.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.products.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findByCategoryidAndIsActive(long categoryId, int isActive);
}
