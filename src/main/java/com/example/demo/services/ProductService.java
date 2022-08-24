package com.example.demo.services;

import java.util.List;
import java.util.Set;

import com.example.demo.Entity.Product;

public interface ProductService 
{
	Integer saveProduct(Product product);
	List<Product> getAllProduct();
	Product getOneProduct(Integer pid);
	void deletProduct(Integer pid);
	void updateProduct(Product p);
	void modifySubById(String sstd, Integer sid);
}
