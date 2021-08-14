package com.omnirio.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.products.entity.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long>{

	List<Attribute> findByCategoryAndIsActive(long categoryId, int isActive); 
	
}
