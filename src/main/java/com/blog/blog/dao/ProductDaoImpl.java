package com.blog.blog.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.blog.blog.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	private List<Product> products = new ArrayList<>(); 
	
	public ProductDaoImpl()
	{
		products.add(new Product(1, new String("Ordinateur portable"), 350));
		products.add(new Product(2, new String("Aspirateur Robot"), 500));
		products.add(new Product(3, new String("Table de Ping Pong"), 750));
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public Product findById(int id) {
		return products.get(2);
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
