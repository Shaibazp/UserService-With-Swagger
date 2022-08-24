package com.example.demo.controller;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerArray;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Entity.Product;
import com.example.demo.ProdError.ProductNotFound;
import com.example.demo.services.ImpProdService;

@RestController
@RequestMapping("/prod")
public class ProdController 
{
	@Autowired
	private ImpProdService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> prodsave(@RequestBody Product product)
	{
		ResponseEntity<?> resp = null;
		try
		{
			Integer ppid = service.saveProduct(product);
			resp = new ResponseEntity<String>("Created....."+ppid, HttpStatus.OK);
		}
		catch(ProductNotFound p)
		{
			throw p;
		}
		return resp;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> prodAll()
	{
		ResponseEntity<?> resp = null;
		try
		{
			List<Product> list = service.getAllProduct();
			resp = new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		}
		catch(ProductNotFound p)
		{
			throw p;
		}
		return resp;
	}
	
	@GetMapping("/find/{pid}")
	public ResponseEntity<?> prodfindOne(@PathVariable Integer pid)
	{
		ResponseEntity<?> resp = null;
		try
		{
			Product list = service.getOneProduct(pid);
			resp = new ResponseEntity<Product>(list, HttpStatus.OK);
		}
		catch(ProductNotFound p)
		{
			throw p;
		}
		return resp;
	}
	
	@DeleteMapping("/delet/{pid}")
	public ResponseEntity<?> prodDelete(@PathVariable Integer pid)
	{
		ResponseEntity<?> resp = null;
		try
		{
			service.deletProduct(pid);
			resp = new ResponseEntity<String>("Deletd.....", HttpStatus.OK);
		}
		catch(ProductNotFound p)
		{
			throw p;
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> produpdate(@RequestBody Product pid)
	{
		ResponseEntity<?> resp = null;
		try
		{
			service.updateProduct(pid);
			resp = new ResponseEntity<String>("Updated.....", HttpStatus.OK);
		}
		catch(ProductNotFound p)
		{
			throw p;
		}
		return resp;
	}
	
	@PatchMapping("/submodi/{sid}/{sstd}")
	public ResponseEntity<?> produpdateSub(@PathVariable Integer sid, @PathVariable String sstd)
	{
		ResponseEntity<?> resp = null;
		try
		{
			service.modifySubById(sstd, sid);
			resp = new ResponseEntity<String>("Updated.....", HttpStatus.OK);
		}
		catch(ProductNotFound p)
		{
			throw p;
		}
		return resp;
	}
}
