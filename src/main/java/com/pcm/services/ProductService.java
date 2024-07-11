package com.pcm.services;

import java.util.List;

import com.pcm.entities.Products;

public interface ProductService {
	
	public List<Products> getAll();

	public List<Products> getProductsByFilter(String criteria, String value);

	public Products saveProduct();
	
}
