package com.pcm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcm.entities.Supplier;
import com.pcm.exceptions.NoDataFoundException;
import com.pcm.services.SupplierService;

@RestController
@RequestMapping("/api/v2")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/supplier/get/all")
	public ResponseEntity<List<Supplier>> getAllSuppliers(){
		List<Supplier> suppliers = supplierService.getAll();
		
		if(suppliers == null || suppliers.isEmpty()) {
			throw new NoDataFoundException("No Suppliers Found");
		}
		
		return new ResponseEntity<List<Supplier>>(suppliers, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@GetMapping("/supplier/get/{code}")
	public ResponseEntity<Supplier> getSupplierByCode(@PathVariable String code){
		Supplier supplier = supplierService.getSupplierByCode(code);
		
		if(supplier == null) {
			throw new NoDataFoundException("No Supplier Exists with code:" + code);
		}
		
		return new ResponseEntity<Supplier>(supplier, new HttpHeaders(), HttpStatus.OK);
		
	}
}
