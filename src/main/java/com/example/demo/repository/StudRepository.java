package com.example.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Product;

public interface StudRepository extends JpaRepository<Product, Integer> 
{
	@Modifying
	@Query(value = "update prod_tab SET sstd=:sstd where sid=:sid", nativeQuery = true)
	void modifySubById(String sstd, Integer sid);
}
