package com.pcm.services;

import java.util.List;

import com.pcm.entities.Supplier;

public interface SupplierService {

	public List<Supplier> getAll();
	
	public Supplier getSupplierByCode(String code);
}
