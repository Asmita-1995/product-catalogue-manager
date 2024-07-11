package com.pcm.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcm.entities.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{
	
	ProductType findByType(String type);

}
