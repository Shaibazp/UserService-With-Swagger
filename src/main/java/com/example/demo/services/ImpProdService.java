package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Product;
import com.example.demo.ProdError.ProductNotFound;
import com.example.demo.repository.StudRepository;
@Service
public class ImpProdService implements ProductService
{
	@Autowired
	private StudRepository repo;
	
	public Integer saveProduct(Product product) 
	{
		return repo.save(product).getSid();
	}

	public List<Product> getAllProduct() 
	{
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Product getOneProduct(Integer pid) 
	{
		// TODO Auto-generated method stub
		return repo.findById(pid).orElseThrow(()->new ProductNotFound("Product Not Found....."));
	}

	public void deletProduct(Integer pid) 
	{
		repo.delete(getOneProduct(pid));

	}

	public void updateProduct(Product p) 
	{
		if(p == null || !repo.existsById(p.getSid()))
		{
			throw new ProductNotFound("Product Not Available.....");
		}
		else
		{
			repo.save(p);
		}

	}

	@Transactional
	public void modifySubById(String ssub, Integer sid)
	{
		if(!repo.existsById(sid))
		{
			throw new ProductNotFound("Product Not Available.....");
		}
		else
		{
			repo.modifySubById(ssub, sid);
		}
		
	}

}
