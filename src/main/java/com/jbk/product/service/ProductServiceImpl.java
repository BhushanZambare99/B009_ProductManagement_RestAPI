package com.jbk.product.service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.product.dao.ProductDao;
import com.jbk.product.entity.Product;
import com.jbk.product.sort.ProductIdComparator;
import com.jbk.product.sort.ProductNameComparator;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		String id = new SimpleDateFormat("yyyyMMddHHmmssss").format(new java.util.Date());
		product.setProductId("PAPL-" + id);
		boolean isAdded = dao.saveProduct(product);
		return isAdded;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = dao.getAllProduct();
		return list;
	}

	@Override
	public Product getProductById(String productId) {
		Product product = dao.getProductById(productId);
		return product;
	}

	@Override
	public boolean deleteProduct(String productId) {
		boolean isDeleted = dao.deleteProduct(productId);
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated = dao.updateProduct(product);
		return isUpdated;
	}

	@Override
	public List<Product> sortProducts_ASC(String sortBy) {
		List<Product> list = dao.getAllProduct();
		if (list.size() > 1) {
			if (sortBy.equalsIgnoreCase("productId")) {
				Collections.sort(list, new ProductIdComparator());
			} else if (sortBy.equalsIgnoreCase("productName")) {
				Collections.sort(list, new ProductNameComparator());
			}
		}
		return list;
	}

	@Override
	public List<Product> sortProducts_DSC(String sortBy) {
		List<Product> list = dao.getAllProduct();
		if (list.size() > 1) {
			if (sortBy.equalsIgnoreCase("productId")) {
				Collections.sort(list, new ProductIdComparator());
				Collections.reverse(list);
			} else if (sortBy.equalsIgnoreCase("productName")) {
				Collections.sort(list, new ProductNameComparator());
				Collections.reverse(list);
			}
		}
		return list;
	}

}
