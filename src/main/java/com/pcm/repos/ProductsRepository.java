package com.pcm.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pcm.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

	List<Products> findProductsByProductTypeId(int value);
	
	List<Products> findProductsByColorIgnoreCase(String value);
	
	@Query(nativeQuery = true, value="Select * From PCM_Products where Supplier_Id= :value")
	List<Products> findProductsBySupplierId(int value);

}
