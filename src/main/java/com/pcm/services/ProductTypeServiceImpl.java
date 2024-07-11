package com.pcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcm.entities.ProductType;
import com.pcm.repos.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	
	@Autowired
	private ProductTypeRepository productTypeRepository;

	public List<ProductType> getAll(){
		return productTypeRepository.findAll();
	}
	
}
