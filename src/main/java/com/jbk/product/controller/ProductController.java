package com.jbk.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.product.entity.Product;
import com.jbk.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/saveProduct")
	public ResponseEntity<Boolean> saveProduct(@RequestBody Product Product) {
		boolean isAdded = service.saveProduct(Product);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = service.getAllProduct();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/getProductById")
	public ResponseEntity<Product> getProductById(@RequestParam String productId) {
		Product product = service.getProductById(productId);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/deleteProduct")
	public ResponseEntity<Boolean> deleteProduct(@RequestParam String productId) {
		boolean isDeleted = service.deleteProduct(productId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(value = "/updateProduct")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) {
		boolean isUpdated = service.updateProduct(product);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
