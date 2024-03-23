package com.salil.learnings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
	
	

	
	
	ArrayList<Product> products = new ArrayList<Product>();

	
	@Override
	public List<Product> findAll() {
		
		if(products.size()==0)
			addStaticProducts();
		
		return products;
	}

	@Override
	public void addProduct(Product product) throws Exception {
		System.out.println("In add product"
				+ "");
		
		if(product.getPrice() > 5000) {
			System.out.println("Price of the product is too high we cannot add it to our system");
			throw new Exception("Price is too high");
		}
		
		
		
		products.add(product); //
		//we will also add it to a database 
		// connect to a database, pass that product value

	}
	
	public List<Product> addStaticProducts(){
		products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6, 15));
		products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3, 7));
		products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7, 12));
		products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1, 18));
		
		return products;

	}

	@Override
	public Product findProduct(int id) {
		
		for(Product product : products) {
			if(product.getId()==id) {
				return product;
			}
		}
		return null;
	}
	
	
	
}
