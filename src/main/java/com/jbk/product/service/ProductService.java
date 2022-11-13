package com.jbk.product.service;

import java.util.List;

import com.jbk.product.entity.Product;

public interface ProductService {
	public boolean saveProduct(Product product);

	public List<Product> getAllProduct();

	public Product getProductById(String productId);

	public boolean deleteProduct(String productId);

	public boolean updateProduct(Product product);
	
	public List<Product> sortProducts_ASC(String sortBy);
	
	public List<Product> sortProducts_DSC(String sortBy);
}
