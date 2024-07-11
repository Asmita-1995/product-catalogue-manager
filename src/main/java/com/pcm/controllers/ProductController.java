package com.pcm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcm.entities.ProductType;
import com.pcm.entities.Products;
import com.pcm.exceptions.NoDataFoundException;
import com.pcm.services.ProductService;
import com.pcm.services.ProductTypeService;

@RestController
@RequestMapping("/api/v2")
public class ProductController {

	@Autowired
	private ProductTypeService productTypeService;
	
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/types/get")
	public ResponseEntity<List<ProductType>> getAllProductTypes(){
		List<ProductType> types = productTypeService.getAll();
		
		if(types == null || types.isEmpty()) {
			throw new NoDataFoundException("No Products Types Configured");
		}
		
		return new ResponseEntity<List<ProductType>>(types, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@GetMapping("/product/get/")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> products = productService.getAll();
		
		if(products == null || products.isEmpty()) {
			throw new NoDataFoundException("No Products Found");
		}
		
		return new ResponseEntity<List<Products>>(products, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@PostMapping("/product/save/")
	public ResponseEntity<Products> saveProduct(){
		Products products = productService.saveProduct();
		
		if(products == null) {
			throw new NoDataFoundException("Unable to save product");
		}
		
		return new ResponseEntity<Products>(products, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@GetMapping("/product/filter/{criteria}/{value}")
	public ResponseEntity<List<Products>> getFilteredProducts(@PathVariable String criteria, @PathVariable String value){
		List<Products> products = productService.getProductsByFilter(criteria, value);
		
		if(products == null || products.isEmpty()) {
			throw new NoDataFoundException("No Products Found for criteria:" + criteria + " value:" + value);
		}
		
		return new ResponseEntity<List<Products>>(products, new HttpHeaders(), HttpStatus.OK);
		
	}

}
