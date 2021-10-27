package com.blog.blog.dao;

import java.util.List;

import com.blog.blog.model.Product;

public interface ProductDao {
	
public List<Product> findAll();

public Product findById(int id);

public Product save(Product product);
}
