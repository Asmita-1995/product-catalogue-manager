package com.pcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcm.entities.Supplier;
import com.pcm.repos.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;

	public List<Supplier> getAll(){
		return supplierRepository.findAll();
	}
	
	public Supplier getSupplierByCode(String code){
		return supplierRepository.findSupplierByCode(code);
	}
}
