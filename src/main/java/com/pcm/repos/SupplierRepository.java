package com.pcm.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcm.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

	public Supplier findSupplierByCode(String code);
}
