package com.salil.learnings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;

	//http://localhost:8080/products
	@GetMapping(value = "/products")
	public List<Product> getProduct() {
		List<Product> products = productService.findAll();
		System.out.println("Products : "+products);
		return products;
	}
	
	//One other way of adding a GET mapping
//	@RequestMapping(method = RequestMethod.GET, value = "/getProducts")
//	public List<Product> getProduct1() {
//		return null;
//	}
	
	//http://localhost:8080/product?id=100
	@GetMapping(value = "/product")
	public Product getParticularProduct(@RequestParam int id) {
		Product product = productService.findProduct(id);
		return product;
	}

	
	//http://localhost:8080/products
	/*
	{
"id": 111,
"pname": "SamSung",
"batchno": "ABC12343",
"price": 500,
"noofproduct": 20,
"productQuantity": 12
}
	 */
	@PostMapping(value = "/products")
	public String addProduct(@RequestBody Product product) throws Exception {

		productService.addProduct(product);

		return "New Product added";
	}

}
