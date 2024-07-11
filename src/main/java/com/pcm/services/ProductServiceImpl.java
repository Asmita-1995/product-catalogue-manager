package com.pcm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcm.entities.ProductType;
import com.pcm.entities.Products;
import com.pcm.entities.Supplier;
import com.pcm.repos.ProductTypeRepository;
import com.pcm.repos.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private ProductTypeRepository productTypeRepository;

	public List<Products> getAll(){
		return productsRepository.findAll();
	}

	@Override
	public List<Products> getProductsByFilter(String criteria, String value) {
		
		switch(Criteria.valueOf(criteria.toUpperCase())) {
		case TYPE:
			return productsRepository.findProductsByProductTypeId(Integer.valueOf(value));
		case COLOR:
			return productsRepository.findProductsByColorIgnoreCase(value);
		case SUPPLIER:
			return productsRepository.findProductsBySupplierId(Integer.valueOf(value));
		default:
			return null;
		}		
	}

	@Override
	public Products saveProduct() {
		
		// New Supplier
		Supplier supplier = new Supplier();
		supplier.setName("SANJAY KUMAR");
		supplier.setCode("SKS");
		supplier.setAddress("GURGAON");
		
		// Existing Product Type		
		ProductType prodType = productTypeRepository.findByType("MOBILE");
		System.out.println(prodType.toString());
		
		Products prod = new Products();		
		prod.setName("MMX " + Math.random());
		prod.setColor("White");
		prod.setQuantity(10);
		prod.setSupplier(supplier);
		prod.setProductType(prodType);
		//prod.setTypeId(prodType.getId());
				
		return productsRepository.save(prod);		
	}	
}

enum Criteria {
	TYPE("TYPE"), COLOR("COLOR"), SUPPLIER("SUPPLIER");
	String criteria;
	
	Criteria(String criteria) {
		this.criteria = criteria;
	}	
	
}
